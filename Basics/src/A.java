public class A { //parent class always the calls the class Object while using super(); Super is always used when a constructor is created.
    public A(){
        super();
        System.out.println("in A");
    }
    public A(int n){
        super();
        System.out.println("in A int");
    }
}
