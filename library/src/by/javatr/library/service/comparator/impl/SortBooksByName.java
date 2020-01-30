package by.javatr.library.service.comparator.impl;

import by.javatr.library.bean.Book;
import by.javatr.library.service.comparator.LibraryComparator;

public class SortBooksByName implements LibraryComparator<Book> {

    @Override
    public int compare(Book book1, Book book2) {
        return book1.getNameBook().compareTo(book2.getNameBook());
    }
}
