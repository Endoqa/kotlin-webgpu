package wgpu

import lib.wgpu.*
import lib.wgpu.proc.WGPUBufferMapCallback
import lib.wgpu.proc.WGPUCompilationInfoCallback
import lib.wgpu.proc.WGPUCreateComputePipelineAsyncCallback
import lib.wgpu.proc.WGPUCreateRenderPipelineAsyncCallback
import lib.wgpu.proc.WGPUDeviceLostCallback
import lib.wgpu.proc.WGPUPopErrorScopeCallback
import lib.wgpu.proc.WGPUQueueWorkDoneCallback
import lib.wgpu.proc.WGPURequestAdapterCallback
import lib.wgpu.proc.WGPURequestDeviceCallback
import lib.wgpu.proc.WGPUUncapturedErrorCallback
import java.lang.foreign.Arena

public val DEFAULT_CALLBACK_MODE: WGPUCallbackMode = WGPUCallbackMode.AllowSpontaneous

context(Arena)
public fun createBufferMapCallback(
    mode: WGPUCallbackMode = DEFAULT_CALLBACK_MODE,
    callback: WGPUBufferMapCallback
): WGPUBufferMapCallbackInfo {
    val info = WGPUBufferMapCallbackInfo.allocate(this@Arena)
    info.mode = mode
    info.callback = callback.allocate(this@Arena)
    return info
}

context(Arena)
public fun createCompilationInfoCallback(
    mode: WGPUCallbackMode = DEFAULT_CALLBACK_MODE,
    callback: WGPUCompilationInfoCallback
): WGPUCompilationInfoCallbackInfo {
    val info = WGPUCompilationInfoCallbackInfo.allocate(this@Arena)
    info.mode = mode
    info.callback = callback.allocate(this@Arena)
    return info
}

context(Arena)
public fun createCreateComputePipelineAsyncCallback(
    mode: WGPUCallbackMode = DEFAULT_CALLBACK_MODE,
    callback: WGPUCreateComputePipelineAsyncCallback
): WGPUCreateComputePipelineAsyncCallbackInfo {
    val info = WGPUCreateComputePipelineAsyncCallbackInfo.allocate(this@Arena)
    info.mode = mode
    info.callback = callback.allocate(this@Arena)
    return info
}

context(Arena)
public fun createCreateRenderPipelineAsyncCallback(
    mode: WGPUCallbackMode = DEFAULT_CALLBACK_MODE,
    callback: WGPUCreateRenderPipelineAsyncCallback
): WGPUCreateRenderPipelineAsyncCallbackInfo {
    val info = WGPUCreateRenderPipelineAsyncCallbackInfo.allocate(this@Arena)
    info.mode = mode
    info.callback = callback.allocate(this@Arena)
    return info
}

context(Arena)
public fun createDeviceLostCallback(
    mode: WGPUCallbackMode = DEFAULT_CALLBACK_MODE,
    callback: WGPUDeviceLostCallback
): WGPUDeviceLostCallbackInfo {
    val info = WGPUDeviceLostCallbackInfo.allocate(this@Arena)
    info.mode = mode
    info.callback = callback.allocate(this@Arena)
    return info
}

context(Arena)
public fun createPopErrorScopeCallback(
    mode: WGPUCallbackMode = DEFAULT_CALLBACK_MODE,
    callback: WGPUPopErrorScopeCallback
): WGPUPopErrorScopeCallbackInfo {
    val info = WGPUPopErrorScopeCallbackInfo.allocate(this@Arena)
    info.mode = mode
    info.callback = callback.allocate(this@Arena)
    return info
}

context(Arena)
public fun createQueueWorkDoneCallback(
    mode: WGPUCallbackMode = DEFAULT_CALLBACK_MODE,
    callback: WGPUQueueWorkDoneCallback
): WGPUQueueWorkDoneCallbackInfo {
    val info = WGPUQueueWorkDoneCallbackInfo.allocate(this@Arena)
    info.mode = mode
    info.callback = callback.allocate(this@Arena)
    return info
}

context(Arena)
public fun createRequestAdapterCallback(
    mode: WGPUCallbackMode = DEFAULT_CALLBACK_MODE,
    callback: WGPURequestAdapterCallback
): WGPURequestAdapterCallbackInfo {
    val info = WGPURequestAdapterCallbackInfo.allocate(this@Arena)
    info.mode = mode
    info.callback = callback.allocate(this@Arena)
    return info
}

context(Arena)
public fun createRequestDeviceCallback(
    mode: WGPUCallbackMode = DEFAULT_CALLBACK_MODE,
    callback: WGPURequestDeviceCallback
): WGPURequestDeviceCallbackInfo {
    val info = WGPURequestDeviceCallbackInfo.allocate(this@Arena)
    info.mode = mode
    info.callback = callback.allocate(this@Arena)
    return info
}

context(Arena)
public fun createUncapturedErrorCallback(callback: WGPUUncapturedErrorCallback): WGPUUncapturedErrorCallbackInfo {
    val info = WGPUUncapturedErrorCallbackInfo.allocate(this@Arena)
    info.callback = callback.allocate(this@Arena)
    return info
}
