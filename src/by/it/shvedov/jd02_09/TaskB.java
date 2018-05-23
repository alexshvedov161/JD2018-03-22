package by.it.shvedov.jd02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TaskB {
    public static void main(String[] args) {
        try {
            JAXBContext context=JAXBContext.newInstance(Persons.class);
            Unmarshaller m=  context.createUnmarshaller();
            //String xmlPath=System.getProperty("usre.dir")+"/src/by/it/shvedov/jd02_08/persons+xsd.xml";
            FileReader reader=new FileReader("src/by/it/shvedov/jd02_08/persons+xsd.xml");
            Persons person=(Persons)m.unmarshal(reader);
            System.out.println(person);
            //Marshaller m=jaxContext.createMar;
//Gson fgd=GsonBuilder().serial
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
