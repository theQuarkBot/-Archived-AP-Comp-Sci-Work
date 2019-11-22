/**
 * 
 */
package matrices;

public class MatrixSummingRunner
{
	private static int tests = 0;
	
	private static void test(int one, int two) {
		tests++;
		if (one != two) System.out.println(tests + " " + one + " " + two);
	}
	
	public static void main( String args[] ) //throws IOException
	{
		MatrixSumming m = new MatrixSumming();
		test(m.sum(0, 0), 4);
		test(m.sum(0, 1), 6);
		test(m.sum(0, 2), 4);
		test(m.sum(1, 0), 6);
		test(m.sum(1, 1), 9);
		test(m.sum(1, 2), 6);
		test(m.sum(2, 0), 4);
		test(m.sum(2, 1), 6);
		test(m.sum(2, 2), 4);
	}
}
