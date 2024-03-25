package SunGame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class penalty24 extends JFrame {

	public void penalty24() {

		JFrame frame = new JFrame("페널티 킥");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

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