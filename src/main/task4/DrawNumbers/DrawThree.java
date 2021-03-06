package main.task4.DrawNumbers;

import java.util.List;

public class DrawThree extends Draw {

    final static int COUNT_SYMBOLS = 14;

    public DrawThree() {
        super(COUNT_SYMBOLS);
    }

    public List<String> getMaket() {
        List<String> maketNumber = List.of(" %s%s%s ",
                "%s   %s",
                "    %s",
                "  %s%s ",
                "    %s",
                "%s   %s",
                " %s%s%s ");
        return maketNumber;
    }
}