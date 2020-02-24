package by.javatr.library.controller.command.impl.book;

import by.javatr.library.bean.Author;
import by.javatr.library.bean.Publishing;
import by.javatr.library.controller.Controller;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.service.factory.ServiceFactory;
import by.javatr.library.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetBookTest {

    @Test
    void getBook_Test_By_Id_Positive() {
        Controller controller = new Controller();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookServiceImpl libraryService = serviceFactory.getBookService();

        String expected = null;
        try {
            expected = libraryService.findEntityById(2).toString();
        } catch (ServiceException e) {
            expected = "";
        }

        String actual = controller.executeTask("GET_BOOK?BY_ID?2&");

        assertEquals(expected, actual);
    }

    @Test
    void getBook_Test_By_Id_Negative() {
        Controller controller = new Controller();

        String expected = "You entered not valid id.";

        String actual = controller.executeTask("GET_BOOK?BY_ID?-2&");

        assertEquals(expected, actual);
    }

    @Test
    void getBook_Test_By_Name_Positive() {
        Controller controller = new Controller();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookServiceImpl libraryService = serviceFactory.getBookService();

        String expected = null;
        try {
            expected = libraryService.findEntityByName("Test").toString();
        } catch (ServiceException e) {
            expected = "";
        }

        String actual = controller.executeTask("GET_BOOK?BY_NAME?Test&");

        assertEquals(expected, actual);
    }

    @Test
    void getBook_Test_By_Author_Positive() {
        Controller controller = new Controller();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookServiceImpl libraryService = serviceFactory.getBookService();

        Author author = new Author("Maria", "Slaboda");

        String expected = null;
        try {
            expected = libraryService.findBooksByAuthor(author).toString();
        } catch (ServiceException e) {
            expected = "";
        }

        String actual = controller.executeTask("GET_BOOK?BY_AUTHOR?Maria&Slaboda");

        assertEquals(expected, actual);
    }

    @Test
    void getBook_Test_By_Publishing_Positive() {
        Controller controller = new Controller();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookServiceImpl libraryService = serviceFactory.getBookService();

        Publishing publishing = new Publishing(1, "Ekb", "Russia");

        String expected = null;
        try {
            expected = libraryService.findBooksByPublishing(publishing).toString();
        } catch (ServiceException e) {
            expected = "";
        }

        String actual = controller.executeTask("GET_BOOK?BY_PUBLISHING?Ekb&");

        assertEquals(expected, actual);
    }

    @Test
    void getBook_Test_By_Count_Pages_Positive() {
        Controller controller = new Controller();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookServiceImpl libraryService = serviceFactory.getBookService();

        String expected = null;
        try {
            expected = libraryService.findBooksByCountPages(123).toString();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        String actual = controller.executeTask("GET_BOOK?BY_COUNT_PAGES?123&");

        assertEquals(expected, actual);
    }

    @Test
    void getBook_Test_By_Count_Pages_Negative() {
        Controller controller = new Controller();

        String expected = "You entered invalid count pages.";

        String actual = controller.executeTask("GET_BOOK?BY_COUNT_PAGES?-2&");

        assertEquals(expected, actual);
    }
}