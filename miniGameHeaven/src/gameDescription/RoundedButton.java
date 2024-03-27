package gameDescription;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
        
     // 텍스트를 그리기 위해 글꼴 색상 설정
        g.setColor(getForeground());
        // 텍스트의 폰트와 스타일 설정
        g.setFont(getFont());

		
        super.paintComponent(g);
    }
    
 

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
    }
    
    public static void main(String[] args) {

    	JFrame f = new JFrame();
    	f.setBounds(0,  0,  500, 500);
    	f.setLayout(null);
    	RoundedButton button = new RoundedButton(40);
        button.setBackground(new Color(255, 0, 0));
        button.setBounds(20, 20, 200, 40);
        f.add(button);
        f.setVisible(true);
    	
	}
    
}
