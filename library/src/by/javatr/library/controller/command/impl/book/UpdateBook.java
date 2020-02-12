package by.javatr.library.controller.command.impl.book;

import by.javatr.library.bean.Book;
import by.javatr.library.controller.command.Command;
import by.javatr.library.controller.util.BookParser;
import by.javatr.library.exception.service.ServiceException;
import by.javatr.library.service.factory.ServiceFactory;
import by.javatr.library.service.impl.BookServiceImpl;

public class UpdateBook implements Command {

    @Override
    public String execute(String request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookServiceImpl libraryService = serviceFactory.getBookService();

        String[] split = request.substring(request.lastIndexOf("?") + 1).split(PARAM_DELIMITER);

        int idOldBook = Integer.parseInt(split[0]);
        String nameOldBook = split[1];
        String authorsOldBook = split[2];
        String publishingOldBook = split[3];
        int countPagesOldBook = Integer.parseInt(split[4]);

        int idNewBook = Integer.parseInt(split[5]);
        String nameNewBook = split[6];
        String authorsNewBook = split[7];
        String publishingNewBook = split[8];
        int countPagesNewBook = Integer.parseInt(split[9]);

        Book oldBook = new Book();
        oldBook.setIdBook(idOldBook);
        oldBook.setNameBook(nameOldBook);
        oldBook.setAuthorsBook(BookParser.getAuthors(authorsOldBook));
        oldBook.setPublishingBook(BookParser.getPublishing(publishingOldBook));
        oldBook.setCountPagesBook(countPagesOldBook);

        Book newBook = new Book();
        newBook.setIdBook(idNewBook);
        newBook.setNameBook(nameNewBook);
        newBook.setAuthorsBook(BookParser.getAuthors(authorsNewBook));
        newBook.setPublishingBook(BookParser.getPublishing(publishingNewBook));
        newBook.setCountPagesBook(countPagesNewBook);

        try{
            libraryService.update(oldBook, newBook);
        } catch (ServiceException e) {
            return e.getMessage();
        }

        return "Book updated.";
    }
}
