package interfaces;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main_Interface extends JFrame{

	public Main_Interface() {
		
		setSize(800, 600);
		setLocationRelativeTo(null);
		setLayout(null);

		RoundedButton[] button = new RoundedButton[6];
		Color[] colors = {new Color(26, 188, 156), new Color(52, 152, 219), new Color(243, 156, 18), new Color(241, 196, 15), new Color(155, 89, 182), new Color(64, 64, 64)};
		
		for(int i = 0; i < button.length; i++) {
			button[i] = new RoundedButton(30);
			button[i].setBackground(colors[i]);
			add(button[i]);
			if(i < 3) {
				button[i].setBounds(20 + (i *210), 20, 200, 250);
			}else {
				button[i].setBounds(20 + ((i - 3) *210), 280, 200, 250);
			}
			button[i].setBorderPainted(false);
		}
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
		
		new Main_Interface();
		
	}
	
}
