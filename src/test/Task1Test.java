package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import main.task1.Task1;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

class Task1Test {
    String[] text = null;
    int[] result = null;
    Task1 task1;

    @ParameterizedTest
    @CsvSource(value = {"sfx7879wef789ce123we, 61", "d45e12, 12", "asd, 0", "421, 7"})
    void testEvaluateUsingStream(String input, Integer expected) {
        task1 = new Task1(input);
        assertEquals(expected, task1.evaluateUsingStream());
    }

    @ParameterizedTest
    @CsvSource(value = {"sfx7879wef789ce123we, 61", "d45e12, 12", "asd, 0", "421, 7"})
    void testEvaluateUsingRegex(String input, Integer expected) {
        task1 = new Task1(input);
        assertEquals(expected, task1.evaluateUsingRegex());
    }
}