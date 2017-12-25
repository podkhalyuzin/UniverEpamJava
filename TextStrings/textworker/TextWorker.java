/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textworker;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Елена
 */
public class TextWorker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
               
        try {
            // TODO code application logic here
            Text text = new Text("src\\resources\\text.txt");
            String[] textAsStringArray= text.getText();
            for(String str:textAsStringArray)
                System.out.println(str);
            
            String[] result =text.findSentenceByRegularExpression("Bohr");
            for(String str:result)
                System.out.println(str);
            
            System.out.println(text.getWordsNumber());
          
            TextElement[] elements = Text.parseToTextElementArray(textAsStringArray[0]);
            for(int i=0;i<elements.length;i++){
                if(elements[i] instanceof Word)
                    System.out.println(elements[i]+" - word");
                else if(elements[i] instanceof TextSymbols)
                    System.out.println(elements[i]+" - sign");
                else System.out.println(elements[i]+" - unknow");
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage()); 
        } 
    }
}
