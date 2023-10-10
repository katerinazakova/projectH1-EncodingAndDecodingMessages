package com.github.katerinazakova;

import java.util.Scanner;

import static com.github.katerinazakova.Decoding.isValidEncodedMessage;
import static com.github.katerinazakova.Encoding.encodeInputMessage;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please input operation (encode/decode/exit):");
            String choice = scanner.nextLine();
            switch (choice) {
                case "encode":
                    System.out.println("Input string:");
                    String inputText = scanner.nextLine();
                    System.out.println("Encoded string:");
                    System.out.println(encodeInputMessage(inputText));
                    break;
                case "decode":
                    System.out.println("Input encoded string:");
                    String inputMessage = scanner.nextLine();
                    System.out.println(isValidEncodedMessage(inputMessage));
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