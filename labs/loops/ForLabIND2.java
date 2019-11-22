package loops;

import java.util.Scanner;

public class ForLabIND2 {
	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Please input your start number: ");
		int start = s.nextInt();
		System.out.print("Please input your stop number: ");
		int stop = s.nextInt();
		
		long sum = 0;
		int even = 0;
		int odd = 0;
		int divSix = 0;
		
		for (int i = start; i <= stop; i++)
		{
			sum += i;
			if (i % 2 == 0)
			{
				even++;
				if (i % 6 == 0)
					divSix++;
			}
			if (i % 2 != 0)
				odd++;
			
		}
		
		System.out.println("Total of all numbers: " + sum);
		System.out.println("Total number of even numbers: " + even);
		System.out.println("Total number of odd numbers: " + odd);
		System.out.println("Total number of numbers divisible by 6: " + divSix);
		
		s.close();
	}
}
