package interfaces;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main_Interface2 extends JFrame{

	public Main_Interface2() {
		
		setSize(800, 600);
		setLocationRelativeTo(null);
		setLayout(null);

		RoundedPanel[] button = new RoundedPanel[6];
		Color[] colors = {new Color(26, 188, 156), new Color(52, 152, 219), new Color(243, 156, 18), new Color(241, 196, 15), new Color(155, 89, 182), new Color(64, 64, 64)};
		
		for(int i = 0; i < button.length; i++) {
			button[i] = new RoundedPanel(30);
			button[i].setBackground(colors[i]);
			add(button[i]);
			if(i < 3) {
				button[i].setBounds(20 + (i *210), 20, 200, 250);
			}else {
				button[i].setBounds(20 + ((i - 3) *210), 280, 200, 250);
			}
			button[i].setOpaque(false);
		}
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	class RoundedPanel extends JPanel{
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
	
	class RoundedButton extends JButton {
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
	        g.setColor(getForeground());
	        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
	    }
	}
	
	
	public static void main(String[] args) {
		
		new Main_Interface2();
		
	}
	
}
