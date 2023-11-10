package com.github.katerinazakova;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EncodingTest {
    @Test
    void encodeInputMessage_ValidInput() {
        //Arrange
        String input = "Hi <3";
        String expectedResult = "0 0 00 00 0 0 00 000 0 00 00 0 0 0 00 00 0 0 00 0 0 0 00 000000 0 0000 00 000 0 00 00 00 0 00";
        //Act
        String result = Encoding.encodeInputMessage(input);
        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    void encodeInputMessage_ValidInputForStringC() {
        //Arrange
        String input = "C";
        String expectedResult = "0 0 00 0000 0 00";
        //Act
        String result = Encoding.encodeInputMessage(input);
        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    void encodeInputMessage_EmptyString() {
        //Arrange
        String input = "";
        String expectedResult = "";
        //Act
        String result = Encoding.encodeInputMessage(input);
        //Assert
        assertEquals(expectedResult, result);
    }
}
