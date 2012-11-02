package com.unlimited.panaceum.ir.declaration

import japa.parser.ast.ImportDeclaration
import japa.parser.ast.expr.NameExpr
import org.junit.Test

/**
 * @author Iulian Dumitru
 */
class XMLImportDeclarationTest {


  @Test
  def test = {

    val declaration = new ImportDeclaration(new NameExpr("com.unlimited"), false, true)
    val xmlImportDeclaration = new XMLImportDeclaration(declaration)

    println(xmlImportDeclaration.toXML)

  }

}
