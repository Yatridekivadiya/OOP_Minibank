
import java.util.Scanner;

public class minibank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Customer customer = new Customer(101, "Rahul", "rahul@gmail.com");
        Account account = new Account(1001, 5000.0);

        int choice;

        do {
            System.out.println("\n===== MiniBank =====");
            System.out.println("1. Bank Information");
            System.out.println("2. Customer Information");
            System.out.println("3. Account Information");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Welcome to MiniBank!");
                    System.out.println("Simple and Secure Banking");
                    break;

                case 2:
                    customer.displayCustomer();
                    break;

                case 3:
                    System.out.println("Account Number: " + account.getAccountNumber());
                    System.out.println("Balance: " + account.getBalance());
                    break;

                case 4:
                    System.out.print("Enter deposit amount: ");
                    account.deposit(sc.nextDouble());
                    break;

                case 5:
                    System.out.print("Enter withdrawal amount: ");
                    account.withdraw(sc.nextDouble());
                    break;

                case 6:
                    System.out.println("Thank you for using MiniBank!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
