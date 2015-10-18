package de.fu.add;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		int numberOfRuns = 10; // (int) (Math.pow(10, 6) * 20);
		float[] input = new float[numberOfRuns];
		Random random = new Random();
		for (int i = 0; i < numberOfRuns; i++) {
			input[i] = random.nextFloat();
		}
		show(input, numberOfRuns - 1, "Input");
		float[] output = new QuickSort(input).go();
		show(output, numberOfRuns - 1, "Output");
	}

	private static void show(float[] toShow, int until, String desc) {
		System.out.println(desc);
		List<Float> temp = new ArrayList<Float>();
		for (int i = 0; i < until + 1; i++) {
			temp.add(toShow[i]);
		}
		System.out.println(temp);
	}
}
