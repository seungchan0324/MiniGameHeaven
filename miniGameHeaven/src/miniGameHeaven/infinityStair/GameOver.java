package infinityStair;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GameOver extends JLabel {
	private Image gameOver; // ��� �̹����� ������ ����
	public static JButton retrybutton, endbutton;

	public GameOver() {

		setLayout(null);
		setBounds(0, 20, StartPanel.screenWidth, (StartPanel.screenWidth * 3 / 4));
		setBackground(new Color(0X0F000000, true));

		ImageIcon img = new ImageIcon("GameOver.png");
		gameOver = img.getImage().getScaledInstance(StartPanel.screenWidth - 15, (StartPanel.screenWidth * 1 / 2),
				Image.SCALE_SMOOTH); // �̹��� ũ�� ����
		img = new ImageIcon(gameOver);
		setIcon(img);
		setFocusable(true);

		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 21);

		ImageIcon new_game = new ImageIcon("New Game.png");
		Image new_gameimg = new_game.getImage();
		Image changeimg = new_gameimg.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
		new_game = new ImageIcon(changeimg);

		retrybutton = new JButton(new_game);
		retrybutton.setBounds(175, 540, 100, 50);
		retrybutton.setFocusable(true);
		retrybutton.setContentAreaFilled(false); // ���� ������ �����ϰ� ����
		retrybutton.setFocusPainted(false);

		ImageIcon exit = new ImageIcon("Exit.png");
		Image exitimg = exit.getImage();
		Image exitchangeimg = exitimg.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
		exit = new ImageIcon(exitchangeimg);

		endbutton = new JButton(exit);
		endbutton.setBounds(325, 540, 100, 50);
		endbutton.setFocusable(true);
		endbutton.setContentAreaFilled(false); // ���� ������ �����ϰ� ����
		endbutton.setFocusPainted(false);

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
