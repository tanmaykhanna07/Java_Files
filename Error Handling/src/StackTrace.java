public class StackTrace {
    public static void main(String[] args){
        try{
            method1();
        } catch(Exception o){
            o.printStackTrace();
        }
    }

    public static void method3(){
        int[] nums = new int[5];
        nums[5] = 10; //unchecked exceptions. These exceptions are not checked by the compiler at compile time.
    }
    public static void method2(){
        method3();
    }
    public static void method1(){
        method2();
    }
}
