package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task5.SafetyBox;
import task5.Solution;
import task5.Subject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    private List<Subject> listSubjects1 = null;
    private List<Subject> listSubjects2 = null;
    private List<Subject> listSubjects3 = null;
    private SafetyBox safetyBox1 = null;
    private SafetyBox safetyBox2 = null;
    private SafetyBox safetyBox3 = null;

    @BeforeEach
    void setUp() {
        listSubjects1 = Arrays
                .asList(new Subject("Гитара", 1, 1500),
                        new Subject("Бензопила", 4, 3000),
                        new Subject("Ноутбук", 3, 2000));
        safetyBox1 = new SafetyBox(4);

        listSubjects2 = Arrays
                .asList(new Subject("Ожерелье", 4, 4000),
                        new Subject("Кольцо", 1, 2500),
                        new Subject("Подвеска", 3, 2000));
        safetyBox2 = new SafetyBox(4);

        listSubjects3 = Arrays
                .asList(new Subject(6, 5),
                        new Subject(4, 3),
                        new Subject(3, 1),
                        new Subject(2, 3),
                        new Subject(5, 6));
        safetyBox3 = new SafetyBox(15);
    }
    List<Subject> expectedSubjectInBox = new ArrayList<>();

    @Test
    void testSolutionFirst() {
        Solution task5 = new Solution(listSubjects1, safetyBox1);
        task5.methodDynamicProgramming();
        assertEquals(3500, safetyBox1.getValueInSafety());
        expectedSubjectInBox.add(listSubjects1.get(0));
        expectedSubjectInBox.add(listSubjects1.get(2));
        assertEquals(expectedSubjectInBox, safetyBox1.getSubjectInSafetyBox());
    }

    @Test
    void testSolutionSecond() {
        Solution task5 = new Solution(listSubjects2, safetyBox2);
        task5.methodDynamicProgramming();
        assertEquals(4500, safetyBox2.getValueInSafety());
        expectedSubjectInBox.add(listSubjects2.get(1));
        expectedSubjectInBox.add(listSubjects2.get(2));
        assertEquals(expectedSubjectInBox, safetyBox2.getSubjectInSafetyBox());
    }

    @Test
    void testSolutionThird() {
        Solution task5 = new Solution(listSubjects3, safetyBox3);
        task5.methodDynamicProgramming();
        assertEquals(14, safetyBox3.getValueInSafety());
        expectedSubjectInBox.add(listSubjects3.get(0));
        expectedSubjectInBox.add(listSubjects3.get(1));
        expectedSubjectInBox.add(listSubjects3.get(4));
        assertEquals(expectedSubjectInBox, safetyBox3.getSubjectInSafetyBox());
    }
}