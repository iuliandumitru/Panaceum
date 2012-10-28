package com.unlimited.panaceum.ir

import japa.parser.ast.CompilationUnit
import japa.parser.ast.body.BodyDeclaration

/**
 * @author Iulian Dumitru 
 */

object CompilationUnitConversions {

  implicit def toRichCompilationUnit(e: CompilationUnit): XMLRepresentation = new RichCompilationUnit(e)

  implicit def toRichBodyDeclaration(e: BodyDeclaration): XMLRepresentation = new RichBodyDeclaration(e)

}
