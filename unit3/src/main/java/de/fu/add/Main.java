package de.fu.add;

public class Main {
	public static void main(String[] args) {
		Baum baum = new Baum(2);
		baum.show();
		new MittlererWegLaengenFinder().finde(baum);
	}
}
