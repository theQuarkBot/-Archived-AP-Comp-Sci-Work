//Neil Powers

package recursion;

public class RecursionPractice {
	public static int countOddDigets(int num) {
		if (num > 0) {
			if (num%2 == 1)
				return countOddDigets(num/10) + 1;
			return countOddDigets(num/10);
		}
		return 0;
	}
	
	public static int chickenCounter(String word, String find) {
		if (word.indexOf(find) > -1)
			return chickenCounter(word.substring(word.indexOf(find)+1), find) + 1;
		return 0;
	}
	
	/* I made the lucky seven assignment also accept numbers such as 4, 6, 93, etc.
	 * Example - Counting: 5; Input: 5315535; Output: 12
	 */
	public static int luckySevens(String input, int find) {
		String strFind = Integer.toString(find);
		
		if (input.indexOf(strFind) > -1) {
			if (input.indexOf(strFind + strFind) == input.indexOf(strFind))
				return luckySevens(input.substring(input.indexOf(strFind + strFind) + 2), find) + find*2;
			return luckySevens(input.substring(input.indexOf(strFind) + 1), find) + 1;
		}
		return 0;
	}
	
	public static int numCount(String input, int find) {
		String num = Integer.toString(find);
		if (input.indexOf(find) > -1) {
			input = input.substring(input.indexOf(find));
			if (numRep(input, num) > 1) {
				return numRep(input, num)*find + numCount(input.substring(input.indexOf(find), input.indexOf(find)+numRep(input, num)), find);
			}
			return 1 + numCount(input.substring(1), find);
		}
		return 0;
	}
	

	private static int numRep(String input, String find) {
		int counter = 0;
		while (input.indexOf(find) == 0) {
			counter++;
			input = input.substring(1);
		}
		return counter;
	}
}
