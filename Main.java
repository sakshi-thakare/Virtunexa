import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        ExpenseManager expenseManager = new ExpenseManager();
        DatabaseManager dbManager = null;

        try {
            dbManager = new DatabaseManager("jdbc:sqlite:expenses.db");
            dbManager.createTable();
        } catch (SQLException e) {
            System.out.println("Error initializing database: " + e.getMessage());
        }

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Perform arithmetic operations");
            System.out.println("2. Manage expenses");
            System.out.println("3. Generate report");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Arithmetic operations
                    System.out.println("Enter first number:");
                    double a = scanner.nextDouble();
                    System.out.println("Enter second number:");
                    double b = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline

                    System.out.println("Select operation (add, subtract, multiply, divide):");
                    String operation = scanner.nextLine();

                    switch (operation) {
                        case "add":
                            System.out.println("Result: " + calculator.add(a, b));
                            break;
                        case "subtract":
                            System.out.println("Result: " + calculator.subtract(a, b));
                            break;
                        case "multiply":
                            System.out.println("Result: " + calculator.multiply(a, b));
                            break;
                        case "divide":
                            System.out.println("Result: " + calculator.divide(a, b));
                            break;
                        default:
                            System.out.println("Invalid operation.");
                    }
                    break;

                case 2:
                    // Manage expenses
                    System.out.println("1. Add Expense");
                    System.out.println("2. Edit Expense");
                    System.out.println("3. Delete Expense");
                    System.out.println("4. View Expenses");
                    int expenseChoice = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    switch (expenseChoice) {
                        case 1:
                            System.out.println("Enter amount:");
                            double amount = scanner.nextDouble();
                            scanner.nextLine();  // Consume newline
                            System.out.println("Enter category:");
                            String category = scanner.nextLine();
                            System.out.println("Enter date (YYYY-MM-DD):");
                            String date = scanner.nextLine();
                            expenseManager.addExpense(amount, category, date);
                            try {
                                dbManager.insertExpense(amount, category, date);
                            } catch (SQLException e) {
                                System.out.println("Error inserting expense: " + e.getMessage());
                            }
                            break;
                        case 2:
                            System.out.println("Enter expense index to edit:");
                            int editIndex = scanner.nextInt();
                            scanner.nextLine();  // Consume newline
                            System.out.println("Enter new amount:");
                            double newAmount = scanner.nextDouble();
                            scanner.nextLine();  // Consume newline
                            System.out.println("Enter new category:");
                            String newCategory = scanner.nextLine();
                            System.out.println("Enter new date:");
                            String newDate = scanner.nextLine();
                            expenseManager.editExpense(editIndex, newAmount, newCategory, newDate);
                            break;
                        case 3:
                            System.out.println("Enter expense index to delete:");
                            int deleteIndex = scanner.nextInt();
                            expenseManager.deleteExpense(deleteIndex);
                            break;
                        case 4:
                            expenseManager.viewExpenses();
                            break;
                        default:
                            System.out.println("Invalid option.");
                    }
                    break;

                case 3:
                    // Generate report
                    expenseManager.generateReport();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
