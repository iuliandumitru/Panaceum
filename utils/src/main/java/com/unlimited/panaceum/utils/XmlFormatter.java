package com.unlimited.panaceum.utils;

import scala.xml.PrettyPrinter;
import scala.xml.TopScope$;
import scala.xml.XML;

/**
 * XML formatter.
 *
 * @author Iulian Dumitru
 */
public class XmlFormatter {

    public static final int WIDTH = 150;
    public static final int STEP = 3;

    private XmlFormatter() {
    }

    public static String format(String xml) {
        PrettyPrinter pp = new PrettyPrinter(WIDTH, STEP);
        return pp.format(XML.loadString(xml), TopScope$.MODULE$);
    }

}
