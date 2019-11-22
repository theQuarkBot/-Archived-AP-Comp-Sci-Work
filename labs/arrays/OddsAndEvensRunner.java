//Neil Powers

package arrays;

import java.util.Arrays;

public class OddsAndEvensRunner {

	public static void main(String[] args) {		
		int[] eg1 = {1,2,3,4,13,54,85,102,242};
		int[] eg2 = {2,10,20,21,23,24,40,55,60,61};
		
		System.out.println("All evens of " + Arrays.toString(eg1) + ": " + Arrays.toString(OddsAndEvens.getAllEvens(eg1)));
		System.out.println("All odds of " + Arrays.toString(eg2) + ": " + Arrays.toString(OddsAndEvens.getAllOdds(eg2)));
	}

}
