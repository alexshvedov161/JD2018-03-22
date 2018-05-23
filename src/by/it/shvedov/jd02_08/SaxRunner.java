package by.it.shvedov.jd02_08;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxRunner {
    public static void main(String[] args) {
        String fileName= "src/by/it/shvedov/jd02_08/persons.xml";

        try {
            SAXParserFactory factory=SAXParserFactory.newInstance();
            SAXParser parser=factory.newSAXParser();
            Sax handler= new Sax();
            parser.parse(new File(fileName),handler);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
