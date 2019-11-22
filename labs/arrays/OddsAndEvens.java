//Neil Powers

package arrays;

public class OddsAndEvens {
	public static int[] getAllEvens(int[] array)
	{
		int len = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) len++;
		}
		
		int[] result = new int[len];
		int j = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				result[j] = array[i];
				j++;
			}
		}
		
		return result;
	}

	public static int[] getAllOdds(int[] array)
	{
		int len = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 != 0) len++;
		}
		
		int[] result = new int[len];
		int j = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 != 0) {
				result[j] = array[i];
				j++;
			}
		}
		
		return result;
	}
}
