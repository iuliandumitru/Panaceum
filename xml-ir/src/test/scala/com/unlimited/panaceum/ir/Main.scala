package com.unlimited.panaceum.ir

import japa.parser.JavaParser
import CompilationUnitConversions._

import com.unlimited.panaceum.utils.XmlFormatter

/**
 * @author Iulian Dumitru 
 */
object Main {


  def main(args: Array[String]) {

    val in = classOf[TestParser].getResourceAsStream("/Test.txt")
    val compilationUnit = JavaParser.parse(in)
    val xml = compilationUnit.toXML

    println(s"Unformatted: \n\n${xml}\n\n\n")

    val formattedXml = XmlFormatter.format(xml)

    println(formattedXml)

  }


}
