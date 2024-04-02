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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class B_FindingPASS extends JFrame {

	public B_FindingPASS() {

		setTitle("��й�ȣ ã��");
		setSize(350, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// =========================�⺻ ������ ����=================================

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 5, 5, 5);
		Font font = new Font("Dotum", Font.PLAIN, 14);
		panel.setBackground(new Color(255, 255, 244));
		panel.setFont(font);

		JLabel la3 = new JLabel("���̵�");
		la3.setFont(font);
		panel.add(la3, gbc);

		JTextField idfind = new JTextField();
		idfind.setFont(font);
		idfind.setPreferredSize(new Dimension(300, 40));
		gbc.gridy++;
		panel.add(idfind, gbc);

		JLabel la1 = new JLabel("���� �� �Է��� �̸��� �ּ�");
		la1.setFont(font);
		gbc.gridy++;
		panel.add(la1, gbc);

		JTextField emailfind = new JTextField();
		emailfind.setFont(font);
		emailfind.setPreferredSize(new Dimension(300, 40));
		gbc.gridy++;
		panel.add(emailfind, gbc);

		JLabel la2 = new JLabel("�������(YYMMDD)");
		la2.setFont(font);
		gbc.gridy++;
		panel.add(la2, gbc);

		JTextField birthdayfind = new JTextField();
		birthdayfind.setFont(font);
		birthdayfind.setPreferredSize(new Dimension(300, 40));
		gbc.gridy++;
		panel.add(birthdayfind, gbc);

		// ��ư ������ ��� ��µǴ� �ؽ�Ʈ��
		JLabel result = new JLabel();
		result.setFont(font);
		gbc.gridy++;
		panel.add(result, gbc);

		//////////////////////////////////////////

		JButton bt = new JButton("��й�ȣ ã��");
		bt.setFont(font);
		bt.setForeground(Color.white);
		bt.setBackground(Color.DARK_GRAY);
		bt.setPreferredSize(new Dimension(300, 40));

		bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String id = idfind.getText();
				String email = emailfind.getText();
				String birthday = birthdayfind.getText();
				boolean found = false;

				for (A_Join.Join join : A_Join.hm.values()) {
					if (join != null && join.id.equals(id) && join.email.equals(email)
							&& join.birthday.equals(birthday)) {

						result.setText("ȸ������ ��й�ȣ�� " + join.pass + "�Դϴ�.");
						found = true;
						break;

					}
				}

				if (!found) {
					result.setText("ȸ�� ������ �������� �ʽ��ϴ�.");

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

	}// �������

	public static void main(String[] args) {

		new B_FindingPASS();
	}

}
