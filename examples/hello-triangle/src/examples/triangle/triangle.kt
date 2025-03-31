package examples.triangle

import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import lib.wgpu.*
import wgpu.GPU
import wgpu.GPUPowerPreference
import wgpu.GPURequestAdapterOptions
import java.io.File
import java.lang.foreign.*
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine



fun main() {
    println(File("../../libs/libwebgpu_dawn.so").exists())
    System.load(File("../../libs/libwebgpu_dawn.so").absolutePath)
    runBlocking(newSingleThreadContext("App")) {
        appMain(emptyArray())
    }
}

suspend fun appMain(args: Array<String>) {
    val gpu = GPU()

    val adapter = gpu.requestAdapter(GPURequestAdapterOptions(powerPreference = GPUPowerPreference.HighPerformance))
    require(adapter != null) { "Failed to find a suitable GPU" }
    println(adapter.features)
    println(adapter.info)
    println(adapter.limits)

}

