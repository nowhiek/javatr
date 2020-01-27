package by.javatr.library.dao.impl;

import by.javatr.library.dao.LibraryDAO;
import by.javatr.library.entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.print.attribute.AttributeSetUtilities;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.ArrayList;
import java.util.List;

public class XmlBookDAO implements LibraryDAO <Book, Integer> {

    private String path;

    public XmlBookDAO(){}

    public XmlBookDAO(String path){
        this.path = path;
    }

    @Override
    public List<Book> getAll() {
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Book getEntityById(Integer id) {
        Book result = new Book();

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

                        return result;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }//or release getAll and foreach

        return result;
    }

    @Override
    public boolean update(Book oldBook, Book newBook) {
        return false;
    }

    @Override
    public boolean create(Book entity) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document document = docBuilder.parse(path);

            Element root = document.getDocumentElement();

            Element rootElement = document.getDocumentElement();

            Element book = document.createElement("book");
            book.setAttribute("id", "1");
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
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
