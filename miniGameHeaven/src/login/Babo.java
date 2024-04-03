package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Main_Interface.Main_Interface;
import defaultFrame.DefaultFrame;
import defaultFrame.RoundedButton;
import my_Information.MyInformationCharacter;
import my_Information.MyInformationPanel;

public class Babo extends JPanel {
	private ImageIcon characterimg;
	private RoundedButton myinformation_button, main_button;
	private JLabel my_button_text, main_button_text;
	private Font font = new Font("���� ���", Font.BOLD, 10);
	private Font gobuttonfont = new Font("���� ���", Font.BOLD, 16);
	int cnt = 0;

	public Babo() {
		setSize(768, 600);
		setLayout(null);
		setBackground(new Color(255, 255, 244));

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);

		JLabel label = new JLabel();
		add(label);

		if(MyInformationCharacter.characterselect.equals( "Gumi")) {
			characterimg = new ImageIcon("����������.png");
		}else if(MyInformationCharacter.characterselect.equals( "Dalri")) {
			characterimg = new ImageIcon("�������޸�.png");
		}else {
			characterimg = new ImageIcon("�����.png");
		}
		
		JLabel character = new JLabel(characterimg);
		character.setBounds(130, 20, 500, 500);
		add(character);

		ImageIcon ic2 = new ImageIcon("jan.png");
		JLabel field = new JLabel(ic2);
		field.setBounds(130, 90, 500, 500);
		add(field);
		
		my_button_text = new JLabel("�� ����");
		my_button_text.setFont(gobuttonfont);
		my_button_text.setForeground(new Color(120, 120, 120));
		my_button_text.setBounds(25, -2, 100, 40);
		myinformation_button = new RoundedButton(40);
		myinformation_button.add(my_button_text);
		myinformation_button.setBackground(new Color(230, 230, 230));
		myinformation_button.setLayout(null);
		myinformation_button.setBounds(550, 50, 100, 40);
		myinformation_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.windowForComponent(myinformation_button).setVisible(false);
				DefaultFrame.getInstance(new MyInformationPanel(), "�� ����");
			}
		});
		add(myinformation_button);
		
		main_button_text = new JLabel("����");
		main_button_text.setFont(gobuttonfont);
		main_button_text.setForeground(new Color(120, 120, 120));
		main_button_text.setBounds(35, -2, 100, 40);
		main_button = new RoundedButton(40);
		main_button.add(main_button_text);
		main_button.setBackground(new Color(230, 230, 230));
		main_button.setLayout(null);
		main_button.setBounds(100, 50, 100, 40);
		main_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.windowForComponent(main_button).setVisible(false);
				DefaultFrame.getInstance(new Main_Interface(), "���� ȭ��");
			}
		});
		add(main_button);
		
		JButton but1 = new JButton("�λ�");
		but1.setBounds(120, 480, 120, 40);
		but1.setFont(new Font("���� ���", Font.BOLD, 10));
		but1.setVisible(true);
		add(but1);

		JButton but2 = new JButton("������");
		but2.setBounds(320, 480, 120, 40);
		but2.setFont(new Font("���� ���", Font.BOLD, 10));
		but2.setVisible(true);
		add(but2);

		JButton but3 = new JButton("������ �Ҷ��");
		but3.setBounds(520, 480, 120, 40);
		but3.setFont(new Font("���� ���", Font.BOLD, 10));
		but3.setVisible(true);
		add(but3);

		// ��ư 1 �׼� ������
		but1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �������� �޽��� ����
				String[] messages = { "�ȳ� �ݰ���", "�� �̸��� ���̾�", "���� ������ ����~" };
				String message = messages[new Random().nextInt(messages.length)];
				label.setBounds(180, 60, 400, 50);
				label.setHorizontalAlignment(JLabel.CENTER);
				label.setFont(new Font("���� ���", Font.BOLD, 30));
				label.setText(message);
			}
		});

		// ��ư 2 �׼� ������
		but2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �������� �޽��� ����
				String[] messages = { "�����̸� ��õ�Ұ�", "����� ��õ�Ұ�", "������ ��õ�Ұ�", "����", "ī���� ��õ�Ұ�" };
				String message = messages[new Random().nextInt(messages.length)];
				label.setBounds(180, 60, 400, 50);
				label.setHorizontalAlignment(JLabel.CENTER);
				label.setFont(new Font("���� ���", Font.BOLD, 30));
				label.setText(message);

			}
		});

		// ��ư 3 �׼� ������
		but3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �������� �޽��� ����
				String[] messages = { "�ȵ�", "�Ⱦ�", "������" };
				String message = messages[new Random().nextInt(messages.length)];
				label.setBounds(180, 60, 400, 50);
				label.setHorizontalAlignment(JLabel.CENTER);
				label.setFont(new Font("���� ���", Font.BOLD, 30));
				label.setText(message);
			}
		});

	}

}
