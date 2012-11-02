package com.unlimited.panaceum.ir.declaration

import japa.parser.ast.body._
import com.unlimited.panaceum.ir.XMLRepresentation
import java.util
import japa.parser.ast.TypeParameter
import scala.collection.JavaConversions._

import com.unlimited.panaceum.ir.XMLConversions._
import japa.parser.ast.`type`.ClassOrInterfaceType

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

      val extendsList = d.getExtends match {
        case null => new util.ArrayList[ClassOrInterfaceType]
        case _ => d.getExtends
      }

      val implementsList = d.getImplements match {
        case null => new util.ArrayList[ClassOrInterfaceType]
        case _ => d.getImplements
      }

      d.isInterface match {
        case true => {

          <interface name={d.getName}>
            {if (extendsList.size()>0)
            <extends>
              {for {e <- extendsList} yield <extend>{e.getName}</extend>}
            </extends>
            }
            {if (typeParameters.size()>0)
            <parameters>
              {for { p <- typeParameters} yield <param type={p.getName}></param> }
            </parameters>
            }
          </interface>

        }

        case false => {
          <class name={d.getName}>
            {if (extendsList.size()>0)
            <extends>
              {for {e <- extendsList} yield <extend>{e.getName}</extend>}
            </extends>
            }

            {if (implementsList.size()>0)
            <implements>
              {for {e <- implementsList} yield <implement>{e.getName}</implement>}
            </implements>
            }

            {if (typeParameters.size()>0)
            <parameters>
              {for { p <- typeParameters} yield <param type={p.getName}></param> }
            </parameters>
            }
          </class>
        }

      }

    }

    case d: EmptyTypeDeclaration => <empty></empty>

    case d: EnumDeclaration => {
      <enum name={d.getName}>
        {for (entry <- d.getEntries) yield {
        entry.toXML
      }}
      </enum>
    }

    case d@_ => throw new Error(s"Unknown declaration type! Found: $d")

  }

}
