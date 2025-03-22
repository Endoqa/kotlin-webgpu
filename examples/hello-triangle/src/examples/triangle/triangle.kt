package examples.triangle

import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import lib.wgpu.*
import java.io.File
import java.lang.foreign.*
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

private fun setDawnInCPP() {

    val hackyCCode = SymbolLookup.loaderLookup().find("_ZN4dawn6native8GetProcsEv").get()

    val m = Linker.nativeLinker().downcallHandle(
        hackyCCode,
        FunctionDescriptor.of(
            ValueLayout.ADDRESS
        )
    )

    val dawnProcSetProcsAddr = SymbolLookup.loaderLookup().find("dawnProcSetProcs").get()
    val dawnProcSetProcs = Linker.nativeLinker().downcallHandle(
        dawnProcSetProcsAddr,
        FunctionDescriptor.ofVoid(ValueLayout.ADDRESS)
    )

    val table = m.invokeExact() as MemorySegment
    dawnProcSetProcs.invokeExact(table) as Unit

}

fun Arena.allocateString(str: String): WGPUStringView {
    val view = WGPUStringView.allocate(this)
    val s = allocateFrom(str)
    view.data = s
    view.length = (s.byteSize().toULong() - 1u)
    return view
}

fun main() {
    System.load(File("/nix/store/8binbhw803iyvq1hwdpr8z80853x36cn-vulkan-loader-1.4.304.0/lib/libvulkan.so").absolutePath)
    System.load(File("/home/admin/Projects/webgpu-related/Dawn/dawn/out/cmake-debug/src/dawn/native/libwebgpu_dawn.so").absolutePath)
//    System.load(File("../../libs/libdawn_native.so").absolutePath)
    runBlocking(newSingleThreadContext("App")) {
        appMain(emptyArray())
    }
}

suspend fun appMain(args: Array<String>) {

//    System.load(File("../../libs/lib_dawn_proc.a").absolutePath)
//    setDawnInCPP()

    val allocator = Arena.ofAuto()

    val instance = wgpuCreateInstance(MemorySegment.NULL)

    if (instance == MemorySegment.NULL) {
        error("Failed to create WGPU instance")
    }


    val options = WGPURequestAdapterOptions.allocate(allocator)

    options.backendType = WGPUBackendType.Vulkan
    options.powerPreference = WGPUPowerPreference.HighPerformance

    val adapter = requestAdapter(instance, options)

    if (adapter == MemorySegment.NULL) {
        error("Failed to request adapter")
    }


    val deviceDesc = WGPUDeviceDescriptor.allocate(allocator)
    deviceDesc.label = allocator.allocateString("My Device")
    deviceDesc.defaultQueue.label = allocator.allocateString("My Queue")
    val device = requestDevice(instance, adapter, deviceDesc)

    if (device == MemorySegment.NULL) {
        error("Failed to create device")
    }

    val adapterInfo = WGPUAdapterInfo.allocate(allocator)
    wgpuDeviceGetAdapterInfo(device, adapterInfo.`$mem`)

    println(adapterInfo.backendType)
    println(
        adapterInfo.device.data.reinterpret(adapterInfo.device.length.toLong()).toArray(ValueLayout.JAVA_BYTE)
            .decodeToString()
    )
    println(
        adapterInfo.architecture.data.reinterpret(adapterInfo.architecture.length.toLong())
            .toArray(ValueLayout.JAVA_BYTE)
            .decodeToString()
    )
    println(adapterInfo.adapterType)


    val queue = wgpuDeviceGetQueue(device)
    println(queue)
    wgpuQueueSetLabel(queue, allocator.allocateString("My Queue"))
    fun onQueueWorkDone(
        status: WGPUQueueWorkDoneStatus,
        userdata1: Pointer<Unit>,
        userdata2: Pointer<Unit>,
    ) {
        println("Queue work done: $status")
    }
    with(allocator) {
        val cbInfo = WGPUQueueWorkDoneCallbackInfo.allocate(this)
        cbInfo.mode = WGPUCallbackMode.AllowSpontaneous
        cbInfo.callback = lib.wgpu.proc.WGPUQueueWorkDoneCallback(::onQueueWorkDone).allocate(this)
        wgpuQueueOnSubmittedWorkDone(queue, cbInfo)
    }

    val encoderDesc = WGPUCommandEncoderDescriptor.allocate(allocator)
    encoderDesc.label = allocator.allocateString("My Encoder")
    val encoder = wgpuDeviceCreateCommandEncoder(device, encoderDesc.`$mem`)

    println(encoder)

    val cmdBufferDescriptor = WGPUCommandBufferDescriptor.allocate(allocator)
    cmdBufferDescriptor.label = allocator.allocateString("My Command Buffer")
    val command = wgpuCommandEncoderFinish(encoder, cmdBufferDescriptor.`$mem`)


    println(command)

    val cmdArr = allocator.allocateFrom(ValueLayout.ADDRESS, command)

    wgpuQueueSubmit(queue, 1u, cmdArr)

    println(System.getenv("LD_LIBRARY_PATH"))
}


suspend fun requestAdapter(instance: WGPUInstance, options: WGPURequestAdapterOptions? = null): WGPUAdapter {
    val o = options?.`$mem` ?: MemorySegment.NULL

    return Arena.ofConfined().use { arena ->
        suspendCoroutine<WGPUAdapter> { continuation ->
            val cbInfo = WGPURequestAdapterCallbackInfo.allocate(arena)
            cbInfo.mode = WGPUCallbackMode.AllowProcessEvents
            cbInfo.callback =
                lib.wgpu.proc.WGPURequestAdapterCallback { status, device, message, userdata1, userdata2 ->
                    when (status) {

                        WGPURequestAdapterStatus.Success -> continuation.resumeWith(Result.success(device))
                        else -> continuation.resumeWithException(
                            RuntimeException("Failed to request adapter: $status")
                        )
                    }
                }.allocate(arena)


            with(arena) {
                wgpuInstanceRequestAdapter(
                    instance,
                    o,
                    cbInfo,
                )
            }

            wgpuInstanceProcessEvents(instance)
        }
    }

}


suspend fun requestDevice(
    instance: WGPUInstance,
    adapter: WGPUAdapter,
    options: WGPUDeviceDescriptor? = null
): WGPUDevice {
    val o = options?.`$mem` ?: MemorySegment.NULL

    return Arena.ofConfined().use { arena ->
        suspendCoroutine<WGPUDevice> { continuation ->
            val cbInfo = WGPURequestDeviceCallbackInfo.allocate(arena)
            cbInfo.mode = WGPUCallbackMode.AllowProcessEvents
            cbInfo.callback = lib.wgpu.proc.WGPURequestDeviceCallback { status, device, message, userdata1, userdata2 ->
                when (status) {
                    WGPURequestDeviceStatus.Success -> continuation.resumeWith(Result.success(device))
                    else -> continuation.resumeWithException(
                        RuntimeException("Failed to request device: $status")
                    )
                }
            }.allocate(arena)

            with(arena) {
                wgpuAdapterRequestDevice(
                    adapter,
                    o,
                    cbInfo,
                )
            }
            wgpuInstanceProcessEvents(instance)
        }
    }
}
