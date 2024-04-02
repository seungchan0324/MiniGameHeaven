package defaultFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedPanel extends JPanel {
	private Color backgroundColor;
	private int cornerRadius;

	public RoundedPanel(int radius, Color bgColor) {
		super();
		cornerRadius = radius;
		backgroundColor = bgColor;
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(backgroundColor);
		g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));
		g2d.dispose();
	}

	public void setColor(Color color) {
		backgroundColor = color;
		repaint(); // 배경색을 변경한 후 패널을 다시 그려야 합니다.
	}
}
