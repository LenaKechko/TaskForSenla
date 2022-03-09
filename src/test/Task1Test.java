package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import task1.Task1;

class Task1Test {
    String[] text = null;
    int[] result = null;
    Task1 task1;

    @BeforeEach
    void setUp() {
        text = new String[]{"sfx7879wef789ce123we", "d45e12", "asd", "421"};
        result = new int[]{61, 12, 0, 7};
    }

    @Test
    void testEvaluateUsingStream() {
        for (int i = 0; i < text.length; i++) {
            task1 = new Task1(text[i]);
            assertEquals(result[i], task1.evaluateUsingStream());
        }
    }

    @Test
    void testEvaluateUsingRegex() {
        for (int i = 0; i < text.length; i++) {
            task1 = new Task1(text[i]);
            assertEquals(result[i], task1.evaluateUsingRegex());
        }
    }
}