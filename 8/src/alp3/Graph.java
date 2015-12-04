package alp3;

import java.util.ArrayList;
import java.util.EnumSet;

public class Graph {
	ArrayList<Node> nodes = new ArrayList<Node>();

	public Graph() {
		Node a = genNode("a", EnumSet.of(E.K, E.M, E.W, E.Z), null, null);
		Node b = genNode("b", EnumSet.of(E.K, E.W), EnumSet.of(E.M, E.Z), null);
		Node c = genNode("c", EnumSet.of(E.K, E.W), EnumSet.of(E.M), EnumSet.of(E.Z));

		Node d = genNode("d", EnumSet.of(E.K), EnumSet.of(E.M, E.W), EnumSet.of(E.Z));
		Node e = genNode("e", EnumSet.of(E.K), EnumSet.of(E.M, E.Z), EnumSet.of(E.W));
		Node f = genNode("f", EnumSet.of(E.Z), EnumSet.of(E.M, E.K), EnumSet.of(E.W));

		Node g = genNode("g", EnumSet.of(E.W), EnumSet.of(E.M, E.K), EnumSet.of(E.Z));
		Node h = genNode("h", EnumSet.of(E.W), EnumSet.of(E.M, E.Z), EnumSet.of(E.K));
		Node i = genNode("i", EnumSet.of(E.Z), EnumSet.of(E.M, E.W), EnumSet.of(E.K));

		Node j = genNode("j", EnumSet.of(E.Z), EnumSet.of(E.M), EnumSet.of(E.W, E.K));
		Node k = genNode("k", null, EnumSet.of(E.M, E.Z), EnumSet.of(E.K, E.W));
		Node l = genNode("l", null, null, EnumSet.of(E.K, E.W, E.M, E.Z));

		setOuts(a, b);
		setOuts(b, c);
		setOuts(c, d, g);

		setOuts(d, e);
		setOuts(e, f);
		setOuts(f, j);

		setOuts(g, h);
		setOuts(h, i);
		setOuts(i, j);

		setOuts(j, k);
		setOuts(k, l);
		System.out.println("Graph built");
		
	}

	private void setOuts(Node node, Node... nodes) {
		node.outgoings(true, nodes);
	}

	private Node genNode(String name, EnumSet<E> u1, EnumSet<E> boot, EnumSet<E> u2) {
		if (u1 == null) {
			u1 = EnumSet.noneOf(E.class);
		}
		if (u2 == null) {
			u2 = EnumSet.noneOf(E.class);
		}
		if (boot == null) {
			boot = EnumSet.noneOf(E.class);
		}
		Node node = new Node(name, u1, u2, boot);
		this.nodes.add(node);
		return node;
	}

	public ArrayList<Node> getNodes() {
		return nodes;
	}
}
