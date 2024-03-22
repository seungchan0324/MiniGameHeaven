package infinityStair;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Character {
	ImageIcon img = new ImageIcon("토양이.png");
	Image image = img.getImage();
	private int charX = (StartPanel.screenWidth / 2) - (img.getIconWidth() / 2 );
	private int charY = (StartPanel.screenHeight / 2)- (img.getIconHeight() / 2) - 30;
	
	public Character() {
	}
	
	// x, y는 좌표
	public Character(int x, int y) {
		this.charX = x;
		this.charY = y;
	}
	
	public Character(int x, int y, ImageIcon img) {
		this.charX = x;
		this.charY = y;
		Image image = img.getImage();
	}

	public void draw(Graphics g, JPanel panel) {
		g.drawImage(image, charX, charY, panel);
	}

	public void setX(int charX) {
		this.charX = charX;
	}

	public void setY(int charY) {
		this.charY = charY;
	}
	
}

