package main.task1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/*1. Напишите программу, которая возвращает сумму цифр,
присутствующих в данной строке. Если цифр нет,
то возвращаемая сумма должна быть равна 0. */
public class Task1 {

    private String text = "";

    public Task1(String text) {
        this.text = text;
    }

    public Integer evaluateUsingRegex() {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(text);
        Integer sum = 0;
        while (matcher.find()) {
            sum += Integer.parseInt(matcher.group());
        }
        return sum;
    }
}
