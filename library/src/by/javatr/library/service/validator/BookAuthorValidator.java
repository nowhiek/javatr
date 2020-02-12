package by.javatr.library.service.validator;

import by.javatr.library.bean.Author;

public class BookAuthorValidator {

    public static boolean validate(Author author) {
        return (author != null && author.getAuthorFirstName() != null && !author.getAuthorFirstName().isEmpty()
                && author.getAuthorSecondName() != null && !author.getAuthorSecondName().isEmpty());
    }
}
