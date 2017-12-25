/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textworker;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Елена
 */
public class TextSymbols implements TextElement{
    
    String symbol;

    public TextSymbols(String symbol) throws UnfamiliarSymbolException {
        if(!isSymbol(symbol))
            throw new UnfamiliarSymbolException();
        this.symbol = symbol;
    }
    
    public static boolean isSymbol(String symbol){
        Pattern pattern = Pattern.compile("-|:|;|!|\\?|\\.|,|\\(|\\)|%|#|\\*|^|\\+|=|$|\"");
        Matcher matcher = pattern.matcher(symbol);
        return matcher.matches();
    }   

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.symbol);
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
        final TextSymbols other = (TextSymbols) obj;
        if (!Objects.equals(this.symbol, other.symbol)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return symbol;
    }    
}
