package com.unlimited.panaceum.ir.declaration

import com.unlimited.panaceum.ir.XMLRepresentation
import japa.parser.ast.PackageDeclaration

/**
 * @author Iulian Dumitru
 */
class XMLPackageDeclaration(declaration: PackageDeclaration) extends XMLRepresentation {
  /**
   * XML representation.
   *
   * @return XML representation of an object
   */
  def toXML = <package>
    {declaration.getName}
  </package>

}
