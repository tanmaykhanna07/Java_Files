import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args){
        try{
            File myFile = new File("./File Handling/src/myfirstfile.txt");
            if(myFile.createNewFile()){
                System.out.println("Created a new file");
            }else{
                System.out.println("File already exists");
            }
        }catch(IOException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
}

