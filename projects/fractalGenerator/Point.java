package fractalGenerator;

public class Point {
	private int x, y;
	
	public Point() {
		x = 0;
		y = 0;
	}
	
	public Point(int _x, int _y) {
		x = _x;
		y = _y;
	}
	
	public int getx() {
		return x;
	}
	
	public int gety() {
		return y;
	}
	
	public void setX(int _x) {
		x = _x;
	}
	
	public void setY(int _y) {
		y = _y;
	}
}

