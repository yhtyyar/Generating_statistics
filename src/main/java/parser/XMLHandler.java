package parser;

import model.Address;
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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class XMLHandler extends DefaultHandler{

    private static final SAXParserFactory factory = SAXParserFactory.newInstance();
    private SAXParser parser;
    private XMLReader xmlReader;

    private static final List<String> addressList = new ArrayList<>();
    private static final List<String> cityNameList = new LinkedList<>();
    private static final List<Integer> floorList = new LinkedList<>();

    public XMLHandler() {

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

        xmlReader.setContentHandler(this);

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
    public void startDocument() throws SAXException {
        addressList.clear();
        cityNameList.clear();
        floorList.clear();
        super.startDocument();
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        if (qName.equals("item")) {
            String cityName = attributes.getValue("city");
            String streetName = attributes.getValue("street");
            int houseNumber = Integer.parseInt(attributes.getValue("house"));
            int floor = Integer.parseInt(attributes.getValue("floor"));

            addressList.add(String.valueOf(new Address(cityName, streetName, houseNumber, floor)));
            cityNameList.add(cityName);
            floorList.add(floor);

        } else {

            // ???? ???????? ?????? ???????????????????????? ???????????????????? ?????? ???????????????????? ??????????????????
            System.out.println("");
        }
    }

    public List<String> getAddressList() {
        return addressList;
    }

    public List<String> getCityNameList() {
        return cityNameList;
    }

    public List<Integer> getFloors() {
        return floorList;
    }

}
