package by.javatr.library.service.validator;

import by.javatr.library.bean.User;

public class UserValidator {

    public static boolean validate(User user) {
        return (user != null
                && IdentifierValidator.validate((int) user.getIdUser())
                && UserNameValidator.validate(user.getNameUser())
                && PasswordValidator.validate(user.getPasswordUser())
                && (user.getRoleUser() != null && user.getRoleUser().getTitle() != null && !user.getRoleUser().getTitle().isEmpty()));
    }
}
