package fr.belinguier.ecole;

import java.util.Scanner;

import static fr.belinguier.ecole.Converter.convertToSecond;

public class Main {

    private static int getTimeUnit(final Scanner scanner, final String message) {
        int result;

        while (true) {
            System.out.printf(message);
            while (!scanner.hasNextLine());
            try {
                result = Integer.parseInt(scanner.nextLine());
                if (result >= 0)
                    return result;
                System.out.println("Number must be positive.");
            } catch (final NumberFormatException ignored) {
                System.err.println("Please write correct number.");
            }
        }
    }

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int result = convertToSecond(
                getTimeUnit(scanner, "hours: "),
                getTimeUnit(scanner, "minutes: "),
                getTimeUnit(scanner, "seconds: ")
        );

        System.out.println("result secondes: " + result);
    }

}