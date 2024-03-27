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

		setTitle("회원 가입");
		setSize(400, 700);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// =========================기본 프레임 설정=================================

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 5, 5, 5);
		Font font = new Font("Dotum", Font.PLAIN, 16);
		panel.setBackground(new Color(255, 255, 219));
		panel.setFont(font);

		JLabel la1 = new JLabel("아이디");
		la1.setFont(font);
		panel.add(la1, gbc);

		JTextField idField = new JTextField();
		idField.setFont(font);
		idField.setPreferredSize(new Dimension(350, 50));
		gbc.gridy++;
		panel.add(idField, gbc);

		JLabel la2 = new JLabel("비밀번호");
		la2.setFont(font);
		gbc.gridy++;
		panel.add(la2, gbc);

		JTextField passField = new JTextField();
		passField.setFont(font);
		passField.setPreferredSize(new Dimension(350, 50));
		gbc.gridy++;
		panel.add(passField, gbc);

		JLabel la3 = new JLabel("이메일");
		la3.setFont(font);
		gbc.gridy++;
		panel.add(la3, gbc);

		JTextField emailField = new JTextField();
		emailField.setFont(font);
		emailField.setPreferredSize(new Dimension(350, 50));
		gbc.gridy++;
		panel.add(emailField, gbc);

		JLabel la4 = new JLabel("생년월일(YYMMDD 모양의 여섯 자리 숫자)");
		la4.setFont(font);
		gbc.gridy++;
		panel.add(la4, gbc);

		JTextField birthdayField = new JTextField();
		birthdayField.setFont(font);
		birthdayField.setPreferredSize(new Dimension(350, 50));
		gbc.gridy++;
		panel.add(birthdayField, gbc);

		JLabel la5 = new JLabel("개인 정보 제공 동의 여부");
		la5.setFont(font);
		gbc.gridy++;
		panel.add(la5, gbc);

		TextArea agree = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		agree.setFont(font);
		agree.setPreferredSize(new Dimension(350, 150));
		gbc.gridy++;
		agree.append(
				"귀하께서 회원 가입 시 입력하신 개인 정보를 '미니게임천국' 서비스 종료 시점까지 당사에서 보관하는 것에 동의합니다. 보관 중인 개인 정보는 기본 회원 식별 절차 및 '미니게임천국' 서비스 제공 외 당사와 제휴된 소셜커머스 마케팅 업체에 제공될 수 있으며 각종 빅데이터 기반 서비스 개발에 활용될 수 있습니다. 귀하께서는 개인 정보 제공에 미동의하실 수 있으나 그 경우 당사가 제공하는 일체의 서비스 이용이 불가능합니다.");
		agree.setEditable(false);
		panel.add(agree, gbc);

		Checkbox yes = new Checkbox("동의합니다.", true);
		gbc.gridy++;
		panel.add(yes, gbc);

		// ============================텍스트 필드==================================

		JButton bt = new JButton("회원 가입");
		bt.setBackground(new Color(200, 200, 200));
		bt.setFont(font);

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
				String pass = passField.getText();
				String email = emailField.getText();
				String birthday = birthdayField.getText();

				if (Register.hm.containsKey(id)) {
					JOptionPane.showMessageDialog(null, "중복된 아이디입니다.");
					return;
				}
				if (Register.emailcheck(email)) {
					JOptionPane.showMessageDialog(null, "중복된 이메일입니다.");
					return;
				}

				Register.Join join = new Register.Join(id, email, pass, birthday);
				Register.hm.put(id, join);

				JOptionPane.showMessageDialog(null, id + "님의 회원 가입이 완료되었습니다.\n로그인 페이지에서 로그인해 주세요.");
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

	}// 여기안에

}
