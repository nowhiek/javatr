package by.javatr.basket.util.validator;

import by.javatr.basket.entity.ColorEnum;

public class ColorValidator {

    public static boolean validate(ColorEnum color){
        return (color != null && !color.getTitle().isEmpty());
    }
}
