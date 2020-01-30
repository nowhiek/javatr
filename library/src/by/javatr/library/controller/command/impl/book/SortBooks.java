package by.javatr.library.controller.command.impl.book;

import by.javatr.library.controller.command.Command;
import by.javatr.library.service.comparator.impl.*;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.service.factory.ServiceFactory;
import by.javatr.library.service.impl.BookServiceImpl;

public class SortBooks implements Command {

    @Override
    public String execute(String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookServiceImpl libraryService = serviceFactory.getBookService();

        String currentSort = request.substring(request.indexOf("?") + 1, request.lastIndexOf("?"));

        try {
            switch (currentSort) {
                case "SORT_BY_ID": {
                    return libraryService.sortEntitiesByComparator(new SortBooksById()).toString();
                }
                case "SORT_BY_NAME": {
                    return libraryService.sortEntitiesByComparator(new SortBooksByName()).toString();
                }
                case "SORT_BY_AUTHORS": {
                    return libraryService.sortEntitiesByComparator(new SortBooksByAuthors()).toString();
                }
                case "SORT_BY_PUBLISHING": {
                    return libraryService.sortEntitiesByComparator(new SortBooksByPublishing()).toString();
                }
                case "SORT_BY_COUNT_PAGES": {
                    return libraryService.sortEntitiesByComparator(new SortBooksByCountPages()).toString();
                }
                default: {
                    return libraryService.getAll().toString();
                }
            }
        }catch (ServiceException e){
            return e.getMessage();
        }
    }
}
