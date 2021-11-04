package exercice1;

import java.io.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;

public class parser {

	public PrintWriter out = null;

	public void parse(String _fichier) throws SAXException, ParserConfigurationException, IOException {

		FileInputStream _xml_input_file = new FileInputStream(_fichier);

		parse(_xml_input_file);
	}

	public void parse(InputStream _xml_input_file) throws SAXException, ParserConfigurationException, IOException {

		out = new PrintWriter(new FileOutputStream("./toto.html"));
		out.println("<html xmlns:fo=\"http://www.w3.org/1999/XSL/Format\"><head />");
		out.println("<body>");
		out.println(
				"<META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"><h1 align=\"left\">Domaines </h1>");

		DocumentBuilderFactory _factory = DocumentBuilderFactory.newInstance();

		_factory.setIgnoringComments(true);

		DocumentBuilder _builder = _factory.newDocumentBuilder();

		Document doc = _builder.parse(_xml_input_file);

		final Element root = doc.getDocumentElement();
		final NodeList rootNodes = root.getChildNodes();
		final int countRootNodes = rootNodes.getLength();

		for (int i = 0; i < countRootNodes; i++) {
			if (rootNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
				final Element domain = (Element) rootNodes.item(i);
				final Element title = (Element) domain.getElementsByTagName("title").item(0);
				out.println("<h2><a href=\"#" + title.getTextContent() + "\">" + title.getTextContent() + "</a></h2>");
			}
		}

		out.println("<hr>");
		out.println("<hr>");

		for (int i = 0; i < countRootNodes; i++) {
			if (rootNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
				final Element domain = (Element) rootNodes.item(i);
				final Element title = (Element) domain.getElementsByTagName("title").item(0);

				out.println("<table width=\"100%\" border=\"1\">");
				out.println("	<tr>");
				out.println("   	<td width=\"100%\" bgcolor=\"#C0C0C0\">");
				out.println("			<h2><a name=\"" + title.getTextContent() + "\">" + title.getTextContent()
						+ "</a></h2>");
				out.println("		</td>");
				out.println("	</tr>");
				out.println("</table>");

				final NodeList bib_refs = domain.getElementsByTagName("bib_ref");
				final int nbBibRefElements = bib_refs.getLength();

				for (int j = 0; j < nbBibRefElements; j++) {
					final Element bib_ref = (Element) bib_refs.item(j);
					out.println("<hr>");
					final Element year = (Element) bib_ref.getElementsByTagName("year").item(0);

					out.println("Annee  :" + year.getTextContent());
					out.println("<br />");

					final Element titleChild = (Element) bib_ref.getElementsByTagName("title").item(0);

					out.println("<h3>Titre  :" + titleChild.getTextContent() + "</h3>");

					final Element author = (Element) bib_ref.getElementsByTagName("author").item(0);
					out.println("Auteur  :" + author.getTextContent());
					out.println("<br />");

					final Element link = (Element) bib_ref.getElementsByTagName("weblink").item(0);
					out.println(
							"Lien : <a href=\"" + link.getTextContent() + "\">" + link.getTextContent() + "</a></h2>");
					out.println("<br />");
				}
			}
		}

		out.close();
		out.flush();
	}
}