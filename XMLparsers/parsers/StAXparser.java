package com.company.XMLparsers.parsers;

import com.company.XMLparsers.depositComponents.Deposit;
import com.company.XMLparsers.depositComponents.Type;
import com.company.XMLparsers.utils.Utils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class StAXparser {

    private Integer key = null;
    private String bank ="";
    private String country ="";
    private Type type = null;
    private String depositor ="";
    private int id = 0;
    private double amount = 0.0;
    private double profitability = 0.0;
    private int timeConstraint = 0;

    static Logger logger = Logger.getLogger(DOMparser.class);

    static{
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }

    /**
     * принимает как параметр строку - путь к файлу и возвращает XMLEventReader
     * @param path
     * @return XMLEventReader
     * @throws FileNotFoundException
     * @throws XMLStreamException
     */
    public XMLEventReader newXMLEventReader(String path) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        return xmlInputFactory.createXMLEventReader(
                new FileInputStream(path));
    }

    public Map<Integer,Deposit> getData(String path) throws FileNotFoundException, XMLStreamException, InvalidDataException {
        Map<Integer,Deposit> result = new HashMap<Integer,Deposit>();
        XMLEventReader xmlEventReader = this.newXMLEventReader(path);
        while(xmlEventReader.hasNext()){
            XMLEvent xmlEvent = xmlEventReader.nextEvent();
            if (xmlEvent.isStartElement())
               fillOutField(xmlEvent,xmlEventReader);
            //if Deposit end element is reached, add deposit object to list
            if(xmlEvent.isEndElement()){
                EndElement endElement = xmlEvent.asEndElement();
                if(endElement.getName().getLocalPart().equals("Deposit")){
                    result.put(key,new Deposit(bank,country,type,depositor,id,amount,profitability,timeConstraint));
                }
            }
        }
        logger.info("StAX parsing has been done");
        return result;
    }

    /**
     * проверяем значение тега и вносим значение в нужное поле
     * @param xmlEvent
     * @param xmlEventReader
     * @throws XMLStreamException
     */
    private void fillOutField(XMLEvent xmlEvent , XMLEventReader xmlEventReader) throws XMLStreamException {
        StartElement startElement = xmlEvent.asStartElement();
        switch(startElement.getName().getLocalPart()) {
            case "Deposit":
                Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                if(idAttr != null) key = Integer.parseInt(idAttr.getValue());
                break;
            case "Name":
                bank = xmlEventReader.nextEvent().asCharacters().getData();
                break;
            case "Country":
                country = xmlEventReader.nextEvent().asCharacters().getData();
                break;
            case "Type":
                type = Type.parseToType(xmlEventReader.nextEvent().asCharacters().getData());
                break;
            case "Depositor":
                depositor = xmlEventReader.nextEvent().asCharacters().getData();
                break;
            case "Account_id":
                id = Integer.parseInt(xmlEventReader.nextEvent().asCharacters().getData());
                break;
            case "Ammount_on_deposit":
                amount = Double.parseDouble(xmlEventReader.nextEvent().asCharacters().getData());
                break;
            case "Profitability":
                profitability = Double.parseDouble(xmlEventReader.nextEvent().asCharacters().getData());
                break;
            case "Time_constraint":
                timeConstraint = Integer.parseInt(xmlEventReader.nextEvent().asCharacters().getData());
            default: break;
        }
    }
}




