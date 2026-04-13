import java.util.Scanner;

class Account {
    private int pin;
    private double balance;

    public Account(int pin, double initialBalance) {
        this.pin = pin;
        this.balance = initialBalance;
    }

    public boolean validatePin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account userAccount = new Account(1234, 500.0);
        
        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();

        if (!userAccount.validatePin(enteredPin)) {
            System.out.println("Incorrect PIN. Access Denied.");
            return;
        }

        int choice;
        while (true) {
            System.out.println("\n1. Check Balance 2. Deposit 3. Withdraw 4. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            if (choice == 4) break;

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: $" + userAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    userAccount.deposit(sc.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    userAccount.withdraw(sc.nextDouble());
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
        System.out.println("Thank you for using the ATM.");
    }
}
