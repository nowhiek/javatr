package by.epam.jwd.service.validator;

import by.epam.jwd.bean.User;
import by.epam.jwd.exception.service.ServiceException;
import by.epam.jwd.exception.service.ServiceUserNotCorrectException;

public final class CreateUserValidator {
	
	public static boolean validate(User user) throws ServiceException {
		if (user != null) {
			if (!StringValidator.validate(user.getUserName())) {
				throw new ServiceUserNotCorrectException("Username empty.");
			}
			
			if (!StringValidator.validate(user.getUserPassword())) {
				throw new ServiceUserNotCorrectException("Password empty.");
			}
			
			if (!StringValidator.validate(user.getUserEmail())) {
				throw new ServiceUserNotCorrectException("Email empty.");
			}
			
			if (!LoginValidator.validate(user.getUserName())) {
				throw new ServiceUserNotCorrectException("The username must be between 6 and 11 characters long.");
			}
			
			if (!PasswordValidator.validate(user.getUserPassword())) {
				throw new ServiceUserNotCorrectException("The password must be between 4 and 16 characters long.");
			}
			
			if (!EmailValidator.validate(user.getUserEmail())) {
				throw new ServiceUserNotCorrectException("The email not valid. Example of a valid email address: example@example.com");
			}
		}
		
		return true;
	}
}
