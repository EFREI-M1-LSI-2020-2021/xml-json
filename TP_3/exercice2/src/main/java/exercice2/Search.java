package exercice2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Search 
{
    public static void main( String[] args ) throws ParserConfigurationException, SAXException, IOException
    {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse("file.xml");

        Element root = document.getDocumentElement();
        NodeList nodes = root.getChildNodes();

        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){
            String field = in.readLine();

            boolean found = false;

            for(int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if(node.getNodeName().equals(field)) {
                    found = true;
                    System.out.println(node.getTextContent());
                    break;
                }
            }

            if(!found) {
                System.out.println("This tag does not exists !");
            }
        }
    }
}
