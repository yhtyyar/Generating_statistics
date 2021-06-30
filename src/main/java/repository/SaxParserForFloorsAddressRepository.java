package repository;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class SaxParserForFloorsAddressRepository implements FloorsOfInCityAddressRepository {

    private static final List<String> cityNameList = new LinkedList<>();
    private static final List<Integer> floorList = new LinkedList<>();
    private static final SAXParserFactory factory = SAXParserFactory.newInstance();
    private static SAXParser parser;
    private static final XMLHandler handler = new XMLHandler();
    private static XMLReader xmlReader;


    public SaxParserForFloorsAddressRepository() {

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
    public List<String> getCityNameList() {

        return cityNameList;
    }

    @Override
    public List<Integer> getFloorsOfInCity() {

        return floorList;
    }


    private static class XMLHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {

            if (qName.equals("item")) {
                String cityName = attributes.getValue("city");
                int floor = Integer.parseInt(attributes.getValue("floor"));

                cityNameList.add(cityName);
                floorList.add(floor);

            }
        }
    }

}
