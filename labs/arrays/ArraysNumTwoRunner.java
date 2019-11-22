//Neil Powers

package arrays;

import java.util.Arrays;

public class ArraysNumTwoRunner{

	public static void main(String[] args) {
		int[] increase = {1,4,5,7,8,19,20,65};
		int[] fincrease = {1,4,9,16,14,19,9,91};
		int[] decrease = {65,20,19,8,7,5,4,1};
		System.out.println("goingUp for " + Arrays.toString(increase)
				+ ": " + ArraysNumberTwo.goingUp(increase));
		System.out.println("goingDown for " + Arrays.toString(decrease)
				+ ": " + ArraysNumberTwo.goingDown(decrease));
		System.out.println("removeVal); for " + Arrays.toString(fincrease) + ": "
				+ Arrays.toString(ArraysNumberTwo.getCountValuesBiggerThanX(fincrease, 5, 9)));
	}

}
