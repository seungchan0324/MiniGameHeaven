package join;

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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import infinityStair.StartFrame;
import login.Logintest;

public class A_JoinView extends JFrame {

	private JTextArea agree;
	private Checkbox yes;

	public A_JoinView() {

		setTitle("회원 가입");
		setSize(768, 600);
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// =========================기본 프레임 설정=================================

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth=2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(8, 10, 8, 10);
		Font font = new Font("나눔고딕", Font.PLAIN, 14);
		Font font2 = new Font("나눔고딕", Font.BOLD, 42);
		panel.setBackground(new Color(255, 255, 244));
		panel.setFont(font);

		//////////////////////////////////////////////

		JLabel la0 = new JLabel("     회원 가입");
		la0.setFont(font2);
		gbc.gridy++;
		panel.add(la0, gbc);

		JTextField idField = new JTextField("아이디");
		idField.setFont(font);
		idField.setPreferredSize(new Dimension(300, 40));
		idField.setForeground(Color.LIGHT_GRAY);

		idField.addFocusListener(new FocusListener() { // 이벤트
			@Override
			public void focusGained(FocusEvent e) {
				if (idField.getText().equals("아이디")) {
					idField.setText(""); // 기본 텍스트가 있으면 지우기
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (idField.getText().equals("")) {
					idField.setText("아이디"); // 다른 필드에 포커스 발생하면 다시 기본 텍스트 표시
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
		panel.add(idField, gbc);

		JPasswordField passField = new JPasswordField("비밀번호");
		passField.setFont(font);
		passField.setForeground(Color.LIGHT_GRAY);
		passField.setPreferredSize(new Dimension(300, 40));

		passField.setEchoChar((char) 0);
		passField.addFocusListener(new FocusListener() { 
			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf(passField.getPassword()).equals("비밀번호")) {
					passField.setText("");
					passField.setEchoChar('*'); // 비밀번호 입력시 *로 보이게
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (String.valueOf(passField.getPassword()).equals("")) {
					passField.setText("비밀번호"); // 포커스 잃었을 때 다시 기본 텍스트 표시
					passField.setEchoChar((char) 0); // 텍스트가 보이도록 설정
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
		panel.add(passField, gbc);

		JTextField emailField = new JTextField("이메일");
		emailField.setFont(font);
		emailField.setPreferredSize(new Dimension(300, 40));
		emailField.setForeground(Color.LIGHT_GRAY);

		emailField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (emailField.getText().equals("이메일")) {
					emailField.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (emailField.getText().equals("")) {
					emailField.setText("이메일");
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
		panel.add(emailField, gbc);

		JTextField birthdayField = new JTextField("생년월일(YYMMDD 모양의 여섯 자리 숫자)");
		birthdayField.setFont(font);
		birthdayField.setPreferredSize(new Dimension(300, 40));
		birthdayField.setForeground(Color.LIGHT_GRAY);

		birthdayField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (birthdayField.getText().equals("생년월일(YYMMDD 모양의 여섯 자리 숫자)")) {
					birthdayField.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (birthdayField.getText().equals("")) {
					birthdayField.setText("생년월일(YYMMDD 모양의 여섯 자리 숫자)");
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
		panel.add(birthdayField, gbc);

		// ============================정보입력 필드=================================

		JLabel la5 = new JLabel("개인 정보 제공 동의");
		la5.setFont(font);
		la5.setForeground(Color.blue);
		gbc.gridy++;
		gbc.gridwidth = 1;
		gbc.anchor=GridBagConstraints.WEST;
		panel.add(la5, gbc);

		la5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				toggleAgreeVisibility();
			}
		});

		yes = new Checkbox("", true);
		gbc.gridx++;
		gbc.anchor = GridBagConstraints.EAST;
		panel.add(yes, gbc);

		
		
		agree = new JTextArea();
		agree.setFont(font);
		agree.setPreferredSize(new Dimension(300, 155));

		agree.append(
				"귀하께서 회원 가입 시 입력하신 개인 정보를 '미니게임천국' 서비스 종료 시점까지 당사에서 보관하는 것에 동의합니다. 보관 중인 개인 정보는 기본 회원 식별 절차 및 '미니게임천국' 서비스 제공 외 당사와 제휴된 소셜커머스 마케팅 업체에 제공될 수 있으며 각종 빅데이터 기반 서비스 개발에 활용될 수 있습니다. 귀하께서는 개인 정보 제공에 미동의하실 수 있으나 그 경우 당사가 제공하는 일체의 서비스 이용이 불가능합니다.");
		agree.setEditable(false);
		agree.setLineWrap(true);
		agree.setVisible(false);
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		gbc.anchor=GridBagConstraints.WEST;
		gbc.gridy++;
		panel.add(agree, gbc);

		// ============================텍스트 필드==================================

		JButton bt = new JButton("회원 가입하기");
		bt.setFont(font);
		bt.setForeground(Color.white);
		bt.setBackground(Color.DARK_GRAY);

		// 체크박스 미선택시 버튼 비활성화
		yes.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				bt.setEnabled(yes.getState());

			}
		});

		// 정보비교
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id = idField.getText();
				String pass = new String(passField.getPassword());
				String email = emailField.getText();
				String birthday = birthdayField.getText();

				if (A_Join.hm.containsKey(id)) {
					JOptionPane.showMessageDialog(null, "중복된 아이디입니다.");
					return;
				}
				if (A_Join.emailcheck(email)) {
					JOptionPane.showMessageDialog(null, "중복된 이메일입니다.");
					return;
				}

				A_Join.Join join = new A_Join.Join(id, email, pass, birthday);
				A_Join.hm.put(id, join);

				JOptionPane.showMessageDialog(null, id + "님의 회원 가입이 완료되었습니다.\n로그인 페이지에서 로그인해 주세요.");
				dispose();
				StartFrame.getInstance(new Logintest());
			}
		});

		gbc.gridy++;
		gbc.gridx = 0;
		bt.setPreferredSize(new Dimension(300, 40));

		panel.add(bt, gbc);
		add(panel);
		setLocationRelativeTo(null);

		setVisible(true);

	}// 여기안에

	@Override
	public void addNotify() {
		super.addNotify();
		yes.requestFocusInWindow();
	}

	private void toggleAgreeVisibility() {
		agree.setVisible(!agree.isVisible());
	}

}
