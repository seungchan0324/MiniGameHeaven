package swipeBlockCrack;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

class Ball {
	private int x;
	private int y;
	static double dx;
	static double dy;
	private int radius;
	private Color color;

	// x, y�� ��ǥ dx, dy�� �̵��ӵ� radius�� ������
	public Ball(int x, int y, int dx, int dy, int radius, Color color) {
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.radius = radius;
		this.color = color;
	}

	public void moveTo(double targetX, double targetY, int speed) {
	    // ��ǥ ���������� �Ÿ��� ����մϴ�.
	    double distanceX = targetX - x;
	    double distanceY = targetY - y;

	    // ��ǥ ���������� �Ÿ����� ����Ͽ� x �� y �������� �̵��� ũ�⸦ ����մϴ�.
	    double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
	    double ratio = Math.min((double) speed / distance, 1.0); // �ִ� ������ 1�� �����մϴ�.
	    dx = ratio * distanceX;
	    dy = ratio * distanceY;
	}

	// ���� ���Ʒ��� �ε������� y�� ��ȣ�� �ݴ�ǰ� �¿쿡 �ε��������� x�� �ݴ�ȴ�.
	public void move(int panelHeight) {
		x += dx;
		y += dy;

		if (x - radius <= 0 || x + radius >= 550) {
			dx = -dx;
		}
		if (y + radius <= 0) {
			dy = -dy;
		}
		if (y - radius >= 540) {
			Main.showDashedLine = true;
			dx = 0;
			dy = 0;
		}
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
	}

	// getBounds�ȿ� �����ϸ� �ٿ�� �Ǵ� ���� �ش� ���� �簢����
	public Rectangle getBounds() {
		return new Rectangle(x - radius, y - radius, 2 * radius, 2 * radius);
	}

	// ���� ���Ʒ��� �ε������� �¿쿡 �ε��������� ������ �� �˾ƾ� ��
	public void reverseDirection() {
		dx = -dx;
		dy = -dy;
	}

	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}
}