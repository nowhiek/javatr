package by.javatr.library.service.validator.impl;

import by.javatr.library.entity.Author;
import by.javatr.library.service.validator.LibraryValidator;

public class AuthorNameValidator implements LibraryValidator<Author> {

    @Override
    public boolean validate(Author author) {
        return (author != null && author.getAuthorFirstName() != null && !author.getAuthorFirstName().isEmpty());
    }
}
