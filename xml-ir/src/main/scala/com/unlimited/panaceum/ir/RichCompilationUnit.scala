package com.unlimited.panaceum.ir

import com.unlimited.panaceum.ir.XMLRepresentation
import japa.parser.ast.body.{ClassOrInterfaceDeclaration, BodyDeclaration}
import japa.parser.ast.CompilationUnit
import scala.collection.JavaConversions._
import CompilationUnitConversions._

/**
 * @author Iulian Dumitru 
 */
class RichCompilationUnit(compilationUnit: CompilationUnit) extends XMLRepresentation {

  def toXML: String = {

    val XML = new StringBuilder

    XML.append("<unit>")

    val packageDeclaration = compilationUnit.getPackage
    XML.append( s"""<package name="${packageDeclaration.getName}"/>""")

    val imports = compilationUnit.getImports
    XML.append("<imports>")
    imports.foreach {
      i =>
        XML.append(s"<import>${i.getName}</import>")
    }
    XML.append("</imports>")

    val types = compilationUnit.getTypes

    types.foreach {

      t =>

        t match {

          case e: ClassOrInterfaceDeclaration if e.isInterface => {
            XML.append( s"""<interface name="${t.getName}">""")

            val members = e.getMembers
            members.foreach {
              m =>
                XML.append(m.toXML)
            }

            XML.append("</interface")
          }

          case e: ClassOrInterfaceDeclaration => {
            XML.append( s"""<class name="${t.getName}" >""")
            val members = e.getMembers
            members.foreach {
              m =>
                XML.append(m.toXML)
            }
            XML.append("</class>")
          }

        }

    }

    XML.append("</unit>")

    XML.toString()

  }

}
