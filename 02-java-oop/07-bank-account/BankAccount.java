import java.util.Random;
import java.util.Arrays;

public class BankAccount {
    private String accountNumber;
    private double checkingBalance;
    private double savingsBalance;
    protected static int numberOfAccounts = 0;
    protected static double totalAmount = 0;

    private String getAccountNumber() {
        int[] randomArray = new int[10];
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            randomArray[i] = rand.nextInt(10);
        }
        this.accountNumber = Arrays.toString(randomArray)
            .replace(",", "")
            .replace("[", "")
            .replace("]", "")
            .replace(" ", "");
        return this.accountNumber;
    }

    public BankAccount() {
        getAccountNumber();
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        numberOfAccounts++;
    }

    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public void deposit(double amount, String accountType) {
        if (accountType.equals("Checking")) {
            this.checkingBalance += amount;
        } else if (accountType.equals("Savings")) {
            this.savingsBalance += amount;
        }
        BankAccount.totalAmount += amount;
    }

    public void withdraw(double amount, String accountType) {
        if (accountType.equals("Checking")) {
            if (this.checkingBalance < amount) {
                System.out.println("Sorry, insufficient funds!");
            } else {
                this.checkingBalance -= amount;
            }
            BankAccount.totalAmount -= amount;
        } else if (accountType.equals("Savings")) {
            if (this.savingsBalance < amount) {
                System.out.println("Sorry, insufficient funds!");
            } else {
                this.savingsBalance -= amount;
            }
            BankAccount.totalAmount -= amount;
        }
    }

    public void displayAmounts() {
        System.out.println(String.format("Checking Account: %.2f, Savings Account: %.2f", this.checkingBalance, this.savingsBalance));
    }

}