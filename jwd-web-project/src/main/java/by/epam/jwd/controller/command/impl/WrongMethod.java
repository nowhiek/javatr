package by.epam.jwd.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import by.epam.jwd.controller.command.Command;
import by.epam.jwd.controller.servlet.JSPPageName;

public class WrongMethod implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		return JSPPageName.ERROR_PAGE;
	}
}
