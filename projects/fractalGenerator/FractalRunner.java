package fractalGenerator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class FractalRunner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public FractalRunner(int factor)
	{
		super("Fractal Runner");

		setSize(WIDTH+40,HEIGHT+40);

		getContentPane().add(new Gasket(factor));
		//getContentPane().add(new Carpet());

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@SuppressWarnings("unused")
	public static void main( String args[] )
	{
		int factor = Integer.parseInt(JOptionPane.showInputDialog("Please input a number (-50 to 50) to set the rotation factor"
				+ "\nNote: the higher the absolute value of the number, the less the rotation"));
		FractalRunner run = new FractalRunner(factor);
	}
}
