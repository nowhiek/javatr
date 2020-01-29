package by.javatr.library.controller.command.impl;

import by.javatr.library.controller.command.Command;
import by.javatr.library.entity.Book;
import by.javatr.library.service.comparator.LibraryComparator;
import by.javatr.library.service.comparator.impl.*;
import by.javatr.library.service.impl.BookServiceImpl;

import java.util.Comparator;

public class SortBooks implements Command {

    @Override
    public String execute(String request) {
        BookServiceImpl impl = new BookServiceImpl();

        String currentSort = request.substring(request.indexOf("?") + 1, request.lastIndexOf("?"));

        switch (currentSort){
            case "SORT_BY_ID" : {
                return impl.sortEntitiesByComparator(new SortBooksById()).toString();
            }
            case "SORT_BY_NAME" : {
                return impl.sortEntitiesByComparator(new SortBooksByName()).toString();
            }
            case "SORT_BY_AUTHORS" : {
                return impl.sortEntitiesByComparator(new SortBooksByAuthors()).toString();
            }
            case "SORT_BY_PUBLISHING" : {
                return impl.sortEntitiesByComparator(new SortBooksByPublishing()).toString();
            }
            case "SORT_BY_COUNT_PAGES" : {
                return impl.sortEntitiesByComparator(new SortBooksByCountPages()).toString();
            }
            default : {
                return impl.getAll().toString();
            }
        }
    }
}
