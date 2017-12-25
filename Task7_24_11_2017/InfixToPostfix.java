package com.company.Task7_24_11_2017;

/**
 * Convert arithmetic from infix to postfix
 *
 * @example 1 * ( 12 + 23 ) - ( 4 / 5 ) => 1 12 23 + * 4 5 / -
 * @author  Yong Su
 */
import java.util.Stack;
import java.lang.StringBuilder;

class InfixToPostfix {
    /**
     * Perform the conversion
     *
     * @param expression Arithmetic infix format
     */
    public static String convert(String expression) {
        // Use StringBuilder to append string is faster than
        // String concatenation
        StringBuilder sb = new StringBuilder();

        // Use a stack to track operations
        Stack<Character> op = new Stack<Character>();

        // Convert expression string to char array
        char[] chars = expression.toCharArray();

        // The length of expression character
        int N = chars.length;

        for (int i = 0; i < N; i++) {
            char ch = chars[i];

            if (Character.isDigit(ch)) {
                // Number, simply append to the result
                while (Character.isDigit(chars[i])) {
                    sb.append(chars[i++]);
                }
                // Use space as delimiter
                sb.append(' ');
            } else if (ch == '(') {
                // Left parenthesis, push to the stack
                op.push(ch);
            } else if (ch == ')') {
                // Right parenthesis, pop and append to the result until meet the left parenthesis
                while (op.peek() != '(') {
                    if(op.peek()=='s')
                        sb.append(op.pop()+"in").append(' ');
                    else if(op.peek()=='c')
                        sb.append(op.pop()+"os").append(' ');
                    else sb.append(op.pop()).append(' ');
                }
                // Don't forget to pop the left parenthesis out
                op.pop();
            } else if (isOperator(ch)) {
                // Operator, pop out all higher priority operators first and then push it to the stack
                if(ch=='s'){
                    while (!op.isEmpty() && priority(op.peek()) >= priority(ch)) {
                        sb.append(op.pop()).append(' ');
                    }
                    i=i+2;
                }
                else if(ch=='c'){
                    while (!op.isEmpty() && priority(op.peek()) >= priority(ch)) {
                        sb.append(op.pop()).append(' ');
                    }
                    i=i+2;
                }else{
                    while (!op.isEmpty() && priority(op.peek()) >= priority(ch)) {
                        if(op.peek()=='s')
                            sb.append(op.pop()+"in").append(' ');
                        else if(op.peek()=='c')
                            sb.append(op.pop()+"os").append(' ');
                        else sb.append(op.pop()).append(' ');
                    }
                }
                op.push(ch);
            }
        }

        // Finally pop out whatever left in the stack and append to the result
        while(!op.isEmpty()) {
            if(op.peek()=='s')
                sb.append(op.pop()+"in").append(' ');
            else if(op.peek()=='c')
                sb.append(op.pop()+"os").append(' ');
            else sb.append(op.pop()).append(' ');
        }

        return sb.toString();
    }

    /**
     * Check if a character is an operator
     */
    private static boolean isOperator(char ch) {
        return ch == '*' || ch == '/' || ch == '+' || ch == '-' || ch == 's' || ch =='c';
    }

    /**
     * Define the operator priority
     */
    private static int priority(char operator) {
        switch (operator) {
            case 's' :
            case 'c' : return 3;
            case '*' :
            case '/' : return 2;
            case '+' :
            case '-' : return 1;
        }
        return 0;
    }
}

