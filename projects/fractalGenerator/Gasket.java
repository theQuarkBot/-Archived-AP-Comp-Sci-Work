package fractalGenerator;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Canvas;

@SuppressWarnings("serial")
public class Gasket extends Canvas implements Runnable
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private int factor = 0;

	public Gasket(int _factor)
	{
		setBackground(Color.WHITE);
		factor = _factor;
	}

	//sets everything
	public void paint( Graphics window )
	{	
		window.setColor(Color.BLUE);
		window.setFont(new Font("ARIAL",Font.BOLD,24));
		window.drawString("Fractal", 25, 50);
		
		//starting points
		Point p1 = new Point(WIDTH/2, HEIGHT/16);
		Point p2 = new Point(WIDTH/16*3, HEIGHT/8*3);
		Point p3 = new Point(WIDTH/16*5, HEIGHT/8*7);
		Point p4 = new Point(WIDTH/16*11, HEIGHT/8*7);
		Point p5 = new Point(WIDTH/16*13, HEIGHT/8*3);
		
		Line l1 = new Line(p1, p2);
		Line l2 = new Line(p2, p3);
		Line l3 = new Line(p3, p4);
		Line l4 = new Line(p4, p5);
		Line l5 = new Line(p5, p1);
		gasket(window, l1, l2, l3, l4, l5, factor);
	}

	//draws the fractal
	public void gasket(Graphics window, Line l1, Line l2, Line l3, Line l4, Line l5, int factor) {
		if (l1.getLength()>1 && l2.getLength()>1) {
			
		    Color randColor = new Color((int) (Math.random()*256), (int) (Math.random()*256), (int) (Math.random()*256));
			window.setColor(randColor);
			
			int x[] = {l1.getP1().getx(), l2.getP1().getx(), l3.getP1().getx(), l4.getP1().getx(), l5.getP1().getx()};
			int y[] = {l1.getP1().gety(), l2.getP1().gety(), l3.getP1().gety(), l4.getP1().gety(), l5.getP1().gety()};
			
			window.drawLine(x[0], y[0], x[1], y[1]);
			window.drawLine(x[1], y[1], x[2], y[2]);
			window.drawLine(x[2], y[2], x[3], y[3]);
			window.drawLine(x[3], y[3], x[4], y[4]);
			window.drawLine(x[4], y[4], x[0], y[0]);
			window.fillPolygon(x, y, 5);
			
			//Setting new points and lines
			Point[] _p = new Point[5];
			if (Math.abs(factor) == 1 || factor == 0) {
				_p[0] = l1.getMid();
				_p[1] = l2.getMid();
				_p[2] = l3.getMid();
				_p[3] = l4.getMid();
				_p[4] = l5.getMid();
			}
			else {
				_p[0] = l1.getNewPoint(factor);
				_p[1] = l2.getNewPoint(factor);
				_p[2] = l3.getNewPoint(factor);
				_p[3] = l4.getNewPoint(factor);
				_p[4] = l5.getNewPoint(factor);
			}
			// --
			Line[] _l = new Line[5];
			_l[0] = new Line(_p[0], _p[1]);
			_l[1] = new Line(_p[1], _p[2]);
			_l[2] = new Line(_p[2], _p[3]);
			_l[3] = new Line(_p[3], _p[4]);
			_l[4] = new Line(_p[4], _p[0]);
			
			gasket(window, _l[0], _l[1], _l[2], _l[3], _l[4], factor);
		}		
	}

	@SuppressWarnings("static-access")
	public void run()
	{
		try{
		  	Thread.currentThread().sleep(3);
		}
		catch(Exception e)
		{
		}
	}
}