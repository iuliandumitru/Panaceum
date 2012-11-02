package com.unlimited.panaceum.ir.declaration

import japa.parser.ast.body._
import com.unlimited.panaceum.ir.XMLRepresentation
import java.util
import japa.parser.ast.TypeParameter
import scala.collection.JavaConversions._

import com.unlimited.panaceum.ir.XMLConversions._
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

      val typeParameters = d.getTypeParameters match {
        case null => new util.ArrayList[TypeParameter]
        case _ => d.getTypeParameters
      }

      val extendsList = d.getExtends
      val implementsList = d.getImplements


      d.isInterface match {
        case true => {
          <interface name={d.getName}>

            <parameters>
              {typeParameters.map {
              t =>
                <param name={t.getName}></param>
            }}
            </parameters>

          </interface>
        }

        case false => {
          <class name={d.getName}>

            <parameters>
              {typeParameters.map {
              t =>
                <param name={t.getName}></param>
            }}
            </parameters>

          </class>
        }

      }

    }

    case d: EmptyTypeDeclaration => <empty></empty>

    case d: EnumDeclaration => {
      <enum name={d.getName}>
        {for (entry <- d.getEntries) yield {entry.toXML}}
      </enum>
    }

    case d@_ => throw new Error(s"Unknown declaration type! Found: $d")

  }

}
