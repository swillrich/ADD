package de.fu.add;

public class Main {
	public static void main(String[] args) {
		Baum baum = new Baum();
		baum.createFullBinaryTree(5);
		baum.show();
		new MittlererWegLaengenFinder().berechne(baum);
	}
}
