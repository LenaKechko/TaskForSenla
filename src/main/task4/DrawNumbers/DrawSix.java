package main.task4.DrawNumbers;

import java.util.List;

public class DrawSix extends Draw {

    final static int COUNT_SYMBOLS = 17;

    public DrawSix() {
        super(COUNT_SYMBOLS);
    }

    public List<String> getMaket() {
        List<String> maketNumber = List.of(" %s%s%s%s",
                "%s    ",
                "%s    ",
                "%s%s%s%s ",
                "%s   %s",
                "%s   %s",
                " %s%s%s ");
        return maketNumber;
    }
}