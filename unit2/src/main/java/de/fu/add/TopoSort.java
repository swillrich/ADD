package de.fu.add;

import java.io.*;
import java.util.Arrays;

class TopoSort {
	int n;
	Knoten[] Liste; // Liste aller Knoten 1,...,n
	Knoten[] freieKnoten; // Menge Q der Knoten ohne Vorgänger
	int AnzfreieKnoten; // (als Stapel gespeichert)

	static IntReader input;

	public static void main(String[] args) throws IOException {
		input = new IntReader(args);
		TopoSort x = new TopoSort();
	}

	TopoSort() throws IOException {
		System.out.println("Topologischen Sortieren.");
		// Einlesen
		n = input.readInt();

		// Inititalisieren array:
		Liste = new Knoten[n + 1];
		for (int i = 1; i <= n; i++)
			Liste[i] = new Knoten(i);

		// Einlesen Kanten
		try {
			for (;;) {
				Knoten e = Liste[input.readInt()];
				Knoten f = Liste[input.readInt()];
				Kante x = new Kante(e, f);
				x.next = e.ersterNachfolger;
				e.ersterNachfolger = x;
				f.anzVorgaenger++;
			}
		} catch (EOFException e) {
		}

		// Vorbereiten:
		freieKnoten = new Knoten[n];
		AnzfreieKnoten = 0;
		for (int i = 1; i <= n; i++) {
			Knoten e = Liste[i];
			if (e.anzVorgaenger == 0)
				freieKnoten[AnzfreieKnoten++] = e;
		}
		// Sortieren:
		System.out.println("");
		sort: for (int i = 1; i <= n; i++) {
			if (AnzfreieKnoten == 0) {
				System.out.println("Die Eingabe enth�lt einen Kreis.");
				showAllCircles();
				break sort;
			}
			// Wähle einen Knoten ohne Vorgänger
			Knoten x = freieKnoten[--AnzfreieKnoten];
			System.out.println(x);
			// Entferne ausgehende Kanten:
			Kante z = x.ersterNachfolger;
			while (z != null) {
				z.v.anzVorgaenger--;
				if (z.v.anzVorgaenger == 0)
					freieKnoten[AnzfreieKnoten++] = z.v;
				z = z.next;
			}
		}
	}

	private void showAllCircles() {
		Knoten[] copy = Arrays.copyOf(this.Liste, this.Liste.length);
		for (Knoten k : copy) {
			
		}
	}
}

class Knoten {
	int Name, anzVorgaenger;
	Kante ersterNachfolger;

	Knoten(int i) {
		Name = i;
		anzVorgaenger = 0;
		ersterNachfolger = null;
	}

	public String toString() {
		return String.valueOf(Name);
	}
}

class Kante {
	Knoten u, v;
	Kante next;

	Kante(Knoten uu, Knoten vv) {
		u = uu;
		v = vv;
	}
}
