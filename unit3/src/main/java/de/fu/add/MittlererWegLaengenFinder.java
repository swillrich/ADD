package de.fu.add;

/**
 * @author willrich
 *
 *         Berechnet den Mittelwert der inneren Wege von Root zu allen Knoten.
 *         Hierzu muss der Baum nicht vollständig sein.
 */
public class MittlererWegLaengenFinder {

	/**
	 * Die Summe aller inneren Weglängen
	 */
	int summe = 0;
	/**
	 * Zählt die Länge eins Weges mit
	 */
	int tmpCounter = 0;
	/**
	 * Zählt die Anzahl der Knoten, die im Baum existieren
	 */
	int anzahlKnoten = 0;

	public void berechne(Baum baum) {
		new BaumDFS(baum.getRoot()) {

			@Override
			public void visit(Knoten k, int tiefe) {
				tmpCounter++;
				anzahlKnoten++;
				summe += tmpCounter - 1;
			}

			public void leaf(Knoten k, int tiefe) {
				tmpCounter--;
			}
		};
		System.out.println("Mittlere innere Weglänge ist " + (summe / anzahlKnoten));
	}
}
