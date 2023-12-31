package com.github.katerinazakova;

public class Encoding {
    public static String encodeInputMessage(String message) {
        if (message.isEmpty() || !(message.matches("\\A\\p{ASCII}*\\z"))) {
            return "Invalid input contains empty string or non-ASCII characters";
        }
        StringBuilder binaryMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            String binaryCode = String.format("%7s", Integer.toBinaryString(c)).replace(' ', '0');
            binaryMessage.append(binaryCode);
        }
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < binaryMessage.length()) {
            char currentElementOfBinary = binaryMessage.charAt(i);
            int count = 1;

            while (i + 1 < binaryMessage.length() && binaryMessage.charAt(i + 1) == currentElementOfBinary) {
                count++;
                i++;
            }

            result.append((currentElementOfBinary == '1' ? "0" : "00") + " " + "0".repeat(count) + " ");
            i++;
        }
        return result.toString().trim();
    }

}
