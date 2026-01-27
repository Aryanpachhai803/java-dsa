package Day_2;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfixConversion {

    /**
     * Determine the precedence of an operator
     * 
     * @param op The operator character
     * @return An integer representing the precedence
     */

    private static int getPrecedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1; // Lowest precedence: Addition and Subtraction

            case '*':
            case '/':
                return 2; // Medium precedence: Multiplication and Division

            case '^':
            case '$':
                return 3; // Highest precedence: Exponentiation and Dollar sign

            default:
                return 0;
        }
    }

    public static String convertToPostfix(String infixExpression) {
        // 1. Create a StringBuilder to build the final postfix expression
        StringBuilder postfixResult = new StringBuilder();

        // 2. Create a Stack to hold the operators and paranthesis
        Stack<Character> operatorStack = new Stack<>();

        // 3. Loop through every character in the Infix expression
        for (int i = 0; i < infixExpression.length(); i++) {
            char token = infixExpression.charAt(i);

            // Ignore any blank spaces
            if (Character.isWhitespace(token)) {
                continue;
            }

            // Case 1: The token is an operand (Letter or Digit)
            if (Character.isLetterOrDigit(token)) {

                // If it is a number or a variable, just add it directly to the postfix result
                postfixResult.append(token);
            }

            // Case 2: The token is opening parenthesis '('+
            else if (token == '(') {
                // Push '(' onto the stack.
                operatorStack.push(token);
            }

            // Case 3: The token is closing parenthesis ')'
            else if (token == ')') {
                // Pop operators from the stack and append to the postfix result until the
                // matching '(' is found
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfixResult.append(operatorStack.pop());
                }

                // If the stack isnot empty, discard/remove '('
                if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                    operatorStack.pop();
                }
            }

            // Case 4: The token is an operator ( +, -, *, /)
            else {
                // While the stack isnot empty AND the top operator has greater or equal
                // precedence than the current token:

                while (!operatorStack.isEmpty() && getPrecedence(operatorStack.peek()) >= getPrecedence(token)) {
                    // Crucial check: Donot push the opening parenthesis '('
                    // It belongs to Case 3
                    if (operatorStack.peek() == '(') {
                        break;
                    }

                    // Pop the higher precedence operator and push it to the result
                    postfixResult.append(operatorStack);
                }

                // Now , push the current operator on to the stack
                operatorStack.push(token);
            }
        }

        // 4. After scanning the expression, POP all the remaining operator from the
        // stack

        while (!operatorStack.isEmpty()) {
            postfixResult.append(operatorStack.pop());
        }
        return postfixResult.toString();
    }

    public static void main(String[] args) {

        String infixExpression = "A*B+C";
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter Infix Expression: ");
        // String infixExpression = sc.nextLine();

        String postfixResult = convertToPostfix(infixExpression);
        System.out.println("Infix Expression" + infixExpression);
        System.out.println("Postfix Expression" + postfixResult);

        // sc.close();
    }
}
