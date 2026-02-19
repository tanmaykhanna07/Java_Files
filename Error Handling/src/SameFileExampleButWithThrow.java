import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SameFileExampleButWithThrow {
    public static void main(String[] args) throws IOException {
        method1();
        System.out.println("Hello");
    }

    public static void method1() {
        try {
            FileReader fileReader = new FileReader("a.txt"); //din't compile before adding throws FileNotFoundExceptoin, no such file like a.txt exits btw
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
            throw new RuntimeException("oops"); //throw just forcefully throws an exception
        }
    }
}
