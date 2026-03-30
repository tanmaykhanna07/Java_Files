import java.sql.*;
import java.util.Scanner;

public class LabOnBoarding {
    private static final String url = "jdbc:mysql://localhost:3306/college";
    private static final String username = "root";
    private static final String password = "khanna2007";
    public static void main(String[] args){
        try{
            Scanner scanner = new Scanner(System.in);
            Connection connection = DriverManager.getConnection(url,username,password);
            String query = "INSERT INTO labs(lab_name,building) VALUES(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,"Quantum Mechanics Lab");
            preparedStatement.setString(2,"Science Block");
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("Inserted Quantum Physics Lab successfully");
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                int newLabKey = 0;
                if(generatedKeys.next()){
                    newLabKey = generatedKeys.getInt(1);
                    System.out.println("SQL Generated Lab Key = " + newLabKey);
                }
                String stationQuery = "INSERT INTO workstations(lab_id,station_name,status) VALUES(?,?,?)";
                PreparedStatement workstationStatement = connection.prepareStatement(stationQuery);
                for(int i = 0; i < 5; i++){
                    System.out.println("Enter the station Name: ");
                    String stationName = scanner.nextLine();
                    String status = "Available";
                    workstationStatement.setInt(1,newLabKey);
                    workstationStatement.setString(2,stationName);
                    workstationStatement.setString(3,status);
                    workstationStatement.addBatch();
                }
                int[] stationsAdded = workstationStatement.executeBatch();
                for(int i = 0; i < stationsAdded.length; i++){
                    System.out.print(stationsAdded[i]);
                    System.out.print(" ");
                }
            }else{
                System.out.println("INSERTION FAILED!");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
