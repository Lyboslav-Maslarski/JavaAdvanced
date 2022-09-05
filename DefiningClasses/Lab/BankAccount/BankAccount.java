package DefiningClasses.Lab.BankAccount;

public class BankAccount {
    private static int bankAccountCount = 1;
    private static double interestRate = 0.02;
    private int id;
    private double balance;

    public BankAccount() {
        this.id = bankAccountCount++;
    }

    public static void setInterestRate(double interest) {
        interestRate = interest;
    }

    public double getInterest(int years) {
        return balance * years * interestRate;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public int getId() {
        return id;
    }
}

