public class Test {
    public static void main(String[] args){
        int[] num = {10,200,30,40};
        int[] den = {1,2,0,4};
        for(int i = 0; i < 10; i ++ ){ //ArrayIndexOutOfBoundsException
            try{
                System.out.println(divide(num[i],den[i]));
            } catch (Exception e) {
                System.out.println(e);;
            }

        }
    }

    public static int divide(int a, int b){
        try{
            return a/b;
        }catch(ArithmeticException e) {
            System.out.println(e); // gives NullPointer Exception
            System.out.println(" ");
            return -1;
        }catch(NullPointerException e){
            System.out.println(e); // gives NullPointer Exception
            System.out.println(" ");
            return -1;
        }catch(Exception e){
            System.out.println(e); // gives NullPointer Exception
            System.out.println(" ");
            return -1;
        }
    }
}

