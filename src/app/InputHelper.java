package app;

import java.util.Scanner;

public class InputHelper {

    private Scanner scanner;

    public InputHelper() {
        scanner = new Scanner(System.in);
    }

    public String input(String message) {

        System.out.print(message);
        return scanner.nextLine();
    }

    public int inputInt(String message) {

        System.out.print(message);

        int value = scanner.nextInt();
        scanner.nextLine();

        return value;
    }

    public double inputDouble(String message) {

        System.out.print(message);

        double value = scanner.nextDouble();
        scanner.nextLine();

        return value;
    }
}