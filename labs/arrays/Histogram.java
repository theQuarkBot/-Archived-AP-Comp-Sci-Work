//Neil Powers

package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Histogram {

	public static void toHisto(String s) {
		int array[] = toArray(s);
		Arrays.sort(array);
		
		int i = 0;
        int curnum, count;
        while (i < array.length) {
            curnum = array[i];
            count = 0;
            for (; i < array.length && curnum == array[i]; i ++, count++){}

            System.out.println("Number of " + curnum + "'s: " + count);
        }
	}

	//Had to look up the .hasNextInt util and chopper
	private static int[] toArray(String s) {
		Scanner chopper = new Scanner(s);
		int array[] = new int[getLen(s)];
		int i = 0;
		while (chopper.hasNextInt()) {
			array[i] = chopper.nextInt();
			i++;
		}
		chopper.close();
		return array;
	}

	private static int getLen(String s) {
		Scanner chopper = new Scanner(s);
		int len = 0;
	    while (chopper.hasNextInt()) {
	        chopper.nextInt();
	        len++;
	    }
	    
	    chopper.close();
	    return len;
	}
}
