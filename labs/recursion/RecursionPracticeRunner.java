package recursion;

import java.util.Scanner;

public class RecursionPracticeRunner {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter 1 for: countOddDigets \nEnter 2 for: chickenCounter \nEnter 3 for: luckySevens");
		
		int select = s.nextInt();
		
		if (select == 1) {
			System.out.print("Enter a number to see how many odd digits it has: ");
			int num = s.nextInt();
			System.out.print(RecursionPractice.countOddDigets(num));
		}
		else if (select == 2) {
			System.out.print("Enter a string which you want to count the number of: ");
			String find = s.next();
			System.out.print("Enter a string to find the number of " + find +"'s in it: ");
			String word = s.next();
			System.out.print(RecursionPractice.chickenCounter(word, find));
		}
		else if (select == 3) {
			System.out.print("Enter a number which you wish to find: ");
			int find = s.nextInt();
			System.out.print("Enter a number to find the lucky " + find + "'s: ");
			String num = s.next();
			System.out.print(RecursionPractice.luckySevens(num, find));
		}
		else if (select == 4) {
			System.out.print("Enter a number which you wish to find: ");
			int find = s.nextInt();
			System.out.print("Enter a number to find the number of lucky " + find + "'s: ");
			String input = s.next();
			System.out.print(RecursionPractice.numCount(input, find));
		}
		else {
			System.out.print("Put a legitimate number in!\nTry again: ");
		}
		
		s.close();
	}

}

