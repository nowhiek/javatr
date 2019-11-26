package by.javatr.basket.entity;

public enum ColorEnum {
    RED("Red"),
    ORANGE("Orange"),
    YELLOW("Yellow"),
    GREEN("Green"),
    LIGHT_BLUE("Light blue"),
    BLUE("Blue"),
    PURPLE("Purple");

    private String title;

    ColorEnum(String title) {
        this.title = title;
    }

    ColorEnum(){}

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "{Color - " + title + "}";
    }
}
