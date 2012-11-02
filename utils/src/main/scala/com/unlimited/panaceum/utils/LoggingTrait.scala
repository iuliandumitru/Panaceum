package com.unlimited.panaceum.utils

import org.slf4j.{LoggerFactory, Logger}

/**
 * Logging trait. Used to inject a logger fields in any class.
 *
 * @author Iulian Dumitru 
 */
trait LoggingTrait {

  val LOG = LoggerFactory.getLogger(getClass)

}
