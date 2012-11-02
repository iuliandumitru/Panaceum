package com.unlimited.panaceum.ir.declaration

import japa.parser.ast.body._
import com.unlimited.panaceum.ir.XMLRepresentation

/**
 * @author Iulian Dumitru
 */
class XMLTypeDeclaration(declaration: TypeDeclaration) extends XMLRepresentation {
  /**
   * XML representation.
   *
   * @return XML representation of an object
   */
  def toXML = declaration match {

    case d: AnnotationDeclaration => <annotation name={d.getName}></annotation>

    case d: ClassOrInterfaceDeclaration => {

      d.isInterface match {
        case true => {
          <interface name={d.getName}></interface>
        }
        case false => {
          <class name={d.getName}></class>
        }
      }

    }

    case d: EmptyTypeDeclaration => <empty></empty>

    case d: EnumDeclaration => <enum name={d.getName}></enum>

    case d@_ => throw new Error(s"Unknown declaration type! Found: $d")

  }

}
