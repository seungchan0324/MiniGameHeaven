package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.Border;

public class Babo extends JPanel {

	int cnt = 0;

	public Babo() {
		setSize(768, 600);
		setLayout(null);
		setBackground(new Color(255, 255, 244));

		ImageIcon ic2 = new ImageIcon("jan.png");
		JLabel la = new JLabel(ic2);
		la.setBounds(130, 160, 500, 500);

		ImageIcon ic = new ImageIcon("备固.png");
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
						ImageIcon newIcon = new ImageIcon("备固_糠2.png");
						button.setIcon(newIcon);
					} else if (cnt == 1) {
						ImageIcon newIcon = new ImageIcon("备固_第.png");
						button.setIcon(newIcon);
					} else if (cnt == 2) {
						ImageIcon newIcon = new ImageIcon("备固_糠.png");
						button.setIcon(newIcon);
					} else if (cnt == 3) {
						ImageIcon newIcon = new ImageIcon("备固.png");
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
				textLabel.setText("救崇");
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
	}

}
