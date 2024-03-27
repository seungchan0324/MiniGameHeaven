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
