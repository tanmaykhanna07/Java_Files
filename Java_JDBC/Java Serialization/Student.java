import java.io.Serializable;

public class Student implements Serializable{
    public int rollno;
    public String name;

    Student(int rollno, String name){
        this.rollno = rollno;
        this.name = name;
    }
}