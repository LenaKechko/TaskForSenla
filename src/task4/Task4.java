package task4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task4 {

    private List<String> drawList = new ArrayList<>();

    private int countSymbols = 0;

    public Task4() {

    }

    public void setDrawList(InputDate number) {
        String symbols = "";
        for (int i = 0; i < number.getSize(); i++) {
            symbols = "*";
            if (number.getNumber(i) == number.getMaxNumber()) {
                symbols = number.getMaxNumber().toString();
            }
            String finalSymbols = symbols;
            List<String> temp = number.getDraw()
                    .get(i)
                    .getMaket()
                    .stream()
                    .map(x -> x.replace("%s", finalSymbols))
                    .collect(Collectors.toList());
            drawList = Stream.concat(drawList.stream(), temp.stream())
                    .collect(Collectors.toList());
        }
    }

    public void printResult(InputDate number) {
        for (int i = 0; i < drawList.size() / number.getSize(); i++) {
            for (int j = i; j < drawList.size(); j += 7) {
                System.out.print(drawList.get(j) + "  ");
            }
            System.out.println();
        }
    }
}
