package by.javatr.library.controller.command.impl.book;

import by.javatr.library.controller.Controller;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UpdateBookTest {

    @Test
    void updateBook_Test_Positive() {
        Controller controller = new Controller();

        String expected = "Book updated.";

        String actual = controller.executeTask("UPDATE_BOOK?4&Test&&&123&44&TestTest&Auth1:Auth1&1#Ekb#Russia&123");

        assertEquals(expected, actual);
    }

    @Test
    void updateBook_Test_Negative() {
        Controller controller = new Controller();

        String expected = "You entered not valid id.";

        String actual = controller.executeTask("UPDATE_BOOK?-4&Test&&&123&44&TestTest&Auth1:Auth1&1#Ekb#Russia&123");

        assertEquals(expected, actual);
    }
}