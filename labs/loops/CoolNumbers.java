package loops;

public class CoolNumbers 
{
	/*
	 *method isCoolNumber will return true if
	 *	num % 3-6 all have a remainder of 1
	 *it will return false otherwize
	 */
	public static boolean isCoolNumber( int num )
	{
		for (int i = 3; i <= 6; i++) {
			if (num % i != 1)
				return false;
		}
		return true;
	}
	
		/*
	 *method countCoolNumbers will return the count
	 *of the coolNumbers between 6 and stop
	 */
	public static int countCoolNumbers( int stop )
	{
		int total = 0;
		for (int i = 6; i <= stop; i++) {
			if (isCoolNumber(i))
				total++;
		}
		return total;
	}
}