package infinityStair;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GameOver extends JLabel{
	private Image gameOver; // 배경 이미지를 저장할 변수
	public static JButton retrybutton, endbutton;
	
	public GameOver() {
		
		setLayout(null);
		setBounds(0, 20, StartPanel.screenWidth, (StartPanel.screenWidth * 3 / 4));
		setBackground(new Color(0X0F000000,true) );
		
		ImageIcon img = new ImageIcon("GameOver2.png");
		gameOver = img.getImage().getScaledInstance(StartPanel.screenWidth - 15, (StartPanel.screenWidth * 1 / 2), Image.SCALE_SMOOTH); // 이미지 크기 조정
		img = new ImageIcon(gameOver);
		setIcon(img);
		setFocusable(true);

		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 21);
		
		retrybutton = new JButton("재시작");
		retrybutton.setForeground(new Color(124, 12, 6));
		retrybutton.setFont(font);
		retrybutton.setBackground(new Color(252, 165, 0));
		retrybutton.setBounds(175, 540, 100, 50);
		retrybutton.setFocusable(true);
		
		endbutton = new JButton("종료");
		endbutton.setForeground(new Color(124, 12, 6));
		endbutton.setFont(font);
		endbutton.setBackground(new Color(252, 165, 0));
		endbutton.setBounds(325, 540, 100, 50);
		endbutton.setFocusable(true);
		
		retrybutton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				StartFrame.instance.getContentPane().removeAll();
				StartFrame.instance.dispose();
				StartFrame.getInstance(new StartPanel());
			}
		});

		endbutton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				StartFrame.instance.dispose();
			}
		});

		setVisible(true);
		
	}
	
}
