package by.javatr.library.controller.command.impl.book;

import by.javatr.library.controller.command.Command;
import by.javatr.library.bean.Book;
import by.javatr.library.controller.util.BookParser;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.service.factory.ServiceFactory;
import by.javatr.library.service.impl.BookServiceImpl;

public class AddBook implements Command {

    @Override
    public String execute(String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookServiceImpl libraryService = serviceFactory.getBookService();

        String[] split = request.substring(request.indexOf("?") + 1).split(PARAM_DELIMITER);
        Book book = new Book();

        int id = Integer.parseInt(split[0]);
        String bookName = split[1];
        String paramAuthors = split[2];
        String paramPublishing = split[3];
        int countPage = Integer.parseInt(split[4]);

        book.setIdBook(id);
        book.setNameBook(bookName);
        book.setAuthorsBook(BookParser.getAuthors(paramAuthors));
        book.setPublishingBook(BookParser.getPublishing(paramPublishing));
        book.setCountPagesBook(countPage);

        try {
            return libraryService.create(book) ? "Book added." : "Book not added.";
        } catch (ServiceException e) {
            return e.getMessage();
        }
    }
}
