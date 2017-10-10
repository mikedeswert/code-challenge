import java.util.Scanner;

/**
 * User: mdeswert, Date: 10/10/2017.
 */
public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        boolean continueCalculating = true;

        while (continueCalculating) {
            System.out.print("Enter an arithmetic expression (type 'quit' to exit):\t");
            String expression = scanner.nextLine();

            if ("quit".equals(expression.trim())) {
                continueCalculating = false;
            } else if(!expression.isEmpty()) {
                double result = calculator.calculate(expression);
                System.out.println("The result is: " + result);
            }
        }
    }
}
