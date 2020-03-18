package by.epam.jwd.service.factory;

import by.epam.jwd.service.UserService;
import by.epam.jwd.service.impl.UserServiceImpl;

public class ServiceFactory {
	
	private static final ServiceFactory instance = new ServiceFactory();

    private final UserService userServiceImpl = new UserServiceImpl();

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public UserService getUserService(){
        return userServiceImpl;
    }
}
