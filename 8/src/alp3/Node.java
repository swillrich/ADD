package alp3;

import java.util.EnumSet;
import java.util.LinkedList;

public class Node implements Comparable<Node> {

	private LinkedList<Node> outgoing = new LinkedList<Node>();

	private EnumSet<E> ufer1;
	private EnumSet<E> ufer2;
	private EnumSet<E> boot;
	private Node predecessor;
	private String name;

	public Node(String name, EnumSet<E> ufer1, EnumSet<E> ufer2, EnumSet<E> boot) {
		this.ufer1 = ufer1;
		this.ufer2 = ufer2;
		this.boot = boot;
		this.name = name;
	}

	public Node getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Node predecessor) {
		this.predecessor = predecessor;
	}

	public void outgoings(boolean withBackEdge, Node... nodes) {
		for (Node node : nodes) {
			outgoing.add(node);
			if (withBackEdge) {
				node.outgoings(false, this);
			}
		}
	}

	public EnumSet<E> getBoot() {
		return boot;
	}

	public LinkedList<Node> getOutgoing() {
		return outgoing;
	}

	public EnumSet<E> getUfer1() {
		return ufer1;
	}

	public EnumSet<E> getUfer2() {
		return ufer2;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Node " + name + ": Ufer1 " + ufer1.toString() + ", Boot " + boot.toString() + ", Ufer2 "
				+ ufer2.toString();
	}

	@Override
	public int compareTo(Node o) {
		return o.getName().compareTo(this.getName());
	}
}
