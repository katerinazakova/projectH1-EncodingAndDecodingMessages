package com.github.katerinazakova;

import java.util.Scanner;

import static com.github.katerinazakova.Decoding.checkingValidityEncodedMessage;
import static com.github.katerinazakova.Encoding.encodeInputMessage;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please input operation (encode/decode/exit):");
            String choice = scanner.nextLine();
            switch (choice) {
                case "encode":
                    System.out.println("Input message:");
                    String message = scanner.nextLine();
                    System.out.println("Encoded message:");
                    System.out.println(encodeInputMessage(message));
                    break;
                case "decode":
                    System.out.println("Input encoded message:");
                    String encodedMessage = scanner.nextLine();
                    System.out.println(checkingValidityEncodedMessage(encodedMessage));
                    break;
                case "exit":
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("There is no '" + choice + "' operation");

            }
        }
    }
}