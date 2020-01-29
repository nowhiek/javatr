package by.javatr.library.service.validator.impl;

import by.javatr.library.entity.Book;
import by.javatr.library.service.validator.LibraryValidator;

public class BookValidator implements LibraryValidator <Book> {

    @Override
    public boolean validate(Book book) {
        return (new IdentifierValidator().validate((int) book.getIdBook())
                && new NameValidator().validate(book.getNameBook())
                && new BookPublishingValidator().validate(book.getPublishingBook())
                && new BookCountPagesValidator().validate(book.getCountPagesBook()));
    }

    //TODO authors for (int i ....)
}
