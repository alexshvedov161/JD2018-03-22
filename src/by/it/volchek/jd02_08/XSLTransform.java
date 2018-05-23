package by.it.volchek.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
//
//private final static String root="src/by/it/akhmelev/jd02_07/";
//public static void main(String[ ] args) {
//        String fileName=root+"Person.xml";
//        String fileHTML=root+"Person.html";
//        String transform="src/by/it/akhmelev/jd02_08/transform.xsl";

public class XSLTransform {

    //использование XPath в преобразованиях XSL
    public static void main(String[ ] args) {
        String fileName="src/by/it/volchek/jd02_08/DoorManufacturer.xml";
        String fileHTML="src/by/it/volchek/jd02_08/DoorManufacturer.html";
        String transform="src/by/it/volchek/jd02_08/transform.xsl";
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            // установка используемого XSL-преобразования
            Transformer transformer = tf.newTransformer(new StreamSource(transform));
            // установка исходного XML-документа и конечного XML-файла
            transformer.transform(new StreamSource(fileName),
                    new StreamResult(fileHTML));
            System.out.println("Transform " + fileName + " complete");
        } catch(TransformerException e) {
            System.err.println("Impossible transform file " + fileName + " : " + e);
        }
}
}
