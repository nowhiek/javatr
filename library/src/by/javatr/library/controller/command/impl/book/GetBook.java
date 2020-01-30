package by.javatr.library.controller.command.impl.book;

import by.javatr.library.controller.command.Command;
import by.javatr.library.bean.Author;
import by.javatr.library.bean.Book;
import by.javatr.library.bean.Publishing;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.service.factory.ServiceFactory;
import by.javatr.library.service.impl.BookServiceImpl;

public class GetBook implements Command {

    @Override
    public String execute(String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookServiceImpl libraryService = serviceFactory.getBookService();

        String currentCommand = request.substring(request.indexOf("?") + 1, request.lastIndexOf("?"));
        System.out.println(currentCommand);
        String[] split = request.substring(request.lastIndexOf("?") + 1).split(PARAM_DELIMITER);

        try {
            switch (currentCommand) {
                case "BY_ID": {
                    int id = Integer.parseInt(split[0]);

                    return libraryService.findEntityById(id).toString();
                }
                case "BY_NAME": {
                    String name = split[0];

                    return libraryService.findEntityByName(name).toString();
                }
                case "BY_AUTHOR": {
                    String firstName = split[0];
                    String secondName = split[1];
                    Author author = new Author(firstName, secondName);

                    return libraryService.findBooksByAuthor(author).toString();
                }
                case "BY_PUBLISHING": {
                    String namePublishing = split[0];
                    Publishing publishing = new Publishing(1, namePublishing, "default");

                    return libraryService.findBooksByPublishing(publishing).toString();
                }
                case "BY_COUNT_PAGES": {
                    int count = Integer.parseInt(split[0]);

                    return libraryService.findBooksByCountPages(count).toString();
                }
                default:
                    return new Book().toString();
            }
        }catch (ServiceException e){
            return e.getMessage();
        }
    }
}
