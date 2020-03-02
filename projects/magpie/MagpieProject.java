package magpie;

/**
 * A program to carry on conversations with a human user.
 * This version:
 *<ul><li>
 * 		Uses advanced search for keywords 
 *</li><li>
 * 		Will transform statements as well as react to keywords
 *</li></ul>
 * @author Laurie White
 * @version April 2012
 *
 */
 
public class MagpieProject
{
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */	
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";		
		//no input
		if (statement.length() == 0)
		{
			response = "Say something, please.";
		}
		else if (findKeyword(statement, "time", 0) >= 0)
		{
			response = java.time.LocalTime.now().toString();
			return response;
		}
		//greeting statements
		else if ((findKeyword(statement, "hello") >=0)
				|| (findKeyword(statement, "hi") >= 0))
		{
			response = getRandomGreeting(statement);
		}	
		else if ((findKeyword(statement, "are you a robot", 0) >= 0)
				|| (findKeyword(statement, "robot", 0) >= 0)
				|| (findKeyword(statement, "ai", 0) >= 0)
				|| (findKeyword(statement, "artificial intelligence", 0) >= 0))
		{
			response = "I am a robot.";
			return response;
		}
		else if (findKeyword(statement, "lol", 0) >= 0)
		{
			response = "Yep, pretty funny.";
		}
		
		//contains "no"
		else if (findKeyword(statement, "why", 0) >= 0)
		{
			response = getWhy(statement);
		}
		else if (findKeyword(statement, "no") >= 0)
		{
			response = whySoNegative();
		}
		else if (findKeyword(statement, "city", 0) >= 0)
		{
			response = getRandomCity();
		}
		else if ((findKeyword(statement, "dog", 0) >= 0)
				|| (findKeyword(statement, "cat", 0) >= 0)
				|| (findKeyword(statement, "bird", 0) >= 0)
				|| (findKeyword(statement, "pet", 0) >= 0)
				|| (findKeyword(statement, "pets", 0) >= 0))
		{
			response = "Tell me more about your pets.";
		}
		
		
		//family
		else if (findKeyword(statement, "mother") >= 0
			|| findKeyword(statement, "father") >= 0
			|| findKeyword(statement, "sister") >= 0
			|| findKeyword(statement, "brother") >= 0
			|| findKeyword(statement, "family") >= 0)
		{
			response = "Tell me more about your family.";
		}
		else if((findKeyword(statement, "weather", 0) >= 0))
		{
			if (findKeyword(statement, "?", 0) >= 0)
			{
				response = "The weather is cloudy with a slight to major chance of meatballs.";
			}
			else
			{
				response = "The weather is, in my opinion, quite nice today.";
			}
		}
		else if (findKeyword(statement, "school", 0) >= 0)
		{
			response = getRandomSchool(statement);
		}
		// Responses which require transformations
		
		else if (findKeyword(statement, "i", 0) >= 0)
		{
			if (findKeyword(statement, "like", 0) >= 0)
			{
				if (findKeyword(statement, "i like", 0) >= 0)
				{
					response = "Tell me more about why you like" 
				+ iLikeRestOfStatement(statement);
				}
				else if (findKeyword(statement, "i don't like", 0) >= 0)
				{
					response = "Tell me more about why you don't like"
				+ iLikeRestOfStatement(statement);
				}
				else return getRandomResponse();
			}
			else if (findKeyword(statement, "i hate", 0) >= 0)
			{
				response = iHateRestOfStatement(statement);
			}
			else if (findKeyword(statement, "I want", 0) >= 0)
			{
				response = transformIWantToStatement(statement);
			}
		}
		else
		{
			// Look for a two word (you <something> me)
			// pattern
			int psn = findKeyword(statement, "you", 0);

			if (psn >= 0
					&& findKeyword(statement, "me", psn) >= 0)
			{
				response = transformYouMeStatement(statement);
			}
			else
			{
				response = getRandomResponse();
			}
		}		
		return response;
	}
	
	//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	private String iHateRestOfStatement(String statement) 
	{
		statement = statement.trim().toLowerCase();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar == ".")
		{
			statement = statement.substring(0, statement.length() - 1);
		}
				
		if (findKeyword(statement, "i hate", 0) >=0)
		{
			int psnOfIHate = findKeyword (statement, "i hate", 0);
			String restOfStatement = statement.substring(psnOfIHate + 6);
			return "Tell me more about why you hate" + restOfStatement;
		}
		else return getRandomResponse();
	}
	
	private String iLikeRestOfStatement(String statement) 
	{
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar == ".")
		{
			statement = statement.substring(0, statement.length() - 1);
		}
		
		int psnOfILike = findKeyword (statement, "i like", 0);

		if (findKeyword(statement, "you", 0) == statement.length() - 3)
		{	
			int psnOfYou = findKeyword (statement, "you", 0);
			String restOfStatement = statement.substring(psnOfILike + 6, psnOfYou) + "me";
			return restOfStatement + ".";
		}
		else
		{
			String restOfStatement = statement.substring(psnOfILike + 6);
			return restOfStatement + ".";
		}
	}
	
	//I want statement
	private String transformIWantToStatement(String statement)
	{
		//Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		
		//The actual part
		if (statement.indexOf("i want to") >= 0)
		{
			int psn = findKeyword (statement, "i want to", 0);
			String restOfStatement = statement.substring(psn + 9).trim();
			return "What would it mean to " + restOfStatement + "?";
		}
		else if (statement.indexOf("i want you to") >= 0)
		{
			int psn = findKeyword (statement, "i want you to", 0);

			if (findKeyword(statement, "me", 0) >= statement.length() - 2)
			{
				String restOfStatement = statement.substring(psn + 13, findKeyword(statement, "me", 0));
				return "Why do you want me to" + restOfStatement + "you?";
			}
			else
			{
				String restOfStatement = statement.substring(psn + 13).trim();
				return "Why do you want me to " + restOfStatement + "?";
			}
		}
		else if (statement.indexOf("i want") >= 0 && statement.indexOf("you")
				>= statement.length()-4)
		{
			int psn = findKeyword (statement, "i want", 0);
			String restOfStatement = statement.substring((psn + 6), statement.length()-3);
			return "Why do you want to" + restOfStatement + " me?";
		}
		else if (statement.indexOf("i want") >= 0)
		{
			int psn = findKeyword (statement, "I want", 0);
			String restOfStatement = statement.substring(psn + 6).trim();
			return "Would you be really be happy if you had " + restOfStatement + "?";
		}
		else return "Sorry, I do not know what you mean.";
	}

	
	/* Take a statement with "you <something> me" and transform it into 
	 * what makes you think that I <something> you?
	 *  */
	private String transformYouMeStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement.length() - 1);
		}
		
		int psnOfYou = findKeyword (statement, "you", 0);
		int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);
		
		String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
		return "What makes you think that I " + restOfStatement + " you?";
	}
	
	private String getWhy(String statement) 
	{
		String response = "";
		if (findKeyword(statement, "why do", 0) >= 0)
		{
			String restOfStatement = statement.substring(statement.indexOf("why do ") + 6);
			response = "I do not know why " + restOfStatement;
			return response;
		}
		return "I do not know. \n"
				+ "I recommend looking it up if you are still unsure.";
	}
	

	
	
	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @param startPos the character of the string to begin the search at
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal, int startPos)
	{
		String phrase = statement.trim();
		//  The only change to incorporate the startPos is in the line below
		int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
		
		//  Refinement--make sure the goal isn't part of a word 
		while (psn >= 0) 
		{
			//  Find the string of length 1 before and after the word
			String before = " ", after = " "; 
			if (psn > 0)
			{
				before = phrase.substring (psn - 1, psn).toLowerCase();
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
			}
			
			//  If before and after aren't letters, we've found the word
			if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
					&& ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
			{
				return psn;
			}
			
			//  The last position didn't work, so let's find the next, if there is one.
			psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
			
		}
		
		return -1;
	}
	
	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	

	//random responses
	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}

		return response;
	}	
	private String getRandomGreeting(String statement) 
	{
		final int NUMBER_OF_GREETINGS = 5;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_GREETINGS);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "How are you?";
		}
		if (whichResponse == 1)
		{
			response = "Nice to meet you.";
		}
		if (whichResponse == 2)
		{
			response = "What is your name?";
		}
		if (whichResponse == 3)
		{
			response = "How old are you?";
		}
		if (whichResponse == 4)
		{
			response = "hmm";
		}
		
		return response;
	}	
	private String getRandomSchool(String statement) {
		final int NUM_OF_SCHOOLS = 5;
		double r = Math.random();
		int whichResponse = (int)(r * NUM_OF_SCHOOLS);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "Why do you like school.";
		}
		if (whichResponse == 1)
		{
			response = "Remember to stay in school.";
		}
		if (whichResponse == 2)
		{
			response = "That's nice.";
		}
		if (whichResponse == 3)
		{
			response = "You making any friends at school?";
		}
		if (whichResponse == 4)
		{
			response = "Do you plan on going to college (if you have not gone already)?";
		}
		
		return response;
	}
	private String whySoNegative() {
		final int NEG_NUM = 5;
		double r = Math.random();
		int whichResponse = (int)(r * NEG_NUM);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "Why so negative?";
		}
		if (whichResponse == 1)
		{
			response = "You have to say no?";
		}
		if (whichResponse == 2)
		{
			response = "C'mon mate.";
		}
		
		return response;
	}
	private String getRandomCity()
	{
		final int RAND_CITY = 5;
		double r = Math.random();
		int whichResponse = (int)(r * RAND_CITY);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "This is computerville.";
		}
		if (whichResponse == 1)
		{
			response = "This is not the moon, in case you are wondering.";
		}
		if (whichResponse == 2)
		{
			response = "We are in a branch of your imagination.";
		}
		
		return response;
	}

}
