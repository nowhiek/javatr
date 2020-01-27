package by.javatr.library.runner;

import by.javatr.library.controller.Controller;
import by.javatr.library.entity.*;
import by.javatr.library.service.impl.BookServiceImpl;
import by.javatr.library.service.impl.UserServiceImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        User user = new User(1, "Da", "DA", Role.USER);
        Author author1 = new Author("Oleg", "Mashikov");
        Author author2 = new Author("Maria", "Slaboda");
        Author author3 = new Author("Nikita", "Jigurda");

        Author[] authors1 = new Author[] {author1, author2};
        Author[] authors2 = new Author[] {author1};
        Author[] authors3 = new Author[] {author2, author3, author1};

        Publishing publishing1 = new Publishing(1, "ekb", "Russia");

        Book book1 = new Book(1, "Test", 123);
        Book book2 = new Book(2, "Atest", authors2, publishing1, 124);
        Book book3 = new Book(3, "BTest", authors3, 90);
        Book book4 = new Book(4, "Ztext", publishing1, 90);
        Book book5 = new Book(5, "WTeSt", authors1, publishing1, 200);

        UserServiceImpl dao = new UserServiceImpl();
        BookServiceImpl dao1 = new BookServiceImpl();

        List<Book> all = dao1.getAll();

        List<Book> booksByAuthor = dao1.findBooksByCountPages(222);

        for (int i = 0; i < booksByAuthor.size(); i++){
            System.out.println(booksByAuthor.get(i));
        }

        //System.out.println(entityById);

        Controller controller = new Controller();

    }
}
