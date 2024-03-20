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
	    // 현재 공의 위치를 벡터로 표현합니다.
	    Vector2D currentPos = new Vector2D(x, y);
	    
	    // 마우스 포인터의 위치를 벡터로 표현합니다.
	    Vector2D targetPos = new Vector2D(targetX, targetY);
	    
	    // 이동 방향 벡터를 계산합니다.
	    Vector2D direction = targetPos.subtract(currentPos).normalize();
	    
	    // 이동 거리를 계산합니다.
	    double distance = speed;
	    
	    // 새로운 공의 위치를 설정합니다.
	    dx = direction.getX() * distance;
	    dy = direction.getY() * distance;
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