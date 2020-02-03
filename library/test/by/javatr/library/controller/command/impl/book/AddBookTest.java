package by.javatr.library.controller.command.impl.book;

import by.javatr.library.controller.Controller;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddBookTest {

    @Test
    void addBook_Test_Positive() {
        Controller controller = new Controller();

        String expected = "Book added.";

        String actual = controller.executeTask("ADD_BOOK?10&TestMethod&Author1:Author1&1#Ekb#Russia&320");

        assertEquals(expected, actual);
    }

    @Test
    void addBook_Test_Negative() {
        Controller controller = new Controller();

        String expected = "Book was not correct.";

        String actual = controller.executeTask("ADD_BOOK?-1&TestMethod&Author1:Author1&1#Ekb#Russia&320");

        assertEquals(expected, actual);
    }
}