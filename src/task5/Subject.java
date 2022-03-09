package task5;

public class Subject {

    private String name = "Undefined";
    private int volume;
    private int value;

    public Subject(int volume, int value) {
        this.volume = volume;
        this.value = value;
    }

    public Subject(String name, int volume, int value) {
        this.name = name;
        this.volume = volume;
        this.value = value;
    }

    public int getVolume() {
        return volume;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return String.format("Наименование - %s, объем - %d, ценность - %d", this.getName(), this.getVolume(), this.getValue());
    }

}
