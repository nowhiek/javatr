package by.javatr.library.service.comparator.impl;

import by.javatr.library.entity.Book;
import by.javatr.library.service.comparator.LibraryComparator;

public class SortBooksById implements LibraryComparator<Book> {

    @Override
    public int compare(Book book1, Book book2) {
        return Long.compare(book1.getIdBook(), book2.getIdBook());
    }
}
