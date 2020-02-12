package by.javatr.library.service.impl;

import by.javatr.library.bean.Author;
import by.javatr.library.bean.Book;
import by.javatr.library.bean.Publishing;
import by.javatr.library.dao.factory.DAOFactory;
import by.javatr.library.dao.impl.BookDAO;
import by.javatr.library.exception.dao.DAOException;
import by.javatr.library.exception.service.*;
import by.javatr.library.service.LibraryService;
import by.javatr.library.service.validator.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookServiceImpl implements LibraryService <Book>{

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private BookDAO bookDAO = daoFactory.getBookDAO();

    @Override
    public List<Book> getAll() throws ServiceException {
        List<Book> all = null;

        try {
            all = bookDAO.getAll();
        } catch (DAOException e) {
            throw new ServiceGetAllBooksException(e);
        }

        return all;
    }

    @Override
    public boolean create(Book entity) throws ServiceException {
        if (!BookValidator.validate(entity))
            throw new ServiceBookNotCorrectException("Book was not correct.");

        try {
            return bookDAO.create(entity);
        } catch (DAOException e) {
            throw new ServiceCreateBookException("The book was not created.");
        }
    }

    @Override
    public boolean remove(int id) throws ServiceException {
        if (!IdentifierValidator.validate(id))
            throw new ServiceIdentifierNotCorrectException("You entered not valid id.");

        try {
            return (findEntityById(id) != null && bookDAO.remove(id));
        } catch (DAOException e) {
            throw new ServiceRemoveBookException("The book was not deleted.", e);
        }
    }

    @Override
    public boolean update(Book oldEntity, Book newEntity) throws ServiceException {
        if (!BookValidator.validate(newEntity))
            throw new ServiceBookNotCorrectException("Book was not correct.");

        try {
            return (findEntityById((int) oldEntity.getIdBook()) != null && bookDAO.update(oldEntity, newEntity));
        } catch (DAOException e) {
            throw new ServiceUpdateBookException("The book was not updated.", e);
        }
    }

    @Override
    public Book findEntityById(int id) throws ServiceException {
        if (!IdentifierValidator.validate(id))
            throw new ServiceIdentifierNotCorrectException("You entered not valid id.");

        Book book = null;

        try {
            book = bookDAO.getEntityById(id);
        } catch (DAOException e) {
            throw new ServiceGetAllBooksException("Book was not received.", e);
        }

        return book;
    }

    @Override
    public Book findEntityByName(String bookName) throws ServiceException {
        if (!NameValidator.validate(bookName))
            throw new ServiceNameNotCorrectException("You entered not valid name.");

        List<Book> books = null;
        Book book = null;

        try {
            books = bookDAO.getAll();

            for (Book tmp : books) {
                if (tmp.getNameBook().equalsIgnoreCase(bookName)) {
                    book = tmp;

                    break;
                }
            }
        } catch (DAOException e) {
            throw new ServiceGetAllBooksException("Book was not received.", e);
        }

        return book;
    }

    @Override
    public List<Book> sortEntitiesByComparator(Comparator comparator) throws ServiceException {
        List<Book> books = null;

        try {
            books = bookDAO.getAll();

            books.sort(comparator);
        } catch (DAOException e) {
            throw new ServiceGetAllBooksException("Users were not received.", e);
        }

        return books;
    }

    public List<Book> findBooksByAuthor(Author author) throws ServiceException {
        if (!BookAuthorValidator.validate(author))
            throw new ServiceNameNotCorrectException("You entered not valid author name.");

        List<Book> books = null;
        List<Book> result = null;

        try {
            books = bookDAO.getAll();
            result = new ArrayList<>();

            for (Book book : books) {
                if (book.getAuthorsBook().length != 0) {
                    for (int i = 0; i < book.getAuthorsBook().length; i++) {
                        if (book.getAuthorsBook()[i].equals(author)) {
                            result.add(book);
                        }
                    }
                }
            }
        } catch (DAOException e) {
            throw new ServiceGetAllBooksException("Users were not received.", e);
        }

        return result;
    }

    public List<Book> findBooksByPublishing(Publishing publishing) throws ServiceException {
        if (!BookPublishingValidator.validate(publishing))
            throw new ServicePublishingNotCorrectException("You entered invalid publishing.");

        List<Book> books = null;
        List<Book> result = null;

        try {
            books = bookDAO.getAll();
            result = new ArrayList<>();

            for (Book book : books) {
                if (book.getPublishingBook() != null) {
                    if (book.getPublishingBook().getNamePublishing().equalsIgnoreCase(publishing.getNamePublishing())){
                        result.add(book);
                    }
                }
            }
        } catch (DAOException e) {
            throw new ServiceGetAllBooksException("Users were not received.", e);
        }

        return result;
    }

    public List<Book> findBooksByCountPages(int count) throws ServiceException {
        if (!BookCountPagesValidator.validate(count))
            throw new ServiceCountPagesNotCorrectException("You entered invalid count pages.");

        List<Book> books = null;
        List<Book> result = null;

        try {
            books = bookDAO.getAll();
            result = new ArrayList<>();

            for (Book book : books) {
                if (book.getCountPagesBook() == count) {
                    result.add(book);
                }
            }
        } catch (DAOException e) {
            throw new ServiceGetAllBooksException("Users were not received.", e);
        }

        return result;
    }
}
