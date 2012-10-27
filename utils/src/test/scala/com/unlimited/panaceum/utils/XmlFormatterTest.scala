package com.unlimited.panaceum.utils

import org.junit._

/**
 * @author Iulian Dumitru 
 */
class XmlFormatterTest {

  @Test
  def testFormat = {

    val xml = """<class name='GroupByReducePipe'><method name='processNextStart'></method>
                <method name='addValue'><parameters><parameter name='value'/>
                  <parameter name='values'/></parameters></method><method name='getSideEffect'></method>
                <method name='getKey'><parameters><parameter name='start'/></parameters></method><method name='getValue'>
                <parameters><parameter name='start'/></parameters></method><method name='reset'></method></class>""".trim


    val formatted = XmlFormatter.format(xml).trim
    Assert.assertNotNull(formatted)

    println(formatted)


    /*
        Assert.assertEquals(
          """
    <class name="GroupByReducePipe">
      <method name="processNextStart"></method>
      <method name="addValue">
        <parameters>
          <parameter name="value"></parameter>
          <parameter name="values"></parameter>
        </parameters>
      </method>
      <method name="getSideEffect"></method>
      <method name="getKey">
        <parameters>
          <parameter name="start"></parameter>
        </parameters>
      </method>
      <method name="getValue">
        <parameters>
          <parameter name="start"></parameter>
        </parameters>
      </method>
      <method name="reset"></method>
    </class>
          """.trim, formatted)
    */


  }

}
