package by.javatr.library.controller.command.impl.book;

import by.javatr.library.controller.Controller;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.service.comparator.impl.*;
import by.javatr.library.service.factory.ServiceFactory;
import by.javatr.library.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortBooksTest {

    @Test
    void sortBooks_Test_By_Id() {
        Controller controller = new Controller();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookServiceImpl libraryService = serviceFactory.getBookService();

        String expected = null;
        try {
            expected = libraryService.sortEntitiesByComparator(new SortBooksById()).toString();
        } catch (ServiceException e) {
            expected = "";
        }

        String actual = controller.executeTask("SORT_BOOKS?SORT_BY_ID?");

        assertEquals(expected, actual);
    }

    @Test
    void sortBooks_Test_By_Name() {
        Controller controller = new Controller();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookServiceImpl libraryService = serviceFactory.getBookService();

        String expected = null;
        try {
            expected = libraryService.sortEntitiesByComparator(new SortBooksByName()).toString();
        } catch (ServiceException e) {
            expected = "";
        }

        String actual = controller.executeTask("SORT_BOOKS?SORT_BY_NAME?");

        assertEquals(expected, actual);
    }

    @Test
    void sortBooks_Test_By_Authors() {
        Controller controller = new Controller();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookServiceImpl libraryService = serviceFactory.getBookService();

        String expected = null;
        try {
            expected = libraryService.sortEntitiesByComparator(new SortBooksByAuthors()).toString();
        } catch (ServiceException e) {
            expected = "";
        }

        String actual = controller.executeTask("SORT_BOOKS?SORT_BY_AUTHORS?");

        assertEquals(expected, actual);
    }

    @Test
    void sortBooks_Test_By_Publishing() {
        Controller controller = new Controller();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookServiceImpl libraryService = serviceFactory.getBookService();

        String expected = null;
        try {
            expected = libraryService.sortEntitiesByComparator(new SortBooksByPublishing()).toString();
        } catch (ServiceException e) {
            expected = "";
        }

        String actual = controller.executeTask("SORT_BOOKS?SORT_BY_PUBLISHING?");

        assertEquals(expected, actual);
    }

    @Test
    void sortBooks_Test_By_Count_Pages() {
        Controller controller = new Controller();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookServiceImpl libraryService = serviceFactory.getBookService();

        String expected = null;
        try {
            expected = libraryService.sortEntitiesByComparator(new SortBooksByCountPages()).toString();
        } catch (ServiceException e) {
            expected = "";
        }

        String actual = controller.executeTask("SORT_BOOKS?SORT_BY_COUNT_PAGES?");

        assertEquals(expected, actual);
    }
}