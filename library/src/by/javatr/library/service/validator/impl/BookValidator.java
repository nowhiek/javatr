package by.javatr.library.service.validator.impl;

import by.javatr.library.bean.Book;
import by.javatr.library.service.validator.LibraryValidator;

public class BookValidator implements LibraryValidator <Book> {

    @Override
    public boolean validate(Book book) {
        if (book != null) {
            if (book.getAuthorsBook() != null){
                for (int i = 0; i < book.getAuthorsBook().length; i++) {
                    if (!new BookAuthorValidator().validate(book.getAuthorsBook()[i])) {
                        return false;
                    }
                }
            }
        }

        return (book != null
                && new IdentifierValidator().validate((int) book.getIdBook())
                && new NameValidator().validate(book.getNameBook())
                && new BookPublishingValidator().validate(book.getPublishingBook())
                && new BookCountPagesValidator().validate(book.getCountPagesBook()));
    }
}
