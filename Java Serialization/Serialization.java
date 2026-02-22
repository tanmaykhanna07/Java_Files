import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {
    public static void main(String[] args) throws Exception {
        String fileName = "./Data/testfile.ser";
        Student s1 = new Student(1,"Tanmay");
        try(FileOutputStream fos = new FileOutputStream(fileName); ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(s1);
            System.out.println("Succesfully created");
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        } 
    }
}   
