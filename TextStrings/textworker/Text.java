/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textworker;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Елена
 */
public class Text {
   
    private String[] sentence;
   // private static String[] RegularExpressionTemplates;
    
    
    public Text(String[] sentence){        
        this.sentence=sentence;
    }
      
    public Text(String file) throws IOException{        
        FileReader reader = new FileReader(file);
        // читаем посимвольно
        StringBuilder textAsStringBuilder = new StringBuilder();
        int c;
        while((c=reader.read())!=-1)
            textAsStringBuilder.append((char) c);
        
        String textAsString = textAsStringBuilder.toString();
        //слова которые содержат точку кладем во временный
        //списочный массив и заминяем шаблоном
        ArrayList<String> wordsContainPointTemporaryStorage = new ArrayList<String>(); 
        
        String[] textAsSingleWords = textAsString.split(" ");
        ArrayList<Pattern> Patterns = new ArrayList<Pattern>();
        Patterns.add(Pattern.compile("[Ff][Ee][Aa][Tt]+\\."));
        Patterns.add(Pattern.compile("[Vv][Ss]+\\."));
        Patterns.add(Pattern.compile("[Ff]+\\.+[Gg]+\\.")); //пока не пашет
        Patterns.add(Pattern.compile("[Ii]+\\.+[Ee]+\\."));
        Patterns.add(Pattern.compile("([0-9]*\\.[0-9]+)"));
        Patterns.add(Pattern.compile("[smk]m\\."));
        Patterns.add(Pattern.compile("([0-9]*\\.[0-9]+)"));
        Patterns.add(Pattern.compile("[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                                    "[A-Za-z0-9-()]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})"));
        Patterns.add(Pattern.compile("([0-9]*[\\.]{1}[0-9]+]{1,})"));
        
        for(int i=0;i<textAsSingleWords.length;i++){
            for(int j=0;j<Patterns.size();j++){
                if(textAsSingleWords[i].matches(Patterns.get(j).pattern())){
                   wordsContainPointTemporaryStorage.add(textAsSingleWords[i]);
                   textAsSingleWords[i]="TEMPORARY_TEMPLATE";      
                }
                    
            }
        }
        textAsString="";
        for(int i=0;i<textAsSingleWords.length;i++){
            textAsString+=textAsSingleWords[i]+" ";
        }
        this.sentence = textAsString.split("\\.|!|;|\\?");
        for(int i=0;i<this.sentence.length;i++)
            this.sentence[i]=this.sentence[i].trim();
         
        int k=0;
        for(int i=0;i<this.sentence.length;i++){
            while(!this.sentence[i].replaceFirst("TEMPORARY_TEMPLATE"," ").equals(this.sentence[i])){
                this.sentence[i]=this.sentence[i].replaceFirst("TEMPORARY_TEMPLATE",wordsContainPointTemporaryStorage.get(k++));  
            }              
        }      
       // Pattern sign = Pattern.compile("[a-zA-Z]{1,},");
        for(int i=0;i<sentence.length;i++){
           // Matcher matcher = sign.matcher(sentence[i]);
          //  while(matcher.find()) {
            sentence[i] = sentence[i].replaceAll(","," , ").trim();
            sentence[i] = sentence[i].replaceAll("\\)"," \\) ").trim();
            sentence[i] = sentence[i].replaceAll(":"," : ").trim();
            sentence[i] = sentence[i].replaceAll("\\("," \\( ").trim();
            sentence[i] = sentence[i].replaceAll("\\["," \\[ ").trim();
            sentence[i] = sentence[i].replaceAll("\\]"," \\] ").trim();
            sentence[i] = sentence[i].replaceAll("(\\s)+"," ").trim();
                   
        }
    }
    
    public int getWordsNumber(){      
        int counter=0; //счетчик слов
        for(String sentence : this.sentence){
           String[] words = sentence.split(" ");
           counter+=words.length;
        }  
        return counter;
    }
    
    public String[] getText(){    
        return this.sentence;
    }
    
    public String toSolidString(){      
        StringBuilder result = new StringBuilder("");
        
        for(int i=0;i<this.sentence.length;i++){
            String[] temp = this.sentence[i].split(" ");
            for(int j=0;j<temp.length;j++)
                result.append(temp[j].trim());
        }
        
        return result.toString().trim();
    }
    
    @Override
    public boolean equals(Object otherObject){       
        if(!fastComparison(otherObject))
            return false;
        if(this==otherObject)
            return true;
        Text otherText = (Text) otherObject;
        for(int i=0;i<this.sentence.length;i++){
            if(!this.sentence[i].equals(otherText.getText()[i]))
                return false;
        }
        return true;
    }
    
    public boolean equalsIgnoreCase(Object otherObject){      
        if(!fastComparison(otherObject))
            return false;
        if(this==otherObject)
            return true;
        Text otherText = (Text) otherObject;
        for(int i=0;i<this.sentence.length;i++){
            if(!this.sentence[i].equalsIgnoreCase(otherText.getText()[i]));
                return false;
        }
        return true;
    }
    
    // бытрое стравнение без проверки полей
    private boolean fastComparison(Object otherObject){       
        if(otherObject==null)
            return false;
        if(!(otherObject instanceof Text))
            return false;
        return true;
    }
       
    @Override
    public int hashCode() {        
        int hash = 7;
        hash = 19 * hash + Arrays.deepHashCode(this.sentence);
        return hash;
    }
        
    @Override
    public String toString(){        
        StringBuilder textAsStringBuilder=new StringBuilder("");
        for(String str:this.sentence){
           textAsStringBuilder=textAsStringBuilder.append(str).append(". ");
        }
        return textAsStringBuilder.toString();
    }
      
    public String[] findSentenceByKeyWord(String word){         
        word=word.trim();
        ArrayList<String> resultAsArrayList = new ArrayList<>();
        for(int i=0;i<this.sentence.length;i++){
            if(this.sentence[i].length()<word.length())
               continue;
            
            String[] wordsOfSentence = this.sentence[i].split(" ");
            for(String singleWord:wordsOfSentence){
                if(singleWord.trim().equalsIgnoreCase(word)){
                    resultAsArrayList.add(this.sentence[i]);
                    continue;
                }
            }   
        }
        
       String[] result = new String[resultAsArrayList.size()];
       for(int i=0;i<result.length;i++)
           result[i]=resultAsArrayList.get(i);
       return result;
    }    
    
    public String[] findSentenceByRegularExpression(String RegExp){        
        ArrayList<String> resultAsArrayList = new ArrayList<String>();
        for(int i=0;i<this.sentence.length;i++){
            if(!this.sentence[i].replaceFirst(RegExp," ").equals(this.sentence[i]))
               resultAsArrayList.add(this.sentence[i]);
        }
        
        String[] result = new String[resultAsArrayList.size()];
        for(int i=0;i<result.length;i++)
           result[i]=resultAsArrayList.get(i);
        return result;    
    }
    
    public static TextElement[] parseToTextElementArray(String sentence){
        String[] wordsAndSymbols = sentence.split(" ");
        TextElement[] elements = new TextElement[wordsAndSymbols.length];
        for(int i=0;i<elements.length;i++){
            try{
                elements[i] = new Word(wordsAndSymbols[i]);
                continue;
            }
            catch(IncorrectWordException ex){}
            try{
                elements[i] = new TextSymbols(wordsAndSymbols[i]);
                continue;
            }
            catch(UnfamiliarSymbolException ex){}
            elements[i]=null;
            System.out.println("warning : unfamiliar element");
        }
        return elements;
    }
}
