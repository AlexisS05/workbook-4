package org.utils;

import org.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class Utils {
    static Scanner scanner = new Scanner(System.in);
    public static char getCharInput() {
        String userInput = scanner.nextLine().toUpperCase().trim();
        if (!userInput.isEmpty()) {
            return userInput.charAt(0);
        } else {
            return getCharInput();
        }
    }

    public static double getDoubleInput(String amountString) { // For main
        while (true) {
            if (amountString.isEmpty()) {
                System.out.println("Amount cannot be empty. Please enter a valid numeric amount.");
                amountString = Utils.getStringInputCustom("Enter an amount: ");
            } else {
                try {
                    return Double.parseDouble(amountString);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid numeric amount.");
                    amountString = Utils.getStringInputCustom("Enter an amount: ");
                }
            }
        }
    }

    public static int getIntInput(String prompt){
        System.out.println(prompt);
        int value = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return value;
    }

    public static String getStringInputCustom(String prompt) { // For the amount entry
        String input;
        System.out.println(prompt);
        input = scanner.nextLine();

        // Prompts the user in custom search in case input is empty or non-numeric
        while (!input.isEmpty() && !isNumeric(input)) {
            System.out.println("Invalid input. Please enter a valid value: ");
            input = scanner.nextLine();
        }

        return input;
    }

    public static boolean isNumeric(String str) { // To evaluate in getStringInputCustom
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String getStringInput(String prompt) {
        String input;

        System.out.println(prompt);

        while (true) {
            input = scanner.nextLine();

            if (!input.isEmpty() && input.matches("^[a-zA-Z\\s]+$")) {
                break; // Exit the loop if the input is valid
            } else {
                System.out.println("Invalid input. Please enter a non-empty input containing only alphabetic characters and spaces: ");
            }
        }

        return input;
    }
    public static String getEmailInput(String prompt) {
        String input;

        System.out.println(prompt);

        input = scanner.nextLine().trim();

        while (input.isEmpty()) {
            System.out.println("Invalid input. Please enter a non-empty input: ");
            input = scanner.nextLine().trim();
        }

        return input;
    }
}
