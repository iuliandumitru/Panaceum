package com.unlimited.panaceum.ir

import japa.parser.ast.body._
import japa.parser.ast.`type`.{ReferenceType, ClassOrInterfaceType}
import com.unlimited.panaceum.ir.TypeConversions._
import scala.collection.JavaConversions._

/**
 * Body Declaration enhanced with XML representation.
 *
 * @author Iulian Dumitru 
 */
class RichBodyDeclaration(bd: BodyDeclaration) extends XMLRepresentation {

  def toXML: String = bd match {

    case md: MethodDeclaration => {

      val modifiers = md.getModifiers
      val isFinal = ModifierSet.isFinal(modifiers)
      val isAbstract = ModifierSet.isAbstract(modifiers)

      val modifierName = if (ModifierSet.isPrivate(modifiers)) "private"
      else if (ModifierSet.isPublic(modifiers)) "public"
      else if (ModifierSet.isProtected(modifiers)) "protected"
      else throw new Error("Cannot find modifier name!")

      s"""<method name="${md.getName}" modifer="${modifierName}" isFinal="${isFinal}" isAbstract="${isAbstract}" />"""

    }

    case declaration: FieldDeclaration => {

      val modifiers = declaration.getModifiers

      val fieldTypeName = declaration.getType match {
        case t: ClassOrInterfaceType => t.getName
        case t: ReferenceType => t.getType.typeName
        case t@_ => throw new Error(s"Error finding field type! Found [$t]")
      }

      val isFinal = ModifierSet.isFinal(modifiers)
      val variables = declaration.getVariables


      val xml = new StringBuilder

      variables.foreach {
        v =>
          val id = v.getId
          xml.append( s"""<field name="${id}" type="${fieldTypeName}" isFinal="${isFinal}" />""")
      }

      xml.toString()

    }

    case d: ConstructorDeclaration => {

      val modifiers = d.getModifiers
      val modifierName = if (ModifierSet.isPrivate(modifiers)) "private"
      else if (ModifierSet.isPublic(modifiers)) "public"
      else if (ModifierSet.isProtected(modifiers)) "protected"
      else throw new Error("Cannot find modifier name!")

      val parameters = d.getParameters
      val typeParameters = d.getTypeParameters

      <constructor modifier={modifierName}>
        <parameters>
          {for (p <- parameters) yield <parameter name={p.getId.getName} type={p.getType.typeName}/>}
        </parameters>
      </constructor>.toString()


    }

    case d@_ => {
      throw new Error(s"Unknown BodyDeclaration! Found ${d}")
    }

  }


}
