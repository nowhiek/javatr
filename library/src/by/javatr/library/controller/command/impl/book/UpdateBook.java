package by.javatr.library.controller.command.impl.book;

import by.javatr.library.bean.Author;
import by.javatr.library.bean.Book;
import by.javatr.library.bean.Publishing;
import by.javatr.library.controller.command.Command;
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
        oldBook.setAuthorsBook(getAuthors(authorsOldBook));
        oldBook.setPublishingBook(getPublishing(publishingOldBook));
        oldBook.setCountPagesBook(countPagesOldBook);

        Book newBook = new Book();
        newBook.setIdBook(idNewBook);
        newBook.setNameBook(nameNewBook);
        newBook.setAuthorsBook(getAuthors(authorsNewBook));
        newBook.setPublishingBook(getPublishing(publishingNewBook));
        newBook.setCountPagesBook(countPagesNewBook);

        try{
            libraryService.update(oldBook, newBook);
        } catch (ServiceException e) {
            return e.getMessage();
        }

        return "Book updated.";
    }

    private Author[] getAuthors(String params){
        Author[] authors = null;

        if (!params.isEmpty()){
            String[] tmp = params.split("#");
            authors = new Author[tmp.length];

            for (int i = 0; i < authors.length; i++){
                String[] data = tmp[i].split(":");
                Author author = new Author(data[0], data[1]);
                authors[i] = author;
            }
        }

        return authors;
    }

    private Publishing getPublishing(String params){
        Publishing publishing = null;

        if (!params.isEmpty()){
            String[] tmp = params.split("#");

            int idPublishing = Integer.parseInt(tmp[0]);
            String namePublishing = tmp[1];
            String countryPublishing = tmp[2];

            publishing = new Publishing(idPublishing, namePublishing, countryPublishing);
        }

        return publishing;
    }
}
