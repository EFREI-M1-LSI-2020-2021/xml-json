package exercice1;

public class Transf {

	public static void main(String[] args) {
		try {
			System.out.println("début");
			parser parseur = new parser();

			String filename = "bib.xml";

			parseur.parse(filename);
			System.out.println("fin");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
