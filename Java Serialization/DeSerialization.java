import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerialization {
    public static void main(String[] args) throws Exception {
        String fileName = "./Data/testfile.ser";
        
        try(FileInputStream fis = new FileInputStream(fileName); ObjectInputStream ois = new ObjectInputStream(fis)){
            
            Student student = (Student)ois.readObject();
            System.out.println(student.name);
            System.out.println(student.rollno);


        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        } 
    }
}   

