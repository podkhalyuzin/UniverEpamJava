/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textworker;

/**
 *
 * @author Елена
 */
public class UnfamiliarSymbolException extends Exception {

    /**
     * Creates a new instance of <code>UnfamiliarSymbolException</code> without
     * detail message.
     */
    public UnfamiliarSymbolException() {
    }

    /**
     * Constructs an instance of <code>UnfamiliarSymbolException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UnfamiliarSymbolException(String msg) {
        super(msg);
    }
}
