package by.javatr.library.service.validator;

import by.javatr.library.bean.Book;

public class BookValidator {

    public static boolean validate(Book book) {
        if (book != null) {
            if (book.getAuthorsBook() != null){
                for (int i = 0; i < book.getAuthorsBook().length; i++) {
                    if (!BookAuthorValidator.validate(book.getAuthorsBook()[i])) {
                        return false;
                    }
                }
            }
        }

        return (book != null
                && IdentifierValidator.validate((int) book.getIdBook())
                && NameValidator.validate(book.getNameBook())
                && BookPublishingValidator.validate(book.getPublishingBook())
                && BookCountPagesValidator.validate(book.getCountPagesBook()));
    }
}
