package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.Border;

public class Babo extends JFrame {

	int cnt = 0;

	public Babo() {
		setTitle("캐릭터");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(768, 600);

		ImageIcon ic2 = new ImageIcon("jan.png");
		JLabel la = new JLabel(ic2);
		la.setBounds(130, 160, 500, 500);

		ImageIcon ic = new ImageIcon("구미.png");
		JButton button = new JButton(ic);
		button.setBounds(130, 70, 500, 500);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);

		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					if (cnt == 0) {
						ImageIcon newIcon = new ImageIcon("구미_옆2.png");
						button.setIcon(newIcon);
					} else if (cnt == 1) {
						ImageIcon newIcon = new ImageIcon("구미_뒤.png");
						button.setIcon(newIcon);
					} else if (cnt == 2) {
						ImageIcon newIcon = new ImageIcon("구미_옆.png");
						button.setIcon(newIcon);
					} else if (cnt == 3) {
						ImageIcon newIcon = new ImageIcon("구미.png");
						button.setIcon(newIcon);
						cnt = -1;
					}
				}
				cnt++;
			}
		});

		JLabel textLabel = new JLabel("");
		textLabel.setBounds(320, 80, 100, 30);
		textLabel.setHorizontalAlignment(JLabel.CENTER);
		textLabel.setVerticalAlignment(JLabel.NORTH);

		add(textLabel);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textLabel.setText("안녕");
				textLabel.setFont(new Font("Serif", Font.BOLD, 15));
				Border border = BorderFactory.createLineBorder(Color.black);
				textLabel.setBorder(border);
				textLabel.setOpaque(true);
				textLabel.setBackground(Color.white);

				Timer timer = new Timer(2000, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						textLabel.setText("");
						textLabel.setBorder(null);
						textLabel.setOpaque(false);
					}
				});
				timer.setRepeats(false);
				timer.start();
			}
		});

		add(button);
		add(la);

		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
