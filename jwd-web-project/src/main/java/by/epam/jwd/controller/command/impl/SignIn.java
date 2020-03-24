package by.epam.jwd.controller.command.impl;

import javax.servlet.http.HttpServletRequest;

import by.epam.jwd.controller.command.Command;
import by.epam.jwd.controller.servlet.JSPPageName;
import by.epam.jwd.exception.service.ServiceException;
import by.epam.jwd.exception.service.ServiceSignInException;
import by.epam.jwd.exception.service.ServiceUserNotFoundException;
import by.epam.jwd.exception.service.ServiceUserPasswordNotEqualsException;
import by.epam.jwd.service.UserService;
import by.epam.jwd.service.factory.ServiceFactory;

public class SignIn implements Command {
	
	@Override
	public String execute(HttpServletRequest request) {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService serviceImpl = serviceFactory.getUserService();
		
		String page = JSPPageName.INDEX;
		
		String userName = request.getParameter("login");
		String userPassword = request.getParameter("password");
		
		try {
			serviceImpl.signIn(userName, userPassword);
			page = JSPPageName.AUTH_PAGE;
			request.setAttribute("auth_user", userName);
		} catch (ServiceSignInException | ServiceUserNotFoundException | ServiceUserPasswordNotEqualsException e) {
			//change e.getMessage();
			request.setAttribute("message", e.getMessage());
		} catch (ServiceException e) {
			page = JSPPageName.ERROR_PAGE;
		}
		
		return page;
	}
}
