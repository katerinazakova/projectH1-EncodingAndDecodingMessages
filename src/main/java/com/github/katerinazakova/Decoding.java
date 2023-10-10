package com.github.katerinazakova;

public class Decoding {

    public static String isValidEncodedMessage(String inputMessage) {
        if (!(isOnlyZeroOrSpaceInCode(inputMessage))) {
            return "Encoded string is not valid.";
        }
        if (!(isNumberOfBlocksEven(inputMessage))) {
            return "Encoded string is not valid.";
        }
        if (!(isLengthOfDecodeBinaryStringMultipleOf7(inputMessage))) {
            return "Encoded string is not valid.";
        }
        if (!(is0Or00InEvenBlocks(inputMessage))) {
            return "Encoded string is not valid.";
        } else {
            return "Decoded string: " + "\n" + decodeInputMessage(inputMessage);
        }
    }

    public static String decodeInputMessage(String inputMessage) {
        String decodeBinary = decodingBinaryString(inputMessage);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < decodeBinary.length(); i += 7) {
            String binaryChar = decodeBinary.substring(i, Math.min(i + 7, decodeBinary.length()));
            int decimalChar = Integer.parseInt(binaryChar, 2);
            result.append((char) decimalChar);
        }
        return result.toString();
    }

    public static String decodingBinaryString(String inputMessage) {
        StringBuilder decoded = new StringBuilder();

        String[] blocks = inputMessage.split(" ");
        for (int i = 0; i < blocks.length; i += 2) {
            String binaryDigit = blocks[i].equals("00") ? "0" : "1";
            int count = blocks[i + 1].length();
            decoded.append(binaryDigit.repeat(count));
        }
        return decoded.toString();
    }

    public static boolean isOnlyZeroOrSpaceInCode(String inputMessage) {
        return inputMessage.matches("^[0\\s]+$");
    }

    public static boolean isNumberOfBlocksEven(String inputMessage) {
        String[] blocks = inputMessage.split(" ");
        int length = blocks.length;
        return (length % 2 == 0);
    }

    public static boolean is0Or00InEvenBlocks(String inputMessage) {
        String[] blocks = inputMessage.split(" ");
        for (int i = 0; i < blocks.length; i += 2) {
            if (!("0".equals(blocks[i]) || "00".equals(blocks[i]))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLengthOfDecodeBinaryStringMultipleOf7(String inputMessage) {
        int length = decodingBinaryString(inputMessage).length();
        return length % 7 == 0;
    }
}


