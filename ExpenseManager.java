import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
    private List<Expense> expenses = new ArrayList<>();

    // Add expense
    public void addExpense(double amount, String category, String date) {
        expenses.add(new Expense(amount, category, date));
    }

    // Edit expense
    public void editExpense(int index, double amount, String category, String date) {
        if (index >= 0 && index < expenses.size()) {
            Expense expense = expenses.get(index);
            expense = new Expense(amount, category, date);
            expenses.set(index, expense);
        } else {
            System.out.println("Invalid index.");
        }
    }

    // Delete expense
    public void deleteExpense(int index) {
        if (index >= 0 && index < expenses.size()) {
            expenses.remove(index);
        } else {
            System.out.println("Invalid index.");
        }
    }

    // View all expenses
    public void viewExpenses() {
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    // Generate a summary report
    public void generateReport() {
        double totalAmount = 0;
        for (Expense expense : expenses) {
            totalAmount += expense.getAmount();
        }
        System.out.println("Total Expenses: " + totalAmount);
    }
}
