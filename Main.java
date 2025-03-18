import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // variables
        double balance = 0;

        double deposit;
        char choice;
        double withdraw;

        do {
            choice = template();

            switch (choice) {
                case '1' -> {
                    showBalance(balance);
                }
                case '2' -> {

                    deposit = deposit();
                    balance += deposit;

                }
                case '3' -> {
                    withdraw = withdraw(balance);
                    balance -= withdraw;

                }
                case '4' -> {
                    System.out.println("Goodbye!");
                }
                default -> {
                    starsPattern();
                    System.out.println("Invalid choice");
                }
            }

        } while (choice != '4');

        balance = 0;

    }

    static double deposit() {
        double deposit;

        System.out.print("Enter the amount to be deposited: ");
        deposit = scanner.nextDouble();
        scanner.nextLine();
        if (deposit <= 0) {
            System.out.println("Cannot deposit 0 or less");
            return 0;
        } else {
            return deposit;
        }

    }

    static double withdraw(double balance) {
        double withdraw;

        System.out.print("Enter the amount to be withdrawn: ");
        withdraw = scanner.nextDouble();
        scanner.nextLine();
        if (withdraw < 0) {
            System.out.println("Cannot withdraw a negative amount");
            return 0;
        } else if (withdraw > balance) {
            System.out.println("Insufficient funds");
            return 0;
        } else {
            return withdraw;
        }

    }

    static void starsPattern() {
        for (int i = 0; i < 15; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    static void showBalance(double balance) {
        starsPattern();
        System.out.printf("$%.2f", balance);
        System.out.println();

    }

    static char template() {

        char choice;
        starsPattern();
        System.out.println("BANKING PROGRAM");
        starsPattern();

        System.out.println("1. Show Balance\n2. Deposit\n3. Withdraw\n4. Exit");
        starsPattern();
        System.out.print("Enter a choice: ");
        choice = scanner.nextLine().charAt(0);

        return choice;
    }
}