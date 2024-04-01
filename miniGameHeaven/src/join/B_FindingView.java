package join;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class B_FindingView extends JFrame {

	public B_FindingView() {

		setTitle("아이디/비밀번호 찾기");
		setSize(350, 200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// =========================================================

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(15, 15, 15, 15);
		Font font = new Font("Dotum", Font.PLAIN, 14);
		panel.setBackground(new Color(255, 255, 244));
		panel.setFont(font);

		// ==========================================================

		JButton bt = new JButton("아이디 찾기");
		bt.setFont(font);
		bt.setForeground(Color.white);
		bt.setBackground(Color.DARK_GRAY);
		bt.setPreferredSize(new Dimension(150, 30));
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				B_FindingID findid = new B_FindingID();
			}
		});
		panel.add(bt, gbc);

		JButton bt2 = new JButton("비밀번호 찾기");
		bt2.setFont(font);
		bt2.setForeground(Color.white);
		bt2.setBackground(Color.DARK_GRAY);
		bt2.setPreferredSize(new Dimension(150, 30));
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				B_FindingPASS findpass = new B_FindingPASS();
			}
		});
		gbc.gridy++;
		panel.add(bt2, gbc);

		// ==========================================================
		add(panel);
		setLocationRelativeTo(null);
		setVisible(true);

	}
}