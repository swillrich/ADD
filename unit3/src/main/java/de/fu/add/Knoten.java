package de.fu.add;

/**
 * @author willrich
 *
 *         Ein Knoten, der im Baum ist
 */
public class Knoten {
	private Knoten left;
	private Knoten right;
	private int id;

	public void initChilds() {
		left = new Knoten();
		right = new Knoten();
	}

	public Knoten getLeft() {
		return left;
	}

	public Knoten getRight() {
		return right;
	}

	public void setId(int i) {
		this.id = i;
	}

	public int getId() {
		return id;
	}
}
