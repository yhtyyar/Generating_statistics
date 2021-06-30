package repository;


import model.Address;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class SaxParserGetAllAddressRepository implements GetAllAddressRepository {


    private static final List<String> addresses = new ArrayList<>();
    private static final SAXParserFactory factory = SAXParserFactory.newInstance();
    private static SAXParser parser;
    private static final XMLHandlerForList handler = new XMLHandlerForList();
    private static XMLReader xmlReader;


    public SaxParserGetAllAddressRepository() {

        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            System.out.println("Parser configuration  error: " + e.toString());
        } catch (SAXException e) {
            System.out.println("Sax parsing error: " + e.toString());
        }

        try {
            xmlReader = parser.getXMLReader();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        xmlReader.setContentHandler(handler);

        InputSource source = new InputSource("src/main/resources/address.xml");

        source.setEncoding(StandardCharsets.UTF_8.displayName());


        try {
            xmlReader.parse(source);
        } catch (SAXException e) {
            System.out.println("Sax parsing error: " + e.toString());
        } catch (IOException e) {
            System.out.println("IO parsing error: " + e.toString());
        }

    }

    @Override
    public List<String> getAllInList() {

        return addresses;
    }


    private static class XMLHandlerForList extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {

            if (qName.equals("item")) {
                String cityName = attributes.getValue("city");
                String streetName = attributes.getValue("street");
                int houseNumber = Integer.parseInt(attributes.getValue("house"));
                int floor = Integer.parseInt(attributes.getValue("floor"));

                addresses.add(String.valueOf(new Address(cityName, streetName, houseNumber, floor)));
            }
        }
    }
}
