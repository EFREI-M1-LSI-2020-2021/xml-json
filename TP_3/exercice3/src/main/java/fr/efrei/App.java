package fr.efrei;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class App
{
    public static void main( String[] args ) throws Exception
    {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse("gender.xml");

        Element root = document.getDocumentElement();

        List<Person> persons = getPersons(root);

        Document output = builder.newDocument();
        Element list = output.createElement("list");

        for(Person p : persons) {
            list.appendChild(getPerson(output, p));
        }

        output.appendChild(list);

        DOMImplementation domImpl = output.getImplementation();
        DocumentType doctype = domImpl.createDocumentType("doctype", "", "list [\n"+
            "   <!ELEMENT list (man | woman)*>\n" +
            "   <!ELEMENT man (sons, daughters)>\n" +
            "   <!ATTLIST man name CDATA #REQUIRED>\n" +
            "   <!ELEMENT woman (sons, daughters)>\n" +
            "   <!ATTLIST woman name CDATA #REQUIRED>\n" +
            "   <!ELEMENT sons (man)*>\n" +
            "   <!ELEMENT daughters (woman)*>\n" +
            "]");

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, doctype.getSystemId());
        transformer.transform(new DOMSource(output), new StreamResult(new File("output.xml")));
    }

    public static Element getPerson(Document doc, Person p) {

        Gender gender = p.getGender();
        Element person;

        if(gender.equals(Gender.Man)) {
            person = doc.createElement("man");
        }
        else {
            person = doc.createElement("woman");
        }

        person.setAttribute("name", p.getName());

        Element sons = doc.createElement("sons");

        for(Person son : p.getSons()) {
            sons.appendChild(getPerson(doc, son));
        }

        Element daughters = doc.createElement("daughters");

        for(Person daughter : p.getDaughters()) {
            daughters.appendChild(getPerson(doc, daughter));
        }

        person.appendChild(sons);
        person.appendChild(daughters);

        return person;
    }

    public static List<Person> getPersons(Element root) throws Exception {

        List<Person> persons = new ArrayList<>();

        Node node = root.getFirstChild();
        while (node != null && node.getNextSibling() != null) {
            node = node.getNextSibling();

            if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName() == "person") {

                Element el = (Element) node;

                String genderVal = el.getAttribute("gender");
                Gender gender;

                switch (genderVal) {
                    case "M": gender = Gender.Man; break;
                    case "F": gender = Gender.Woman; break;
                    default: throw new Exception("Invalid gender");
                }

                String name = el.getElementsByTagName("name").item(0).getTextContent();

                List<Person> sons = new ArrayList<>();
                List<Person> daughters = new ArrayList<>();

                Node childs = el.getElementsByTagName("children").item(0);
                List<Person> children = getPersons((Element) childs);

                for(Person person : children) {
                    if(person.getGender().equals(Gender.Man)) {
                        sons.add(person);
                    }
                    else {
                        daughters.add(person);
                    }
                }

                persons.add(new Person(name, gender, sons, daughters));   
            }
        }

        return persons;
    }
}
