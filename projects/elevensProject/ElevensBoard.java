/**
 * @author Neil & Nicolette
 */
package elevensProject;

import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
@SuppressWarnings("unused")
public class ElevensBoard extends Board {
	
	private static final int BOARD_SIZE = 9;
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	private static final boolean I_AM_DEBUGGING = false;

	 public ElevensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		if (selectedCards.size() == 2)
			return containsPairSum11(selectedCards);
		else if (selectedCards.size() == 3)
			return containsJQK(selectedCards);
		return false;
	}

	@Override
	public boolean anotherPlayIsPossible() {
		List<Integer> i = cardIndexes();
		// Did it this wau so that it checks both of them with one if statement.
		if (!containsPairSum11(i))
			return containsJQK(i);
		return true;
		
	}

	private boolean containsPairSum11(List<Integer> selectedCards) {
		// Did a for loop here so that you can have anotherPlayIsPossibble() a bit shorter (i.e. it can check all nine pairs at the same time)
		for (int i = 0; i < selectedCards.size() - 1; i++)
			for (int j = i + 1; j < selectedCards.size(); j++)
				if (cardAt(selectedCards.get(i)).pointValue() + cardAt(selectedCards.get(j)).pointValue() == 11)
					return true;
		return false;
	}

	private boolean containsJQK(List<Integer> selectedCards) {
		// Did a for loop here for same reason as stated in line 49
		boolean j = false, q = false, k = false;
		for (int i = 0; i < selectedCards.size(); i++) {
			if (cardAt(selectedCards.get(i)).rank() == "jack") j = true;
			else if (cardAt(selectedCards.get(i)).rank() == "queen") q = true;
			else if (cardAt(selectedCards.get(i)).rank() == "king") k = true;
		}
		return (j && q && k);
	}
}
