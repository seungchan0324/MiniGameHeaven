package gameDescription;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

public class RoundedButton extends JButton {
	private int radius;
	private String text;

	public RoundedButton(int radius, String text) {
		this.radius = radius;
		this.text = text;
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

		// 텍스트를 그리기 위해 글꼴 색상 설정
		g.setColor(getForeground());
		// 텍스트의 폰트와 스타일 설정
		g.setFont(getFont());
		// FontMetrics를 사용하여 텍스트의 너비와 높이를 얻어 중앙에 위치시킵니다.
		FontMetrics fm = g.getFontMetrics();
		int x = (getWidth() - fm.stringWidth(text)) / 2;
		int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
		// 텍스트 그리기
		g.drawString(text, x, y);
		super.paintComponent(g);
	}

	@Override
	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
	}

}