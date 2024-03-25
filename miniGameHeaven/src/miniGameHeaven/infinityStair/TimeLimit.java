package infinityStair;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class TimeLimit implements ActionListener {
	static RoundedPanel gaugepanel, framepanel, backgroundpanel;
	Timer timer = new Timer(100, this);
	public static int gauge = 145;

	public TimeLimit() {

		framepanel = new RoundedPanel(10);
		framepanel.setBounds(150, 5, 300, 40);
		framepanel.setBackground(new Color(124, 12, 6));

		gaugepanel = new RoundedPanel(10);
		gaugepanel.setBounds(155, 10, gauge, 30);
		gaugepanel.setBackground(new Color(252, 165, 0));

		backgroundpanel = new RoundedPanel(10);
		backgroundpanel.setBounds(155, 10, 290, 30);
		backgroundpanel.setBackground(new Color(40, 40, 40));

	}

	class RoundedPanel extends JPanel {
		private int radius;

		public RoundedPanel(int radius) {
			this.radius = radius;
			setOpaque(false); // 투명 배경을 위해 설정
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			int width = getWidth();
			int height = getHeight();
			Graphics2D graphics = (Graphics2D) g;
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			graphics.setColor(getBackground());
			graphics.fillRoundRect(0, 0, width, height, radius, radius);
		}

	}

	public void timerstart() {
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gaugepanel.setBounds(155, 10, gauge, 30);
		gauge -= 5;
		if (Brick.brickcnt >= 100) {
			gauge -= 0.5;
		} else if (Brick.brickcnt >= 500) {
			gauge -= 0.5;
		} else if (Brick.brickcnt >= 1000) {
			gauge -= 1;
		}
	}

}
