package by.javatr.library.dao.impl;

import by.javatr.library.dao.LibraryDAO;
import by.javatr.library.entity.Role;
import by.javatr.library.entity.User;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.ArrayList;
import java.util.List;

public class XmlUserDAO implements LibraryDAO <User, Integer> {

    private String path;

    public XmlUserDAO(){}

    public XmlUserDAO(String path){
        this.path = path;
    }

    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();

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
                    tmpUser.setRoleUser(Role.valueOf(user.getElementsByTagName("role").item(0).getTextContent().toUpperCase()));

                    result.add(tmpUser);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public User getEntityById(Integer id) {
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
                        User tmpUser = new User();

                        tmpUser.setIdUser(Integer.parseInt(user.getAttribute("id")));
                        tmpUser.setNameUser(user.getElementsByTagName("user_name").item(0).getTextContent());
                        tmpUser.setPasswordUser(user.getElementsByTagName("user_password").item(0).getTextContent());
                        tmpUser.setRoleUser(Role.valueOf(user.getElementsByTagName("role").item(0).getTextContent().toUpperCase()));

                        return tmpUser;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new User();
    }

    @Override
    public boolean update(User oldUser, User newUser) {
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

                    if (Integer.parseInt(user.getAttribute("id")) == oldUser.getIdUser()){
                        node = null;
                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
}

    @Override
    public boolean create(User entity){
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

    public boolean isUserExist(User entity) {
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

                    if (tmpUser.equals(entity)){
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
