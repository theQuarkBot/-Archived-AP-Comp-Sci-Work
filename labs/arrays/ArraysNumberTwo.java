//Neil Powers

package arrays;

public class ArraysNumberTwo {
	public static boolean goingUp(int[] numArray)
	{
		for (int i = 1; i < numArray.length; i++) {
			if (numArray[i] <= numArray[i-1])
				return false;
		}
		return true;
	}

	public static boolean goingDown(int[] numArray)
	{
		for (int i = 1; i < numArray.length; i++) {
			if (numArray[i] >= numArray[i-1])
				return false;
		}
		return true;
	}
	
	public static int[] getCountValuesBiggerThanX(int[] numArray, int count, int x)
	{
		//sets length of new array to get rid of blank values
		int len = 0;
		for (int i = 0; i < numArray.length; i++) {
			if (numArray[i] > x) len++;
		}
		//makes new array of values greater than x
		int[] newNumArray = new int[len];
		int j = 0;
		for (int i = 0; i < numArray.length; i++) {
			if (numArray[i] > x) {
				newNumArray[j] = numArray[i];
				j++;
			}
		}
		//limits length of that array to count
		if (newNumArray.length <= count)
			return newNumArray;
		else {
			int[] result = new int[count];
			for (int i = 0; i < count; i++) {
				result[i] = newNumArray[i];
			}
		}
		
		return newNumArray;
	}
}
