package com.unlimited.panaceum.ir

import japa.parser.ast.body.{EmptyTypeDeclaration, EnumDeclaration, ClassOrInterfaceDeclaration}
import japa.parser.ast.CompilationUnit
import scala.collection.JavaConversions._
import CompilationUnitConversions._

/**
 * Enhanced compilation unit with XML representation.
 *
 * @author Iulian Dumitru 
 */
class XMLCompilationUnit(val compilationUnit: CompilationUnit) extends XMLRepresentation {

  def toXML = {

    val packageDeclaration = compilationUnit.getPackage.toXML

    <unit>
      {packageDeclaration}
      <imports>
       {for (stmt <- compilationUnit.getImports) yield {stmt.toXML}}
      </imports>
    </unit>





    /* val XML = new StringBuilder

        XML.append("<unit>")

        val packageDeclaration = compilationUnit.getPackage
        XML.append( s"""<package name="${packageDeclaration.getName}"/>""")

        val imports = compilationUnit.getImports
        XML.append("<imports>")
        imports.foreach {
          importDeclaration =>
            XML.append(s"<import>${importDeclaration.getName}</import>")
        }
        XML.append("</imports>")

        val types = compilationUnit.getTypes

        types.foreach {

          typeDeclaration =>

            typeDeclaration match {

              case e: ClassOrInterfaceDeclaration if e.isInterface => {

                XML.append( s"""<interface name="${typeDeclaration.getName}" """)
                val extendsList = e.getExtends
                extendsList match {
                  case null => ""
                  case _ => {
                    XML.append( """extends="""")
                    XML.append(extendsList.mkString(","))
                    XML.append( """"""")
                  }
                }

                val members = e.getMembers
                members.foreach {
                  m =>
                    XML.append(m.toXML)
                }

                XML.append("</interface")
              }

              case e: ClassOrInterfaceDeclaration => {
                XML.append( s"""<class name="${typeDeclaration.getName}" """)
                val extendsList = e.getExtends

                //find the superclass
                val list = extendsList.collect {
                  case c => c.getName
                }
                extendsList match {
                  case null => ""
                  case _ => {
                    XML.append( """extends="""")
                    XML.append(list.mkString(","))
                    XML.append( """"""")
                  }
                }
                XML.append(">")

                val members = e.getMembers
                members.foreach {
                  member =>
                    XML.append(member.toXML)
                }
                XML.append("</class>")
              }

              case declaration: EnumDeclaration => {

                XML.append("<enums>")
                XML.append(declaration.toXML)
                XML.append("</enums>")

              }

              case d: EmptyTypeDeclaration => {
                println("EMPTY DECLARATION !!!" + d)
              }

              case d@_ => {
                throw new Error(s"Unknown declaration! Found: $d")
              }

            }

        }

        XML.append("</unit>")

        XML.toString()
    */
  }

}
