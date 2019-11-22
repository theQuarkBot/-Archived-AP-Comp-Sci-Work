/**
 * @author Neil Powers
 * Affiliation: N/A
 * Date: 2/6/18
 */

package pageOne;

public class LargestPrimeFactor {
	public static void main(String[] args) {
		//double var = 600851475143;
		long var = 2;
		for (long i = 2; i < var; i++) {
		    if (var % i == 0) { // It is a divisor
		        boolean isPrime = true;
		        for (long j = 2; j < i; j++) {
		            if (i % j == 0) {
		                isPrime = false;
		                break;
		            }
		        }
		        if (isPrime) {
		        }
		    }
		}
	}

}
