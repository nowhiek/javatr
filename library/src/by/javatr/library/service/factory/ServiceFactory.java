package by.javatr.library.service.factory;

import by.javatr.library.service.impl.BookServiceImpl;
import by.javatr.library.service.impl.UserServiceImpl;

public final class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final BookServiceImpl bookService = new BookServiceImpl();
    private final UserServiceImpl userService = new UserServiceImpl();

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public BookServiceImpl getBookService(){
        return bookService;
    }

    public UserServiceImpl getUserService(){
        return userService;
    }
}
