package semesterOne;

import java.util.Scanner;

public class DecreasingWord {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner p = new Scanner(System.in);
		System.out.print("Please input a string: ");
		String s = p.next();
		System.out.println("Your string was: " + s);
		
		int l = s.length();
		for (int i = 0; i < l; i++) {
			System.out.println(s);
			if (s.length() > 1)
				s = s.substring(0, s.length()-1);
		}
	}
}
