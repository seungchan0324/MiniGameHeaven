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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class B_FindingID extends JFrame {

	public B_FindingID() {

		setTitle("아이디 찾기");
		setSize(350, 350);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// =========================기본 프레임 설정=================================

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 5, 5, 5);
		Font font = new Font("Dotum", Font.PLAIN, 14);
		panel.setBackground(new Color(255, 255, 244));
		panel.setFont(font);

		JLabel la1 = new JLabel("가입 시 입력한 이메일 주소");
		la1.setFont(font);
		panel.add(la1, gbc);

		JTextField emailfind = new JTextField();
		emailfind.setFont(font);
		emailfind.setPreferredSize(new Dimension(300, 40));
		gbc.gridy++;
		panel.add(emailfind, gbc);

		JLabel la2 = new JLabel("생년월일(YYMMDD)");
		la2.setFont(font);
		gbc.gridy++;
		panel.add(la2, gbc);

		JTextField birthdayfind = new JTextField();
		birthdayfind.setFont(font);
		birthdayfind.setPreferredSize(new Dimension(300, 40));
		gbc.gridy++;
		panel.add(birthdayfind, gbc);

		//버튼 누르면 결과 출력되는 텍스트라벨
		JLabel result = new JLabel();
		result.setFont(font);
		gbc.gridy++;
		panel.add(result, gbc);

		//////////////////////////////////////////

		JButton bt = new JButton("아이디 찾기");
		bt.setFont(font);
		bt.setForeground(Color.white);
		bt.setBackground(Color.DARK_GRAY);
		bt.setPreferredSize(new Dimension(300, 40));

		bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String email = emailfind.getText();
				String birthday = birthdayfind.getText();
				boolean found = false;

				for (A_Join.Join join : A_Join.hm.values()) {
					if (join.email.equals(email) && join.birthday.equals(birthday)) {

						result.setText("회원님의 아이디는 " + join.id + "입니다.");
						found = true;
						break;

					}
				}

				if (!found) {
					result.setText("회원 정보가 존재하지 않습니다.");

				}
			}
		});

		gbc.gridy++;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel.add(bt, gbc);

		////////////////////

		add(panel);
		setLocationRelativeTo(null);
		setVisible(true);

	}// 여기까지

	public static void main(String[] args) {

		new B_FindingID();

	}

}
