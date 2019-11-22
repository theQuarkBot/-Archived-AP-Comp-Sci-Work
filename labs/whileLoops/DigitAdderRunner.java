package whileLoops;

import java.util.Scanner;

public class DigitAdderRunner
{
	public static void main( String args[] )
	{
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in); 
		int input = s.nextInt();
		int run = 0;
		while(run <= 10)
		{
			System.out.println(DigitAdder.sumDigits(input)
					+ " is the sum of the digits of " + input);
			
			input = s.nextInt();
			run++;
		}
	}
}