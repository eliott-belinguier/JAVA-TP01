package fr.belinguier.ecole;

import java.util.Scanner;

import static fr.belinguier.ecole.Checker.isCorrectAddress;

public class Main {

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter IP address: ");
            while (!scanner.hasNextLine());
            try {
                if (isCorrectAddress(scanner.nextLine()))
                    System.out.println("Correct IP !");
            } catch (Checker.MalformedAddressException exception) {
                System.err.println(exception.getMessage());
            }
        }
    }

}