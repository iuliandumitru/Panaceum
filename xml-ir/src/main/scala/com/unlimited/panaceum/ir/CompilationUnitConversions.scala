package com.unlimited.panaceum.ir

import japa.parser.ast.{Node, CompilationUnit}
import japa.parser.ast.body.BodyDeclaration
import japa.parser.ast.stmt.Statement
import japa.parser.ast.expr.Expression

/**
 * Implicit conversions to simplify XML representation support.
 *
 * @author Iulian Dumitru 
 */

object CompilationUnitConversions {

  implicit def toRichCompilationUnit(e: CompilationUnit): XMLRepresentation = new RichCompilationUnit(e)

  implicit def toRichBodyDeclaration(e: BodyDeclaration): XMLRepresentation = new RichBodyDeclaration(e)

  implicit def toRichStatement(e: Statement): XMLRepresentation = new RichStatement(e)

  implicit def toRichExpression(e: Expression): XMLRepresentation = new RichExpression(e)


}
