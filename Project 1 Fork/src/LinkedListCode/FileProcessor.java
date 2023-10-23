package LinkedListCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor {

    /**
     * Processes arithmetic expressions line-by-line in the given file.
     *
     * @param filePath Path to a file containing arithmetic expressions.
     */
    public static void processFile(String filePath) {
        File infile = new File(filePath);
        try (Scanner scan = new Scanner(infile)) {
            while (scan.hasNext()) {
                String line = scan.nextLine();
                processArithmeticExpression(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }

    /**
     * Process an arithmetic expression from a line of text and print the result.
     *
     * @param expression A line containing an arithmetic expression.
     */
    public static void processArithmeticExpression(String expression) {
        // Remove white spaces from the expression
        expression = expression.replaceAll("\\s", "");

        // Split the expression based on arithmetic operators (+, *, ^)
        String[] components = expression.split("[\\+\\*\\^]");

        if (components.length != 2) {
            System.out.println("Invalid expression: " + expression);
            return;
        }

        String operand1 = components[0];
        String operator = expression.replaceAll("[\\d]", "");
        String operand2 = components[1];

        LinkedList num1 = new LinkedList(null);
        LinkedList num2 = new LinkedList(null);

        // Check if operand1 and operand2 are numeric
        if (operand1.matches("\\d+")) {
            int number = Integer.parseInt(operand1);
            num1 = new LinkedList(new node(number, null));
        }

        if (operand2.matches("\\d+")) {
            int number = Integer.parseInt(operand2);
            num2 = new LinkedList(new node(number, null));
        }

        LinkedList result = null;

        switch (operator) {
            case "+":
                result = Operations.add(num1, num2);
                break;
            case "*":
                result = Operations.multiply(num1, num2);
                break;
            case "^":
                result = Operations.exponentiate(num1, num2);
                break;
            default:
                System.out.println("Invalid operator: " + operator);
                break;
        }

        if (result != null) {
            System.out.print(operand1 + " " + operator + " " + operand2 + " = ");
            String reversedResult = new StringBuilder(result.toString()).reverse().toString();
            System.out.print(reversedResult);
            System.out.println();
        }



    }






}
