package de.fu.add;

/**
 * @author willrich
 *
 *         Durchsucht einen binaeren Baum rekursiv per DFS (Depth-First Search)
 */
public abstract class BaumDFS {
	public BaumDFS(Knoten knoten) {
		deeper(knoten, 0);
	}

	/**
	 * Rekursive Funktion, die jeweils eins tiefer geht.
	 * 
	 * @param k
	 *            aktueller Knoten
	 * @param tiefe
	 *            Tiefe des aktuellen Knotens
	 */
	private void deeper(Knoten k, int tiefe) {
		if (k == null) {
			return;
		}
		visit(k, tiefe);
		deeper(k.getLeft(), tiefe + 1);
		deeper(k.getRight(), tiefe + 1);
		leaf(k, tiefe);
	}

	/**
	 * Wird aufgerufen, wenn ein beliebiger Knoten per DFS besucht wird
	 * 
	 * @param k
	 *            der aktuelle Knoten
	 * @param tiefe
	 *            die Tiefe des aktuellen Knotens
	 */
	public abstract void visit(Knoten k, int tiefe);

	/**
	 * Wird aufgerufen, wenn ein beliebiger Knoten per DFS verlassen wird
	 * 
	 * @param k
	 *            der aktuelle Knoten
	 * @param tiefe
	 *            die Tiefe des aktuellen Knotens
	 */
	public void leaf(Knoten k, int tiefe) {

	};
}
