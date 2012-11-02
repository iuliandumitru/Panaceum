package com.unlimited.panaceum.ir.declaration

import japa.parser.ast.ImportDeclaration
import com.unlimited.panaceum.ir.XMLRepresentation

/**
 * @author Iulian Dumitru
 */
class XMLImportDeclaration(declaration: ImportDeclaration) extends XMLRepresentation {
  /**
   * XML representation.
   *
   * @return XML representation of an object
   */
  def toXML = <import static={declaration.isStatic} all={declaration.isAsterisk}>
    {declaration.getName}
  </import>

}
