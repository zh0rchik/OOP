package lab6Class;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JPanel;

public class PaintPanel extends JPanel {
	int [][] array;
	int row;
	int column;
	int [][] newArray;
	int newRow;
	int newColumn;
	
	public int countColor = 10;
	public Color [] color = new Color [countColor];
	
	public PaintPanel() {
		color[0] = new Color(128,0,0);
		color[1] = new Color(255, 0, 0);
		color[2] = new Color(255, 128, 0);
		color[3] = new Color(255, 255, 0);
		color[4] = new Color(0,255,0);
		color[5] = new Color(0,255, 128);
		color[6] = new Color(0,255,255);
		color[7] = new Color(0,0,255);
		color[8] = new Color(128, 0, 255);
		color[9] = new Color(255,255,255);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		int x = 0;
		int y = 0;
		for(int i = 0; i < row; i++) {
			x = 0;
			for(int j = 0; j < column; j++) {
				int n = array[i][j]%10;
				g.setColor(color[n]);
				g.fillRect(x, y, 20, 20);
				x+=20;
			}
			y+=20;
		}
		
		x = 0;
		y = 0;
		for(int i = 0; i < row; i++) {
			x = 0;
			for(int j = 0; j < column; j++) {
				g.setColor(new Color(0,0,0));
				g.drawRect(x, y, 20, 20);
				x+=20;
				}
			y+=20;
			}
		
		
		x = 0;
		y += 20;
		int newY = y;
		for(int i = 0; i < newRow; i++) {
			x = 0;
			for(int j = 0; j < newColumn; j++) {
				int n = array[i][j]%10;
				g.setColor(color[n]);
				g.fillRect(x, y, 20, 20);
				x+=20;
			}
			y+=20;
		}
		
		x = 0;
		y = newY;
		for(int i = 0; i < newRow; i++) {
			x = 0;
			for(int j = 0; j < newColumn; j++) {
				g.setColor(new Color(0,0,0));
				g.drawRect(x, y, 20, 20);
				x+=20;
				}
			y+=20;
			}
		}
	
	
	public void setData(int [][] outArray, int outRow, int outColumn, 
			int [][] outNewArray, int outNewRow, int outNewColumn) {
		array = outArray;
		row = outRow;
		column = outColumn;
		
		newArray = outNewArray;
		newRow = outNewRow;
		newColumn = outNewColumn;
	}
	
}
