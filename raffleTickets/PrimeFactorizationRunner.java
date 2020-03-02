package semesterOne;

import java.util.Scanner;

public class PrimeFactorizationRunner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		System.out.print(PrimeFactorization.finder(num, ""));
		scanner.close();
	}

}