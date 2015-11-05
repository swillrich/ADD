package de.fu.add;

public class MittlererWegLaengenFinder {
	
	int summe = 0;
	int tmpCounter = 0;
	int anzahlBlaetter = 0;
	
	
	public void finde(Baum baum) {
		new BaumDFS(baum.getRoot()) {
			
			@Override
			public void visit(Knoten k, int tiefe) {
				tmpCounter++;
				if (k.getLeft() == null && k.getRight() == null) {
					summe += tmpCounter - 1;
					anzahlBlaetter++;
				}
			}

			public void leaf(Knoten k, int tiefe) {
				tmpCounter--;
			}
		};
		System.out.println("Mittlere innere Weglänge ist " + (summe / anzahlBlaetter));
	}
}
