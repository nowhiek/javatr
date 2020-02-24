package by.javatr.library.controller.command.impl.book;

import by.javatr.library.controller.Controller;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.service.factory.ServiceFactory;
import by.javatr.library.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetAllBooksTest {

    @Test
    void getAllBooks_Test() {
        Controller controller = new Controller();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookServiceImpl libraryService = serviceFactory.getBookService();

        String expected = null;

        try {
            expected = libraryService.getAll().toString();
        } catch (ServiceException e) {
            expected = "";
        }

        String actual = controller.executeTask("GET_ALL_BOOKS?");

        assertEquals(expected, actual);
    }
}