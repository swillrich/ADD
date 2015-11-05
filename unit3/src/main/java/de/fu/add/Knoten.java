package de.fu.add;

public class Knoten {
	private String value = "";
	private Knoten left;
	private Knoten right;
	private int id;

	public void initChilds() {
		left = new Knoten();
		right = new Knoten();
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Knoten getLeft() {
		return left;
	}

	public Knoten getRight() {
		return right;
	}

	public String getValue() {
		return value;
	}

	public void setId(int i) {
		this.id = i;
	}

	public int getId() {
		return id;
	}
}
