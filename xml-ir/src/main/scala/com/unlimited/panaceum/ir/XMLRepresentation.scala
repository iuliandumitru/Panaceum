package com.unlimited.panaceum.ir

import com.unlimited.panaceum.utils.XmlFormatter
import xml.Elem


/**
 * XML representation.
 *
 * @author Iulian Dumitru 
 */

trait XMLRepresentation {

  implicit def anyToText(a: AnyVal) = xml.Text(a.toString)

  implicit def xmlToString(xml: Elem) = xml.toString()

  /**
   * XML representation.
   *
   * @return XML representation of an object
   */
  def toXML: Elem

  /**
   * @return formatted xml representation
   */
  def toFormattedXML: String = XmlFormatter.format(toXML.toString())

}

