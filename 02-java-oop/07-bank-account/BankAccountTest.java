public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();

        System.out.println(BankAccount.numberOfAccounts);
        
        account1.deposit(500, "Checking");
        account1.deposit(750, "Savings");

        account2.deposit(1000, "Checking");
        account2.deposit(1250, "Savings");

        account1.withdraw(450, "Checking");
        account1.withdraw(800, "Savings");

        account2.withdraw(1250, "Checking");
        account2.withdraw(1000, "Savings");

        account1.displayAmounts();
        account2.displayAmounts();
    }
}