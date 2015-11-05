package de.fu.add;

/**
 * @author willrich
 *
 *         Berechnet den Mittelwert der inneren Wege von Root zu allen Knoten.
 *         Hierzu muss der Baum nicht vollst�ndig sein.
 */
public class MittlererWegLaengenFinder {

	/**
	 * Die Summe aller inneren Wegl�ngen
	 */
	int summe = 0;
	/**
	 * Z�hlt die L�nge eins Weges mit
	 */
	int tmpCounter = 0;
	/**
	 * Z�hlt die Anzahl der Knoten, die im Baum existieren
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
		System.out.println("Mittlere innere Wegl�nge ist " + (summe / anzahlKnoten));
	}
}
