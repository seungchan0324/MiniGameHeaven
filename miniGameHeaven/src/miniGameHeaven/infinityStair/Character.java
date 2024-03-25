package infinityStair;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import interfaces.MyInformationCharacter;

public class Character {
	private int charX;
	private int charY;
	public static int middlepointcharacter;
	ImageIcon img;
	Image image;
	
	
	public Character() {
		characterSelect();
	}
	
	public void characterSelect(){
		if(MyInformationCharacter.characterselect.equals("Gumi")) {
			img = new ImageIcon("구미.png");
			charY = (StartPanel.screenHeight - img.getIconHeight()) / 2 - 25;
		}else if(MyInformationCharacter.characterselect.equals("Dalri")) {
			img = new ImageIcon("달리.png");
			charY = (StartPanel.screenHeight - img.getIconHeight()) / 2 - 20;
		}else {
			img = new ImageIcon("토양이.png");
			charY = (StartPanel.screenHeight - img.getIconHeight()) / 2 - 30;
		}
		image = img.getImage();
		charX = (StartPanel.screenWidth  - img.getIconWidth()) / 2 ;
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

