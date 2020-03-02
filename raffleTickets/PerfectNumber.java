//Neil Powers

package semesterOne;

import java.util.Scanner;

public class PerfectNumber {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int num = 0;
		int sum = 0;
		
		System.out.println("Please input a number. \n" + "Input zero to terminate the loop.");
		
		/*Loop to find num(s)
		*
		 * Using a do while to make sure it is done at least one once. 
		 * Refer back to line 9 and line 32 for reason
		 * Basically, num was set as 0 and 0 quits the loop so I had to make a workaround.
		*/
		do {
			num = s.nextInt();
			for (int i = 1; i <= num/2; i++) {
				if (num % i == 0)
					sum += i;
			}
			if (num == sum) {
				System.out.println(num + " is perfect");
			}
			else {
				System.out.println(num + " is not perfect");
			}
		}
		while (num != 0);
	}
}
