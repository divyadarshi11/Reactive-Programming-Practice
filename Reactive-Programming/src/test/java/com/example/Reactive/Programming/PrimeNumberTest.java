package com.example.Reactive.Programming;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class PrimeNumberTest {

    @ParameterizedTest
    @CsvSource({
        "2, true",
        "3, true",
        "4, false",
        "5, true",
        "6, false",
        "7, true"
    })
    public void testIsPrime(int number, boolean expectedResult) {
        assertEquals(expectedResult, isPrime(number));
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
