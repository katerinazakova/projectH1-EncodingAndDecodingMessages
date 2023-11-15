package com.github.katerinazakova;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EncodingTest {
    @Test
    void encodeInputMessage_ValidInput() {
        assertAll(() -> assertEquals("0 0 00 00 0 0 00 000 0 00 00 0 0 0 00 00 0 0 00 0 0 0 00 000000 0 0000 00 000 0 00 00 00 0 00", Encoding.encodeInputMessage("Hi <3")),
                () -> assertEquals("0 0 00 0000 0 00", Encoding.encodeInputMessage("C")),
                () -> assertEquals("00 0 0 00 00 000 0 0 00 0 0 00 00 00 0 0 00 00 0 00 00 00 0 00", Encoding.encodeInputMessage("123"))
        );
    }

}