package by.javatr.library.dao.util;

import by.javatr.library.bean.User;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

public final class UserParser {

    public static Document getDocument(String path) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document document = docBuilder.parse(path);

        return document;
    }

    public static void writeToXML(String path, Document document) throws TransformerException {
        DOMSource source = new DOMSource(document);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult(path);
        transformer.transform(source, result);
    }

    public static void appendChildes(Document document, User entity){
        Element root = document.getDocumentElement();
        Element rootElement = document.getDocumentElement();
        Element element = createTagElement(document);

        rootElement.appendChild(getAttributeToRoot(element, entity));

        element.appendChild(getNameToChild(document, entity));
        element.appendChild(getPasswordToChild(document, entity));
        element.appendChild(getRoleToChild(document, entity));

        root.appendChild(element);
    }

    private static Element createTagElement(Document document){
        String tag = "user";

        Element user = document.createElement(tag);

        return user;
    }

    private static Element getAttributeToRoot(Element element, User entity){
        String attribute = "id";

        element.setAttribute(attribute, String.valueOf(entity.getIdUser()));

        return element;
    }

    private static Element getNameToChild(Document document, User entity){
        String tag = "user_name";

        Element name = document.createElement(tag);
        name.appendChild(document.createTextNode(entity.getNameUser()));

        return name;
    }

    private static Element getPasswordToChild(Document document, User entity) {
        String tag = "user_password";

        Element password = document.createElement(tag);
        password.appendChild(document.createTextNode(entity.getPasswordUser()));

        return password;
    }

    private static Element getRoleToChild(Document document, User entity) {
        String tag = "role";

        Element role = document.createElement(tag);
        role.appendChild(document.createTextNode(entity.getRoleUser().getTitle()));

        return role;
    }
}
