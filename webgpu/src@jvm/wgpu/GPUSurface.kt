package wgpu

import lib.wgpu.*
import java.lang.foreign.Arena

public class GPUSurface(
    private val surface: WGPUSurface
) {


    public fun getCapabilities(adapter: GPUAdapter): GPUSurfaceCapabilities {
        return unsafeScope {
            val capabilities = WGPUSurfaceCapabilities.allocate(this)

            when (wgpuSurfaceGetCapabilities(surface, adapter.into(), capabilities.`$mem`)) {
                WGPUStatus.Success -> GPUSurfaceCapabilities.from(capabilities)
                else -> error("Failed to get surface capabilities")
            }
        }
    }


    public fun configure(config: GPUSurfaceConfiguration) {
        return unsafeScope {
            wgpuSurfaceConfigure(surface, config.into().`$mem`)
        }
    }

    public fun getCurrentTexture(): GPUSurfaceTexture {

        val arena = Arena.ofShared()
        val texture = WGPUSurfaceTexture.allocate(arena)
        wgpuSurfaceGetCurrentTexture(surface, texture.`$mem`)

        return GPUSurfaceTexture(texture, arena)
    }

    public fun present() {
        wgpuSurfacePresent(surface)
    }
}
