package test;

import org.junit.jupiter.api.*;
import main.task2.Task2;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @ParameterizedTest
            @ValueSource(ints = {10, 5})
            void isHaveSimpleMultipliers(Integer input) {
        Task2 task2 = new Task2(input);
        assertTrue(task2.evaluate());
        assertTrue(task2.getSimpleMultipliers(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, -1})
    void isNotHaveSimpleMultipliers(Integer input) {
        Task2 task2 = new Task2(input);
        assertFalse(task2.evaluate());
        assertFalse(task2.getSimpleMultipliers(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"10, Результат: 10=2*5, Проверка результата: 2*5=10", "106, Результат: 106=2*53, Проверка результата: 2*53=106"})
    void testSolution(Integer input, String expectedFirstResult, String expectedSecondResult) {
        Task2 task2 = new Task2(input);
        task2.solution();
        String textExpected = String.format(expectedFirstResult + "\n" + expectedSecondResult + "\n");
        assertEquals(textExpected, output.toString());
    }

    @AfterEach
    public void cleanUp() {
        System.setOut(null);
    }
}