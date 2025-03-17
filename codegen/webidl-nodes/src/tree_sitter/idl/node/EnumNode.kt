package tree_sitter.idl.node

import kotlin.collections.List
import tree_sitter.Node

public sealed interface EnumNodeValues : IDLTSBaseNode {
  public companion object {
    public operator fun invoke(node: Node): EnumNodeValues {
      val n = createNode(node)
      if (n is EnumNodeValues) {
        return n
      }
      throw IllegalArgumentException("Node is not a EnumNodeValues")
    }
  }
}

public class EnumNode(
  override val `$node`: Node,
) : IDLTSBaseNode,
    _DefinitionNode {
  public val attributes: ExtendedAttributeListNode?
    get() = (`$node`.getChildByFieldName("attributes"))?.let { ExtendedAttributeListNode(it) }

  public val name: IdentifierNode
    get() = IdentifierNode(`$node`.getChildByFieldName("name") ?:
        error("required field name is null"))

  public val `value`: List<StringNode>
    get() = useCursor { cursor ->
      `$node`.childrenByFieldName("value", cursor)
      .asSequence()
      .map { StringNode(it) }
      .toList()
    }

  public val values: List<EnumNodeValues>
    get() = useCursor { cursor ->
      `$node`.childrenByFieldName("values", cursor)
      .asSequence()
      .map { EnumNodeValues(it) }
      .toList()
    }
}
