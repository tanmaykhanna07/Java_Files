public class Bank {
    private int balance;

    Bank(int balance){
        this.balance = balance;
    }

    public void withdrawAmount(int amount) throws Exception{
        if(amount > balance){
            throw new CustomInsufficientFundsException();
        }
        balance -= amount;
    }
}
