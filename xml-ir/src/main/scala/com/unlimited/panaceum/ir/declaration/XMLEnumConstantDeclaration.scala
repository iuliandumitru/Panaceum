package com.unlimited.panaceum.ir.declaration

import japa.parser.ast.body.EnumConstantDeclaration
import com.unlimited.panaceum.ir.XMLRepresentation
import xml.Elem

/**
 * @author Iulian Dumitru
 */
class XMLEnumConstantDeclaration(declaration: EnumConstantDeclaration) extends XMLRepresentation{
  /**
   * XML representation.
   *
   * @return XML representation of an object
   */
  def toXML: Elem = <constant>{declaration.getName}</constant>

}
