import java.sql.*;

public class Main {

    private static final String url = "jdbc:mysql://localhost:3306/simple_bank";
    private static final String username = "root";
    private static final String password = "khanna2007";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM accounts";

            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                int account_id = resultSet.getInt("account_id");
                int customer_id = resultSet.getInt("customer_id");
                double balance = resultSet.getDouble("balance");
                String account_type = resultSet.getString("account_type");
                System.out.println("Account ID: " + account_id);
                System.out.println("Customer ID: " + customer_id);
                System.out.println("Account type: " + account_type);
                System.out.println("Balance: " + balance);
                System.out.println();
            }



        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
