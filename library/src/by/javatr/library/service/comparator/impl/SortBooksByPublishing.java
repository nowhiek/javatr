package by.javatr.library.service.comparator.impl;

import by.javatr.library.entity.Book;
import by.javatr.library.service.comparator.LibraryComparator;

public class SortBooksByPublishing implements LibraryComparator<Book> {

    @Override
    public int compare(Book book1, Book book2) {
        if (book1.getPublishingBook() == null && book2.getPublishingBook() == null){
            return -1;
        }else if (book1.getPublishingBook() != null && book2.getPublishingBook() == null){
            return 1;
        }else if (book1.getPublishingBook() == null && book2.getPublishingBook() != null){
            return -1;
        }

        if (book1.getPublishingBook().getNamePublishing() == null && book2.getPublishingBook().getNamePublishing() == null){
            return 0;
        }else if (book1.getPublishingBook().getNamePublishing() == null && book2.getPublishingBook().getNamePublishing() != null){
            return 1;
        }else if (book1.getPublishingBook().getNamePublishing() != null && book2.getPublishingBook().getNamePublishing() == null){
            return -1;
        }

        return book1.getPublishingBook().getNamePublishing().compareTo(book2.getPublishingBook().getNamePublishing());
    }
}
