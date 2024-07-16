package webgpu

import not
import webgpu.c.Pointer

internal fun wgpuError(status: Any, message: Pointer<Byte>): IllegalStateException {
    return if (!message) {
        IllegalStateException("$status ${message.getString(0)}")
    } else {
        IllegalStateException("$status")
    }
}

internal fun wgpuError(status: Any, message: String): IllegalStateException {
    return IllegalStateException("$status $message")
}