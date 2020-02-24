package by.javatr.library.controller.command.impl.book;

import by.javatr.library.controller.Controller;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.service.comparator.impl.SortBooksByCountPages;
import by.javatr.library.service.factory.ServiceFactory;
import by.javatr.library.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveBookTest {

    @Test
    void removeBook_Test_Positive() {
        Controller controller = new Controller();

        String expected = "Book deleted.";

        String actual = controller.executeTask("REMOVE_BOOK?1&");

        assertEquals(expected, actual);
    }

    @Test
    void removeBook_Test_Negative() {
        Controller controller = new Controller();

        String expected = "You entered not valid id.";

        String actual = controller.executeTask("REMOVE_BOOK?-1&");

        assertEquals(expected, actual);
    }
}