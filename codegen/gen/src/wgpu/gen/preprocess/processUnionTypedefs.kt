package wgpu.gen.preprocess

import idl.*


internal fun processUnionTypedefs(idl: IDL) {
    val namesToProcess = listOf("GPUColor", "GPUOrigin2D", "GPUOrigin3D", "GPUExtent3D")


    val typedefsToProcess = idl.definitions
        .filterIsInstance<Typedef>()
        .filter { typedef: Typedef ->
            val needProcess = typedef.name in namesToProcess
            if (!needProcess) return@filter false

            val type = typedef.type

            val matchBasicAssumption = type is UnionType && type.memberTypes.size == 2

            if (!matchBasicAssumption) return@filter false

            type as UnionType

            val matchTypeAssumption = type.memberTypes[0] is SequenceType && type.memberTypes[1] is Identifier

            if (!matchTypeAssumption) return@filter false

            (type.memberTypes[1] as Identifier).name == "${typedef.name}Dict"
        }

    for (typedef in typedefsToProcess) {
        val dictName = "${typedef.name}Dict"
        val dictDef = idl.definitions.filterIsInstance<Dictionary>().find { it.name == dictName }

        if (dictDef != null) {
            val newDict = dictDef.copy(name = typedef.name)

            val dictIndex = idl.definitions.indexOf(dictDef)
            if (dictIndex >= 0) {
                idl.definitions[dictIndex] = newDict
            }
            idl.definitions.remove(typedef)
        }
    }
}