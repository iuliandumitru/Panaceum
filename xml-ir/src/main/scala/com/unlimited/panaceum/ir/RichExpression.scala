package com.unlimited.panaceum.ir

import japa.parser.ast.expr.{AnnotationExpr, Expression}
import xml.Elem

/**
 * Enhance Expression with XML representation.
 *
 * @author Iulian Dumitru 
 */
class RichExpression(expression: Expression) extends XMLRepresentation {

  def toXML: String = throw new Error("Unknown expression type!")
}
