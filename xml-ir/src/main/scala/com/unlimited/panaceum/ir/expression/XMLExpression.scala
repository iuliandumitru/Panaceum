package com.unlimited.panaceum.ir.expression

import japa.parser.ast.expr.{AnnotationExpr, Expression}
import com.unlimited.panaceum.ir.XMLRepresentation

/**
 * Enhance Expression with XML representation.
 *
 * @author Iulian Dumitru 
 */
class XMLExpression(expression: Expression) extends XMLRepresentation {

  def toXML = expression match {

    case e: AnnotationExpr => <annotation></annotation>

    case _ => throw new Error("Unknown expression type!")

  }

}
