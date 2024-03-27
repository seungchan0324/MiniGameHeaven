package register;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegisterView extends JFrame {

	public RegisterView() {

		setTitle("ȸ�� ����");
		setSize(400, 700);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// =========================�⺻ ������ ����=================================

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 5, 5, 5);
		Font font = new Font("Dotum", Font.PLAIN, 16);
		panel.setBackground(new Color(255, 255, 219));
		panel.setFont(font);

		JLabel la1 = new JLabel("���̵�");
		la1.setFont(font);
		panel.add(la1, gbc);

		JTextField idField = new JTextField();
		idField.setFont(font);
		idField.setPreferredSize(new Dimension(350, 50));
		gbc.gridy++;
		panel.add(idField, gbc);

		JLabel la2 = new JLabel("��й�ȣ");
		la2.setFont(font);
		gbc.gridy++;
		panel.add(la2, gbc);

		JTextField passField = new JTextField();
		passField.setFont(font);
		passField.setPreferredSize(new Dimension(350, 50));
		gbc.gridy++;
		panel.add(passField, gbc);

		JLabel la3 = new JLabel("�̸���");
		la3.setFont(font);
		gbc.gridy++;
		panel.add(la3, gbc);

		JTextField emailField = new JTextField();
		emailField.setFont(font);
		emailField.setPreferredSize(new Dimension(350, 50));
		gbc.gridy++;
		panel.add(emailField, gbc);

		JLabel la4 = new JLabel("�������(YYMMDD ����� ���� �ڸ� ����)");
		la4.setFont(font);
		gbc.gridy++;
		panel.add(la4, gbc);

		JTextField birthdayField = new JTextField();
		birthdayField.setFont(font);
		birthdayField.setPreferredSize(new Dimension(350, 50));
		gbc.gridy++;
		panel.add(birthdayField, gbc);

		JLabel la5 = new JLabel("���� ���� ���� ���� ����");
		la5.setFont(font);
		gbc.gridy++;
		panel.add(la5, gbc);

		TextArea agree = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		agree.setFont(font);
		agree.setPreferredSize(new Dimension(350, 150));
		gbc.gridy++;
		agree.append(
				"���ϲ��� ȸ�� ���� �� �Է��Ͻ� ���� ������ '�̴ϰ���õ��' ���� ���� �������� ��翡�� �����ϴ� �Ϳ� �����մϴ�. ���� ���� ���� ������ �⺻ ȸ�� �ĺ� ���� �� '�̴ϰ���õ��' ���� ���� �� ���� ���޵� �Ҽ�Ŀ�ӽ� ������ ��ü�� ������ �� ������ ���� ������ ��� ���� ���߿� Ȱ��� �� �ֽ��ϴ�. ���ϲ����� ���� ���� ������ �̵����Ͻ� �� ������ �� ��� ��簡 �����ϴ� ��ü�� ���� �̿��� �Ұ����մϴ�.");
		agree.setEditable(false);
		panel.add(agree, gbc);

		Checkbox yes = new Checkbox("�����մϴ�.", true);
		gbc.gridy++;
		panel.add(yes, gbc);

		// ============================�ؽ�Ʈ �ʵ�==================================

		JButton bt = new JButton("ȸ�� ����");
		bt.setBackground(new Color(200, 200, 200));
		bt.setFont(font);

		// üũ�ڽ� �̼��ý� ��ư ��Ȱ��ȭ
		yes.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				bt.setEnabled(yes.getState());

			}
		});

		// ������
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id = idField.getText();
				String pass = passField.getText();
				String email = emailField.getText();
				String birthday = birthdayField.getText();

				if (Register.hm.containsKey(id)) {
					JOptionPane.showMessageDialog(null, "�ߺ��� ���̵��Դϴ�.");
					return;
				}
				if (Register.emailcheck(email)) {
					JOptionPane.showMessageDialog(null, "�ߺ��� �̸����Դϴ�.");
					return;
				}

				Register.Join join = new Register.Join(id, email, pass, birthday);
				Register.hm.put(id, join);

				JOptionPane.showMessageDialog(null, id + "���� ȸ�� ������ �Ϸ�Ǿ����ϴ�.\n�α��� ���������� �α����� �ּ���.");
				dispose();
			}
		});
		gbc.gridy++;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel.add(bt, gbc);

		add(panel);
		setLocationRelativeTo(null);

		setVisible(true);

	}// ����ȿ�

}
