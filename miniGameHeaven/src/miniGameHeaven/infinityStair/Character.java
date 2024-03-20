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

	// x, y는 좌표 dx, dy는 이동속도 radius는 반지름
	public Character(int x, int y, int radius, Color color) {
		this.charX = x;
		this.charY = y;
		this.radius = radius;
		this.color = color;
	}

	public void moveTo(double targetX, double targetY, int speed) {
	    // 현재 공의 위치를 벡터로 표현합니다.
	    Vector2D currentPos = new Vector2D(charX, charY);
	    
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
	
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(charX - radius, charY - radius, 2 * radius, 2 * radius);
	}

	// 각각 위아래에 부딪혔을때 좌우에 부딪혔을때를 구분할 줄 알아야 함
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

