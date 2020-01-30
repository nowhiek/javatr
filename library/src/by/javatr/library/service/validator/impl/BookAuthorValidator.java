package by.javatr.library.service.validator.impl;

import by.javatr.library.bean.Author;
import by.javatr.library.service.validator.LibraryValidator;

public class BookAuthorValidator implements LibraryValidator <Author> {

    @Override
    public boolean validate(Author author) {
        return (author != null && author.getAuthorFirstName() != null && !author.getAuthorFirstName().isEmpty()
                && author.getAuthorSecondName() != null && !author.getAuthorSecondName().isEmpty());
    }
}
