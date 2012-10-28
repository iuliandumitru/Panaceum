package com.unlimited.panaceum.ir

import japa.parser.ast.stmt._
import scala.collection.JavaConversions._
import com.unlimited.panaceum.ir.CompilationUnitConversions._
import xml.Elem

/**
 * Enhance statement with XML representation.
 *
 * @author Iulian Dumitru 
 */
class RichStatement(statement: Statement) extends XMLRepresentation {

  implicit def xmlToString(xml: Elem) = xml.toString()


  def toXML = statement match {

    //ignore this for now
    case s: AssertStmt => ""

    case s: BlockStmt => {

      val stmts = s.getStmts
      stmts.collect {
        case s: Statement => s.toXML
      }.mkString

    }

    case s: BreakStmt => {

      val id = s.getId

      <break>
        {id}
      </break>

    }

    case s: ContinueStmt => {

      val id = s.getId
      <continue>
        {id}
      </continue>

    }

    case s: DoStmt => {

      val body = s.getBody
      val condition = s.getCondition

      <do>
        <body>
          {body.toXML}
        </body>
        <condition>
          {condition.toXML}
        </condition>
      </do>

    }

    case s: EmptyStmt => {
      ""
    }

    case s: ExplicitConstructorInvocationStmt => {

      val args = s.getArgs
      val expr = s.getExpr
      val typeArgs = s.getTypeArgs

      <constructor-invocation>

      </constructor-invocation>

    }


    case s@_ => throw new Error(s"Invalid statement! $s")


  }

}
