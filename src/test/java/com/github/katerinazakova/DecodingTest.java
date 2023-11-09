package com.github.katerinazakova;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecodingTest {
    @Test
    void isOnlyZeroOrSpaceInCode_OnlyZero_ReturnTrue() {
        // Arrange
        String input = "000000000";
        //Act
        boolean result = Decoding.isOnlyZeroOrSpaceInCode(input);
        // Assert
        assertTrue(result);
    }

    @Test
    void isOnlyZeroOrSpaceInCode_MixZeroAndSpace_ReturnTrue() {
        // Arrange
        String input = "OO OOO O OOO OO OO O";
        //Act
        boolean result = Decoding.isOnlyZeroOrSpaceInCode(input);
        // Assert
        assertTrue(result);
    }

    @Test
    void isOnlyZeroOrSpaceInCode_ReturnFalse() {
        //Arrange
        String input = "z T1 8 900";
        boolean result = Decoding.isOnlyZeroOrSpaceInCode(input);
        // Assert
        assertFalse(result);
    }

    @Test
    void isOnlyZeroOrSpaceInCode_EmptyString() {
        //Arrange
        String input = "";
        //Act
        boolean result = Decoding.isOnlyZeroOrSpaceInCode(input);
        // Assert
        assertFalse(result);
    }

    @Test
    void isNumberOfBlocksEven_EvenBlocks() {
        //Arrange
        String input = "0 00 0 000 00 0";
        //Act
        boolean result = Decoding.isNumberOfBlocksEven(input);
        // Assert
        assertTrue(result);
    }

    @Test
    void isNumberOfBlocksEven_OddBlocks() {
        //Arrange
        String input = "0 00 0 000 00";
        //Act
        boolean result = Decoding.isNumberOfBlocksEven(input);
        // Assert
        assertFalse(result);
    }

    @Test
    void isNumberOfBlocksEven_EvenBlocksEndsZero() {
        //Arrange
        String input = "0 00 0 000 00 0 ";
        //Act
        boolean result = Decoding.isNumberOfBlocksEven(input);
        // Assert
        assertTrue(result);
    }

    @Test
    void is0Or00InEvenBlocks_FirstBlock_ReturnFalse() {
        //Arrange
        String input = "000 00 0 000 0 0";
        //Act
        boolean result = Decoding.is0Or00InEvenBlocks(input);
        // Assert
        assertFalse(result);
    }

    @Test
    void is0Or00InEvenBlocks_ReturnFalse() {
        //Arrange
        String input = "00 00 000 000 00000 0";
        //Act
        boolean result = Decoding.is0Or00InEvenBlocks(input);
        // Assert
        assertFalse(result);
    }


}
