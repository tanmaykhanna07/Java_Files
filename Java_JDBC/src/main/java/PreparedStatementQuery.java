import java.sql.*;

public class PreparedStatementQuery {
    private static final String url = "jdbc:mysql://localhost:3306/simple_bank";
    private static final String username = "root";
    private static final String password = "khanna2007";

    public static void main(String[] args){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String customerQuery = "INSERT INTO customers(first_name,last_name) VALUES(?,?)";

            PreparedStatement customerStatement = connection.prepareStatement(customerQuery, Statement.RETURN_GENERATED_KEYS);

            customerStatement.setString(1, "Samardeep");
            customerStatement.setString(2, "Singh");

            int cstmRowsAffected = customerStatement.executeUpdate();
            if(cstmRowsAffected > 0){
                System.out.println("Successfully added customer");
                ResultSet generatedKeys = customerStatement.getGeneratedKeys();
                int newCustomerId = 0;
                if(generatedKeys.next()){
                    newCustomerId = generatedKeys.getInt(1);
                    System.out.println("SQL Generated Customer ID "+ newCustomerId);
                }
                String query = "INSERT INTO accounts(customer_id,account_type,balance) VALUES(?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1,newCustomerId);
                preparedStatement.setString(2,"Savings");
                preparedStatement.setDouble(3,25000.00);

                int rowsAffected = preparedStatement.executeUpdate();
                if(rowsAffected > 0){
                    System.out.println("Successfully inserted into accounts");
                }else{
                    System.out.println("NOT INSERTED INTO ACCOUNTS");
                }
            }else{
                System.out.println("Customers table not updated");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}
