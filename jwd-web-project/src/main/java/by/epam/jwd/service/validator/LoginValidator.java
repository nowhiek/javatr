package by.epam.jwd.service.validator;

public final class LoginValidator {
	
	public static boolean validate(String login) {
		return (login.length() >= 6 && login.length() <= 11);
	}
}
