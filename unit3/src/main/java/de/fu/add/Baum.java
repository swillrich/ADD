package de.fu.add;

public class Baum {

	private Knoten root = new Knoten();

	public Knoten getRoot() {
		return root;
	}

	int numbering = 0;

	public Baum(final int maxTiefe) {

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
