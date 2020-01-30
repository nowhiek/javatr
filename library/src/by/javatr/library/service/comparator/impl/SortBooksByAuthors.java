package by.javatr.library.service.comparator.impl;

import by.javatr.library.bean.Book;
import by.javatr.library.service.comparator.LibraryComparator;

public class SortBooksByAuthors implements LibraryComparator<Book> {

    @Override
    public int compare(Book book1, Book book2) {
        if (book1.getAuthorsBook() == null && book2.getAuthorsBook() == null) {
            return 0;
        }else if (book1.getAuthorsBook() == null && book2.getAuthorsBook() != null){
            return 1;
        }else if (book1.getAuthorsBook() != null && book2.getAuthorsBook() == null){
            return -1;
        }

        return Integer.compare(book1.getAuthorsBook().length, book2.getAuthorsBook().length);
    }
}
