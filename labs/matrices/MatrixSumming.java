package matrices;

public class MatrixSumming {
	private int[][] m = {{1,1,1},
						 {1,1,1},
						 {1,1,1}};

	public int sum( int r, int c ) {
		int sum = 0;
		for (int i = 0; i < m.length; i++)
			for (int j = 0; j < m[i].length; j++)
				if (Math.abs(r - i) <= 1 && Math.abs(c -j) <= 1)
					sum += m[i][j];
		return sum;
	}
}
