package by.it.shvedov.jd02_08;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StAX {
    static  String tab="";
    public static void main(String[] args) {
        String fileName="src/by/it/shvedov/jd02_08/persons.xml";
        XMLInputFactory inputFactory=XMLInputFactory.newInstance();
        try (FileInputStream fileInputStream=new FileInputStream(fileName)){
            XMLStreamReader reader=inputFactory.createXMLStreamReader(fileInputStream);
            String el="";
            while(reader.hasNext()){
                int type=reader.next();
                switch(type){
                    case XMLStreamConstants.START_ELEMENT:
                    {
                        System.out.println(tab+"["+reader.getLocalName()+"]");
                        tab=tab+"\t";
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT:{
                       if(!el.isEmpty())
                           System.out.println(tab+el);
                       tab=tab.substring(1);
                       el="";
                        System.out.println(tab+"[/"+reader.getLocalName()+"]");
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS:
                        el=el.concat(reader.getText().trim());
                        break;

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }


    }
}
