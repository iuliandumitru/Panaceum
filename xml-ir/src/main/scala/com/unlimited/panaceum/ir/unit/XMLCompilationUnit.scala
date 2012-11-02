package com.unlimited.panaceum.ir.unit

import japa.parser.ast.CompilationUnit
import scala.collection.JavaConversions._
import com.unlimited.panaceum.ir.XMLConversions._
import com.unlimited.panaceum.ir.XMLRepresentation

/**
 * XML representation of a java compilation unit.
 *
 * @author Iulian Dumitru 
 */
class XMLCompilationUnit(val compilationUnit: CompilationUnit) extends XMLRepresentation {

  override def toXML = {

    val packageDeclaration = compilationUnit.getPackage.toXML
    val importDeclarations = compilationUnit.getImports
    val typeDeclarations = compilationUnit.getTypes
    val commentDeclarations = compilationUnit.getComments

    <unit>

      {packageDeclaration}

      <comments>
       {for (declaration <- commentDeclarations) yield {declaration.toXML}}
      </comments>

      <imports>
       {for (declaration <- importDeclarations) yield {declaration.toXML}}
      </imports>

      <types>
        {for (declaration <- typeDeclarations) yield {declaration.toXML}}
      </types>

    </unit>

  }

}
