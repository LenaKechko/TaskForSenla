package main.task4.DrawNumbers;

import java.util.List;

public class DrawOne extends Draw {

    final static int COUNT_SYMBOLS = 10;

    public DrawOne() {
        super(COUNT_SYMBOLS);
    }

    public List<String> getMaket() {
        List<String> maketNumber = List.of(" %s ",
                "%s%s ",
                " %s ",
                " %s ",
                " %s ",
                " %s ",
                "%s%s%s");
        return maketNumber;
    }
}
