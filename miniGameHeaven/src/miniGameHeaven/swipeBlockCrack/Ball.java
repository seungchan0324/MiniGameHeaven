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

	// x, y는 좌표 dx, dy는 이동속도 radius는 반지름
	public Ball(int x, int y, int dx, int dy, int radius, Color color) {
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.radius = radius;
		this.color = color;
	}

	public void moveTo(double targetX, double targetY, int speed) {
	    // 목표 지점까지의 거리를 계산합니다.
	    double distanceX = targetX - x;
	    double distanceY = targetY - y;

	    // 목표 지점까지의 거리에서 비례하여 x 및 y 방향으로 이동할 크기를 계산합니다.
	    double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
	    double ratio = Math.min((double) speed / distance, 1.0); // 최대 비율을 1로 제한합니다.
	    dx = ratio * distanceX;
	    dy = ratio * distanceY;
	}

	// 각각 위아래에 부딪혔을땐 y의 부호가 반대되고 좌우에 부딪혔을때는 x가 반대된다.
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

	// getBounds안에 접근하면 바운드 되는 원리 해당 값은 사각형임
	public Rectangle getBounds() {
		return new Rectangle(x - radius, y - radius, 2 * radius, 2 * radius);
	}

	// 각각 위아래에 부딪혔을때 좌우에 부딪혔을때를 구분할 줄 알아야 함
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