package magpie;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
 
public class MagpieProjectRunner
{

	/**
	 * Create a Magpie, give it user input, and print its replies.
	 */
	public static void main(String[] args)
	{
		MagpieProject maggie = new MagpieProject();
		
		System.out.println (maggie.getGreeting());
		@SuppressWarnings({ "resource", "unused" })
		Scanner in = new Scanner (System.in);
		String statement = JOptionPane.showInputDialog(maggie.getGreeting());
		
		
		//main code
		while (! (statement.toLowerCase()).equals("goodbye"))
		{			
			statement = JOptionPane.showInputDialog(maggie.getResponse(statement));
		}
	}

}
