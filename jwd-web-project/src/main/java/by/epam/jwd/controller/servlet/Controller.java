package by.epam.jwd.controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.jwd.controller.CommandProvider;
import by.epam.jwd.controller.command.Command;
import by.epam.jwd.dao.connectionpool.ConnectionPool;

public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 10L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	}
	
	@Override
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
	
	@Override
	public void destroy() {
		ConnectionPool.getInstance().dispose();
		super.destroy();
	}
}
