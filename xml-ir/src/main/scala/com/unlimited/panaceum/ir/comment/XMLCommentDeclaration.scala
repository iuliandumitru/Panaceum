package com.unlimited.panaceum.ir.comment

import japa.parser.ast.{LineComment, BlockComment, Comment}
import com.unlimited.panaceum.ir.XMLRepresentation
import japa.parser.ast.body.JavadocComment

/**
 * XML representation of a comment declaration.
 *
 * @author Iulian Dumitru
 */
class XMLCommentDeclaration(comment: Comment) extends XMLRepresentation {
  /**
   * XML representation.
   *
   * @return XML representation of an object
   */
  def toXML = comment match {

    case c: BlockComment => {
      <comment type="block">
        {c.getContent}
      </comment>
    }

    case c: JavadocComment => {
      <comment type="javadoc">
        {c.getContent}
      </comment>
    }

    case c: LineComment => {
      <comment type="line">
        {c.getContent}
      </comment>
    }

    case c@_ => throw new Error(s"Unknown comment type! Found: $c")

  }

}
