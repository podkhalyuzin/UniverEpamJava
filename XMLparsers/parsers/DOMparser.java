package com.company.XMLparsers.parsers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.company.XMLparsers.depositComponents.Deposit;
import com.company.XMLparsers.depositComponents.Type;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;

public class DOMparser {

    /**
     * файл в котором лежит прочитаный xml документ
     */
    private Document document;

    static Logger logger = Logger.getLogger(DOMparser.class);

    static{
        new DOMConfigurator().doConfigure("log4j.xml",LogManager.getLoggerRepository());
    }

    public DOMparser(String path)
            throws ParserConfigurationException, IOException, SAXException {
        File file = new File(path);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse(file);
    }

    public Map<Integer,Deposit> getData() throws InvalidDataException {
        Map<Integer,Deposit> result = new HashMap<Integer,Deposit>();
        NodeList nodeList = document.getElementsByTagName("Deposit");

        for (int i = 0; i < nodeList.getLength(); i++) {
            // Записываем информацию по каждому из найденных элементов
            Node node = nodeList.item(i);
            if (Node.ELEMENT_NODE == node.getNodeType()) {
                Element element = (Element) node;
                // key
                Integer id = Integer.parseInt(element.getAttribute("id"));
                // value
                String bank = element.getElementsByTagName("Name").item(0).getTextContent();
                String country = element.getElementsByTagName("Country").item(0).getTextContent();
                Type type = Type.parseToType(element.getElementsByTagName("Type").item(0).getTextContent());
                String depositor = element.getElementsByTagName("Depositor").item(0).getTextContent();
                int accountID = Integer.parseInt(element.getElementsByTagName("Account_id").item(0).getTextContent());
                double amount = Double.parseDouble(element.getElementsByTagName("Ammount_on_deposit").item(0).getTextContent());
                double profitability = Double.parseDouble(element.getElementsByTagName("Profitability").item(0).getTextContent());
                int timeConstraint = Integer.parseInt(element.getElementsByTagName("Time_constraint").item(0).getTextContent());
                Deposit deposit = new Deposit(bank,country,type,depositor,accountID,amount,profitability ,timeConstraint);
                if(bank == null | country == null | depositor == null | id == 0)
                    throw new InvalidDataException();
                else result.put(id,deposit);
            }
        }
        logger.info("DOM parsing has been done");
        return result;
    }
}
