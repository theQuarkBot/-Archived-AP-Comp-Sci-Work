package ifsBasics;
//Neil Powers

import java.util.Scanner;

public class ifsLabThree{
	public static void main(String args[])
	{
		String number = "";
		int n1, n2, n3, answer;
		
		
		System.out.println("Please input your number in the form of '#-#-#'");
		Scanner in = new Scanner (System.in);
		
		number = in.next();
		n1 = Integer.parseInt(number.substring(0,number.indexOf("-")));
		n2 = Integer.parseInt(number.substring(number.indexOf("-") + 1, number.lastIndexOf("-")));
		n3 = Integer.parseInt(number.substring(number.lastIndexOf("-") + 1));
		
		answer = n1 + n2 + n3;
		System.out.println("It adds up to: " + answer);
		
		in.close();
	}
}