package L03DefiningClasses.ex01BanckAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static BufferedReader reader;
    private static Map<Integer, BankAccount> bankAccounts;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        bankAccounts = new HashMap<>();
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (! "End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int id = Integer.parseInt(tokens[1]);
            switch (command) {
                case "Create":
                    createAccount(id);
                    break;
                case "Deposit":
                    makeDeposit(tokens, id);
                    break;
                case "Withdraw":
                    withdrawMoney(tokens, id);
                    break;
                case "Print":
                    printAccountInfo(id);
                    break;
            }
        }
    }

    private static void printAccountInfo(int id) {
        if (bankAccounts.containsKey(id)) {
            System.out.println(bankAccounts.get(id));
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void withdrawMoney(String[] tokens, int id) {
        double amount = Double.parseDouble(tokens[2]);
        if (bankAccounts.containsKey(id)) {
            if (bankAccounts.get(id).getBalance() - amount >= 0) {
                bankAccounts.get(id).withdraw(amount);
            } else {
                System.out.println("Insufficient balance");
            }

        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void makeDeposit(String[] tokens, int id) {
        double amount = Double.parseDouble(tokens[2]);
        if (bankAccounts.containsKey(id)) {
            bankAccounts.get(id).deposit(amount);
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void createAccount(int id) {
        if (bankAccounts.containsKey(id)) {
            System.out.println("Account already exists");
        } else {
            bankAccounts.put(id, new BankAccount(id));
        }
    }
}
