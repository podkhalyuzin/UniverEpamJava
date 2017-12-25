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
public class IncorrectWordException extends Exception {

    /**
     * Creates a new instance of <code>IncorrectWordException</code> without
     * detail message.
     */
    public IncorrectWordException() {
    }

    /**
     * Constructs an instance of <code>IncorrectWordException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public IncorrectWordException(String msg) {
        System.err.println("Word doesn't match to the pattern");
    }
}
