package wgpu

import java.lang.foreign.MemorySegment

public typealias NativeBuffer = MemorySegment
public typealias AllowSharedBufferSource = MemorySegment

public actual sealed interface GPUBindingResource