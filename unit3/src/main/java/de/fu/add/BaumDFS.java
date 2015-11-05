package de.fu.add;

public abstract class BaumDFS {
	public BaumDFS(Knoten knoten) {
		deeper(knoten, 0);
	}

	private void deeper(Knoten k, int tiefe) {
		if (k == null) {
			return;
		}
		visit(k, tiefe);
		deeper(k.getLeft(), tiefe + 1);
		deeper(k.getRight(), tiefe + 1);
		leaf(k, tiefe);
	}

	public abstract void visit(Knoten k, int tiefe);

	public void leaf(Knoten k, int tiefe) {

	};
}
