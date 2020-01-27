package by.javatr.library.service.comparator.impl;

import by.javatr.library.entity.Book;
import by.javatr.library.service.comparator.LibraryComparator;

public class SortBooksByPublishing implements LibraryComparator<Book> {

    @Override
    public int compare(Book book1, Book book2) {
        return book1.getPublishingBook().getNamePublishing().compareTo(book2.getPublishingBook().getNamePublishing());
    }
}
