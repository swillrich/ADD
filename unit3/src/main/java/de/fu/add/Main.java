package de.fu.add;

public class Main {
	public static void main(String[] args) {
		Baum baum = new Baum(10);
		baum.show();
		new MittlererWegLaengenFinder().finde(baum);
	}
}
