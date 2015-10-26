package de.fu.add;

import java.io.EOFException;
import java.io.IOException;
import java.util.Stack;

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

	Stack<Knoten> stack = new Stack<Knoten>();
	int globalTime = 0;

	private void showAllCircles() {
		System.out.println("\nThe graph contains the circles listed below");
		for (Knoten n : Liste) {
			if (n != null) {
				search(n.ersterNachfolger);
			}
		}
	}

	private void search(Kante k) {
		if (k == null) {
			return;
		}
		Knoten n = k.u;
		n.visited = true;
		globalTime++;
		stack.push(n);
		n.isInStack = true;
		for (Kante e = n.ersterNachfolger; e != null; e = e.next) {
			Knoten v = e.v;
			if (v.isInStack) {
				System.out.println("Circle detected:");
				Knoten first = stack.pop();
				Knoten next = null;
				first.isInStack = false;
				String output = "" + first;
				while (!stack.isEmpty()) {
					next = stack.pop();
					next.isInStack = false;
					output = next + " -> " + output;
					if (next == v) {
						break;
					}
				}
				output = output + " and back to " + next;
				System.out.println(output + "\n");
			} else {
				search(v.ersterNachfolger);
			}
		}
	}
}

class Knoten {
	boolean visited = false;
	int Name, anzVorgaenger;
	Kante ersterNachfolger;
	boolean isInStack;

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
