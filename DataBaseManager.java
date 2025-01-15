import java.sql.*;

public class DatabaseManager {
    private Connection connection;

    public DatabaseManager(String dbURL) throws SQLException {
        connection = DriverManager.getConnection(dbURL);
    }

    public void createTable() throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS expenses (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "amount DOUBLE, " +
                "category TEXT, " +
                "date TEXT)";
        Statement stmt = connection.createStatement();
        stmt.execute(createTableSQL);
    }

    public void insertExpense(double amount, String category, String date) throws SQLException {
        String insertSQL = "INSERT INTO expenses (amount, category, date) VALUES (?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(insertSQL);
        pstmt.setDouble(1, amount);
        pstmt.setString(2, category);
        pstmt.setString(3, date);
        pstmt.executeUpdate();
    }

    public void viewExpenses() throws SQLException {
        String query = "SELECT * FROM expenses";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") + ", Amount: " + rs.getDouble("amount") +
                    ", Category: " + rs.getString("category") + ", Date: " + rs.getString("date"));
        }
    }
}
