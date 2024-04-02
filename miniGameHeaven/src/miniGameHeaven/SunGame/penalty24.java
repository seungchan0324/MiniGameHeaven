package SunGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import defaultFrame.DefaultFrame;
import gameDescription.GameDescription;

public class penalty24 extends JFrame {

	public penalty24() {

		JFrame frame = new JFrame("페널티 킥");
		frame.setSize(700, 700);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				DefaultFrame.getInstance(new GameDescription(4), "게임 설명 화면");
			}
		});

		JButton button = new JButton("게임 시작");
		button.setBounds(280, 500, 100, 50);

		ImageIcon icon = new ImageIcon("st.jpg");
		JLabel label = new JLabel(icon);
		label.setBounds(41, 100, icon.getIconWidth(), icon.getIconHeight());

		frame.add(label);
		frame.add(button);
		frame.setVisible(true);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Game();
			}
		});

	}
}