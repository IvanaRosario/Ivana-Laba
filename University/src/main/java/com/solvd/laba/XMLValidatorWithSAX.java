package com.solvd.laba;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class XMLValidatorWithSAX {
    public static void main(String[] args) {
       try {
           File xmlFile = new File(
                   "C:\\Users\\Ivana Rosario\\IdeaProjects\\University\\src\\main\\resources\\University.xml");
           File xsdFile = new File(
                   "C:\\Users\\Ivana Rosario\\IdeaProjects\\University\\src\\main\\resources\\University.xsd");

           SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
           saxParserFactory.setNamespaceAware(true);
           saxParserFactory.setValidating(false);

           SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
           Schema schema = schemaFactory.newSchema(xsdFile);

           saxParserFactory.setSchema(schema);

           SAXParser saxParser = saxParserFactory.newSAXParser();

           DefaultHandler errorHandler = new DefaultHandler() {
               @Override
               public void error(SAXParseException e) throws SAXException {
                   System.out.println("Error: " + e.getMessage());
               }

               @Override
               public void fatalError(SAXParseException e) throws SAXException {
                   System.out.println("Fatal Error: " + e.getMessage());
               }

               @Override
               public void warning(SAXParseException e) throws SAXException {
                   System.out.println("Warning: " + e.getMessage());
               }
           };

           saxParser.parse(xmlFile, errorHandler);
           System.out.println("XML File is valid");

       } catch(SAXException e) {
           System.out.println("XML File is not valid \n" + e.getMessage());

       } catch(Exception e) {
           e.printStackTrace();
       }

    }
}
