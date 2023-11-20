package com.github.katerinazakova;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class DecodingTest {
    @Test
    void decodeMessageIntoBinaryString_ValidInput() {
        assertAll(() -> assertEquals("10000111000011", Decoding.decodeMessageIntoBinaryString("0 0 00 0000 0 000 00 0000 0 00")),
                () -> assertEquals("101011111010001101111010000011000011101101010000010010010111111",
                        Decoding.decodeMessageIntoBinaryString("0 0 00 0 0 0 00 0 0 00000 00 0 0 0 00 000 0 00 00 0 0 0000 00 0 0 0 00 00000 0 00 00 0000 0 000 00 0 0 00 00 0 0 0 00 0 0 0 00 00000 0 0 00 00 0 0 00 00 0 0 00 0 0 000000"))
        );
    }

    @Test
    void decodeBinaryString_ValidBinaryInput() {
        assertAll(() -> assertEquals("CC", Decoding.decodeBinaryString("10000111000011")),
                () -> assertEquals("Who am I?", Decoding.decodeBinaryString("101011111010001101111010000011000011101101010000010010010111111"))
        );
    }

    @ParameterizedTest
    @CsvSource({"0 00 00 000 0 000000 0, true", "000000000,true", "z*T1 8 900, false",
            "0 00 00 000 T 00,false"})
    void testIsOnlyZeroOrSpaceInCode(String input, boolean expectedResult) {
        boolean result = Decoding.isOnlyZeroOrSpaceInCode(input);
        assertEquals(expectedResult, result);
    }

    @Test
    void isOnlyZeroOrSpaceInCode_EmptyStringInput_FalseReturn() {
        String input = "";
        boolean result = Decoding.isOnlyZeroOrSpaceInCode(input);
        assertFalse(result);
    }

    @ParameterizedTest
    @CsvSource({"0 00 0 000 00 0, true", "0 00 0 000 00 0 ,true", "0 00 0 000 00,false", "0,false"})
    void testIsNumberOfBlocksEven(String input, boolean expectedResult) {
        boolean result = Decoding.isNumberOfBlocksEven(input);
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @CsvSource({"00 00 0 000 00 0,true", "000 00 0 000 0 0,false", "00 00 000 000 00000 0,false"})
    void testIs0Or00InEvenBlocks(String input, boolean expectedResult) {
        boolean result = Decoding.is0Or00InEvenBlocks(input);
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @CsvSource({"0 0 00 0000 0 000 00 0000 0 00,true", "0 0 00 0000 0 000 00 0000 0 00 0 00,false"})
    void testIsLengthOfDecodeBinaryStringMultipleOf7(String input, boolean expectedResult) {
        boolean result = Decoding.isLengthOfDecodeBinaryStringMultipleOf7(input);
        assertEquals(expectedResult, result);
    }

}
