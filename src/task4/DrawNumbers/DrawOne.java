package task4.DrawNumbers;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
