package by.epam.jwd.service.validator;

public final class PasswordValidator {

	public static boolean validate(String password) {
		return (password.length() >= 6 && password.length() <= 12);
	}
}
