package loops;

import static java.lang.System.*;

public class CoolNumbersRunner
{
	public static void main( String[] args )
	{
		out.println( CoolNumbers.countCoolNumbers(250)
				+ " cool numbers between 6 - " + 250);
		out.println(CoolNumbers.countCoolNumbers(1250)
				+ " cool numbers between 6 - " + 1250);
		out.println(CoolNumbers.countCoolNumbers(2250)
				+ " cool numbers between 6 - " + 2250);
		out.println(CoolNumbers.countCoolNumbers(32500)
				+ " cool numbers between 6 - " + 32500);
	}
}