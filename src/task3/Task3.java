package task3;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 3.	Создайте программу, которая будет:
-	подсчитывать количество гласных в словах
-	выводить слова отсортированным списком по количеству гласных (сначала те, у которых больше гласных)
-	делать первую гласную букву в слове заглавной
Предложение вводится пользователем вручную русскими буквами. Разделитель пробел (“ ”).
*/
public class Task3 {

    private List<String> listText;
    static String regex = "[уеыаоэяиюё]";

    public Task3(String text) {
        this.listText = List.of(text.split(" "));
    }

    public LinkedHashMap<String, Integer> countVowelsInWord() {
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile(regex);
        for (String line : listText) {
            Matcher matcher = pattern.matcher(line);
            Integer count = 0;
            while (matcher.find()) {
                count++;
            }
            result.put(line, count);
        }
        return result;
    }

    public LinkedHashMap<String, Integer> sortMap(Map<String, Integer> mapVowels) {
        return mapVowels
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors
                        .toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public String changeString() {
        String result = "";
        Pattern pattern = Pattern.compile(regex);
        for (String line : listText) {
            Matcher matcher = pattern.matcher(line);
            matcher.find();
            int indexFirstVowel = line.indexOf(matcher.group());
            result += line.substring(0, indexFirstVowel) + line.toUpperCase().charAt(indexFirstVowel)
                    + line.substring(indexFirstVowel + 1) + " ";
        }
        return result.trim();
    }

    public void printMap(String text, Map<String, Integer> myMap) {
        System.out.println(text);
        myMap.entrySet()
                .stream()
                .forEach(elem -> System.out.println(elem.getValue() + " " + elem.getKey()));
    }
}
