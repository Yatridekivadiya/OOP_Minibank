
import java.util.Scanner;

public class minibank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Customer customer = new Customer(101, "Rahul", "rahul@gmail.com");

        Account[] accounts = {
            new SavingsAccount(1001, 5000, 1000),
            new CurrentAccount(1002, 2000, 1000),
            new FixedDepositAccount(1003, 10000)
        };

        int choice;

        do {
            System.out.println("\n--- MiniBank Menu ---");
            System.out.println("1. Customer Details");
            System.out.println("2. Display All Accounts");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(customer);
                    break;

                case 2:
                    for (Account account : accounts) {
                        System.out.println(account);
                        System.out.println("Interest Rate: "
                                + account.interestRate() + "%");

                        if (account instanceof SavingsAccount) {
                            System.out.println("Type: Savings Account");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter deposit amount: ");
                    accounts[0].deposit(sc.nextDouble());
                    break;

                case 4:
                    System.out.print("Enter withdrawal amount: ");
                    accounts[0].withdraw(sc.nextDouble());
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
