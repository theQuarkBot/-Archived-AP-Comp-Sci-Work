//Neil Powers & 'G' Piddington
//1/10/2018

package arrays;

import java.util.Arrays;

public class ArraysLabPPRunner
{
	public static void main( String args[] )
	{
		int[] one = {7,4,10,0,1,7,6,5,3,2,9,7};

		System.out.println(Arrays.toString(one));
		System.out.println("sum of spots 3-6  =  " + ArraysLabPP.getSum(one,3,6));
		System.out.println("sum of spots 2-9  =  " + ArraysLabPP.getSum(one,2,9));
		System.out.println("# of 4s  =  " + ArraysLabPP.getCount(one,4));
		System.out.println("# of 9s  =  " + ArraysLabPP.getCount(one,9));
		System.out.println("Removal of 7's = " + Arrays.toString(ArraysLabPP.removeVal(one, 7)));
	}
}
