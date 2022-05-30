package lab5Class;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JPanel;
import javax.swing.SpinnerDateModel;

public class PaintPanel extends JPanel {
	private int n = 0;
	
	public void setDepth(int n) {
		this.n = n;
		repaint();
	}
	
	public void star4(Graphics g, int x, int y, int size) {
		
		g.drawLine(x, y-size, x + size/4, y - size/4);
		g.drawLine(x + size/4, y - size/4, x + size, y);
		g.drawLine(x + size, y, x + size / 4, y + size / 4);
		g.drawLine(x + size / 4, y + size / 4, x, y + size);
		g.drawLine(x, y + size, x - size / 4, y + size / 4);
		g.drawLine(x - size / 4, y + size / 4, x - size, y);
		g.drawLine(x - size, y, x - size / 4, y - size / 4);
		g.drawLine(x - size / 4, y - size / 4, x, y - size);
		
	}
	
	public void recurStar4(Graphics g, int x, int y, int size, int depth)
	{
	    if (depth <= 0)
	        return;
	    star4(g, x, y, size);
	    recurStar4(g, x - size, y, size/2, depth - 1);
	    recurStar4(g, x + size, y, size / 2, depth - 1);
	    recurStar4(g, x, y + size, size / 2, depth - 1);
	    recurStar4(g, x, y - size, size / 2, depth - 1);

	}
	
	public void star5(Graphics g, int x, int y, int size) {
		
		g.drawLine(x, y - size, x+size/5, y - size/3);
		g.drawLine(x+size/5, y - size/3, x + size, y - size/5);
		g.drawLine(x + size, y - size/5, x + size/3, y + size/8);
		g.drawLine(x + size/3, y + size/8, x + size/2, y + size);
		g.drawLine(x + size/2, y + size, x, y + size/3);
		g.drawLine(x, y + size/3, x - size/2, y + size);
		g.drawLine(x - size/2, y + size, x - size/3, y + size/8);
		g.drawLine(x - size/3, y + size/8, x - size, y - size/5);
		g.drawLine(x - size, y - size/5, x - size/5, y- size/3);
		g.drawLine(x - size/5, y- size/3, x, y - size);
		
	}
	
	public void recurStar5(Graphics g, int x, int y, int size, int depth)
	{
	    if (depth <= 0)
	        return;
	    star5(g, x, y, size);
	    recurStar5(g, x, y - size, size / 2, depth - 1);
	    recurStar5(g, x + size, y - size/5, size / 2, depth - 1);
	    recurStar5(g, x + size/2, y + size, size / 2, depth - 1);
	    recurStar5(g, x - size/2, y + size, size / 2, depth - 1);
	    recurStar5(g, x - size, y - size/5, size / 2, depth - 1);
	}

	void recurStar45(Graphics hdc, int x, int y, int size, int depth)
	{
	    if (depth <= 0)
	        return;
	    star4(hdc, x, y, size);
	    recurStar54(hdc, x - size, y, size / 2, depth - 1);
	    recurStar54(hdc, x + size, y, size / 2, depth - 1);
	    recurStar54(hdc, x, y + size, size / 2, depth - 1);
	    recurStar54(hdc, x, y - size, size / 2, depth - 1);
	}

	void recurStar54(Graphics hdc, int x, int y, int size, int depth)
	{
	    if (depth <= 0)
	        return;
	    star5(hdc, x, y, size);
	    recurStar45(hdc, x, y - size, size / 2, depth - 1);
	    recurStar45(hdc, x + size, y - size / 5, size / 2, depth - 1);
	    recurStar45(hdc, x + size / 2, y + size, size / 2, depth - 1);
	    recurStar45(hdc, x - size / 2, y + size, size / 2, depth - 1);
	    recurStar45(hdc, x - size, y - size / 5, size / 2, depth - 1);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		recurStar54(g, 150, 150, 70, n);
		
		}

}