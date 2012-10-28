package com.unlimited.panaceum.ir

import org.junit.Test
import japa.parser.ast.stmt.{AssertStmt, Statement}
import japa.parser.ast.expr.{NameExpr, ThisExpr}
import com.unlimited.panaceum.utils.LoggingTrait

/**
 * @author Iulian Dumitru 
 */
class RichStatementTest extends LoggingTrait {


  @Test
  def testStmt = {

    val stmt = new AssertStmt
    stmt.setCheck(new ThisExpr())
    stmt.setMessage(new NameExpr())

    LOG.debug(">>{}", stmt)


  }


}
