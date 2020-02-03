package by.javatr.library.controller.command.impl.user;

import by.javatr.library.controller.Controller;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignInTest {

    @Test
    void signIn_Test_Positive() {
        Controller controller = new Controller();

        String expected = "Success.";

        String actual = controller.executeTask("SIGN_IN?TestTest&1234567");

        assertEquals(expected, actual);
    }

    @Test
    void signIn_Test_Not_Negative() {
        Controller controller = new Controller();

        String expected = "Fail.";

        String actual = controller.executeTask("SIGN_IN?TestTest&1234");

        assertEquals(expected, actual);
    }

    @Test
    void signIn_Test_Not_Not_Found() {
        Controller controller = new Controller();

        String expected = "This user not founded.";

        String actual = controller.executeTask("SIGN_IN?NOT_FOUND&NOT_FOUND");

        assertEquals(expected, actual);
    }
}