package storeSQL;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SumSAXParser {
    private long sum;

    public class FieldCounter extends DefaultHandler {
        private long sum = 0;

        public long getSum() {
            return sum;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("entry")) {
                sum += Integer.valueOf(attributes.getValue("field"));
            }
        }
    }

    public void parseSum(File file) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLReader xmlReader = parser.getXMLReader();
        FieldCounter counter = new FieldCounter();
        xmlReader.setContentHandler(counter);
        xmlReader.parse(file.getAbsolutePath());
        sum = counter.getSum();
    }

    public long getSum() {
        return sum;
    }
}
