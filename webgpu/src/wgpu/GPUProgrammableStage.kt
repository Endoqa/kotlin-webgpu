package wgpu

/**
 * @param module - The [wgpu.GPUShaderModule] containing the code that this programmable stage will execute.
 * @param entryPoint - The name of the function in [wgpu.GPUProgrammableStage.module] that this stage will use to
 * perform its work.
 *
 * NOTE: Since the [wgpu.GPUProgrammableStage.entryPoint] dictionary member is
 * not required, methods which consume a [wgpu.GPUProgrammableStage] must use the
 * "[$get the entry point$]" algorithm to determine which entry point
 * it refers to.
 * @param constants - Specifies the values of pipeline-overridable constants in the shader module
 * [wgpu.GPUProgrammableStage.module].
 *
 * Each such pipeline-overridable constant is uniquely identified by a single
 * pipeline-overridable constant identifier string, representing the [=pipeline
 * constant ID=] of the constant if its declaration specifies one, and otherwise the
 * constant's identifier name.
 *
 * The key of each key-value pair must equal the
 * pipeline-overridable constant identifier string|identifier string
 * of one such constant, with the comparison performed
 * according to the rules for WGSL identifier comparison.
 * When the pipeline is executed, that constant will have the specified value.
 *
 * Values are specified as <dfn typedef for="">GPUPipelineConstantValue</dfn>, which is a [wgpu.double].
 * They are converted [$to WGSL type$] of the pipeline-overridable constant (`bool`/`i32`/`u32`/`f32`/`f16`).
 * If conversion fails, a validation error is generated.
 *
 * <div class="example">
 *     Pipeline-overridable constants defined in WGSL:
 *
 *     <pre highlight="wgsl">                @id(0)      override has_point_light: bool = true;  // Algorithmic control.
 *         @id(1200)   override specular_param: f32 = 2.3;     // Numeric control.
 *         @id(1300)   override gain: f32;                     // Must be overridden.
 *                     override width: f32 = 0.0;              // Specifed at the API level
 *                                                             //   using the name "width".
 *                     override depth: f32;                    // Specifed at the API level
 *                                                             //   using the name "depth".
 *                                                             //   Must be overridden.
 *                     override height = 2 * depth;            // The default value
 *                                                             // (if not set at the API level),
 *                                                             // depends on another
 *                                                             // overridable constant.
 *     </pre>
 *
 *     Corresponding JavaScript code, providing only the overrides which are required
 *     (have no defaults):
 *
 *     <pre highlight="js">                {
 *             // ...
 *             constants: {
 *                 1300: 2.0,  // "gain"
 *                 depth: -1,  // "depth"
 *             }
 *         }
 *     </pre>
 *
 *     Corresponding JavaScript code, overriding all constants:
 *
 *     <pre highlight="js">                {
 *             // ...
 *             constants: {
 *                 0: false,   // "has_point_light"
 *                 1200: 3.0,  // "specular_param"
 *                 1300: 2.0,  // "gain"
 *                 width: 20,  // "width"
 *                 depth: -1,  // "depth"
 *                 height: 15, // "height"
 *             }
 *         }
 *     </pre>
 * </div>
 */
public abstract class GPUProgrammableStage(
    public open var module: GPUShaderModule,
    public open var entryPoint: String? = null,
    public open var constants: HashMap<String, GPUPipelineConstantValue> = hashMapOf(),
)
