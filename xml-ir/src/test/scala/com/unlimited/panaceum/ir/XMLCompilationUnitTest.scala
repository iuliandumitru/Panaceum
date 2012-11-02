package com.unlimited.panaceum.ir

import org.junit.Test
import japa.parser.JavaParser

/**
 * @author Iulian Dumitru
 */
class XMLCompilationUnitTest {

  @Test
  def test = {

    val in = getClass.getResourceAsStream("/Test.txt")
    val compilationUnit = JavaParser.parse(in)
    val xmlCompilationUnit = new XMLCompilationUnit(compilationUnit)

    println(xmlCompilationUnit.toFormattedXML)

  }


}
