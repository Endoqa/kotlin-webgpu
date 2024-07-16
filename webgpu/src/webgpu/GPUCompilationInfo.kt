package webgpu

import webgpu.c.WGPUCompilationInfo
import webgpu.c.WGPUCompilationMessage

data class GPUCompilationInfo(val messages: List<GPUCompilationMessage>) {

    companion object {
        @JvmStatic
        internal fun from(native: WGPUCompilationInfo): GPUCompilationInfo {
            val messages = (0uL until native.messageCount).map { i ->
                val slice = native.messages.asSlice(
                    i.toLong() * WGPUCompilationMessage.layout.byteSize(),
                    WGPUCompilationMessage.layout
                )

                val m = WGPUCompilationMessage(slice)
                GPUCompilationMessage(
                    m.message.getString(0),
                    m.type,
                    m.lineNum,
                    m.linePos,
                    m.offset,
                    m.length
                )
            }

            return GPUCompilationInfo(messages)
        }
    }

}