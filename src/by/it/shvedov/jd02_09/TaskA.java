package by.it.shvedov.jd02_09;

import javax.xml.bind.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TaskA {
    public static void main(String[] args) {
        try {
            JAXBContext context=JAXBContext.newInstance(Persons.class);
            Unmarshaller m=  context.createUnmarshaller();
          String xmlSource=System.getProperty("usre.dir")+"/src/by/it/shvedov/jd02_07/persons+xsd.xml";
            String xmlTarget=System.getProperty("usre.dir")+"/src/by/it/shvedov/jd02_09/persons+xsd.xml";

            // FileReader reader=new FileReader("src/by/it/shvedov/jd02_08/persons+xsd.xml");
            Persons person=(Persons)m.unmarshal(new File(xmlSource));
            System.out.println(person);


        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
