package main.task4;

import main.task4.DrawNumbers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InputDate {

    private List<Integer> numbers = null;
    private List<Draw> draw = new ArrayList<>();

    public InputDate(String number) {
        this.numbers = Arrays.stream(number.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (Integer num : this.numbers)
            switch (num) {
                case 0:
                    this.draw.add(new DrawZero());
                    break;
                case 1:
                    this.draw.add(new DrawOne());
                    break;
                case 2:
                    this.draw.add(new DrawTwo());
                    break;
                case 3:
                    this.draw.add(new DrawThree());
                    break;
                case 4:
                    this.draw.add(new DrawFour());
                    break;
                case 5:
                    this.draw.add(new DrawFive());
                    break;
                case 6:
                    this.draw.add(new DrawSix());
                    break;
                case 7:
                    this.draw.add(new DrawSeven());
                    break;
                case 8:
                    this.draw.add(new DrawEight());
                    break;
                case 9:
                    this.draw.add(new DrawNine());
                    break;
            }
    }

    public List<Draw> getDraw() {
        return draw;
    }

    public Integer getMaxNumber() {
        return Collections.max(numbers);
    }

    public Integer getNumber(int index) {
        return numbers.get(index);
    }

    public int getSize() {
        return numbers.size();
    }
}
