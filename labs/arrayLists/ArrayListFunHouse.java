// Neil Powers & Holden Soderstrom
// 1/24/18 for - AP COMP SCI

package arrayLists;

import java.util.List;
import java.util.ArrayList;

public class ArrayListFunHouse
{
	public static ArrayList<Integer> getListOfFactors(int number)
	{
		ArrayList<Integer> factors = new ArrayList<Integer>();
		
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				factors.add(i);
			}
		}
		return factors;
	}
	
	public static void keepOnlyCompositeNumbers( List<Integer> nums )
	{
		System.out.println("\nOriginal List: \n" + nums);
		for (int i = 0; i < nums.size(); i++) {
			if (getListOfFactors(nums.get(i)).size() == 0) {
				nums.remove(i);
				i--;
			}
		}
		System.out.println("Composite Only List:");
		//The composite only list is printed because of the remove thing
	}
}