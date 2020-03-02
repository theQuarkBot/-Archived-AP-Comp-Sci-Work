//Neil Powers

package semesterOne;

public class PrimeFactorization {
	public static String finder(int num, String str) {
		for (int counter = 2; counter <= num/2; counter++) {
			if (num % counter == 0) {
				str += counter;
				num /= counter;
				return str + " " + finder(num, "");
			}
		}
		return "" + num;
	}
}
