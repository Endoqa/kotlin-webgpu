package wgpu

/**
 * @param featureLevel - "Feature level" for the adapter request.
 *
 * The allowed <dfn dfn for="">feature level string</dfn> values are:
 *
 * <dl dfn-type="dfn" dfn-for="feature level string">
 *     : <dfn noexport>"core"</dfn>
 *     :: No effect.
 *     : <dfn noexport>"compatibility"</dfn>
 *     :: No effect.
 *
 *         Note:
 *         This value is reserved for future use as a way to opt into additional validation restrictions.
 *         Applications should not use this value at this time.
 * </dl>
 * @param powerPreference - Optionally provides a hint indicating what class of adapter should be selected from
 * the system's available adapters.
 *
 * The value of this hint may influence which adapter is chosen, but it must not
 * influence whether an adapter is returned or not.
 *
 * Note:
 * The primary utility of this hint is to influence which GPU is used in a multi-GPU system.
 * For instance, some laptops have a low-power integrated GPU and a high-performance
 * discrete GPU. This hint may also affect the power configuration of the selected GPU to
 * match the requested power preference.
 *
 * Note:
 * Depending on the exact hardware configuration, such as battery status and attached displays
 * or removable GPUs, the user agent may select different adapters given the same power
 * preference.
 * Typically, given the same hardware configuration and state and
 * `powerPreference`, the user agent is likely to select the same adapter.
 *
 * It must be one of the following values:
 *
 * <dl dfn-type="enum-value" dfn-for="GPUPowerPreference">
 *     : `undefined` (or not present)
 *     ::
 *         Provides no hint to the user agent.
 *
 *     : <dfn>"low-power"</dfn>
 *     ::
 *         Indicates a request to prioritize power savings over performance.
 *
 *         Note:
 *         Generally, content should use this if it is unlikely to be constrained by drawing
 *         performance; for example, if it renders only one frame per second, draws only relatively
 *         simple geometry with simple shaders, or uses a small HTML canvas element.
 *         Developers are encouraged to use this value if their content allows, since it may
 *         significantly improve battery life on portable devices.
 *
 *     : <dfn>"high-performance"</dfn>
 *     ::
 *         Indicates a request to prioritize performance over power consumption.
 *
 *         Note:
 *         By choosing this value, developers should be aware that, for devices created on the
 *         resulting adapter, user agents are more likely to force device loss, in order to save
 *         power by switching to a lower-power adapter.
 *         Developers are encouraged to only specify this value if they believe it is absolutely
 *         necessary, since it may significantly decrease battery life on portable devices.
 * </dl>
 * @param forceFallbackAdapter - When set to `true` indicates that only a fallback adapter may be returned. If the user
 * agent does not support a fallback adapter, will cause [wgpu.GPU.requestAdapter] to
 * resolve to `null`.
 *
 * Note:
 * [wgpu.GPU.requestAdapter] may still return a fallback adapter if
 * [wgpu.GPURequestAdapterOptions.forceFallbackAdapter] is set to `false` and either no
 * other appropriate adapter is available or the user agent chooses to return a
 * fallback adapter. Developers that wish to prevent their applications from running on
 * fallback adapters should check the
 * [wgpu.GPUAdapter.info].[wgpu.GPUAdapterInfo.isFallbackAdapter] attribute prior
 * to requesting a [wgpu.GPUDevice].
 * @param xrCompatible - When set to `true` indicates that the best adapter=] for rendering to a [=WebXR session
 * must be returned. If the user agent or system does not support WebXR sessions then
 * adapter selection may ignore this value.
 *
 * Note:
 * If [wgpu.GPURequestAdapterOptions.xrCompatible] is not set to `true` when the adapter is
 * requested, [wgpu.GPUDevice]s created from the adapter cannot be used to render for
 * WebXR sessions.
 */
public data class GPURequestAdapterOptions(
    public var featureLevel: String = "core",
    public var powerPreference: GPUPowerPreference? = null,
    public var forceFallbackAdapter: Boolean = false,
    public var xrCompatible: Boolean = false,
)
