package lab4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JPanel;

public class PaintPanel extends JPanel {
	public void block(Graphics g, int x, int y) {

		g.setColor(new Color(230, 230, 230));
		g.drawRect(x, y, 15, 10);

		g.setColor(new Color(160, 54, 35));
		g.fillRect(x + 1, y + 1, 14, 9);
	}

	public void fence(Graphics g, int x, int y) {
		g.setColor(new Color(250, 150, 0));
		int fX[] = { x, x, x + 5, x + 10, x + 10 };
		int fY[] = { 30 + y, 5 + y, y, 5 + y, 30 + y };

		Polygon f = new Polygon(fX, fY, 5);
		g.setColor(new Color(250, 125, 0));
		g.fillPolygon(f);
		g.setColor(new Color(153, 75, 0));
		g.drawPolygon(f);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(new Color(117, 187, 253)); // небо
		g.fillRect(0, 0, 570, 370);

		g.setColor(new Color(11, 218, 81)); // земля
		g.fillRect(0, 250, 570, 100);

		g.setColor(new Color(240, 240, 255));
		g.fillOval(490, 21, 40, 40);
		g.setColor(new Color(117, 187, 253));
		g.fillOval(500, 25, 40, 40);

		// дом
		int x = 70;
		int y = 240;

		int w = 0;
		while (w < 10) {
			int h = 0;
			while (h < 8) {
				block(g, x + w * 15, y - h * 10);
				h++;
			}
			w++;
		}

		// дверь
		g.setColor(new Color(150, 75, 0));
		g.fillRect(101, 191, 29, 59);
		g.setColor(new Color(250, 150, 0));
		g.fillOval(120, 220, 5, 5);

		// окно
		g.setColor(new Color(100, 100, 200));
		g.fillRect(161, 191, 29, 9);
		g.fillRect(161, 201, 14, 19);
		g.fillRect(176, 201, 14, 19);

		// крыша
		g.setColor(new Color(170, 90, 0));
		int kX[] = { 60, 145, 230 };
		int kY[] = { 170, 100, 170 };
		Polygon k = new Polygon(kX, kY, 3);
		g.fillPolygon(k);
		g.setColor(new Color(70, 10, 0));
		g.drawPolygon(k);

		// Солнце
		g.setColor(new Color(250, 150, 0));
		int sX[] = { 0, 50, 60, 70, 120, 70, 60, 50 };
		int sY[] = { 60, 50, 0, 50, 60, 70, 120, 70 };
		Polygon s = new Polygon(sX, sY, 8);
		g.fillPolygon(s);
		g.setColor(new Color(250, 235, 0));
		g.fillOval(40, 40, 40, 40);

		// облакa
		x = 100;
		y = 50;

		g.setColor(new Color(236, 240, 241));
		g.fillOval(250 + x, 60, 100, 25);
		g.fillOval(270 + x, 50, 100, 25);
		g.fillOval(310 + x, 60, 100, 20);

		g.fillOval(300 + x, 100 + y, 100, 25);
		g.fillOval(310 + x, 100 + y, 150, 25);
		g.fillOval(360 + x, 110 + y, 100, 20);

		g.fillOval(300 - x, 100, 100, 25);
		g.fillOval(310 - x, 100, 150, 25);
		g.fillOval(360 - x, 110, 100, 20);

		fence(g, 200, 220);
		fence(g, 210, 220);
		fence(g, 220, 220);
		fence(g, 230, 220);
		fence(g, 240, 220);
		fence(g, 250, 220);
		fence(g, 260, 220);
		fence(g, 270, 220);

	}

}
