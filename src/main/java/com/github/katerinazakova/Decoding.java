package com.github.katerinazakova;

public class Decoding {

    public static String checkingValidityEncodedMessage(String encodedMessage) {
        if (!(isOnlyZeroOrSpaceInCode(encodedMessage))) {
            return "Message contains invalid characters";
        }
        if (!(isNumberOfBlocksEven(encodedMessage))) {
            return "Number of blocks are not even";
        }
        if (!(isLengthOfDecodeBinaryStringMultipleOf7(encodedMessage))) {
            return "The length of string is not valid";
        }
        if (!(is0Or00InEvenBlocks(encodedMessage))) {
            return "Even blocks contain invalid number of zeros";
        } else {
            return "Decoded message: " + "\n" + decodeEncodedMessage(encodedMessage);
        }
    }

    public static String decodeEncodedMessage(String encodedMessage) {
        String decodeBinary = decodeMessageIntoBinaryString(encodedMessage);
        return Decoding.decodeBinaryString(decodeBinary);
    }

    public static String decodeBinaryString(String decodeBinary) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < decodeBinary.length(); i += 7) {
            String binaryChar = decodeBinary.substring(i, Math.min(i + 7, decodeBinary.length()));
            int decimalChar = Integer.parseInt(binaryChar, 2);
            result.append((char) decimalChar);
        }
        return result.toString();
    }

    public static String decodeMessageIntoBinaryString(String EncodedMessage) {
        StringBuilder decoded = new StringBuilder();

        String[] blocks = EncodedMessage.split(" ");
        for (int i = 0; i < blocks.length; i += 2) {
            String binaryDigit = blocks[i].equals("00") ? "0" : "1";
            int count = blocks[i + 1].length();
            decoded.append(binaryDigit.repeat(count));
        }
        return decoded.toString();
    }

    public static boolean isOnlyZeroOrSpaceInCode(String encodeMessage) {

        return encodeMessage.matches("^[0\\s]+$");
    }

    public static boolean isNumberOfBlocksEven(String encodeMessage) {
        String[] blocks = encodeMessage.split(" ");
        int length = blocks.length;
        return (length % 2 == 0);
    }

    public static boolean is0Or00InEvenBlocks(String encodeMessage) {
        String[] blocks = encodeMessage.split(" ");
        for (int i = 0; i < blocks.length; i += 2) {
            if (!("0".equals(blocks[i]) || "00".equals(blocks[i]))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLengthOfDecodeBinaryStringMultipleOf7(String encodeMessage) {
        int length = decodeMessageIntoBinaryString(encodeMessage).length();
        return length % 7 == 0;
    }
}


