package by.epam.jwd.controller.command.impl;

import javax.servlet.http.HttpServletRequest;

import by.epam.jwd.bean.Role;
import by.epam.jwd.bean.Status;
import by.epam.jwd.bean.User;
import by.epam.jwd.controller.command.Command;
import by.epam.jwd.controller.servlet.JSPPageName;
import by.epam.jwd.exception.service.ServiceCreateUserException;
import by.epam.jwd.exception.service.ServiceException;
import by.epam.jwd.exception.service.ServiceGetAllUsersException;
import by.epam.jwd.exception.service.ServiceUserNotCorrectException;
import by.epam.jwd.service.UserService;
import by.epam.jwd.service.factory.ServiceFactory;

public class Registr implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService serviceImpl = serviceFactory.getUserService();
		
		String page = JSPPageName.REGISTR_PAGE;
		
		String userName = request.getParameter("login");
		String userPassword = request.getParameter("password");
		String repeatPassword = request.getParameter("repeat_password");
		String userEmail = request.getParameter("email");
		
		try {
			if (!userPassword.equals(repeatPassword)) {
				request.setAttribute("message", "Passwords not equals");
				return page;
			}
			
			User user = new User(userName, userPassword, userEmail, Role.USER, Status.OFFLINE, false);
			
			serviceImpl.create(user);
			page = JSPPageName.INDEX;
		} catch (ServiceUserNotCorrectException | ServiceGetAllUsersException | ServiceCreateUserException e) {
			request.setAttribute("message", e.getMessage());
		} catch (ServiceException e) {
			page = JSPPageName.ERROR_PAGE;
		}
		
		return page;
	}
}
