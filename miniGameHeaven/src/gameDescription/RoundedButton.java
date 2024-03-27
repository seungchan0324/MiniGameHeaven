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
		setContentAreaFilled(false); // ���� ������ �����ϰ� ����
		setFocusPainted(false); // ��Ŀ�� ��, ��ư �׵θ��� �׸��� �ʵ��� ����
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			g.setColor(Color.lightGray);
		} else {
			g.setColor(getBackground());
		}
		g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);

		// �ؽ�Ʈ�� �׸��� ���� �۲� ���� ����
		g.setColor(getForeground());
		// �ؽ�Ʈ�� ��Ʈ�� ��Ÿ�� ����
		g.setFont(getFont());
		// FontMetrics�� ����Ͽ� �ؽ�Ʈ�� �ʺ�� ���̸� ��� �߾ӿ� ��ġ��ŵ�ϴ�.
		FontMetrics fm = g.getFontMetrics();
		int x = (getWidth() - fm.stringWidth(text)) / 2;
		int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
		// �ؽ�Ʈ �׸���
		g.drawString(text, x, y);
		super.paintComponent(g);
	}

	@Override
	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
	}

}