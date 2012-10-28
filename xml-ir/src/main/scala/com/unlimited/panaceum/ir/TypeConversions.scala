package com.unlimited.panaceum.ir

import japa.parser.ast.`type`.Type

/**
 * @author Iulian Dumitru 
 */
object TypeConversions {

  implicit def addGetName(t: Type) = new RichType(t)

}
