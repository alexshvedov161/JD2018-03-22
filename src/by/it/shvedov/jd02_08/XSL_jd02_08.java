package by.it.shvedov.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSL_jd02_08 {
    final static  String text="src/by/it/shvedov/jd02_08/persons.xml";

    public static void main(String[] args) {
        String fileName=text+"xml_data.xml";
        TransformerFactory tf=TransformerFactory.newInstance();
        try {
            Transformer transformer=tf.newTransformer(new StreamSource(text+"persons.xsl"));
            //transformer.transform(new StreamSource("persons.xml"+ text));
            new StreamResult(text+"persons.html");
            System.out.println("transform"+fileName);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
    }
}
