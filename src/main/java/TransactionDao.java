import java.sql.*;

public class TransactionDao {
    private static final String URL = "jdbc:mysql://localhost:3306/home";
    private static final String USER = "root";
    private static final String PASS = "root";
    private Connection connection;

    public TransactionDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("No driver found");
        } catch (SQLException e) {
            System.out.println("Could not establish connection");
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addTransaction(Transaction transaction) {
        final String sql = "insert into home_budget(id, type, description, amount, DATE ) values(?,?,?,?,?)";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setLong(1, transaction.getId());
            prepStmt.setString(2, transaction.getType());
            prepStmt.setString(3, transaction.getDescription());
            prepStmt.setDouble(4, transaction.getAmount());
            prepStmt.setDate(5, transaction.getDate());
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Nie można zapisać tranzakcji");
            e.printStackTrace();
        }
    }
}