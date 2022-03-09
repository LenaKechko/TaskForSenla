package test;

import org.junit.jupiter.api.*;
import task2.Task2;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    void testEvaluate() {
        Task2 task2 = new Task2(10);
        assertTrue(task2.evaluate());
        task2 = new Task2(5);
        assertTrue(task2.evaluate());
        task2 = new Task2(1);
        assertFalse(task2.evaluate());
        task2 = new Task2(-1);
        assertFalse(task2.evaluate());
    }

    @Test
    void testGetSimpleMultipliers() {
        Task2 task2 = new Task2();
        assertTrue(task2.getSimpleMultipliers(10));
        assertTrue(task2.getSimpleMultipliers(5));
        assertFalse(task2.getSimpleMultipliers(1));
        assertFalse(task2.getSimpleMultipliers(0));
    }

    @Test
    void testSolution() {
        Task2 task2 = new Task2(10);
        task2.solution();
        task2 = new Task2(106);
        task2.solution();
        String textExpected = String.format("Result: 10=2*5\nCheck result: 2*5=10\n");
        textExpected += String.format("Result: 106=2*53\nCheck result: 2*53=106\n");
        assertEquals(textExpected, output.toString());
    }

    @AfterEach
    public void cleanUp() {
        System.setOut(null);
    }
}