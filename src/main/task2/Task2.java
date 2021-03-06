package main.task2;

import java.util.ArrayList;
import java.util.stream.Collectors;

/* Создайте программу, которая будет вычислять и выводить
на экран простые множители, из которых состоит целое число,
введенное пользователем. Если введенное число не целое,
то нужно сообщать пользователю об ошибке.*/
public class Task2 {

    private ArrayList<Integer> simpleMultipliers = new ArrayList<>();
    private Integer number;

    public Task2() {
    }

    public Task2(Integer number) {
        this.number = number;
    }

    public boolean evaluate() {
        if (!getSimpleMultipliers(number)) {
            System.out.println("Число не имеет простых множителей " +
                    "потому что равно 0 или 1, или вы написали отрицательной число!");
            return false;
        }
        return true;
    }

    public boolean getSimpleMultipliers(Integer num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                simpleMultipliers.add(i);
                num /= i;
                break;
            }
        }
        if (num != 1) {
            getSimpleMultipliers(num);
        }
        return true;
    }

    public void solution() {
        if (this.evaluate()) {
            String result = simpleMultipliers
                    .stream()
                    .map(x -> x.toString())
                    .collect(Collectors.joining("*"));
            System.out.printf("Результат: %d=%s\n", number, result);
            System.out.printf("Проверка результата: %s=%d\n", result, simpleMultipliers
                    .stream()
                    .reduce((x, y) -> x * y)
                    .get());
        }
    }
}
