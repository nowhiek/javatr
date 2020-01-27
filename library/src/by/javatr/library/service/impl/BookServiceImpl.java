package by.javatr.library.service.impl;

import by.javatr.library.dao.factory.DAOFactory;
import by.javatr.library.entity.Author;
import by.javatr.library.entity.Book;
import by.javatr.library.entity.Publishing;
import by.javatr.library.service.LibraryService;
import by.javatr.library.service.validator.impl.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookServiceImpl implements LibraryService <Book>{

    @Override
    public List<Book> getAll() {
        DAOFactory dao = DAOFactory.getDAOFactory(1);
        List<Book> all = dao.getBookDAO().getAll();

        return all;
    }

    @Override
    public boolean create(Book entity) {
        if (!new BookValidator().validate(entity))
            System.out.println("Exception");

        DAOFactory dao = DAOFactory.getDAOFactory(1);

        return dao.getBookDAO().create(entity);
    }

    @Override
    public boolean remove(Book entity) {
        return false;
    }

    @Override
    public Book findEntityById(int id) {
        DAOFactory dao = DAOFactory.getDAOFactory(1);

        return (Book) dao.getBookDAO().getEntityById(id);
    }

    @Override
    public Book findEntityByName(String bookName) {
        if (!new BookNameValidator().validate(bookName))
            System.out.println("Exception null or empty.");

        DAOFactory dao = DAOFactory.getDAOFactory(1);
        List<Book> books = dao.getBookDAO().getAll();

        for (Book book : books) {
            if (book.getNameBook().equals(bookName)) {
                return book;
            }
        }

        return new Book();
    }

    public List<Book> findBooksByAuthor(Author author) {
        if (!new AuthorNameValidator().validate(author))
            System.out.println("Exception null or empty");

        DAOFactory dao = DAOFactory.getDAOFactory(1);
        List<Book> books = dao.getBookDAO().getAll();
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getAuthorsBook().length != 0) {
                for (int i = 0; i < book.getAuthorsBook().length; i++) {
                    if (book.getAuthorsBook()[i].equals(author)) {
                        result.add(book);
                    }
                }
            }
        }

        return result;
    }

    public List<Book> findBooksByPublishing(Publishing publishing) {
        if (!new PublishingNameValidator().validate(publishing))
            System.out.println("Exception null or empty");

        DAOFactory dao = DAOFactory.getDAOFactory(1);
        List<Book> books = dao.getBookDAO().getAll();
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getPublishingBook() != null) {
                if (book.getPublishingBook().getNamePublishing().equals(publishing.getNamePublishing())){
                    result.add(book);
                }
            }
        }

        return result;
    }

    public List<Book> findBooksByCountPages(int count) {
        if (!new CountPagesValidator().validate(count))
            System.out.println("Exception not correct argument");

        DAOFactory dao = DAOFactory.getDAOFactory(1);
        List<Book> books = dao.getBookDAO().getAll();
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getCountPagesBook() == count) {
               result.add(book);
            }
        }

        return result;
    }

    @Override
    public List<Book> sortEntitiesByComparator(Comparator comparator) {
        DAOFactory dao = DAOFactory.getDAOFactory(1);
        List<Book> books = dao.getBookDAO().getAll();

        books.sort(comparator);

        return books;
    }
}
