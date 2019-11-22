package ifsBasics;
import java.util.Scanner;

public class IfsBasics {
	public static double getPrice(double subTotal) {
		if(subTotal > 2000) return subTotal-subTotal*0.15;
		return subTotal;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter bill amount: ");
		double input = s.nextDouble();
		System.out.printf("bill after discount: %.2f", getPrice(input));
		
		s.close();
	}
}
