package com.unlimited.panaceum.ir.statement

import japa.parser.ast.stmt._
import scala.collection.JavaConversions._
import com.unlimited.panaceum.ir.XMLConversions._
import xml.Elem
import com.unlimited.panaceum.ir.XMLRepresentation

/**
 * Enhance statement with XML representation.
 *
 * @author Iulian Dumitru 
 */
class XMLStatement(statement: Statement) extends XMLRepresentation {

  def toXML = statement match {

    //ignore this for now
    case s: AssertStmt => <assert></assert>

    case s: BlockStmt =>  <block></block>

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

    case s: EmptyStmt => <empty></empty>

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
