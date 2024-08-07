// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int

public enum class WGPUWGSLFeatureName(
    public val `value`: Int,
) {
    ReadonlyAndReadwriteStorageTextures(0x00000001),
    Packed4x8IntegerDotProduct(0x00000002),
    UnrestrictedPointerParameters(0x00000003),
    PointerCompositeAccess(0x00000004),
    ChromiumTestingUnimplemented(0x00050000),
    ChromiumTestingUnsafeExperimental(0x00050001),
    ChromiumTestingExperimental(0x00050002),
    ChromiumTestingShippedWithKillswitch(0x00050003),
    ChromiumTestingShipped(0x00050004),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUWGSLFeatureName::class.java,
            "fromInt",
            MethodType.methodType(WGPUWGSLFeatureName::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUWGSLFeatureName::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUWGSLFeatureName = when (value) {
            ReadonlyAndReadwriteStorageTextures.value -> ReadonlyAndReadwriteStorageTextures
            Packed4x8IntegerDotProduct.value -> Packed4x8IntegerDotProduct
            UnrestrictedPointerParameters.value -> UnrestrictedPointerParameters
            PointerCompositeAccess.value -> PointerCompositeAccess
            ChromiumTestingUnimplemented.value -> ChromiumTestingUnimplemented
            ChromiumTestingUnsafeExperimental.value -> ChromiumTestingUnsafeExperimental
            ChromiumTestingExperimental.value -> ChromiumTestingExperimental
            ChromiumTestingShippedWithKillswitch.value -> ChromiumTestingShippedWithKillswitch
            ChromiumTestingShipped.value -> ChromiumTestingShipped
            else -> error("enum not found")
        }
    }
}
