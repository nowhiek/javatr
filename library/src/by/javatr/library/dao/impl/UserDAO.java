package by.javatr.library.dao.impl;

import by.javatr.library.bean.Role;
import by.javatr.library.bean.User;
import by.javatr.library.dao.LibraryDAO;
import by.javatr.library.dao.factory.DAOFactory;
import by.javatr.library.dao.util.UserParser;
import by.javatr.library.exception.dao.DAOException;
import by.javatr.library.exception.dao.DAOFileParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
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
            Document document = UserParser.getDocument(path);
            NodeList nodeList = document.getElementsByTagName("user");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element user = (Element) nodeList.item(i);
                User tmpUser = new User();

                tmpUser.setIdUser(Integer.parseInt(user.getAttribute("id")));
                tmpUser.setNameUser(user.getElementsByTagName("user_name").item(0).getTextContent());
                tmpUser.setPasswordUser(user.getElementsByTagName("user_password").item(0).getTextContent());
                tmpUser.setRoleUser(Role.valueOf(user.getElementsByTagName("role").item(0).getTextContent().toUpperCase()));

                result.add(tmpUser);
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
            Document document = UserParser.getDocument(path);
            NodeList nodeList = document.getElementsByTagName("user");

            for (int i = 0; i < nodeList.getLength(); i++){
                Element user = (Element) nodeList.item(i);

                if (Integer.parseInt(user.getAttribute("id")) == id) {
                    tmpUser = new User();

                    tmpUser.setIdUser(Integer.parseInt(user.getAttribute("id")));
                    tmpUser.setNameUser(user.getElementsByTagName("user_name").item(0).getTextContent());
                    tmpUser.setPasswordUser(user.getElementsByTagName("user_password").item(0).getTextContent());
                    tmpUser.setRoleUser(Role.valueOf(user.getElementsByTagName("role").item(0).getTextContent().toUpperCase()));

                    break;
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

            Document document = UserParser.getDocument(path);
            Element rootElement = document.createElement("users");
            document.appendChild(rootElement);

            for (int i = 0; i < all.size(); i++) {

                if (all.get(i).equals(oldUser)) {
                    all.get(i).setIdUser(newUser.getIdUser());
                    all.get(i).setNameUser(newUser.getNameUser());
                    all.get(i).setPasswordUser(newUser.getPasswordUser());
                    all.get(i).setRoleUser(newUser.getRoleUser());
                }

                UserParser.appendChildes(document, all.get(i));
                UserParser.writeToXML(path, document);
            }
        } catch (ParserConfigurationException | IOException | TransformerException | SAXException e) {
            throw new DAOFileParseException("Sorry, I'cant parse document.", e);
        }

        return true;
}

    @Override
    public boolean create(User entity) throws DAOException {
        try {
            Document document = UserParser.getDocument(path);

            UserParser.appendChildes(document, entity);
            UserParser.writeToXML(path, document);
        } catch (SAXException | ParserConfigurationException | IOException | TransformerException e) {
            throw new DAOFileParseException("Sorry, I'cant parse document.", e);
        }

        return true;
    }

    @Override
    public boolean remove(Integer id) throws DAOException {
        try {
            List<User> all = getAll();

            Document document = UserParser.getDocument(path);
            Element rootElement = document.createElement("users");
            document.appendChild(rootElement);

            for (int i = 0; i < all.size(); i++) {

                if (all.get(i).getIdUser() != id) {
                    UserParser.appendChildes(document, all.get(i));
                    UserParser.writeToXML(path, document);
                }
            }
        } catch (ParserConfigurationException | IOException | TransformerException | SAXException e) {
            throw new DAOFileParseException("Sorry, I'cant parse document.", e);
        }

        return true;
    }

    public boolean isUserExist(User entity) throws DAOFileParseException {
        try {
            Document document = UserParser.getDocument(path);
            NodeList nodeList = document.getElementsByTagName("user");

            for (int i = 0; i < nodeList.getLength(); i++){
                Element user = (Element) nodeList.item(i);
                User tmpUser = new User();

                tmpUser.setIdUser(Integer.parseInt(user.getAttribute("id")));
                tmpUser.setNameUser(user.getElementsByTagName("user_name").item(0).getTextContent());
                tmpUser.setPasswordUser(user.getElementsByTagName("user_password").item(0).getTextContent());
                tmpUser.setRoleUser(Role.USER);

                if (tmpUser.getNameUser().equalsIgnoreCase(entity.getNameUser()) || tmpUser.getIdUser() == entity.getIdUser()){
                    return true;
                }

            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new DAOFileParseException("Sorry, I'cant parse document.", e);
        }

        return false;
    }
}
