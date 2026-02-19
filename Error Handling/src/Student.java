public class Student {
    public int roll;
    private int Id;

    Student(int roll){
        this.roll = roll;
    }
    public static void main (String[] args){
        Student s = new Student(10);
        System.out.println(s);
    }
    public void setId(int Id){
        this.Id = Id;
    }
    public int getId(){
        return Id;
    }
    @Override
    public String toString(){
        return "Roll number: " + this.roll;
    }
}

