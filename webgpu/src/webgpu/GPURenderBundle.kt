package webgpu

import webgpu.c.WGPURenderBundle

class GPURenderBundle(
    internal val bundle_: WGPURenderBundle,
    internal val desc_: GPURenderBundleDescriptor,
)