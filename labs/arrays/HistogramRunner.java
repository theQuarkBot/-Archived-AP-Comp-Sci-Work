//Neil Powers

package arrays;

import java.util.Scanner;

public class HistogramRunner {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please input your data seat to find the count of each number:");
		Histogram.toHisto(s.nextLine());
		s.close();
	}
}
