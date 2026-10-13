
import java.util.Scanner;

public class minibank {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== MiniBank =====");
            System.out.println("1. Bank Information");
            System.out.println("2. Customer and Account");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Welcome to MiniBank!");
                    System.out.println("Simple and Secure Banking");
                    break;

                case 2:
                    System.out.println("Customer and Account features will be added.");
                    break;

                case 3:
                    System.out.println("Thank you for using MiniBank!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 3);

        sc.close();
    }
}
