package by.epam.jwd.service.validator;

import by.epam.jwd.bean.User;
import by.epam.jwd.exception.service.ServiceException;

public class UserValidator {

	public static boolean validate(User user) throws ServiceException {
		return (user != null
				&& StringValidator.validate(user.getUserName())
				&& StringValidator.validate(user.getUserPassword())
				&& StringValidator.validate(user.getUserEmail())
				&& (user.getUserRole() != null && StringValidator.validate(user.getUserRole().getTitle()))
				&& (user.getUserStatus() != null && StringValidator.validate(user.getUserStatus().getTitle())));
	}
}
