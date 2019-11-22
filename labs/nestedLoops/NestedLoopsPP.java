//Neil and Holden

package nestedLoops;

import java.util.Scanner;

public class NestedLoopsPP {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		int counter = input;
		String output = "";
		
		for (int i = 1; i <= input; i++) {
			for (int j = counter; j >= 1; j--) {
				output += "*";
			}
			for (int k = 1; k <= i; k++) {
				output += "#";
			}
			
			System.out.println(output);
			output = "";
			counter -= 1;
		}
		
		s.close();
	}

}
