package com.unlimited.panaceum.ir

import japa.parser.JavaParser
import japa.parser.ast.visitor.VoidVisitorAdapter
import japa.parser.ast.body.{Parameter, MethodDeclaration}
import java.util
import japa.parser.ast.`type`.ClassOrInterfaceType

/**
 * @author Iulian Dumitru 
 */
object Main {


  def main(args: Array[String]) {

    val in = classOf[TestParser].getResourceAsStream("/Test.txt")
    val cu = JavaParser.parse(in)

  }

}

/**
 * Simple visitor implementation for visiting MethodDeclaration nodes.
 */
class MethodVisitor extends VoidVisitorAdapter {


  override def visit(n: ClassOrInterfaceType, arg: Nothing) {


  }


  //  override def visit(methodDeclaration: MethodDeclaration, arg: AnyRef) {
  //    val parameters: util.List[Parameter] = methodDeclaration.getParameters
  //    System.out.println("<method name='" + methodDeclaration.getName + "'>")
  //    if (parameters != null) {
  //      import scala.collection.JavaConversions._
  //      for (parameter <- parameters) {
  //        System.out.println("<parameter name='" + parameter.getId.getName + "'/>")
  //      }
  //    }
  //    System.out.println("</method>")
  //  }
  override def visit(n: MethodDeclaration, arg: Nothing) {


  }
}
