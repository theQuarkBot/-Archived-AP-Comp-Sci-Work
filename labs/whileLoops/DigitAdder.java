package whileLoops;

public class DigitAdder
{
	public static int sumDigits( int number )
	{
	   int sum = 0;
	   int digit = 0;
	   
	   while (number > 0)
	   {
		   digit = number % 10;
		   sum += digit;
		   number = number / 10;
	   }
	   
	   return sum;
	}
}