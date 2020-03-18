package by.epam.jwd.service.validator;

public final class StringValidator {
	
	public static boolean validate(String field) {
		return (field != null && !field.isEmpty());
	}
}
