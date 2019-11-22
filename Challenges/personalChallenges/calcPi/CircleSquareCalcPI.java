	// NAME: Neil Powers
// DATE: 2/2/18
// ASSOCIATION: N/A

package calcPi;

import javax.swing.JOptionPane;

public class CircleSquareCalcPI {

	public static void main(String[] args) {
		long lim = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of iterations in calculation:"
				+ "\nPlease take note that entering a number exceeding 10,000,000 will take a little while."));
		double total = 0, circle = 0;

		
		for (long i = 0; i < lim; i++) {
			if (Math.pow(Math.random(), 2) + Math.pow(Math.random(), 2) <= 1)
				circle++;
			total++;
		}
		
		System.out.println("Approximation of pi: " + circle / total * 4);
		System.out.println("Actual value of pi:  " + Math.PI);
		System.out.println("Margin of error: " + Math.abs(Math.PI - circle / total * 4));
	}

}
