package ifsBasics;
//Neil Powers

public class WordsCompare {
	private String wordOne, wordTwo;
	private int compare;
	
	public WordsCompare()
	{
		setWords("abc", "def");
	}

	public WordsCompare(String one, String two)
	{
		setWords(one, two);
	}

	public void setWords(String one, String two)
	{
		wordOne = one;
		wordTwo = two;
	}

	public void compare()
	{
		@SuppressWarnings("unused")
		int compare = wordOne.compareToIgnoreCase(wordTwo);
	}
	public String toString()
	{
		if(compare<0)
		{
			return wordOne + " should be placed before " + wordTwo + "\n";
		}
		else if (compare>0)
		{
			return wordOne + " should be placed after " + wordTwo + "\n";
		}
		else
		{
			return "they are the same word";
		}
	}
}
