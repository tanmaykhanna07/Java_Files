import java.sql.*;

public class prepStatementRead {
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
            String query = "SELECT balance FROM accounts WHERE account_id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query); //query compiled till here
            preparedStatement.setInt(1,1);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                System.out.println("Balance: " + resultSet.getDouble("balance"));
            }else{
                System.out.println("Balance not found");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
