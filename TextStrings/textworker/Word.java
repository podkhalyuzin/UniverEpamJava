/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textworker;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Елена
 */
public class Word implements TextElement{

    private String word;

    public Word(String word)throws IncorrectWordException{
        if(!isWord(word))
            throw new IncorrectWordException();
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public static boolean isWord(String word){
        Pattern wordPattern = Pattern.compile("[A-Za-z]{0,}[-\\w|']+[A-Za-z]{1,}");
        Pattern pretextPattern = Pattern.compile("[a-zA-Z]{1}");
        Pattern IntegerNumberPattern = Pattern.compile("([0-9]*(\\.)?[0-9]?)");
        Pattern Floatpattern = Pattern.compile("([0-9]*[[\\.]{1}[0-9]+]{1,})");
        Matcher matcherPreText = pretextPattern.matcher(word);
        Matcher matcherWord = wordPattern.matcher(word);
        Matcher matcherNumber = IntegerNumberPattern.matcher(word);
        Matcher matcherFloat = Floatpattern.matcher(word);
        return matcherWord.matches() || matcherNumber.matches() || matcherFloat.matches() || matcherPreText.matches();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.word);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Word other = (Word) obj;
        if (!Objects.equals(this.word, other.word)) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString(){
        return word;
    }
}

