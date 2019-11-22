package matrices;

public class Grid {
	private String[][] grid;

	public Grid(int rows, int cols, String[] vals) {
		grid = new String[rows][cols];
		for (int r = 0; r < grid.length; r++)
			for (int c = 0; c < grid[r].length; c++)
				grid[r][c] = vals[(int) (Math.random() * vals.length)];
	}

	public String findMax(String[] vals) {
		int max = 0;
		for (int i = 0; i < vals.length; i++) {
			if (countVals(vals[i]) > countVals(vals[max]))
				max = i;
		}
		return vals[max] + " occurs the most";
	}

	private int countVals(String val) {
		int count = 0;
		for (String[] r: grid)
			for (String c: r)
				if (c == val)
					count++;
		return count;
	}

	public String toString() {
		String output = "";
		for (String[] r: grid) {
			for (String c: r)
				output += c + " ";
			output += "\n";
		}
		return output;
	}
}