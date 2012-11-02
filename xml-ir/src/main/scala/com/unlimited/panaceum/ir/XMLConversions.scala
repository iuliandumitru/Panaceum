package com.unlimited.panaceum.ir

import comment.XMLCommentDeclaration
import declaration._
import expression.XMLExpression
import japa.parser.ast._
import body.{EnumConstantDeclaration, TypeDeclaration, BodyDeclaration}
import japa.parser.ast.stmt.Statement
import japa.parser.ast.expr.Expression
import statement.XMLStatement
import unit.XMLCompilationUnit

/**
 * Implicit conversions to simplify XML representation support.
 *
 * @author Iulian Dumitru 
 */

object XMLConversions {

  implicit def toXMLCompilationUnit(e: CompilationUnit): XMLRepresentation = new XMLCompilationUnit(e)

  implicit def toXMLPackageDeclaration(e: PackageDeclaration): XMLRepresentation = new XMLPackageDeclaration(e)

  implicit def toXMLImportDeclaration(e: ImportDeclaration): XMLRepresentation = new XMLImportDeclaration(e)

  implicit def toXMLTypeDeclaration(e: TypeDeclaration): XMLRepresentation = new XMLTypeDeclaration(e)

  implicit def toXMLComment(e: Comment): XMLRepresentation = new XMLCommentDeclaration(e)

  implicit def toXMLXMLEnumConstantDeclaration(e: EnumConstantDeclaration): XMLRepresentation = new XMLEnumConstantDeclaration(e)


  implicit def toXMLBodyDeclaration(e: BodyDeclaration): XMLRepresentation = new XMLBodyDeclaration(e)

  implicit def toXMLStatement(e: Statement): XMLRepresentation = new XMLStatement(e)

  implicit def toXMLExpression(e: Expression): XMLRepresentation = new XMLExpression(e)


}
