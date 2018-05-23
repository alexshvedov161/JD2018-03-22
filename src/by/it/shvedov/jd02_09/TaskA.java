package by.it.shvedov.jd02_09;

import javax.xml.bind.*;
import java.io.*;

import static javax.xml.bind.Marshaller.*;

public class TaskA {
    public static void main(String[] args) {


        try {
            JAXBContext context=JAXBContext.newInstance(Persons.class);
            Unmarshaller unmarsh=context.createUnmarshaller();
            String xmlSource=System.getProperty("user.dir")+"/src/by/it/shvedov/jd02_07/persons+xsd.xml";
             String xmlTarget=System.getProperty("user.dir")+"/src/by/it/shvedov/jd02_09/persons+xsd.xml";
            //String xmlTarget="/src/by/it/shvedov/jd02_07/persons+xsd.xml";
             Persons person=(Persons) unmarsh.unmarshal(new File(xmlSource));
             Marshaller marshaller=context.createMarshaller();
             marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
             marshaller.marshal(person,System.out);
            try (OutputStream outputStream=new FileOutputStream(xmlTarget)){
                marshaller.marshal(person,outputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}
