import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFiles {
    public static  void main(String[] args){
        File file = new File("./File Handling/src/myfirstfile.txt");
        try(Scanner reader = new Scanner(file)){
            while(reader.hasNextLine()){
                System.out.println(reader.nextLine());
            }
        }catch (Exception e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("File information below");
        if (file.exists()) {
            System.out.println("File name: " + file.getName());
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("Writeable: " + file.canWrite());
            System.out.println("Readable: " + file.canRead());
            System.out.println("File size in bytes: " + file.length());
        } else {
            System.out.println("The file does not exist.");
        }
    }
}
