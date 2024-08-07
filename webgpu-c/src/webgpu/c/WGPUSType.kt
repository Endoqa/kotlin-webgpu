// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int

public enum class WGPUSType(
    public val `value`: Int,
) {
    ShaderModuleSPIRVDescriptor(0x00000001),
    ShaderModuleWGSLDescriptor(0x00000002),
    PrimitiveDepthClipControl(0x00000003),
    RenderPassDescriptorMaxDrawCount(0x00000004),
    TextureBindingViewDimensionDescriptor(0x00020000),
    SurfaceDescriptorFromCanvasHTMLSelector(0x00040000),
    SurfaceDescriptorFromMetalLayer(0x00010000),
    SurfaceDescriptorFromWindowsHWND(0x00010001),
    SurfaceDescriptorFromXlibWindow(0x00010002),
    SurfaceDescriptorFromWaylandSurface(0x00010003),
    SurfaceDescriptorFromAndroidNativeWindow(0x00010004),
    SurfaceDescriptorFromXcbWindow(0x00010005),
    SurfaceDescriptorFromWindowsCoreWindow(0x00050000),
    ExternalTextureBindingEntry(0x00050001),
    ExternalTextureBindingLayout(0x00050002),
    SurfaceDescriptorFromWindowsSwapChainPanel(0x00050003),
    DepthStencilStateDepthWriteDefinedDawn(0x00050004),
    DawnTextureInternalUsageDescriptor(0x00050005),
    DawnEncoderInternalUsageDescriptor(0x00050006),
    DawnInstanceDescriptor(0x00050007),
    DawnCacheDeviceDescriptor(0x00050008),
    DawnAdapterPropertiesPowerPreference(0x00050009),
    DawnBufferDescriptorErrorInfoFromWireClient(0x0005000A),
    DawnTogglesDescriptor(0x0005000B),
    DawnShaderModuleSPIRVOptionsDescriptor(0x0005000C),
    RequestAdapterOptionsLUID(0x0005000D),
    RequestAdapterOptionsGetGLProc(0x0005000E),
    RequestAdapterOptionsD3D11Device(0x0005000F),
    DawnRenderPassColorAttachmentRenderToSingleSampled(0x00050010),
    RenderPassPixelLocalStorage(0x00050011),
    PipelineLayoutPixelLocalStorage(0x00050012),
    BufferHostMappedPointer(0x00050013),
    DawnExperimentalSubgroupLimits(0x00050014),
    AdapterPropertiesMemoryHeaps(0x00050015),
    AdapterPropertiesD3D(0x00050016),
    AdapterPropertiesVk(0x00050017),
    DawnComputePipelineFullSubgroups(0x00050018),
    DawnWireWGSLControl(0x00050019),
    DawnWGSLBlocklist(0x0005001A),
    DrmFormatCapabilities(0x0005001B),
    ShaderModuleCompilationOptions(0x0005001C),
    ColorTargetStateExpandResolveTextureDawn(0x0005001D),
    SharedTextureMemoryVkDedicatedAllocationDescriptor(0x0005001E),
    SharedTextureMemoryAHardwareBufferDescriptor(0x0005001F),
    SharedTextureMemoryDmaBufDescriptor(0x00050020),
    SharedTextureMemoryOpaqueFDDescriptor(0x00050021),
    SharedTextureMemoryZirconHandleDescriptor(0x00050022),
    SharedTextureMemoryDXGISharedHandleDescriptor(0x00050023),
    SharedTextureMemoryD3D11Texture2DDescriptor(0x00050024),
    SharedTextureMemoryIOSurfaceDescriptor(0x00050025),
    SharedTextureMemoryEGLImageDescriptor(0x00050026),
    SharedTextureMemoryInitializedBeginState(0x00050027),
    SharedTextureMemoryInitializedEndState(0x00050028),
    SharedTextureMemoryVkImageLayoutBeginState(0x00050029),
    SharedTextureMemoryVkImageLayoutEndState(0x0005002A),
    SharedTextureMemoryD3DSwapchainBeginState(0x0005002B),
    SharedFenceVkSemaphoreOpaqueFDDescriptor(0x0005002C),
    SharedFenceVkSemaphoreOpaqueFDExportInfo(0x0005002D),
    SharedFenceVkSemaphoreSyncFDDescriptor(0x0005002E),
    SharedFenceVkSemaphoreSyncFDExportInfo(0x0005002F),
    SharedFenceVkSemaphoreZirconHandleDescriptor(0x00050030),
    SharedFenceVkSemaphoreZirconHandleExportInfo(0x00050031),
    SharedFenceDXGISharedHandleDescriptor(0x00050032),
    SharedFenceDXGISharedHandleExportInfo(0x00050033),
    SharedFenceMTLSharedEventDescriptor(0x00050034),
    SharedFenceMTLSharedEventExportInfo(0x00050035),
    SharedBufferMemoryD3D12ResourceDescriptor(0x00050036),
    StaticSamplerBindingLayout(0x00050037),
    YCbCrVkDescriptor(0x00050038),
    SharedTextureMemoryAHardwareBufferProperties(0x00050039),
    AHardwareBufferProperties(0x0005003A),
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
            ShaderModuleSPIRVDescriptor.value -> ShaderModuleSPIRVDescriptor
            ShaderModuleWGSLDescriptor.value -> ShaderModuleWGSLDescriptor
            PrimitiveDepthClipControl.value -> PrimitiveDepthClipControl
            RenderPassDescriptorMaxDrawCount.value -> RenderPassDescriptorMaxDrawCount
            TextureBindingViewDimensionDescriptor.value -> TextureBindingViewDimensionDescriptor
            SurfaceDescriptorFromCanvasHTMLSelector.value -> SurfaceDescriptorFromCanvasHTMLSelector
            SurfaceDescriptorFromMetalLayer.value -> SurfaceDescriptorFromMetalLayer
            SurfaceDescriptorFromWindowsHWND.value -> SurfaceDescriptorFromWindowsHWND
            SurfaceDescriptorFromXlibWindow.value -> SurfaceDescriptorFromXlibWindow
            SurfaceDescriptorFromWaylandSurface.value -> SurfaceDescriptorFromWaylandSurface
            SurfaceDescriptorFromAndroidNativeWindow.value -> SurfaceDescriptorFromAndroidNativeWindow
            SurfaceDescriptorFromXcbWindow.value -> SurfaceDescriptorFromXcbWindow
            SurfaceDescriptorFromWindowsCoreWindow.value -> SurfaceDescriptorFromWindowsCoreWindow
            ExternalTextureBindingEntry.value -> ExternalTextureBindingEntry
            ExternalTextureBindingLayout.value -> ExternalTextureBindingLayout
            SurfaceDescriptorFromWindowsSwapChainPanel.value -> SurfaceDescriptorFromWindowsSwapChainPanel
            DepthStencilStateDepthWriteDefinedDawn.value -> DepthStencilStateDepthWriteDefinedDawn
            DawnTextureInternalUsageDescriptor.value -> DawnTextureInternalUsageDescriptor
            DawnEncoderInternalUsageDescriptor.value -> DawnEncoderInternalUsageDescriptor
            DawnInstanceDescriptor.value -> DawnInstanceDescriptor
            DawnCacheDeviceDescriptor.value -> DawnCacheDeviceDescriptor
            DawnAdapterPropertiesPowerPreference.value -> DawnAdapterPropertiesPowerPreference
            DawnBufferDescriptorErrorInfoFromWireClient.value ->
                DawnBufferDescriptorErrorInfoFromWireClient

            DawnTogglesDescriptor.value -> DawnTogglesDescriptor
            DawnShaderModuleSPIRVOptionsDescriptor.value -> DawnShaderModuleSPIRVOptionsDescriptor
            RequestAdapterOptionsLUID.value -> RequestAdapterOptionsLUID
            RequestAdapterOptionsGetGLProc.value -> RequestAdapterOptionsGetGLProc
            RequestAdapterOptionsD3D11Device.value -> RequestAdapterOptionsD3D11Device
            DawnRenderPassColorAttachmentRenderToSingleSampled.value ->
                DawnRenderPassColorAttachmentRenderToSingleSampled

            RenderPassPixelLocalStorage.value -> RenderPassPixelLocalStorage
            PipelineLayoutPixelLocalStorage.value -> PipelineLayoutPixelLocalStorage
            BufferHostMappedPointer.value -> BufferHostMappedPointer
            DawnExperimentalSubgroupLimits.value -> DawnExperimentalSubgroupLimits
            AdapterPropertiesMemoryHeaps.value -> AdapterPropertiesMemoryHeaps
            AdapterPropertiesD3D.value -> AdapterPropertiesD3D
            AdapterPropertiesVk.value -> AdapterPropertiesVk
            DawnComputePipelineFullSubgroups.value -> DawnComputePipelineFullSubgroups
            DawnWireWGSLControl.value -> DawnWireWGSLControl
            DawnWGSLBlocklist.value -> DawnWGSLBlocklist
            DrmFormatCapabilities.value -> DrmFormatCapabilities
            ShaderModuleCompilationOptions.value -> ShaderModuleCompilationOptions
            ColorTargetStateExpandResolveTextureDawn.value -> ColorTargetStateExpandResolveTextureDawn
            SharedTextureMemoryVkDedicatedAllocationDescriptor.value ->
                SharedTextureMemoryVkDedicatedAllocationDescriptor

            SharedTextureMemoryAHardwareBufferDescriptor.value ->
                SharedTextureMemoryAHardwareBufferDescriptor

            SharedTextureMemoryDmaBufDescriptor.value -> SharedTextureMemoryDmaBufDescriptor
            SharedTextureMemoryOpaqueFDDescriptor.value -> SharedTextureMemoryOpaqueFDDescriptor
            SharedTextureMemoryZirconHandleDescriptor.value -> SharedTextureMemoryZirconHandleDescriptor
            SharedTextureMemoryDXGISharedHandleDescriptor.value ->
                SharedTextureMemoryDXGISharedHandleDescriptor

            SharedTextureMemoryD3D11Texture2DDescriptor.value ->
                SharedTextureMemoryD3D11Texture2DDescriptor

            SharedTextureMemoryIOSurfaceDescriptor.value -> SharedTextureMemoryIOSurfaceDescriptor
            SharedTextureMemoryEGLImageDescriptor.value -> SharedTextureMemoryEGLImageDescriptor
            SharedTextureMemoryInitializedBeginState.value -> SharedTextureMemoryInitializedBeginState
            SharedTextureMemoryInitializedEndState.value -> SharedTextureMemoryInitializedEndState
            SharedTextureMemoryVkImageLayoutBeginState.value -> SharedTextureMemoryVkImageLayoutBeginState
            SharedTextureMemoryVkImageLayoutEndState.value -> SharedTextureMemoryVkImageLayoutEndState
            SharedTextureMemoryD3DSwapchainBeginState.value -> SharedTextureMemoryD3DSwapchainBeginState
            SharedFenceVkSemaphoreOpaqueFDDescriptor.value -> SharedFenceVkSemaphoreOpaqueFDDescriptor
            SharedFenceVkSemaphoreOpaqueFDExportInfo.value -> SharedFenceVkSemaphoreOpaqueFDExportInfo
            SharedFenceVkSemaphoreSyncFDDescriptor.value -> SharedFenceVkSemaphoreSyncFDDescriptor
            SharedFenceVkSemaphoreSyncFDExportInfo.value -> SharedFenceVkSemaphoreSyncFDExportInfo
            SharedFenceVkSemaphoreZirconHandleDescriptor.value ->
                SharedFenceVkSemaphoreZirconHandleDescriptor

            SharedFenceVkSemaphoreZirconHandleExportInfo.value ->
                SharedFenceVkSemaphoreZirconHandleExportInfo

            SharedFenceDXGISharedHandleDescriptor.value -> SharedFenceDXGISharedHandleDescriptor
            SharedFenceDXGISharedHandleExportInfo.value -> SharedFenceDXGISharedHandleExportInfo
            SharedFenceMTLSharedEventDescriptor.value -> SharedFenceMTLSharedEventDescriptor
            SharedFenceMTLSharedEventExportInfo.value -> SharedFenceMTLSharedEventExportInfo
            SharedBufferMemoryD3D12ResourceDescriptor.value -> SharedBufferMemoryD3D12ResourceDescriptor
            StaticSamplerBindingLayout.value -> StaticSamplerBindingLayout
            YCbCrVkDescriptor.value -> YCbCrVkDescriptor
            SharedTextureMemoryAHardwareBufferProperties.value ->
                SharedTextureMemoryAHardwareBufferProperties

            AHardwareBufferProperties.value -> AHardwareBufferProperties
            else -> error("enum not found")
        }
    }
}
