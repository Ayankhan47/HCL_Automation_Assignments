import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

class InvalidAmountException extends Exception {
    public InvalidAmountException(String msg) { super(msg); }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String msg) { super(msg); }
}

class Account {
    private final int accountNumber;
    private final String holderName;
    private double balance;

    Account(int accountNumber, String holderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialDeposit;
    }

    int getAccountNumber() { return accountNumber; }

    void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) throw new InvalidAmountException("Deposit amount must be greater than zero.");
        balance += amount;
        System.out.println("Deposited " + amount + ". New balance: " + balance);
    }

    void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) throw new InvalidAmountException("Withdrawal amount must be greater than zero.");
        if (amount > balance) throw new InsufficientFundsException("Insufficient balance. Available: " + balance);
        balance -= amount;
        System.out.println("Withdrawn " + amount + ". New balance: " + balance);
    }

    void checkBalance() { System.out.println("Current balance: " + balance); }

    void displayDetails() {
        System.out.println("---- Account Details ----");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Holder Name    : " + holderName);
        System.out.println("Balance        : " + balance);
    }
}

public class Q5_BankManagement {

    static Map<Integer, Account> accounts = new HashMap<>();
    static int nextAccNo = 1001;

    static Account findAccount(Scanner sc) {
        System.out.print("Enter account number: ");
        int no = sc.nextInt();
        Account acc = accounts.get(no);
        if (acc == null) System.out.println("Account not found!");
        return acc;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch = -1;
        do {
            System.out.println("\n===== BANK MANAGEMENT =====");
            System.out.println("1. Create Account    2. Deposit");
            System.out.println("3. Withdraw          4. Balance Enquiry");
            System.out.println("5. Account Details   0. Exit");
            System.out.print("Enter choice: ");
            try {
                ch = sc.nextInt();
                sc.nextLine();  
                switch (ch) {
                    case 1:
                        System.out.print("Enter holder name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter initial deposit: ");
                        double init = sc.nextDouble();
                        if (init < 0) throw new InvalidAmountException("Initial deposit cannot be negative.");
                        Account a = new Account(nextAccNo, name, init);
                        accounts.put(nextAccNo, a);
                        System.out.println("Account created! Your account number is " + nextAccNo);
                        nextAccNo++;
                        break;
                    case 2: {
                        Account acc = findAccount(sc);
                        if (acc != null) {
                            System.out.print("Enter amount to deposit: ");
                            acc.deposit(sc.nextDouble());
                        }
                        break;
                    }
                    case 3: {
                        Account acc = findAccount(sc);
                        if (acc != null) {
                            System.out.print("Enter amount to withdraw: ");
                            acc.withdraw(sc.nextDouble());
                        }
                        break;
                    }
                    case 4: {
                        Account acc = findAccount(sc);
                        if (acc != null) acc.checkBalance();
                        break;
                    }
                    case 5: {
                        Account acc = findAccount(sc);
                        if (acc != null) acc.displayDetails();
                        break;
                    }
                    case 0: System.out.println("Thank you for banking with us!"); break;
                    default: System.out.println("Invalid choice!");
                }
            } catch (InvalidAmountException | InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter valid numeric input.");
                sc.nextLine();
                ch = -1;
            }
        } while (ch != 0);
        sc.close();
    }
}
