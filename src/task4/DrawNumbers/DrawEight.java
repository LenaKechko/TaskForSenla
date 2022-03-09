package task4.DrawNumbers;

import java.util.ArrayList;
import java.util.List;

public class DrawEight extends Draw {

    final static int COUNT_SYMBOLS = 17;

    public DrawEight() {
        super(COUNT_SYMBOLS);
    }

    public List<String> getMaket() {
        List<String> maketNumber = List.of(" %s%s%s ",
                "%s   %s",
                "%s   %s",
                " %s%s%s ",
                "%s   %s",
                "%s   %s",
                " %s%s%s ");
        return maketNumber;
    }
}