import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            System.out.print("Select an option (1/2/3/4): ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter the amount to withdraw: ");
                double amount = Double.parseDouble(scanner.nextLine());
                if (account.withdraw(amount)) {
                    System.out.printf("Withdrew $%.2f%n", amount);
                } else {
                    System.out.println("Invalid amount or insufficient balance.");
                }
            } else if (choice.equals("2")) {
                System.out.print("Enter the amount to deposit: ");
                double amount = Double.parseDouble(scanner.nextLine());
                if (account.deposit(amount)) {
                    System.out.printf("Deposited $%.2f%n", amount);
                } else {
                    System.out.println("Invalid amount.");
                }
            } else if (choice.equals("3")) {
                double balance = account.checkBalance();
                System.out.printf("Your account balance is $%.2f%n", balance);
            } else if (choice.equals("4")) {
                System.out.println("Thank you for using the ATM. Goodbye!");
                break;
            } else {
                System.out.println("Invalid option. Please select 1, 2, 3, or 4.");
            }
        }
        scanner.close();
    }
}

public class Main {
    public static void main(String[] args) {
        double initialBalance = 1000;
        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}