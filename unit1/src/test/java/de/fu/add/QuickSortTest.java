package de.fu.add;

import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {

	@Test
	public void test() {
		float[] unsorted = new float[] { 0.12f, 0.05f, 0.5f, 0.7f, 0.1f, 0.3f, 0.6f, 0.81f, 0.2f, 0.3f };
		float[] sorted = new float[] { 0.05f, 0.1f, 0.12f, 0.2f, 0.3f, 0.3f, 0.5f, 0.6f, 0.7f, 0.81f };
		new QuickSort(unsorted).go();
		for (int i = 0; i < sorted.length; i++) {
			float actual = unsorted[i];
			float expected = sorted[i];
			Assert.assertTrue(actual + " = " + expected, actual == expected);
		}
	}
}
