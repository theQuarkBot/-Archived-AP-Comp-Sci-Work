/**
 * @author Neil, Nicolette
 * Date: 2/7/18
 * 
 */

package elevensProject;

/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] suits = {"spades", "diamonds", "clubs", "hearts"};
		String[] ranks = {"ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"};
		int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};
		
		Deck deck = new Deck(ranks, suits, values);
		System.out.println(deck.toString());	
	}
}
