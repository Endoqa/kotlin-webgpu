package wgpu

import java.lang.foreign.MemorySegment

public actual typealias NativeBuffer = MemorySegment
public actual typealias AllowSharedBufferSource = MemorySegment

public actual sealed interface GPUBindingResource