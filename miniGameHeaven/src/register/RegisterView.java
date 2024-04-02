package register;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import defaultFrame.DefaultFrame;
import login.Logintest;

public class RegisterView extends JPanel {

	private JTextArea agree;
	private Checkbox yes;

	public RegisterView() {

		// =========================�⺻ ������ ����=================================
		setBounds(0, 0, 768, 600);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 10, 5, 10);
		Font font = new Font("�������", Font.PLAIN, 14);
		Font agreefont = new Font("�������", Font.PLAIN, 13);
		Font font2 = new Font("�������", Font.BOLD, 42);
		setBackground(new Color(255, 255, 244));

		//////////////////////////////////////////////

		JLabel la0 = new JLabel("     ȸ�� ����");
		la0.setFont(font2);
		gbc.gridy++;
		add(la0, gbc);

		JTextField idField = new JTextField("���̵�");
		idField.setFont(font);
		idField.setPreferredSize(new Dimension(300, 40));
		idField.setForeground(Color.LIGHT_GRAY);

		idField.addFocusListener(new FocusListener() { // �̺�Ʈ
			@Override
			public void focusGained(FocusEvent e) {
				if (idField.getText().equals("���̵�")) {
					idField.setText(""); // �⺻ �ؽ�Ʈ�� ������ �����
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (idField.getText().equals("")) {
					idField.setText("���̵�"); // �ٸ� �ʵ忡 ��Ŀ�� �߻��ϸ� �ٽ� �⺻ �ؽ�Ʈ ǥ��
					idField.setForeground(Color.LIGHT_GRAY);
				}
			}
		});

		idField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				idField.setForeground(Color.BLACK);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				idField.setForeground(Color.BLACK);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				idField.setForeground(Color.BLACK);
			}
		});

		gbc.gridy++;
		add(idField, gbc);

		JPasswordField passField = new JPasswordField("��й�ȣ");
		passField.setFont(font);
		passField.setForeground(Color.LIGHT_GRAY);
		passField.setPreferredSize(new Dimension(300, 40));

		passField.setEchoChar((char) 0);
		passField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf(passField.getPassword()).equals("��й�ȣ")) {
					passField.setText("");
					passField.setEchoChar('*'); // ��й�ȣ �Է½� *�� ���̰�
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (String.valueOf(passField.getPassword()).equals("")) {
					passField.setText("��й�ȣ"); // ��Ŀ�� �Ҿ��� �� �ٽ� �⺻ �ؽ�Ʈ ǥ��
					passField.setEchoChar((char) 0); // �ؽ�Ʈ�� ���̵��� ����
					passField.setForeground(Color.LIGHT_GRAY);
				}
			}
		});

		passField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				passField.setForeground(Color.BLACK);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				passField.setForeground(Color.BLACK);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				passField.setForeground(Color.BLACK);
			}
		});

		gbc.gridy++;
		add(passField, gbc);

		JTextField emailField = new JTextField("�̸���");
		emailField.setFont(font);
		emailField.setPreferredSize(new Dimension(300, 40));
		emailField.setForeground(Color.LIGHT_GRAY);

		emailField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (emailField.getText().equals("�̸���")) {
					emailField.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (emailField.getText().equals("")) {
					emailField.setText("�̸���");
					emailField.setForeground(Color.LIGHT_GRAY);
				}
			}
		});

		emailField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				emailField.setForeground(Color.BLACK);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				emailField.setForeground(Color.BLACK);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				emailField.setForeground(Color.BLACK);
			}
		});

		gbc.gridy++;
		add(emailField, gbc);

		JTextField birthdayField = new JTextField("�������(YYMMDD ����� ���� �ڸ� ����)");
		birthdayField.setFont(font);
		birthdayField.setPreferredSize(new Dimension(300, 40));
		birthdayField.setForeground(Color.LIGHT_GRAY);

		birthdayField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (birthdayField.getText().equals("�������(YYMMDD ����� ���� �ڸ� ����)")) {
					birthdayField.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (birthdayField.getText().equals("")) {
					birthdayField.setText("�������(YYMMDD ����� ���� �ڸ� ����)");
					birthdayField.setForeground(Color.LIGHT_GRAY);
				}
			}
		});

		birthdayField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				birthdayField.setForeground(Color.BLACK);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				birthdayField.setForeground(Color.BLACK);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				birthdayField.setForeground(Color.BLACK);
			}
		});

		gbc.gridy++;
		add(birthdayField, gbc);

		// ============================�����Է� �ʵ�=================================

		JLabel la5 = new JLabel("���� ���� ���� ����");
		la5.setFont(font);
		la5.setForeground(Color.blue);
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		add(la5, gbc);

		la5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				toggleAgreeVisibility();
			}
		});

		yes = new Checkbox("", true);
		gbc.gridx++;
		gbc.anchor = GridBagConstraints.EAST;
		add(yes, gbc);

		agree = new JTextArea();
		agree.setFont(agreefont);
		agree.setPreferredSize(new Dimension(300, 155));
		Border border = BorderFactory.createLineBorder(new Color(150, 150, 150));
		agree.setBorder(border);
		
		agree.append(
				"���ϲ��� ȸ�� ���� �� �Է��Ͻ� ���� ������ '�̴ϰ���õ��' ���� ���� �������� ��翡�� �����ϴ� �Ϳ� �����մϴ�. ���� ���� ���� ������ �⺻ ȸ�� �ĺ� ���� �� '�̴ϰ���õ��' ���� ���� �� ���� ���޵� �Ҽ�Ŀ�ӽ� ������ ��ü�� ������ �� ������ ���� ������ ��� ���� ���߿� Ȱ��� �� �ֽ��ϴ�. ���� ���� ������ �̵����� ��� ��簡 �����ϴ� ��ü�� ���� �̿��� �Ұ����մϴ�.");
		agree.setEditable(false);
		agree.setLineWrap(true);
		agree.setVisible(false);
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridy++;
		add(agree, gbc);

		// ============================�ؽ�Ʈ �ʵ�==================================

		JButton bt = new JButton("ȸ�� �����ϱ�");
		bt.setFont(font);
		bt.setForeground(Color.white);
		bt.setBackground(Color.DARK_GRAY);

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
				String pass = new String(passField.getPassword());
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
				/////////////////////////////////////////////////////
				if (idField.getText().equals("���̵�")) {
					JOptionPane.showMessageDialog(null, "���̵� �Է��ϼ���.");
					return;
				}
				if (passField.getText().equals("��й�ȣ")) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է��ϼ���.");
					return;
				}
				if (emailField.getText().equals("�̸���")) {
					JOptionPane.showMessageDialog(null, "�̸����� �Է��ϼ���.");
					return;
				}
				if (birthdayField.getText().equals("�������(YYMMDD ����� ���� �ڸ� ����)")) {
					JOptionPane.showMessageDialog(null, "��������� �Է��ϼ���.");
					return;
				}

				////////////////////////////////////////////////////
				int point = 0;
				Register.Join join = new Register.Join(id, email, pass, birthday, point);
				Register.hm.put(id, join);

				JOptionPane.showMessageDialog(null, id + "���� ȸ�� ������ �Ϸ�Ǿ����ϴ�.\n�α��� ���������� �α����� �ּ���.");
				SwingUtilities.getWindowAncestor(bt).setVisible(false);
				DefaultFrame.getInstance(new Logintest(), "�α���");
			}
		});

		gbc.gridy++;
		gbc.gridx = 0;
		bt.setPreferredSize(new Dimension(300, 40));

		add(bt, gbc);
	}// ����ȿ�

	@Override
	public void addNotify() {
		super.addNotify();
		yes.requestFocusInWindow();
	}

	private void toggleAgreeVisibility() {
		agree.setVisible(!agree.isVisible());
	}

}
