package swipeBlockCrack;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

class Ball {
    private int x;
    private int y;
    private int dx;
    private int dy;
    private int radius;
    private Color color;

    public Ball(int x, int y, int dx, int dy, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.radius = radius;
        this.color = color;
    }

    public void moveTo(int targetX, int targetY) {
        dx = targetX - x;
        dy = targetY - y;
    }

    public void move(int panelHeight) {
        x += dx;
        y += dy;

        if (x - radius <= 0 || x + radius >= panelHeight) {
            dx = -dx;
        }
        if (y - radius <= 0 || y + radius >= panelHeight) {
            dy = -dy;
        }
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }

    public Rectangle getBounds() {
        return new Rectangle(x - radius, y - radius, 2 * radius, 2 * radius);
    }

    public void reverseDirection() {
        dx = -dx;
        dy = -dy;
    }
}