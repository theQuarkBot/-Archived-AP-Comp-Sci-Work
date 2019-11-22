package ifsBasics;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;

public class WordsCompareRunner
{
   @SuppressWarnings("unused")
public static void main( String args[] )
   {
		//add test cases
	   WordsCompare output = new WordsCompare();
	   Scanner s = new Scanner (System.in);
	   String one = s.next();
	   String two = s.next();
	   System.out.print(output.toString());
	   
	  s.close();
	}
}