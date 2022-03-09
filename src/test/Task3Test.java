package test;

import org.junit.jupiter.api.Test;
import task3.Task3;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    Task3 task3 = new Task3("привет менаая нооо зоувут лна");

    @Test
    void testCountVowelsInWord() {
        LinkedHashMap<String, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put("привет", 2);
        expectedResult.put("менаая", 4);
        expectedResult.put("нооо", 3);
        expectedResult.put("зоувут", 3);
        expectedResult.put("лна", 1);
        assertEquals(expectedResult, task3.countVowelsInWord());
    }

    @Test
    void testSortMap() {
        LinkedHashMap<String, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put("менаая", 4);
        expectedResult.put("нооо", 3);
        expectedResult.put("зоувут", 3);
        expectedResult.put("привет", 2);
        expectedResult.put("лна", 1);
        assertEquals(expectedResult, task3.sortMap(task3.countVowelsInWord()));
    }

    @Test
    void testChangeString() {
        assertEquals("прИвет мЕнаая нОоо зОувут лнА", task3.changeString());
    }
}