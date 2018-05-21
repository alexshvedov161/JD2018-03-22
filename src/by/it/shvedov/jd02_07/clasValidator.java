package by.it.shvedov.jd02_07;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class clasValidator {
    public static void main(String[] args) {
        String language= XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName="src/by/it/shvedov/jd02_07/persons+xsd.xml";
        String schemaName="src/by/it/shvedov/jd02_07/person.xsd";
        SchemaFactory factory=SchemaFactory.newInstance(language);
        File schemaLocation=new File(schemaName);
        try {
            Schema schema=factory.newSchema(schemaLocation);
            Validator validator=schema.newValidator();
            Source source=new StreamSource(fileName);
            validator.validate(source);
            System.out.println("Valid");
        } catch (SAXException e) {
            System.out.print("Валидация"+fileName+"не выполнена"+e.getMessage());
        } catch (IOException e) {
            System.out.print(fileName+"не валиден"+e.getMessage());
        }

    }
}
