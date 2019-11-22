package ifsBasics;
import java.util.Scanner;

public class ifsLab1 {
	public static void getNumber(double evenOdd) {
		if(0 == evenOdd%2) {
			System.out.println("Your number is even");
		}
		else
		{
			System.out.println("Your number is odd");
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter number: ");
		double input = s.nextDouble();
		getNumber(input);
		
		s.close();
	}
}
