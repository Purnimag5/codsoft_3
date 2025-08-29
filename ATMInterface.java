import java.util.Scanner;

public class ATMInterfaceConsole {
    private static double balance = 1000.00; // Starting balance
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("🏦 Welcome to the ATM Interface");
        boolean exit = false;

        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            System.out.print(" Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    exitATM();
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Check Balance
    private static void checkBalance() {
        System.out.println(" Current Balance: ₹" + String.format("%.2f", balance));
    }

    // Deposit Money
    private static void depositMoney() {
        System.out.print("Enter amount to deposit: ");
        double depositAmount = scanner.nextDouble();

        if (depositAmount <= 0) {
            System.out.println(" Enter a valid amount greater than 0.");
        } else {
            balance += depositAmount;
            System.out.println("₹" + String.format("%.2f", depositAmount) + " deposited successfully!");
        }
    }

    // Withdraw Money
    private static void withdrawMoney() {
        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = scanner.nextDouble();

        if (withdrawAmount <= 0) {
            System.out.println(" Enter a valid amount greater than 0.");
        } else if (withdrawAmount > balance) {
            System.out.println(" Insufficient balance!");
        } else {
            balance -= withdrawAmount;
            System.out.println(" ₹" + String.format("%.2f", withdrawAmount) + " withdrawn successfully!");
        }
    }

    // Exit ATM
    private static void exitATM() {
        System.out.println(" Thank you for using the ATM. Goodbye!");
    }
}

