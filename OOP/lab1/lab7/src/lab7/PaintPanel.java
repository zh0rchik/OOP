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
	int width = 0;
	int height = 0;
	
	private int[][] arr_lvl = null;
	private int[][] playerId = null;

	private int lvl = 1;
	private int x = 48;
	private int y = 48;
	private int step = 48;
	private int xP = 0;
	private int yP = 0;
	
	public PaintPanel() {
		Scanner sc = null;
		
		try {
			sc = new Scanner(new File("lvl1.txt"));
			width = sc.nextInt();
			height = sc.nextInt();
			xP = sc.nextInt();
			yP = sc.nextInt();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		arr_lvl = new int[height][width];
		playerId = new int[height][width];
		for (int x = 0; x < height ; x++) {
			for (int y = 0; y < width ; y++) {
				int val = sc.nextInt();
				arr_lvl[x][y] = val;
				playerId[x][y] = val;
			}
		}
		sc.close();
	}
	
	public void loadLevel(int level) {
		Scanner sc = null;
		
		try {
			sc = new Scanner(new File(String.format("lvl%d.txt", level)));
			width = sc.nextInt();
			height = sc.nextInt();
			xP = sc.nextInt();
			yP = sc.nextInt();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		arr_lvl = new int[height][width];
		playerId = new int[height][width];
		for (int x = 0; x < height ; x++) {
			for (int y = 0; y < width ; y++) {
				int val = sc.nextInt();
				arr_lvl[x][y] = val;
				playerId[x][y] = val;
			}
		}
		sc.close();
		
	}

	
	
	public void moveLeft() {
		if (playerId[yP][xP - 1] == 1) {        //земля
			x -= step;
			xP -= 1;
		}
		else if (playerId[yP][xP - 1] == 2) {   //лава
			x -= step;
			xP -= 1;
			gameOver();
		}
		else if (playerId[yP][xP - 1] == 3) {   //золото
			x -= step;
			xP -= 1;
			nextLvl();
		}
		
		
		repaint();
	}
	
	public void moveRight() {
		
		if (playerId[yP][xP + 1] == 1) {
			x += step;
			xP += 1;
		}
		else if (playerId[yP][xP + 1] == 2) {   //лава
			x += step;
			xP += 1;
			gameOver();
		}
		else if (playerId[yP][xP + 1] == 3) {   //золото
			x += step;
			xP += 1;
			nextLvl();
		}
		
		repaint();
		
	}
	
	public void moveUp() {
		
		if (playerId[yP - 1][xP] == 1) {
			y -= step;
			yP -= 1;
		}
		else if (playerId[yP - 1][xP] == 2) {   //лава
			x -= step;
			yP -= 1;
			gameOver();
		}
		else if (playerId[yP - 1][xP] == 3) {   //золото
			x -= step;
			yP -= 1;
			nextLvl();
		}
		
		repaint();
	}
	
	public void moveDown() {
		
		if (playerId[yP + 1][xP] == 1) {
			y += step;
			yP += 1;
		}
		else if (playerId[yP + 1][xP] == 2) {   //лава
			x += step;
			yP += 1;
			gameOver();
		}
		else if (playerId[yP + 1][xP] == 3) {   //золото
			x += step;
			yP += 1;
			nextLvl();
		}	
		
		repaint();
	}

	
	public void gameOver() {
		xP = 1;
		yP = 1;
		x = 48;
		y = 48;
		lvl = 1;
		loadLevel(lvl);
		repaint();
		JOptionPane.showMessageDialog(null, "Вы проиграли, попробуйте снова!", "Уведомление", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void nextLvl() {
		xP = 1;
		yP = 1;
		x = 48;
		y = 48;
		lvl++;
		if (lvl > 3) {
			lvl = 1;
			loadLevel(lvl);
			JOptionPane.showMessageDialog(null, "Вы прошли игру!", "Уведомление", JOptionPane.INFORMATION_MESSAGE);
			repaint();
		}
		else if (lvl == 3) {
			loadLevel(lvl);
			JOptionPane.showMessageDialog(null, "Уровень №" + lvl + "!", "Уведомление", JOptionPane.INFORMATION_MESSAGE);
			repaint();
		}		
		else {
			loadLevel(lvl);
			JOptionPane.showMessageDialog(null, "Уровень №" + lvl + "!", "Уведомление", JOptionPane.INFORMATION_MESSAGE);
			repaint();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2D = (Graphics2D)g;
		BufferedImage imageWall = null;
		BufferedImage imageFloor = null;
		BufferedImage imageEnemy = null;
		BufferedImage imageFinish = null;
		
		try {
			imageWall = ImageIO.read(new File("wall.png"));
			imageFloor = ImageIO.read(new File("floor.png"));
			imageEnemy = ImageIO.read(new File("enemy.png"));
			imageFinish = ImageIO.read(new File("finish.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < arr_lvl.length; i++) {
			int top = i * 48;
			for (int j = 0; j < arr_lvl[i].length; j++) {
				int left = j * 48;
				if (arr_lvl[i][j] == 0) {                                  //камень
					g2D.drawImage(imageWall, null, left, top);
				}
				else if (arr_lvl[i][j] == 1) {                             //земля
					g2D.drawImage(imageFloor, null, left, top);
				}
				else if (arr_lvl[i][j] == 2) {                             //лава
					g2D.drawImage(imageEnemy, null, left, top);
				}
				else if (arr_lvl[i][j] == 3) {                             //финиш
					g2D.drawImage(imageFinish, null, left, top);
				}
			}
		}
		
		//игрок
		BufferedImage playerMario= null;
		
		try {
			playerMario= ImageIO.read(new File("player.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		g2D.drawImage(playerMario, null, x, y);
	}		
}