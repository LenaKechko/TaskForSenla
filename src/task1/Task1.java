package task1;

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

    public Integer evaluateUsingStream() {
        // 1ый метод: через stream
        String br = Arrays.stream(text.split("[^0-9]"))
                .filter(s -> !s.equals(""))
                .reduce(String::concat)
                .orElse("0");
        return Stream.of(br.split(""))
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .get();
    }

    public Integer evaluateUsingRegex() {
        // 2ой метод: через регулярные выражения
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(text);
        Integer sum = 0;
        while (matcher.find()) {
            sum += Integer.parseInt(matcher.group());
        }
        return sum;
    }
}
