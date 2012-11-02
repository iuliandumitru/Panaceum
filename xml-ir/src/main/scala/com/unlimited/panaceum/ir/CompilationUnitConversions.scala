package com.unlimited.panaceum.ir

import declaration.{XMLImportDeclaration, XMLPackageDeclaration, XMLBodyDeclaration}
import expression.XMLExpression
import japa.parser.ast.{ImportDeclaration, PackageDeclaration, Node, CompilationUnit}
import japa.parser.ast.body.BodyDeclaration
import japa.parser.ast.stmt.Statement
import japa.parser.ast.expr.Expression
import statement.XMLStatement

/**
 * Implicit conversions to simplify XML representation support.
 *
 * @author Iulian Dumitru 
 */

object CompilationUnitConversions {

  implicit def toXMLCompilationUnit(e: CompilationUnit): XMLRepresentation = new XMLCompilationUnit(e)

  implicit def toXMLPackageDeclaration(e: PackageDeclaration): XMLRepresentation = new XMLPackageDeclaration(e)

  implicit def toXMLImportDeclaration(e: ImportDeclaration): XMLRepresentation = new XMLImportDeclaration(e)


  implicit def toXMLBodyDeclaration(e: BodyDeclaration): XMLRepresentation = new XMLBodyDeclaration(e)

  implicit def toXMLStatement(e: Statement): XMLRepresentation = new XMLStatement(e)

  implicit def toXMLExpression(e: Expression): XMLRepresentation = new XMLExpression(e)


}
