package by.javatr.library.controller.command.impl;

import by.javatr.library.controller.command.Command;
import by.javatr.library.entity.Author;
import by.javatr.library.entity.Book;
import by.javatr.library.entity.Publishing;
import by.javatr.library.service.impl.BookServiceImpl;

public class AddBook implements Command {

    @Override
    public String execute(String request) {
        BookServiceImpl impl = new BookServiceImpl();

        String[] split = request.substring(request.indexOf("?") + 1).split(PARAM_DELIMITER);

        int id = Integer.parseInt(split[0]);
        String bookName = split[1];
        String paramAuthors = split[2];
        String paramPublishing = split[3];
        int countPage = Integer.parseInt(split[4]);

        Book book = new Book();

        book.setIdBook(id);
        book.setNameBook(bookName);
        book.setAuthorsBook(getAuthors(paramAuthors));
        book.setPublishingBook(getPublishing(paramPublishing));
        book.setCountPagesBook(countPage);

        return impl.create(book) ? "Book added." : "Book not added.";
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
