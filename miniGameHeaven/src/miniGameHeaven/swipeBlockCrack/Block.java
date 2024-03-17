package swipeBlockCrack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

class Block {
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	private int number; // 블록에 표시될 숫자

	public Block(int x, int y, int width, int height, Color color, int number) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.number = number;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
		// 블록의 중앙에 숫자 표시
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		int stringWidth = g.getFontMetrics().stringWidth(String.valueOf(number));
		int stringHeight = g.getFontMetrics().getHeight();
		int centerX = x + (width - stringWidth) / 2;
		int centerY = y + (height + stringHeight) / 2;
		g.drawString(String.valueOf(number), centerX, centerY);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
}