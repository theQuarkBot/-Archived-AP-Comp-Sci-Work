/**
 * @author Neil & Nicolette
 * Date: 2/12/18
 * Affiliation: EIHS
 */
package elevensProject;

import java.util.ArrayList;
import java.util.Collections;

public class Shuffler {

	private static final int SHUFFLE_COUNT = 1;

	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		int[] values1 = {4, 2, 3, 1};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive efficient selection shuffles:");
		int[] values2 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println(flip());
		System.out.println(arePermutations(values1, values2));
	}

	public static void perfectShuffle(int[] values) {
		// instantiating half1[] and half2[] so that you have the separate halves for later
		int[] half1 = new int[values.length / 2];
		int[] half2 = new int[values.length - values.length / 2];
		
		// sets half1[] & half2[]
		for (int i = 0; i < values.length / 2; i++)
			half1[i] = values[i];
		for (int i = 0; i < values.length - values.length / 2; i++)
			half2[i] = values[i + values.length / 2];
				
		for (int i = 0; i < values.length / 2; i++) {
			values[i * 2] = half1[i];
			values[i * 2 + 1] = half2[i];
		}
	}

	public static void selectionShuffle(int[] values) {
		// instantiates the array lists for later use
		ArrayList<Integer> notSel = new ArrayList<Integer>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		// setting the arrayLists
		for (int i:values)
			notSel.add(i);
		for (int i = 0; i < values.length; i++)
			temp.add((int) (Math.random() * temp.size()), notSel.get(i));
		
		for (int i = 0; i < values.length; i++)
			values[i] = temp.get(i);
	}
	
	public static String flip() {
		int num = (int) (Math.random()*3);
		
		if (num == 2) return "tails";
		return "heads";
	}
	
	public static Boolean arePermutations(int[] a1, int[] a2) {
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		for (int i: a1) l1.add(i);
		Collections.sort(l1);
		for (int i: a2) l2.add(i);
		Collections.sort(l2);
		
		for (int i: l1) if (l2.contains(i) == false) return false;
		return true;
	}
}
