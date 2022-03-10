package main.task5;

import java.util.Arrays;
import java.util.List;

public class Task5 {

    public void runner() {
        List<Subject> listSubjects = Arrays
                .asList(new Subject("Гитара", 1, 1500),
                        new Subject("Бензопила", 4, 3000),
                        new Subject("Ноутбук", 3, 2000));
        SafetyBox safetyBox = new SafetyBox(4);

//        List<Subject> listSubjects = Arrays
//                .asList(new Subject("Ожерелье", 4,4000),
//                        new Subject("Кольцо", 1,2500),
//                        new Subject("Подвеска", 3,2000));
//        SafetyBox safetyBox = new SafetyBox(4);

//        List<Subject> listSubjects = Arrays
//                .asList(new Subject("1",6, 5),
//                        new Subject("2",4, 3),
//                        new Subject("3",3, 1),
//                        new Subject("4",2, 3),
//                        new Subject("5",5, 6));
//        SafetyBox safetyBox = new SafetyBox(15);

        Solution task5 = new Solution(listSubjects, safetyBox);
        System.out.println("Имеются следующие предметы:");
        listSubjects.stream()
                .forEach(x -> System.out.println(x.getInfo()));
        System.out.println("Сейф объемом:" + safetyBox.getVolume());
        System.out.println("Выгоднее всего в сейф поместить следующие предметы:");
        task5.methodDynamicProgramming();
        safetyBox.getSubjectInSafetyBox()
                .stream()
                .forEach(x -> System.out.println(x.getInfo()));
        System.out.println("Ценность сейфа:" + safetyBox.getValueInSafety());
    }
}
