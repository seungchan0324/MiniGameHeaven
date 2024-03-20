package infinityStair;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import swipeBlockCrack.Main;
import swipeBlockCrack.Vector2D;

public class Character {
	public static int charX;
	public static int charY;
	static double dx;
	static double dy;
	private int radius;
	private Color color;

	// x, y�� ��ǥ dx, dy�� �̵��ӵ� radius�� ������
	public Character(int x, int y, int radius, Color color) {
		this.charX = x;
		this.charY = y;
		this.radius = radius;
		this.color = color;
	}

	public void moveTo(double targetX, double targetY, int speed) {
	    // ���� ���� ��ġ�� ���ͷ� ǥ���մϴ�.
	    Vector2D currentPos = new Vector2D(charX, charY);
	    
	    // ���콺 �������� ��ġ�� ���ͷ� ǥ���մϴ�.
	    Vector2D targetPos = new Vector2D(targetX, targetY);
	    
	    // �̵� ���� ���͸� ����մϴ�.
	    Vector2D direction = targetPos.subtract(currentPos).normalize();
	    
	    // �̵� �Ÿ��� ����մϴ�.
	    double distance = speed;
	    
	    // ���ο� ���� ��ġ�� �����մϴ�.
	    dx = direction.getX() * distance;
	    dy = direction.getY() * distance;
	}
	
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(charX - radius, charY - radius, 2 * radius, 2 * radius);
	}

	// ���� ���Ʒ��� �ε������� �¿쿡 �ε��������� ������ �� �˾ƾ� ��
	public void reverseDirection() {
		dx = -dx;
		dy = -dy;
	}

	public int getX() {
		// TODO Auto-generated method stub
		return charX;
	}

	public int getY() {
		// TODO Auto-generated method stub
		return charY;
	}
	
}

