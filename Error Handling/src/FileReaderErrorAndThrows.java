import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderErrorAndThrows {
    public static void main(String[] args) throws IOException {
        method1();
        System.out.println("Hello");
    }
    public static void method2() throws FileNotFoundException{
        method1();
    }
    public static void method1() throws FileNotFoundException{
        FileReader fileReader = new FileReader("a.txt"); //din't compile before adding throws FileNotFoundExceptoin, no such file like a.txt exits btw
    }
}
