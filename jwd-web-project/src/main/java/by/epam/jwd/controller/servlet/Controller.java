package by.epam.jwd.controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.jwd.controller.CommandProvider;
import by.epam.jwd.controller.command.Command;

public class Controller extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}

	private static final long serialVersionUID = 10L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commandName = null;
		String page = null;
		
		commandName = request.getParameter("command");
	
		Command command = CommandProvider.getInstance().getCommand(commandName);
		
		page = command.execute(request);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}
	
	
}
