package by.javatr.library.dao.impl;

import by.javatr.library.bean.Author;
import by.javatr.library.bean.Book;
import by.javatr.library.bean.Publishing;
import by.javatr.library.dao.LibraryDAO;
import by.javatr.library.dao.factory.DAOFactory;
import by.javatr.library.exception.dao.DAOException;
import by.javatr.library.exception.dao.DAOFileParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements LibraryDAO <Book, Integer> {

    private String path;

    public BookDAO(String path){
        this.path = path;
    }

    public BookDAO(){
        path = DAOFactory.getConnection("file.books");
    }

    @Override
    public List<Book> getAll() throws DAOException {
        List<Book> result = new ArrayList<>();

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document document = docBuilder.parse(path);

            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++){
                Node node = nodeList.item(i);
                List<Author> authors = new ArrayList<>();

                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element book = (Element) node;
                    Book tmpBook = new Book();

                    tmpBook.setIdBook(Integer.parseInt(book.getAttribute("id")));
                    tmpBook.setNameBook(book.getElementsByTagName("book_name").item(0).getTextContent());

                    NodeList authorList = book.getElementsByTagName("author");

                    for (int j = 0; j < authorList.getLength(); j++){
                        Node nodeAuthor = authorList.item(j);

                        if (nodeAuthor.getNodeType() == Node.ELEMENT_NODE){
                            Element author = (Element) nodeAuthor;
                            Author tmpAuthor = new Author();

                            tmpAuthor.setAuthorFirstName(author.getElementsByTagName("author_first_name").item(0).getTextContent());
                            tmpAuthor.setAuthorSecondName(author.getElementsByTagName("author_second_name").item(0).getTextContent());

                            authors.add(tmpAuthor);
                        }
                    }
                    Author[] tmp = new Author[authors.size()];

                    for (int k = 0; k < tmp.length; k++)
                        tmp[k] = authors.get(k);

                    tmpBook.setAuthorsBook(tmp);

                    Publishing tmpPublihing = new Publishing();

                    NodeList publNode = book.getElementsByTagName("publishing");
                    Element publishing = (Element) publNode.item(0);

                    if (publishing != null) {
                        tmpPublihing.setIdPublishing(Integer.parseInt(publishing.getAttribute("id")));
                        tmpPublihing.setNamePublishing(publishing.getElementsByTagName("publishing_name").item(0).getTextContent());
                        tmpPublihing.setCountryPublishing(publishing.getElementsByTagName("publishing_country").item(0).getTextContent());
                        tmpBook.setPublishingBook(tmpPublihing);
                    }

                    tmpBook.setCountPagesBook(Integer.parseInt(book.getElementsByTagName("count_pages").item(0).getTextContent()));

                    result.add(tmpBook);
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new DAOFileParseException("Sorry, I'cant parse document.", e);
        }

        return result;
    }

    @Override
    public Book getEntityById(Integer id) throws DAOException {
        Book result = null;

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document document = docBuilder.parse(path);

            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++){
                Node node = nodeList.item(i);
                List<Author> authors = new ArrayList<>();

                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element book = (Element) node;

                    if (Integer.parseInt(book.getAttribute("id")) == id) {
                        result = new Book();

                        result.setIdBook(Integer.parseInt(book.getAttribute("id")));
                        result.setNameBook(book.getElementsByTagName("book_name").item(0).getTextContent());

                        NodeList authorList = book.getElementsByTagName("author");

                        for (int j = 0; j < authorList.getLength(); j++) {
                            Node nodeAuthor = authorList.item(j);

                            if (nodeAuthor.getNodeType() == Node.ELEMENT_NODE) {
                                Element author = (Element) nodeAuthor;
                                Author tmpAuthor = new Author();

                                tmpAuthor.setAuthorFirstName(author.getElementsByTagName("author_first_name").item(0).getTextContent());
                                tmpAuthor.setAuthorSecondName(author.getElementsByTagName("author_second_name").item(0).getTextContent());

                                authors.add(tmpAuthor);
                            }
                        }
                        Author[] tmp = new Author[authors.size()];

                        for (int k = 0; k < tmp.length; k++)
                            tmp[k] = authors.get(k);

                        result.setAuthorsBook(tmp);

                        Publishing tmpPublihing = new Publishing();

                        NodeList publNode = book.getElementsByTagName("publishing");
                        Element publishing = (Element) publNode.item(0);

                        if (publishing != null) {
                            tmpPublihing.setIdPublishing(Integer.parseInt(publishing.getAttribute("id")));
                            tmpPublihing.setNamePublishing(publishing.getElementsByTagName("publishing_name").item(0).getTextContent());
                            tmpPublihing.setCountryPublishing(publishing.getElementsByTagName("publishing_country").item(0).getTextContent());
                            result.setPublishingBook(tmpPublihing);
                        }

                        result.setCountPagesBook(Integer.parseInt(book.getElementsByTagName("count_pages").item(0).getTextContent()));

                        break;
                    }
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new DAOFileParseException("Sorry, I'cant parse document.", e);
        }

        return result;
    }

    @Override
    public boolean update(Book oldBook, Book newBook) throws DAOException {
        return false;
    }

    @Override
    public boolean create(Book entity) throws DAOException {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document document = docBuilder.parse(path);

            Element root = document.getDocumentElement();

            Element rootElement = document.getDocumentElement();

            Element book = document.createElement("book");
            book.setAttribute("id", String.valueOf(entity.getIdBook()));
            rootElement.appendChild(book);

            Element name = document.createElement("book_name");
            name.appendChild(document.createTextNode(entity.getNameBook()));
            book.appendChild(name);

            if (entity.getAuthorsBook() != null){
                Element authors = document.createElement("authors");
                book.appendChild(authors);

                for (int i = 0; i < entity.getAuthorsBook().length; i++){
                    Element author = document.createElement("author");
                    authors.appendChild(author);

                    Element firstName = document.createElement("author_first_name");
                    firstName.appendChild(document.createTextNode(entity.getAuthorsBook()[i].getAuthorFirstName()));
                    author.appendChild(firstName);

                    Element secondName = document.createElement("author_second_name");
                    secondName.appendChild(document.createTextNode(entity.getAuthorsBook()[i].getAuthorSecondName()));
                    author.appendChild(secondName);
                }
            }

            if (entity.getPublishingBook() != null) {
                Element publishing = document.createElement("publishing");
                publishing.setAttribute("id", String.valueOf(entity.getIdBook()));
                book.appendChild(publishing);


                Element namePublishing = document.createElement("publishing_name");
                namePublishing.appendChild(document.createTextNode(entity.getPublishingBook().getNamePublishing()));
                publishing.appendChild(namePublishing);

                Element countryPublishing = document.createElement("publishing_country");
                countryPublishing.appendChild(document.createTextNode(entity.getPublishingBook().getCountryPublishing()));
                publishing.appendChild(countryPublishing);
            }

            Element pages = document.createElement("count_pages");
            pages.appendChild(document.createTextNode(String.valueOf(entity.getCountPagesBook())));
            book.appendChild(pages);

            root.appendChild(book);

            DOMSource source = new DOMSource(document);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult result = new StreamResult(path);
            transformer.transform(source, result);
        } catch (IOException | ParserConfigurationException | SAXException | TransformerException e) {
            throw new DAOFileParseException("Sorry, I'cant parse document.", e);
        }

        return true;
    }

    @Override
    public boolean remove(Integer id) throws DAOException {
        try {
            List<Book> all = getAll();

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document document = docBuilder.newDocument();

            Element rootElement = document.createElement("library");
            document.appendChild(rootElement);

            for (int k = 0; k < all.size(); k++) {

                if (all.get(k).getIdBook() != id) {
                    Element book = document.createElement("book");
                    book.setAttribute("id", String.valueOf(all.get(k).getIdBook()));
                    rootElement.appendChild(book);

                    Element name = document.createElement("book_name");
                    name.appendChild(document.createTextNode(all.get(k).getNameBook()));
                    book.appendChild(name);

                    if (all.get(k).getAuthorsBook() != null) {
                        Element authors = document.createElement("authors");
                        book.appendChild(authors);

                        for (int i = 0; i < all.get(k).getAuthorsBook().length; i++) {
                            Element author = document.createElement("author");
                            authors.appendChild(author);

                            Element firstName = document.createElement("author_first_name");
                            firstName.appendChild(document.createTextNode(all.get(k).getAuthorsBook()[i].getAuthorFirstName()));
                            author.appendChild(firstName);

                            Element secondName = document.createElement("author_second_name");
                            secondName.appendChild(document.createTextNode(all.get(k).getAuthorsBook()[i].getAuthorSecondName()));
                            author.appendChild(secondName);
                        }
                    }

                    if (all.get(k).getPublishingBook() != null) {
                        Element publishing = document.createElement("publishing");
                        publishing.setAttribute("id", String.valueOf(all.get(k).getIdBook()));
                        book.appendChild(publishing);


                        Element namePublishing = document.createElement("publishing_name");
                        namePublishing.appendChild(document.createTextNode(all.get(k).getPublishingBook().getNamePublishing()));
                        publishing.appendChild(namePublishing);

                        Element countryPublishing = document.createElement("publishing_country");
                        countryPublishing.appendChild(document.createTextNode(all.get(k).getPublishingBook().getCountryPublishing()));
                        publishing.appendChild(countryPublishing);
                    }

                    Element pages = document.createElement("count_pages");
                    pages.appendChild(document.createTextNode(String.valueOf(all.get(k).getCountPagesBook())));
                    book.appendChild(pages);

                    rootElement.appendChild(book);

                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream(path)));
                }
            }
        } catch (ParserConfigurationException | IOException | TransformerException e) {
            throw new DAOFileParseException("Sorry, I'cant parse document.", e);
        }

        return true;
    }
}
