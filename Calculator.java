import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Simple Calculator!");

        // Input first number
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        // Input second number
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        // Choose operation
        System.out.println("Choose an operation (+, -, *, /): ");
        char operation = scanner.next().charAt(0);

        double result = 0;
        boolean validOperation = true;

        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Cannot divide by zero.");
                    validOperation = false;
                }
                break;
            default:
                System.out.println("Invalid operation!");
                validOperation = false;
        }

        // Display result if operation is valid
        if (validOperation) {
            System.out.println("Result: " + result);
        }

        scanner.close();
    }
}