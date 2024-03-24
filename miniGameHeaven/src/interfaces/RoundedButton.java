package interfaces;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class RoundedButton extends JButton {
	private int radius;

	public RoundedButton(int radius) {
		this.radius = radius;
		setContentAreaFilled(false); // 내용 영역을 투명하게 설정
		setFocusPainted(false); // 포커스 시, 버튼 테두리를 그리지 않도록 설정
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			g.setColor(Color.lightGray);
		} else {
			g.setColor(getBackground());
		}
		g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
		super.paintComponent(g);
	}

	@Override
	protected void paintBorder(Graphics g) {
	}
}
