//Neil Powers & 'G' Piddington
//1/10/2018

package arrays;

public class ArraysLabPP {
	//instance variables and constructors could be used, but are not really needed
	
	//getSum() will return the sum of the numbers from start to stop, not including stop
	public static int getSum(int[] numArray, int start, int stop)
	{
		int num = 0;
		for (int i = start; i <= stop; i++) {
			num += numArray[i];
		}
		return num;
	}
	
	//getCount() will return number of times val is present
	public static int getCount(int[] numArray, int val)
	{
		int count = 0;
		for (int i = 0; i < numArray.length; i++) {
			if (numArray[i] == 4)
				count ++;
		}
		return count;
	}
	
	public static int[] removeVal(int[] numArray, int val)
	{
		int len = numArray.length;
		for (int i = 0; i < numArray.length; i++) {
			if (numArray[i] == val)
				len--;
		}
		
		int[] newNumArray = new int[len];
		int j = 0;
		for (int i = 0; i < numArray.length; i++) {
			if (numArray[i] != val) {
				newNumArray[j] = numArray[i];
				j++;
			}
		}
		return newNumArray;
	}
}
