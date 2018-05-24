package fractalGenerator;

public class Line {
	private Point p1, p2;
	
	public Line() {
		p1 = new Point(0,0);
		p2 = new Point(1,1);
	}
	public Line(Point a, Point b) {
		p1 = a;
		p2 = b;
	}
	public Point getMid() {
		int xMid = (p1.getx() + p2.getx())/2;
		int yMid = (p1.gety() + p2.gety())/2;
		
		return new Point(xMid, yMid);
	}
	public Point getNewPoint(int factor) {		
		int xAdd = ((p1.getx() + p2.getx()) + (p1.getx()-p2.getx())/factor)/2;
		int yAdd = ((p1.gety() + p2.gety()) + (p1.gety()-p2.gety())/factor)/2;
		
		return new Point(xAdd, yAdd);
		
	}
	public double getLength() {
		return Math.sqrt(Math.pow(p2.getx()-p1.getx(), 2) + Math.pow(p2.gety()-p1.gety(), 2));
	}
	public Point getP1() {
		return p1;
	}
	public Point getP2() {
		return p2;
	}
}
