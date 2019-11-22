package matrices;

public class FancyWordTwo {
	private char[][] mat;

	private void FancyWord(String s) {
		mat = new char[s.length()][s.length()];
		
		for (int i = 0; i < s.length(); i++)
			for (int j = 0; j < s.length(); j++)
				mat[i][j] = ' ';
		
		for (int i = 0; i < s.length(); i++) {
			int pos = s.length() - i - 1;
			
			mat[0][i] = s.charAt(i);
			mat[i][0] = s.charAt(i);
			mat[s.length()-1][pos] = s.charAt(i);
			mat[pos][s.length()-1] = s.charAt(i);
			
		}
	}

	public String toString(String s) {
		FancyWord(s);
		String output = "";
		for (char[] r: mat) {
			for (char c: r) {
				output += c + " ";
			}
			output += "\n";
		}
		return output;
	}
}