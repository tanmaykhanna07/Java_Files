import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args){
        try(FileWriter writer = new FileWriter("./File Handling/src/myfirstfile.txt")){
            writer.write("Mera naam hai jian mai hu sabse surila meri awaaz se log hojate hai madhosh");
            System.out.println("Succesfully written to the file");
        }
        catch(IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }

        try(FileWriter writer = new FileWriter("./File Handling/src/myfirstfile.txt",true)){
            writer.write("\nAppended Text here");
            System.out.println("Success");
        } catch (IOException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }

    }
}
