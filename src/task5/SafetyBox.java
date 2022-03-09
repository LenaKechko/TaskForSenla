package task5;

import java.util.ArrayList;
import java.util.List;

public class SafetyBox {

    private int volume;

    private List<Subject> subjectInSafetyBox = new ArrayList<>();

    public SafetyBox(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public List<Subject> getSubjectInSafetyBox() {
        return subjectInSafetyBox;
    }

    public void setSubjectInSafetyBox(List<Subject> subjectInSafetyBox) {
        this.subjectInSafetyBox = subjectInSafetyBox;
    }

    public Integer getValueInSafety() {
        return this.getSubjectInSafetyBox()
                .stream()
                .map(x-> x.getValue())
                .reduce(Integer::sum)
                .get();
    }

}
