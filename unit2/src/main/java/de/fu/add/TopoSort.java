package de.fu.add;

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

	private void showAllCircles() {
		System.out.println("\nThe graph contains the circles listed below");
		for (Knoten n : Liste) {
			if (n != null && n.index == -1) {
				search(n.ersterNachfolger);
			}
		}
	}

	Stack<Knoten> stack = new Stack<Knoten>();
	int index = 0;

	private void search(Kante k) {
		if (k == null) {
			return;
		}
		Knoten v = k.u;
		v.index = index;
		v.lowlink = index;
		index++;
		stack.push(v);
		v.onStack = true;
		for (Kante e = v.ersterNachfolger; e != null; e = e.next) {
			Knoten w = e.v;
			if (w.onStack) {
				v.lowlink = w.index < v.lowlink ? w.index : v.lowlink;
			} else if (w.index == -1) {
				search(w.ersterNachfolger);
				v.lowlink = w.lowlink < v.lowlink ? w.lowlink : v.lowlink;
			}
		}
		if (v.lowlink == v.index) {
			List<Knoten> circle = new ArrayList<Knoten>();
			Knoten w = null;
			do {
				w = stack.pop();
				w.onStack = false;
				circle.add(w);
			} while (w != v);
			if (circle.size() > 1) {
				System.out.println("new circle detected:");
				for (int i = circle.size() - 1; i >= 0; i--) {
					System.out.print(circle.get(i) + (i > 0 ? " -> " : ""));
				}
				System.out.print(" and back to "
						+ circle.get(circle.size() - 1));
				System.out.println();
			}
		}
	}
}

class Knoten {
	int lowlink;
	int index = -1;
	int Name, anzVorgaenger;
	Kante ersterNachfolger;
	boolean onStack;

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
