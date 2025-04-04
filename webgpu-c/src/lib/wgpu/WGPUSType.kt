// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType

/**
 * TODO
 */
public enum class WGPUSType(
    public val `value`: Int,
) {
    Null(0x00000000),

    /**
     * TODO
     */
    ShaderSourceSPIRV(0x00000001),

    /**
     * TODO
     */
    ShaderSourceWGSL(0x00000002),

    /**
     * TODO
     */
    RenderPassMaxDrawCount(0x00000003),

    /**
     * TODO
     */
    SurfaceSourceMetalLayer(0x00000004),

    /**
     * TODO
     */
    SurfaceSourceWindowsHWND(0x00000005),

    /**
     * TODO
     */
    SurfaceSourceXlibWindow(0x00000006),

    /**
     * TODO
     */
    SurfaceSourceWaylandSurface(0x00000007),

    /**
     * TODO
     */
    SurfaceSourceAndroidNativeWindow(0x00000008),

    /**
     * TODO
     */
    SurfaceSourceXCBWindow(0x00000009),

    /**
     * TODO
     */
    SurfaceColorManagement(0x0000000a),

    /**
     * TODO
     */
    RequestAdapterWebXROptions(0x0000000b),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUSType::class.java,
            "fromInt",
            MethodType.methodType(WGPUSType::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUSType::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUSType = when (value) {
            Null.value -> Null
            ShaderSourceSPIRV.value -> ShaderSourceSPIRV
            ShaderSourceWGSL.value -> ShaderSourceWGSL
            RenderPassMaxDrawCount.value -> RenderPassMaxDrawCount
            SurfaceSourceMetalLayer.value -> SurfaceSourceMetalLayer
            SurfaceSourceWindowsHWND.value -> SurfaceSourceWindowsHWND
            SurfaceSourceXlibWindow.value -> SurfaceSourceXlibWindow
            SurfaceSourceWaylandSurface.value -> SurfaceSourceWaylandSurface
            SurfaceSourceAndroidNativeWindow.value -> SurfaceSourceAndroidNativeWindow
            SurfaceSourceXCBWindow.value -> SurfaceSourceXCBWindow
            SurfaceColorManagement.value -> SurfaceColorManagement
            RequestAdapterWebXROptions.value -> RequestAdapterWebXROptions
            else -> error("enum not found")
        }
    }
}
