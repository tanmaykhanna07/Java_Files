public class BankMain {
    public static void main(String[] args){

        Bank account = new Bank(15000);
        try{
            account.withdrawAmount(16000);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
