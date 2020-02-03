package by.javatr.library.dao.impl;

import by.javatr.library.bean.Role;
import by.javatr.library.bean.User;
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

public class UserDAO implements LibraryDAO <User, Integer> {

    private String path;

    public UserDAO(String path){
        this.path = path;
    }

    public UserDAO(){
        path = DAOFactory.getConnection("file.users");
    }

    @Override
    public List<User> getAll() throws DAOException {
        List<User> result = new ArrayList<>();

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document document = docBuilder.parse(path);

            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("user");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element user = (Element) node;
                    User tmpUser = new User();

                    tmpUser.setIdUser(Integer.parseInt(user.getAttribute("id")));
                    tmpUser.setNameUser(user.getElementsByTagName("user_name").item(0).getTextContent());
                    tmpUser.setPasswordUser(user.getElementsByTagName("user_password").item(0).getTextContent());
                    tmpUser.setRoleUser(Role.valueOf(user.getElementsByTagName("role").item(0).getTextContent().toUpperCase()));

                    result.add(tmpUser);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new DAOFileParseException("Sorry, I'cant parse document.", e);
        }

        return result;
    }

    @Override
    public User getEntityById(Integer id) throws DAOException {
        User tmpUser = null;

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document document = docBuilder.parse(path);

            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("user");

            for (int i = 0; i < nodeList.getLength(); i++){
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element user = (Element) node;

                    if (Integer.parseInt(user.getAttribute("id")) == id) {
                        tmpUser = new User();

                        tmpUser.setIdUser(Integer.parseInt(user.getAttribute("id")));
                        tmpUser.setNameUser(user.getElementsByTagName("user_name").item(0).getTextContent());
                        tmpUser.setPasswordUser(user.getElementsByTagName("user_password").item(0).getTextContent());
                        tmpUser.setRoleUser(Role.valueOf(user.getElementsByTagName("role").item(0).getTextContent().toUpperCase()));

                        break;
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new DAOFileParseException("Sorry, I'cant parse document.", e);
        }

        return tmpUser;
    }

    @Override
    public boolean update(User oldUser, User newUser) throws DAOException {
        try {
            List<User> all = getAll();

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document document = docBuilder.newDocument();

            Element rootElement = document.createElement("users");
            document.appendChild(rootElement);

            for (int i = 0; i < all.size(); i++) {

                if (all.get(i).equals(oldUser)) {
                    all.get(i).setIdUser(newUser.getIdUser());
                    all.get(i).setNameUser(newUser.getNameUser());
                    all.get(i).setPasswordUser(newUser.getPasswordUser());
                    all.get(i).setRoleUser(newUser.getRoleUser());
                }

                Element user = document.createElement("user");
                user.setAttribute("id", String.valueOf(all.get(i).getIdUser()));
                rootElement.appendChild(user);

                Element name = document.createElement("user_name");
                name.appendChild(document.createTextNode(all.get(i).getNameUser()));
                user.appendChild(name);

                Element password = document.createElement("user_password");
                password.appendChild(document.createTextNode(all.get(i).getPasswordUser()));
                user.appendChild(password);

                Element role = document.createElement("role");
                role.appendChild(document.createTextNode(all.get(i).getRoleUser().getTitle()));
                user.appendChild(role);

                rootElement.appendChild(user);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream(path)));
            }
        } catch (ParserConfigurationException | IOException | TransformerException e) {
            throw new DAOFileParseException("Sorry, I'cant parse document.", e);
        }

        return true;
}

    @Override
    public boolean create(User entity) throws DAOException {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document document = docBuilder.parse(path);

            Element root = document.getDocumentElement();

            Element rootElement = document.getDocumentElement();

            Element user = document.createElement("user");
            user.setAttribute("id", String.valueOf(entity.getIdUser()));
            rootElement.appendChild(user);

            Element name = document.createElement("user_name");
            name.appendChild(document.createTextNode(entity.getNameUser()));
            user.appendChild(name);

            Element password = document.createElement("user_password");
            password.appendChild(document.createTextNode(entity.getPasswordUser()));
            user.appendChild(password);

            Element role = document.createElement("role");
            role.appendChild(document.createTextNode(entity.getRoleUser().getTitle()));
            user.appendChild(role);

            root.appendChild(user);

            DOMSource source = new DOMSource(document);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult result = new StreamResult(path);
            transformer.transform(source, result);
        } catch (SAXException | ParserConfigurationException | IOException | TransformerException e) {
            throw new DAOFileParseException("Sorry, I'cant parse document.", e);
        }

        return true;
    }

    @Override
    public boolean remove(Integer id) throws DAOException {
        try {
            List<User> all = getAll();

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document document = docBuilder.newDocument();

            Element rootElement = document.createElement("users");
            document.appendChild(rootElement);

            for (int i = 0; i < all.size(); i++) {

                if (all.get(i).getIdUser() != id) {
                    Element user = document.createElement("user");
                    user.setAttribute("id", String.valueOf(all.get(i).getIdUser()));
                    rootElement.appendChild(user);

                    Element name = document.createElement("user_name");
                    name.appendChild(document.createTextNode(all.get(i).getNameUser()));
                    user.appendChild(name);

                    Element password = document.createElement("user_password");
                    password.appendChild(document.createTextNode(all.get(i).getPasswordUser()));
                    user.appendChild(password);

                    Element role = document.createElement("role");
                    role.appendChild(document.createTextNode(all.get(i).getRoleUser().getTitle()));
                    user.appendChild(role);

                    rootElement.appendChild(user);

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

    public boolean isUserExist(User entity) throws DAOFileParseException {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document document = docBuilder.parse(path);

            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("user");

            for (int i = 0; i < nodeList.getLength(); i++){
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element user = (Element) node;
                    User tmpUser = new User();

                    tmpUser.setIdUser(Integer.parseInt(user.getAttribute("id")));
                    tmpUser.setNameUser(user.getElementsByTagName("user_name").item(0).getTextContent());
                    tmpUser.setPasswordUser(user.getElementsByTagName("user_password").item(0).getTextContent());
                    tmpUser.setRoleUser(Role.USER);

                    if (tmpUser.getNameUser().equalsIgnoreCase(entity.getNameUser()) || tmpUser.getIdUser() == entity.getIdUser()){
                        return true;
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new DAOFileParseException("Sorry, I'cant parse document.", e);
        }

        return false;
    }
}
