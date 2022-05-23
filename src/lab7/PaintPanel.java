package lab7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PaintPanel extends JPanel {
	int LVL_WIDTH = 10;
	int LVL_HEIGHT = 10;
	
	private int[][] arr_lvl1 = new int[LVL_HEIGHT][LVL_WIDTH];
	private int[][] arr_lvl2 = new int[LVL_HEIGHT][LVL_WIDTH];
	private int[][] arr_lvl3 = new int[LVL_HEIGHT][LVL_WIDTH];
	private int[][] playerId1 = new int[LVL_HEIGHT][LVL_WIDTH];
	private int[][] playerId2 = new int[LVL_HEIGHT][LVL_WIDTH];
	private int[][] playerId3 = new int[LVL_HEIGHT][LVL_WIDTH];
	
	private int lvl = 1;
	private int x = 48;
	private int y = 48;
	private int step = 48;
	private int xPos = 1;
	private int yPos = 1;
	
	public PaintPanel() {
		Scanner Scanner1 = null;
		Scanner Scanner2 = null;
		Scanner Scanner3 = null;
		Scanner Scanner4 = null;
		Scanner Scanner5 = null;
		Scanner Scanner6 = null;
		try {
			Scanner1 = new Scanner(new File("lvl1.txt"));
			Scanner2 = new Scanner(new File("lvl2.txt"));
			Scanner3 = new Scanner(new File("lvl3.txt"));
			
			Scanner4 = new Scanner(new File("lvl1.txt"));
			Scanner5 = new Scanner(new File("lvl2.txt"));
			Scanner6 = new Scanner(new File("lvl3.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for (int x = 0; x < LVL_HEIGHT ; x++) {
			for (int y = 0; y <LVL_WIDTH ; y++) {
				arr_lvl1[x][y] = Scanner1.nextInt();
				arr_lvl2[x][y] = Scanner2.nextInt();
				arr_lvl3[x][y] = Scanner3.nextInt();
				playerId1[x][y] = Scanner4.nextInt();
				playerId2[x][y] = Scanner5.nextInt();
				playerId3[x][y] = Scanner6.nextInt();
			}
		}
		Scanner1.close();
		Scanner2.close();
		Scanner3.close();
		Scanner4.close();
		Scanner5.close();
		Scanner6.close();
	}

	
	
	public void moveLeft() {
		
		if (lvl == 1) {
			if (playerId1[yPos][xPos - 1] == 1) {        //земля
				x -= step;
				xPos -= 1;
			}
			else if (playerId1[yPos][xPos - 1] == 2) {   //лава
				x -= step;
				xPos -= 1;
				gameOver();
			}
			else if (playerId1[yPos][xPos - 1] == 3) {   //золото
				x -= step;
				xPos -= 1;
				nextLvl();
			}
		}
		
		
		
		if (lvl == 2) {
			if (playerId2[yPos][xPos - 1] == 1) {        //земля
				x -= step;
				xPos -= 1;
			}
			else if (playerId2[yPos][xPos - 1] == 2) {   //лава
				x -= step;
				xPos -= 1;
				gameOver();
			}
			else if (playerId2[yPos][xPos - 1] == 3) {   //золото
				x -= step;
				xPos -= 1;
				nextLvl();
			}
		}
		
		
		if (lvl == 3) {
			if (playerId3[yPos][xPos - 1] == 1) {        //земля
				x -= step;
				xPos -= 1;
			}
			else if (playerId3[yPos][xPos - 1] == 2) {   //лава
				x -= step;
				xPos -= 1;
				gameOver();
			}
			else if (playerId3[yPos][xPos - 1] == 3) {   //золото
				x -= step;
				xPos -= 1;
				nextLvl();
			}
		}
		
		
		repaint();
	}
	
	public void moveRight() {
		
		if (lvl == 1) {
			if (playerId1[yPos][xPos + 1] == 1) {
				x += step;
				xPos += 1;
			}
			else if (playerId1[yPos][xPos + 1] == 2) {   //лава
				x += step;
				xPos += 1;
				gameOver();
			}
			else if (playerId1[yPos][xPos + 1] == 3) {   //золото
				x += step;
				xPos += 1;
				nextLvl();
			}
		}
		
		if (lvl == 2) {
			if (playerId2[yPos][xPos + 1] == 1) {
				x += step;
				xPos += 1;
			}
			else if (playerId2[yPos][xPos + 1] == 2) {   //лава
				x += step;
				xPos += 1;
				gameOver();
			}
			else if (playerId2[yPos][xPos + 1] == 3) {   //золото
				x += step;
				xPos += 1;
				nextLvl();
			}
		}
		
		if (lvl == 3) {
			if (playerId3[yPos][xPos + 1] == 1) {
				x += step;
				xPos += 1;
			}
			else if (playerId3[yPos][xPos + 1] == 2) {   //лава
				x += step;
				xPos += 1;
				gameOver();
			}
			else if (playerId3[yPos][xPos + 1] == 3) {   //золото
				x += step;
				xPos += 1;
				nextLvl();
			}
		}
		
		repaint();
		
	}
	
	public void moveUp() {
		
		if (lvl == 1) {
			if (playerId1[yPos - 1][xPos] == 1) {
				y -= step;
				yPos -= 1;
			}
			else if (playerId1[yPos - 1][xPos] == 2) {   //лава
				x -= step;
				yPos -= 1;
				gameOver();
			}
			else if (playerId1[yPos - 1][xPos] == 3) {   //золото
				x -= step;
				yPos -= 1;
				nextLvl();
			}
		}
		
		if (lvl == 2) {
			if (playerId2[yPos - 1][xPos] == 1) {
				y -= step;
				yPos -= 1;
			}
			else if (playerId2[yPos - 1][xPos] == 2) {   //лава
				x -= step;
				yPos -= 1;
				gameOver();
			}
			else if (playerId2[yPos - 1][xPos] == 3) {   //золото
				x -= step;
				yPos -= 1;
				nextLvl();
			}
		}
		
		if (lvl == 3) {
			if (playerId3[yPos - 1][xPos] == 1) {
				y -= step;
				yPos -= 1;
			}
			else if (playerId3[yPos - 1][xPos] == 2) {   //лава
				x -= step;
				yPos -= 1;
				gameOver();
			}
			else if (playerId3[yPos - 1][xPos] == 3) {   //золото
				x -= step;
				yPos -= 1;
				nextLvl();
			}

		}
		
		repaint();
	}
	
	public void moveDown() {
		
		if (lvl == 1) {
			if (playerId1[yPos + 1][xPos] == 1) {
				y += step;
				yPos += 1;
			}
			else if (playerId1[yPos + 1][xPos] == 2) {   //лава
				x += step;
				yPos += 1;
				gameOver();
			}
			else if (playerId1[yPos + 1][xPos] == 3) {   //золото
				x += step;
				yPos += 1;
				nextLvl();
			}			
		}
		
		if (lvl == 2) {
			if (playerId2[yPos + 1][xPos] == 1) {
				y += step;
				yPos += 1;
			}
			else if (playerId2[yPos + 1][xPos] == 2) {   //лава
				x += step;
				yPos += 1;
				gameOver();
			}
			else if (playerId2[yPos + 1][xPos] == 3) {   //золото
				x += step;
				yPos += 1;
				nextLvl();
			}			
		}
		
		if (lvl == 3) {
			if (playerId3[yPos + 1][xPos] == 1) {
				y += step;
				yPos += 1;
			}
			else if (playerId3[yPos + 1][xPos] == 2) {   //лава
				x += step;
				yPos += 1;
				gameOver();
			}
			else if (playerId3[yPos + 1][xPos] == 3) {   //золото
				x += step;
				yPos += 1;
				nextLvl();
			}			
		}
		
		repaint();
	}

	
	public void gameOver() {
		xPos = 1;
		yPos = 1;
		x = 48;
		y = 48;
		lvl = 1;
		repaint();
		JOptionPane.showMessageDialog(null, "Вы проиграли, попробуйте снова!", "Уведомление", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void nextLvl() {
		xPos = 1;
		yPos = 1;
		x = 48;
		y = 48;
		lvl++;
		if (lvl > 3) {
			lvl = 1;
			JOptionPane.showMessageDialog(null, "Вы прошли игру!", "Уведомление", JOptionPane.INFORMATION_MESSAGE);
			repaint();
		}
		else if (lvl == 3) {
			JOptionPane.showMessageDialog(null, "Уровень №" + lvl + "!", "Уведомление", JOptionPane.INFORMATION_MESSAGE);
			repaint();
		}		
		else {
			JOptionPane.showMessageDialog(null, "Уровень №" + lvl + "!", "Уведомление", JOptionPane.INFORMATION_MESSAGE);
			repaint();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2D = (Graphics2D)g;
		BufferedImage blockStoneImage = null;
		BufferedImage blockDirtImage = null;
		BufferedImage blockHellStone = null;
		BufferedImage blockGoldOre = null;
		
		try {
			blockStoneImage = ImageIO.read(new File("wall.png"));
			blockDirtImage = ImageIO.read(new File("floor.png"));
			blockHellStone = ImageIO.read(new File("enemy.png"));
			blockGoldOre = ImageIO.read(new File("finish.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (lvl == 1) {
			
			for (int i = 0; i < arr_lvl1.length; i++) {
				int top = i * 48;
				for (int j = 0; j < arr_lvl1[i].length; j++) {
					int left = j * 48;
					if (arr_lvl1[i][j] == 0) {                                  //камень
						g2D.drawImage(blockStoneImage, null, left, top);
					}
					else if (arr_lvl1[i][j] == 1) {                             //земля
						g2D.drawImage(blockDirtImage, null, left, top);
					}
					else if (arr_lvl1[i][j] == 2) {                             //лава
						g2D.drawImage(blockHellStone, null, left, top);
					}
					else if (arr_lvl1[i][j] == 3) {                             //финиш
						g2D.drawImage(blockGoldOre, null, left, top);
					}
				}
			}
			
		}
		else if (lvl == 2) {
			
			for (int i = 0; i < arr_lvl2.length; i++) {
				int top = i * 48;
				for (int j = 0; j < arr_lvl2[i].length; j++) {
					int left = j * 48;
					if (arr_lvl2[i][j] == 0) {                                  //камень
						g2D.drawImage(blockStoneImage, null, left, top);
					}
					else if (arr_lvl2[i][j] == 1) {                             //земля
						g2D.drawImage(blockDirtImage, null, left, top);
					}
					else if (arr_lvl2[i][j] == 2) {                             //лава
						g2D.drawImage(blockHellStone, null, left, top);
					}
					else if (arr_lvl2[i][j] == 3) {                             //финиш
						g2D.drawImage(blockGoldOre, null, left, top);
					}
				}
			}
			
		}
		else if (lvl == 3) {
			
			for (int i = 0; i < arr_lvl3.length; i++) {
				int top = i * 48;
				for (int j = 0; j < arr_lvl3[i].length; j++) {
					int left = j * 48;
					if (arr_lvl3[i][j] == 0) {                                  //камень
						g2D.drawImage(blockStoneImage, null, left, top);
					}
					else if (arr_lvl3[i][j] == 1) {                             //земля
						g2D.drawImage(blockDirtImage, null, left, top);
					}
					else if (arr_lvl3[i][j] == 2) {                             //лава
						g2D.drawImage(blockHellStone, null, left, top);
					}
					else if (arr_lvl3[i][j] == 3) {                             //финиш
						g2D.drawImage(blockGoldOre, null, left, top);
					}
				}
			}
			
		}
		
		//игрок
		BufferedImage playerMale = null;
		
		try {
			playerMale = ImageIO.read(new File("player.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		g2D.drawImage(playerMale, null, x, y);
	}		
}