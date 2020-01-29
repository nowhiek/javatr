package by.javatr.library.controller.command.impl;

import by.javatr.library.controller.command.Command;
import by.javatr.library.entity.Author;
import by.javatr.library.entity.Book;
import by.javatr.library.entity.Publishing;
import by.javatr.library.service.impl.BookServiceImpl;

public class GetBook implements Command {

    @Override
    public String execute(String request) {
        BookServiceImpl impl = new BookServiceImpl();

        String currentCommand = request.substring(request.indexOf("?") + 1, request.lastIndexOf("?"));
        System.out.println(currentCommand);
        String[] split = request.substring(request.lastIndexOf("?") + 1).split(PARAM_DELIMITER);

        switch (currentCommand){
            case "BY_ID" : {
                int id = Integer.parseInt(split[0]);
                return impl.findEntityById(id).toString();
            }
            case "BY_NAME" : {
                String name = split[0];
                return impl.findEntityByName(name).toString();
            }
            case "BY_AUTHOR" : {
                String firstName = split[0];
                String secondName = split[1];

                Author author = new Author(firstName, secondName);

                return impl.findBooksByAuthor(author).toString();
            }
            case "BY_PUBLISHING" : {
                String namePublishing = split[0];

                Publishing publishing = new Publishing(0, namePublishing, "default");

                return impl.findBooksByPublishing(publishing).toString();
            }
            case "BY_COUNT_PAGES" : {
                int count = Integer.parseInt(split[0]);

                return impl.findBooksByCountPages(count).toString();
            }
            default : return new Book().toString();
        }
    }
}
