import java.util.*;

class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private List<String> transactions; 

    
    public Account(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactions = new ArrayList<String>();
        transactions.add("Account created with initial balance: ₹" + initialBalance);
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited: ₹" + amount + " | Balance: ₹" + balance);
            System.out.println(" Deposit successful!");
        } else {
            System.out.println(" Invalid deposit amount.");
        }
    }

  
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add("Withdrawn: ₹" + amount + " | Balance: ₹" + balance);
            System.out.println(" Withdrawal successful!");
        } else {
            System.out.println(" Insufficient balance or invalid amount.");
        }
    }

    
    public void showBalance() {
        System.out.println(" Current Balance: ₹" + balance);
    }

    
    public void showTransactionHistory() {
        System.out.println("\n Transaction History for " + accountHolder + ":");
        for (String t : transactions) {
            System.out.println("- " + t);
        }
    }
}

// Main class to simulate operations
public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String accHolder = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initBalance = sc.nextDouble();

        Account account = new Account(accNum, accHolder, initBalance);

        int choice;
        do {
            System.out.println("\n=== BANK MENU ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.showBalance();
                    break;
                case 4:
                    account.showTransactionHistory();
                    break;
                case 5:
                    System.out.println(" Thank you for banking with us!");
                    break;
                default:
                    System.out.println(" Invalid choice. Try again!");
            }
        } while (choice != 5);

        sc.close();
    }
}
