package infinityStair;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import my_Information.MyInformationCharacter;

public class Character {
	private int charX;
	private int charY;
	public int middlepointX, rightmiddlepointX, leftmiddlepointX;
	public ImageIcon frontimg, rightimg, leftimg;
	public Image image;

	public Character() {
		characterSelect();
	}

	public void characterSelect() {
		if (MyInformationCharacter.characterselect.equals("Gumi")) {
			frontimg = new ImageIcon("����_��������.png");
			rightimg = new ImageIcon("����_��������_������.png");
			leftimg = new ImageIcon("����_��������_����.png");
			charY = (StartPanel.screenHeight - frontimg.getIconHeight()) / 2 - 21;
			middlepointX = (StartPanel.screenWidth - frontimg.getIconWidth()) / 2;
			rightmiddlepointX = middlepointX;
			leftmiddlepointX = middlepointX;
		} else if (MyInformationCharacter.characterselect.equals("Dalri")) {
			frontimg = new ImageIcon("�޸�_���۸�.png");
			rightimg = new ImageIcon("�޸�_���۸�_������.png");
			leftimg = new ImageIcon("�޸�_���۸�_����.png");
			charY = (StartPanel.screenHeight - frontimg.getIconHeight()) / 2 - 15;
			middlepointX = (StartPanel.screenWidth - frontimg.getIconWidth()) / 2 + 5;
			rightmiddlepointX = middlepointX;
			leftmiddlepointX = middlepointX;
		} else {
			frontimg = new ImageIcon("�����.png");
			rightimg = new ImageIcon("����̿�����.png");
			leftimg = new ImageIcon("����̿���.png");
			charY = (StartPanel.screenHeight - frontimg.getIconHeight()) / 2 - 30;
			middlepointX = (StartPanel.screenWidth - frontimg.getIconWidth()) / 2 + 2;
			rightmiddlepointX = middlepointX - 40;
			leftmiddlepointX = middlepointX - 5;
		}
		charX = middlepointX;
		image = frontimg.getImage();
	}

	// x, y�� ��ǥ
	public Character(int x, int y) {
		this.charX = x;
		this.charY = y;
	}

	public Character(int x, int y, ImageIcon img) {
		this.charX = x;
		this.charY = y;
		image = img.getImage();
	}

	public void draw(Graphics g, JPanel panel) {
		g.drawImage(image, charX, charY, panel);
	}

	public int getCharX() {
		return charX;
	}

	public void setX(int charX) {
		this.charX = charX;
	}

	public void setY(int charY) {
		this.charY = charY;
	}

}
