package wgpu

import lib.wgpu.WGPUSurfaceTexture
import java.lang.foreign.Arena

public class GPUSurfaceTexture(
    private val surfaceTexture: WGPUSurfaceTexture,
    private val owner: Arena
) {


    public val texture: GPUTexture by lazy {
        GPUTexture(surfaceTexture.texture)
    }

}