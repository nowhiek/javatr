package by.javatr.library.service.validator.impl;

import by.javatr.library.bean.User;
import by.javatr.library.service.validator.LibraryValidator;

public class UserValidator implements LibraryValidator <User> {

    @Override
    public boolean validate(User user) {
        return (user != null
                && new IdentifierValidator().validate((int) user.getIdUser())
                && new UserNameValidator().validate(user.getNameUser())
                && new PasswordValidator().validate(user.getPasswordUser())
                && (user.getRoleUser() != null && user.getRoleUser().getTitle() != null && !user.getRoleUser().getTitle().isEmpty()));
    }
}
