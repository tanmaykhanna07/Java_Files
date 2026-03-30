import java.sql.*;

public class LabFileReading {
    private static final String url = "jdbc:mysql://localhost:3306/college";
    private static final String username = "root";
    private static final String password = "khanna2007";
    public static void main(String[] args){
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            connection.setAutoCommit(false);
            String query = "SELECT * FROM workstations WHERE lab_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,7);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println("Station: " + resultSet.getString("station_name"));
                System.out.println("Status: " + resultSet.getString("status"));
                System.out.println(" ");
            }
            connection.commit();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
