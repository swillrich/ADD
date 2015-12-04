package de.fu.add;

/**
 * @author willrich
 * 
 *         Generiert einen vollen Binaer-Baum
 */
public class Baum {

	/**
	 * Der Root-Knoten
	 */
	private Knoten root = new Knoten();

	public Knoten getRoot() {
		return root;
	}

	/**
	 * Nummeriert die Knoten aufsteigend durch (DFS-Reihenfolge)
	 */
	int numbering = 0;

	/**
	 * Konstruiert einen vollen binaeren Baum anhand einer maximalen Tiefe, die
	 * fuer alle Blaetter gilt.
	 */
	public void createFullBinaryTree(final int maxTiefe) {

		new BaumDFS(root) {

			@Override
			public void visit(Knoten k, int tiefe) {
				numbering++;
				k.setId(numbering);
				if (tiefe < maxTiefe) {
					k.initChilds();
				}
			}
		};

		System.out.println(
				"Vollständiger, binärer Baum generiert mit " + (int) (Math.pow(2, (maxTiefe + 1)) - 1) + " Knoten");
	}

	public void show() {
		new BaumDFS(getRoot()) {

			@Override
			public void visit(Knoten k, int tiefe) {
				System.out.println("DSF Read: Knoten # " + k.getId());
			}
		};
	}
}
