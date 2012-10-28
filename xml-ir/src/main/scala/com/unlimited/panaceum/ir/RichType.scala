package com.unlimited.panaceum.ir

import japa.parser.ast.`type`._
import com.unlimited.panaceum.ir.TypeConversions._

/**
 * Rich type.
 * @author Iulian Dumitru 
 */
class RichType(t: Type) {

  def typeName: String = t match {

    case e: ClassOrInterfaceType => e.getName
    case e: PrimitiveType => e.getType.getDeclaringClass.getName
    case e: ReferenceType => e.getType.typeName
    case e: VoidType => "void"
    case e: WildcardType => "?"
    case e@_ => throw new Error(s"Unknown type! Found $e")

  }

}
