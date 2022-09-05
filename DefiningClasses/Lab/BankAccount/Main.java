package DefiningClasses.Lab.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Integer, BankAccount> bankAccountMap = new HashMap<>();
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] command = input.split("\\s+");
            if ("Create".equals(command[0])) {
                BankAccount bankAccount = new BankAccount();
                int id = bankAccount.getId();
                bankAccountMap.put(id, bankAccount);
                System.out.println("Account ID" + id + " created");
            } else if ("Deposit".equals(command[0])) {
                int id = Integer.parseInt(command[1]);
                int deposit = Integer.parseInt(command[2]);
                BankAccount bankAccount = bankAccountMap.get(id);
                if (bankAccount != null) {
                    bankAccount.deposit(deposit);
                    System.out.printf("Deposited %d to ID%d%n", deposit, id);
                } else {
                    System.out.println("Account does not exist");
                }
            } else if ("SetInterest".equals(command[0])) {
                BankAccount.setInterestRate(Double.parseDouble(command[1]));
            } else if ("GetInterest".equals(command[0])) {
                int id = Integer.parseInt(command[1]);
                int years = Integer.parseInt(command[2]);
                BankAccount bankAccount = bankAccountMap.get(id);
                if (bankAccount != null) {
                    System.out.printf("%.2f%n", bankAccount.getInterest(years));
                } else {
                    System.out.println("Account does not exist");
                }
            }
            input = scan.nextLine();
        }
    }
}
