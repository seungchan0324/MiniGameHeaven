package login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Main_Interface.Main_Interface;
import defaultFrame.DefaultFrame;
import defaultFrame.RoundedButton;
import my_Information.MyInformationPanel;
import register.FindingID;
import register.FindingPASS;
import register.Register;
import register.RegisterView;

public class Logintest extends JPanel {
	Font font = new Font("���� ���", Font.BOLD, 16);
	private JTextField userIdField;
	private JPasswordField passwordField;
	private RoundedButton loginButton, registerbutton, findidbutton, findpasswordbutton;
	public static String name;

	public Logintest() {
		setLayout(null);

		ImageIcon icon2 = new ImageIcon("logo.png");
		Image changeimg = icon2.getImage();
		Image changeImg = changeimg.getScaledInstance(600, 137, Image.SCALE_SMOOTH);
		icon2 = new ImageIcon(changeImg);
		JLabel lab2 = new JLabel(icon2);
		lab2.setBounds(84, 80, 600, 137);
		add(lab2);

		userIdField = new JTextField(13);
		userIdField.setText("���̵�");
		userIdField.setBounds(235, 250, 250, 30);
		userIdField.setPreferredSize(new Dimension(300, 40));
		userIdField.setForeground(Color.LIGHT_GRAY);
		add(userIdField);

		userIdField.addFocusListener(new FocusListener() { // �̺�Ʈ
			@Override
			public void focusGained(FocusEvent e) {
				if (userIdField.getText().equals("���̵�")) {
					userIdField.setText(""); // �⺻ �ؽ�Ʈ�� ������ �����
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (userIdField.getText().equals("")) {
					userIdField.setText("���̵�"); // �ٸ� �ʵ忡 ��Ŀ�� �߻��ϸ� �ٽ� �⺻ �ؽ�Ʈ ǥ��
					userIdField.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		userIdField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				userIdField.setForeground(Color.BLACK);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				userIdField.setForeground(Color.BLACK);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				userIdField.setForeground(Color.BLACK);
			}
		});

		passwordField = new JPasswordField(13);
		passwordField.setText("��й�ȣ");
		passwordField.setBounds(235, 300, 250, 30);
		passwordField.setPreferredSize(new Dimension(300, 40));
		passwordField.setForeground(Color.LIGHT_GRAY);
		add(passwordField);

		passwordField.setEchoChar((char) 0);
		passwordField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf(passwordField.getPassword()).equals("��й�ȣ")) {
					passwordField.setText("");
					passwordField.setEchoChar('*'); // ��й�ȣ �Է½� *�� ���̰�
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (String.valueOf(passwordField.getPassword()).equals("")) {
					passwordField.setText("��й�ȣ"); // ��Ŀ�� �Ҿ��� �� �ٽ� �⺻ �ؽ�Ʈ ǥ��
					passwordField.setEchoChar((char) 0); // �ؽ�Ʈ�� ���̵��� ����
					passwordField.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		passwordField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				passwordField.setForeground(Color.BLACK);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				passwordField.setForeground(Color.BLACK);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				passwordField.setForeground(Color.BLACK);
			}
		});
		passwordField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				if ((int) e.getKeyChar() == 10) {
					loginButton.doClick();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		loginButton = new RoundedButton(10);
		loginButton.setText("�α���");
		loginButton.setFont(font);
		loginButton.setBounds(240, 360, 240, 35);
		loginButton.setBackground(new Color(39, 174, 96));
		loginButton.setForeground(Color.white);
		add(loginButton);

		registerbutton = new RoundedButton(10);
		registerbutton.setText("ȸ������");
		registerbutton.setFont(font);
		registerbutton.setBounds(240, 410, 240, 35);
		registerbutton.setBackground(new Color(94, 94, 94));
		registerbutton.setForeground(Color.white);
		add(registerbutton);

		findidbutton = new RoundedButton(10);
		findidbutton.setText("ID ã��");
		findidbutton.setText("ID ã��");
		findidbutton.setBounds(240, 460, 115, 35);
		findidbutton.setBackground(new Color(94, 94, 94));
		findidbutton.setForeground(Color.white);
		findidbutton.setFont(font);
		add(findidbutton);

		findpasswordbutton = new RoundedButton(10);
		findpasswordbutton.setText("PW ã��");
		findpasswordbutton.setFont(font);
		findpasswordbutton.setBounds(365, 460, 115, 35);
		findpasswordbutton.setBackground(new Color(94, 94, 94));
		findpasswordbutton.setForeground(Color.white);
		add(findpasswordbutton);

		ImageIcon icon = new ImageIcon("lo.png");
		JLabel label = new JLabel(icon);
		label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		add(label);

		registerbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.getWindowAncestor(registerbutton).setVisible(false);
				DefaultFrame.getInstance(new RegisterView(), "ȸ������");
			}
		});

		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (userIdField.getText().equals("soldesk") || Register.hm.containsKey(userIdField.getText())) {
					try {
						if (new String(passwordField.getPassword()).equals("1234")) {
							name = "soldesk";
							JOptionPane.showMessageDialog(null, "soldesk�� �ݰ����ϴ�!");
							SwingUtilities.getWindowAncestor(loginButton).setVisible(false);
							DefaultFrame.getInstance(new Main_Interface(), "���� ȭ��");
							MyInformationPanel.money = 100000;
						} else if (Register.hm.get(userIdField.getText()).getPass()
								.equals(new String(passwordField.getPassword()))) {
							name = Register.hm.get(userIdField.getText()).getID();
							JOptionPane.showMessageDialog(null,
									Register.hm.get(userIdField.getText()).getEmail() + "�� �ݰ����ϴ�!");
							SwingUtilities.getWindowAncestor(loginButton).setVisible(false);
							DefaultFrame.getInstance(new Main_Interface(), "���� ȭ��");
							MyInformationPanel.money = Register.hm.get(userIdField.getText()).getPoint();
						} else {
							JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� Ʋ���̽��ϴ�.");
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� Ʋ���̽��ϴ�.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "�������� �ʴ� ���̵��Դϴ�.");
				}
			}
		});

		findidbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new FindingID();

			}
		});

		findpasswordbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new FindingPASS();

			}
		});

	}

}
