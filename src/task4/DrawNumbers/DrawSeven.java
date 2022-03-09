package task4.DrawNumbers;

import java.util.ArrayList;
import java.util.List;

public class DrawSeven extends Draw {

    final static int COUNT_SYMBOLS = 11;

    public DrawSeven() {
        super(COUNT_SYMBOLS);
    }

    public List<String> getMaket() {
        List<String> maketNumber = List.of("%s%s%s%s%s",
                "    %s",
                "   %s ",
                "  %s  ",
                " %s   ",
                "%s    ",
                "%s    ");
        return maketNumber;
    }

}