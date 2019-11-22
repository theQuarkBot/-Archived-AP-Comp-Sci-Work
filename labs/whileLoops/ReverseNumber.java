package whileLoops;

import java.util.Scanner;

public class ReverseNumber
{
	public static void main(String args[])
	{
		System.out.println("Please input a number. \n"
				+ "Input 0 to terminate loop.");
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in); 
		long num = s.nextLong();
		long rnum = 0;
		long snum = num;
		
		while (num != 0)
		{
			rnum *= 10;
			rnum += num % 10;
			num /= 10;
		}
		System.out.println(snum + " reversed is " + rnum);		
	}
}