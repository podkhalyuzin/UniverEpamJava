package com.company.XMLparsers.utils;

import com.company.XMLparsers.parsers.DOMparser;
import com.company.XMLparsers.parsers.InvalidDataException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Utils {

    static Logger logger = Logger.getLogger(DOMparser.class);

    static{
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }

    public static <K, V extends Comparable<? super V>> Map<K, V>
    sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort( list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (-1)*(o1.getValue()).compareTo( o2.getValue() );
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public static void validate(String xmlDociment, String xsdSchema)throws InvalidDataException {
        SchemaFactory factory =
                SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        File schemaLocation = new File(xsdSchema);
        try {
        Schema schema = factory.newSchema(schemaLocation);
        Validator validator = schema.newValidator();
        Source source = new StreamSource("src\\main\\resources\\deposits.xml");
        validator.validate(source);
        logger.info("Dociment : "+xmlDociment+" is valid.");
        }
        catch (SAXException ex) {
            logger.info("Dociment : "+xmlDociment+" is not valid.");
            throw new InvalidDataException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
