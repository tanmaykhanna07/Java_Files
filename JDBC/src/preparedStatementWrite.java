import java.sql.*;
public class preparedStatementWrite {
    private static final String url = "jdbc:mysql://localhost:3306/simple_bank";
    private static final String username = "root";
    private static final String password = "khanna2007";
    public static void main(String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            String query = "INSERT INTO customers(first_name,last_name,email) VALUES(?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,"Tanmay");
            preparedStatement.setString(2,"Khanna");
            preparedStatement.setString(3,"tanmaykhanna@xyz.com");

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("Inserted into customers successfully");
            }else{
                System.out.printf("NOT Inserted");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}