package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.task5.SafetyBox;
import main.task5.Solution;
import main.task5.Subject;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @ParameterizedTest
    @MethodSource("provideArguments")
    void testSolution(List<Subject> listSubjects, SafetyBox safetyBox,
                      Integer expected, List<Integer> expectedNumberSubject) {
        Solution task5 = new Solution(listSubjects, safetyBox);
        task5.methodDynamicProgramming();
        assertEquals(expected, safetyBox.getValueInSafety());
        List<Subject> expectedSubjectInBox = new ArrayList<>();
        for (Integer index : expectedNumberSubject) {
            expectedSubjectInBox.add(listSubjects.get(index));
        }
        assertEquals(expectedSubjectInBox, safetyBox.getSubjectInSafetyBox());
    }

    public static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of(Arrays
                                .asList(new Subject("Гитара", 1, 1500),
                                        new Subject("Бензопила", 4, 3000),
                                        new Subject("Ноутбук", 3, 2000)),
                        new SafetyBox(4), 3500, Arrays.asList(0, 2)),
                Arguments.of(Arrays
                                .asList(new Subject("Ожерелье", 4, 4000),
                                        new Subject("Кольцо", 1, 2500),
                                        new Subject("Подвеска", 3, 2000)),
                        new SafetyBox(4), 4500, Arrays.asList(1, 2)),
                Arguments.of(Arrays
                                .asList(new Subject(6, 5),
                                        new Subject(4, 3),
                                        new Subject(3, 1),
                                        new Subject(2, 3),
                                        new Subject(5, 6)),
                        new SafetyBox(15), 14, Arrays.asList(0, 1, 4))
        );
    }
}