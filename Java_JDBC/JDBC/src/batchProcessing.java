import java.sql.*;
import java.util.Scanner;

public class batchProcessing {
    private static final String url = "jdbc:mysql://localhost:3306/simple_bank";
    private static final String username = "root";
    private static final String password = "khanna2007";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            String query = "INSERT INTO customers(first_name,last_name,email) VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            Scanner scanner = new Scanner(System.in);
            while(true){
                System.out.println("Enter First Name: ");
                String firstName = scanner.next();
                System.out.println("Enter Last Name: ");
                String lastName = scanner.next();
                System.out.println("Enter email address: ");
                String email = scanner.next();
                preparedStatement.setString(1,firstName);
                preparedStatement.setString(2,lastName);
                preparedStatement.setString(3,email);

                preparedStatement.addBatch();

                System.out.println("Add more entries(Y/N): ");
                String choice = scanner.next();
                if(choice.toUpperCase().equals("N")){
                    break;
                }

            }
            int[] arr = preparedStatement.executeBatch();
            for(int i = 0; i< arr.length; i ++){
                if(arr[i] == 0){
                    System.out.println("Query no "+i+" not executed successfully");
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());;
        }
    }
}
