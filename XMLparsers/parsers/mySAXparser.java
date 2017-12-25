package com.company.XMLparsers.parsers;

import com.company.XMLparsers.depositComponents.Deposit;
import com.company.XMLparsers.depositComponents.Type;
import com.company.XMLparsers.utils.Utils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;

public class mySAXparser extends DefaultHandler {

    private String currentElement = "";
    private String attribute = "";
    private Map<Integer,Deposit> deposits = new HashMap<Integer,Deposit>();
    private Integer key = null;
    private String bank ="";
    private String country ="";
    private Type type = null;
    private String depositor ="";
    private int id = 0;
    private double amount = 0.0;
    private double profitability = 0.0;
    private int timeConstraint = 0;

    public Map<Integer, Deposit> getDeposits() {
        return Utils.sortByValue(deposits);
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts)
            throws SAXException {
        attribute = atts.getValue("id");
        currentElement = qName;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (attribute != null){
            key = Integer.parseInt(attribute);
        }
        if (currentElement.equals("Name")) {
            bank = new String(ch, start, length);
        }
        if (currentElement.equals("Country")) {
            country = new String(ch, start, length);
        }
        if (currentElement.equals("Type")) {
            type = Type.parseToType(new String(ch, start, length));
        }
        if (currentElement.equals("Depositor")) {
            depositor = new String(ch, start, length);
        }
        if (currentElement.equals("Account_id")) {
            id = Integer.parseInt(new String(ch, start, length));
        }
        if (currentElement.equals("Ammount_on_deposit")) {
            amount = Double.parseDouble(new String(ch, start, length));
        }
        if (currentElement.equals("Profitability")) {
            profitability = Double.parseDouble(new String(ch, start, length));
        }
        if (currentElement.equals("Time_constraint")) {
            timeConstraint = Integer.parseInt(new String(ch, start, length));
        }
        if(key!=null)
            deposits.put(key,new Deposit(bank,country,type,depositor,id,amount,profitability,timeConstraint));
    }
}

