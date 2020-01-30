package by.javatr.library.service.comparator.impl;

import by.javatr.library.bean.Book;
import by.javatr.library.service.comparator.LibraryComparator;

public class SortBooksByCountPages implements LibraryComparator<Book> {

    @Override
    public int compare(Book book1, Book book2) {
        return Integer.compare(book1.getCountPagesBook(), book2.getCountPagesBook());
    }
}
