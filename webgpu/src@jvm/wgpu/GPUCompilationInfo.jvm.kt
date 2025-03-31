package wgpu

import lib.wgpu.WGPUCompilationInfo
import lib.wgpu.WGPUCompilationMessage
import java.lang.foreign.ValueLayout

public actual class GPUCompilationInfo(
    public actual val messages: Array<GPUCompilationMessage>
) {
    public constructor(info: WGPUCompilationInfo) : this(
        Array(info.messageCount.toInt()) {
            GPUCompilationMessage(
                WGPUCompilationMessage(info.messages.getAtIndex(ValueLayout.ADDRESS, it.toLong()))
            )
        }
    )

}