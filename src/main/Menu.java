package main;

import main.task1.Task1;
import main.task2.Task2;
import main.task3.Task3;
import main.task4.Task4;
import main.task4.InputDate;
import main.task5.Task5;

import java.util.*;

public class Menu {
    String text = "Меню:\n" +
            "1. Задание 1.\n" +
            "2. Задание 2.\n" +
            "3. Задание 3.\n" +
            "4. Задание 4.\n" +
            "5. Задание 5.\n" +
            "6. Выход!";

    public Menu() {
    }

    public void printMenu() {
        System.out.println(text);
    }

    public void checkMenuItem(int menu_item) {
        Scanner sc = new Scanner(System.in);
        switch (menu_item) {
            case 1:
                String term1 = "Условие задания 1. Напишите программу, которая возвращает сумму цифр, присутствующих в данной строке.\n" +
                        "Если цифр нет, то возвращаемая сумма должна быть равна 0.\n" +
                        "Введите строку:";
                System.out.print(term1);
                String text = sc.next();
                Task1 task1 = new Task1(text);
                Integer result = task1.evaluateUsingStream();
                System.out.println("Результат решения задачи с помощью stream:" + result);
                result = task1.evaluateUsingRegex();
                System.out.println("Результат решения задачи с помощью регулярных выражений:" + result);
                break;
            case 2:
                String term2 = "Условие задания 2. Создайте программу, которая будет вычислять и выводить на экран простые множители, \n" +
                        "из которых состоит целое число, введенное пользователем. \n" +
                        "Если введенное число не целое, то нужно сообщать пользователю об ошибке.\n" +
                        "Введите число:";
                System.out.print(term2);
                try {
                    Task2 task2 = new Task2(sc.nextInt());
                    task2.solution();
                } catch (Exception e) {
                    System.out.println("Number isn't integer!");
                }
                break;
            case 3:
                String term3 = "3. Создайте программу, которая будет:\n" +
                        "\t- подсчитывать количество гласных в словах;\n" +
                        "\t- выводить слова отсортированным списком по количеству гласных (сначала те, у которых больше гласных);\n" +
                        "\t- делать первую гласную букву в слове заглавной.\n" +
                        "Предложение вводится пользователем вручную русскими буквами. Разделитель пробел (“ ”).\n";
                System.out.print(term3);
                text = sc.nextLine();
                Task3 task3 = new Task3(text);
                LinkedHashMap<String, Integer> resultPartOne = task3.countVowelsInWord();
                task3.printMap("Количество гласных в словах:", resultPartOne);
                LinkedHashMap<String, Integer> resultPartTwo = task3.sortMap(resultPartOne);
                task3.printMap("Слова отсортированные по количеству гласных в порядке их убывания:", resultPartTwo);
                String result3 = task3.changeString();
                System.out.printf("В исходной строке первая гласная буква каждого слова заглавная:\n%s\n", result3);
                break;
            case 4:
                String term4 = "4. Создайте программу, которая будет получать число и печатать его в следующем формате " +
                        "(формы цифр можно придумать свои, главное,\n чтобы они читались на экране):\n" +
                        "(*) Дополнительно: сделайте так, чтобы наибольшая цифра состояла не из ‘*’, " +
                        "а из соответствующих маленьких (обычных) цифр.\n";
                System.out.print(term4);
                String number = sc.next();
//                String number = "41072819";
//                String number = "0123456789";
                InputDate stringNumber = new InputDate(number);
                Task4 task4 = new Task4();
                task4.setDrawList(stringNumber);
                task4.printResult(stringNumber);
                break;
            case 5:
                String term5 = "5. Есть набор предметов, задаваемый заранее, предметы могут повторяться. " +
                        "Предмет имеет 2 параметра (обязательных, остальные добавлять \nна усмотрение): " +
                        "объем (целое значение) и ценность (целое значение). Предметы неделимы. " +
                        "Также задаётся сейф с обязательным параметром \nего объёма (целое значение). " +
                        "Нужно написать программу, которая наполняет сейф набором предметов таким образом, " +
                        "чтобы ценность этого \nнабора была максимальной.\n";
                System.out.print(term5);
                Task5 task5 = new Task5();
                task5.runner();
                break;
            case 6:
                System.out.println("Хорошего дня!");
                System.exit(0);
            default:
                System.out.println("Введите число от 1 до 6!");
        }
    }

}