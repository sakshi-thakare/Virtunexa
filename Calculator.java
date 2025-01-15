public class Calculator {

    // Add two numbers
    public double add(double a, double b) {
        return a + b;
    }

    // Subtract two numbers
    public double subtract(double a, double b) {
        return a - b;
    }

    // Multiply two numbers
    public double multiply(double a, double b) {
        return a * b;
    }

    // Divide two numbers
    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero.");
            return Double.NaN;
        }
        return a / b;
    }
}
