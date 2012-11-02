package com.unlimited.panaceum.ir.declaration

import org.junit.Test
import japa.parser.ast.PackageDeclaration
import japa.parser.ast.expr.NameExpr

/**
 * @author Iulian Dumitru
 */
class XMLPackageDeclarationTest {


  @Test
  def testXML = {

    val packageDeclaration = new PackageDeclaration(new NameExpr("com.unlimited"))
    val declaration = new XMLPackageDeclaration(packageDeclaration)

    val xml = declaration.toXML

    println(xml)


  }


}
