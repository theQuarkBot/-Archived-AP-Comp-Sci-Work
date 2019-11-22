package matrices;

public class GridRunner {
	public static void main( String args[] ) {
		String[] vals = {"a", "7", "x", "b", "c", "2", "9"};
		int rows = 10, cols = 10;
		Grid g = new Grid(rows, cols, vals);
		
		System.out.println(g.toString());		
		System.out.println(g.findMax(vals) + "\n");
	}
}