import java.sql.*;

public class Main {

    private static final String url = "jdbc:mysql://localhost:3306/?user=root";
    private static final String username = "root";
    private static final String password = "khanna2007";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
jkj;aljoip