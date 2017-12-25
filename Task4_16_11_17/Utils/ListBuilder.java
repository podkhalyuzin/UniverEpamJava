package com.company.Task4_16_11_17.Utils;

import com.company.Task4_16_11_17.Deposit.Currency;
import com.company.Task4_16_11_17.Deposit.DepositorsGroup;
import com.company.Task4_16_11_17.Deposit.PaymentFrequency;
import com.company.Task4_16_11_17.Offer;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ListBuilder {

    /**
     * метод читает из файла данные и представляет их в виде строки
     * @return
     */
    public static String getStringFromFile(){
        StringBuilder solidTextAsStringBuilder = new StringBuilder();
        try(FileReader reader = new FileReader("C:\\Users\\Елена\\Documents\\NetBeansProjects\\" +
                "Epam\\src\\main\\java\\com\\company\\Task4_16_11_17\\InitialInform.txt")) {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1)
                    solidTextAsStringBuilder.append((char)c);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return solidTextAsStringBuilder.toString();
    }

    /**
     * Метод принимает строку и представляет её как список из Offer
     * @param fileAsString
     * @return
     */
    public static ArrayList<Offer> parseToOfferList(String fileAsString){
        String[] allDataArray = fileAsString.split(";");
        for(String string:allDataArray)
            string = string.trim().replaceAll("\\s","");
        ArrayList<Offer> result = new ArrayList<Offer>();
        for(int i=0;i<allDataArray.length;i=i+11){
            result.add(new Offer(allDataArray[i],allDataArray[i+1], Currency.parseToCurrency(allDataArray[i+2]),
                    DepositorsGroup.parseToDepositorsGroup(allDataArray[i+3]),Integer.parseInt(allDataArray[i+4]),
                    Integer.parseInt(allDataArray[i+5]),Double.parseDouble(allDataArray[i+6]), PaymentFrequency.parseToPaymentFrequency(allDataArray[i+7]),
                    Boolean.parseBoolean(allDataArray[i+8]),Boolean.parseBoolean(allDataArray[i+9]),Boolean.parseBoolean(allDataArray[i+10])));
        }
        return result;
    }

    /**
     * группирует предложения с одинаковыми вальтами UAH
     * @param offers
     * @return
     */
    public static ArrayList<Offer> groupByUAH(ArrayList<Offer> offers){
        ArrayList<Offer> result = new ArrayList<Offer>();
        for(Offer offer:offers){
            if(offer.getDeposit().getParametrs().getCurrency().equals(Currency.UAH))
                result.add(offer);
        }
        return result;
    }

    /**
     * группирует предложения с одинаковыми вальтами USD
     * @param offers
     * @return
     */
    public static ArrayList<Offer> groupByUSD(ArrayList<Offer> offers){
        ArrayList<Offer> result = new ArrayList<Offer>();
        for(Offer offer:offers){
            if(offer.getDeposit().getParametrs().getCurrency().equals(Currency.USD))
                result.add(offer);
        }
        return result;
    }

    /**
     * группирует предложения с одинаковыми вальтами EUR
     * @param offers
     * @return
     */
    public static ArrayList<Offer> groupByUER(ArrayList<Offer> offers){
        ArrayList<Offer> result = new ArrayList<Offer>();
        for(Offer offer:offers){
            if(offer.getDeposit().getParametrs().getCurrency().equals(Currency.EUR))
                result.add(offer);
        }
        return result;
    }

    public static ArrayList<Offer> findBestOffer(ArrayList<Offer> offers){
        Offer best = new Offer("","",null,null,0,0,0.,null,false,false,false);
        ArrayList<Offer> result = new ArrayList<Offer>();
        for(Offer offer:offers){
            if(offer.getDeposit().compareTo(best.getDeposit())>=0)
                best = offer;
        }
        for(Offer offer:offers){
            if(offer.getDeposit().compareTo(best.getDeposit())==0)
                result.add(offer);
        }
        return result;
    }

    public static ArrayList<Offer> findOffer(ArrayList<Offer> offers,String bank){
        ArrayList<Offer> result = new ArrayList<Offer>();
        for(Offer offer:offers){
            if(offer.getBank().equals(bank))
                result.add(offer);
        }
        return result;
    }
}

