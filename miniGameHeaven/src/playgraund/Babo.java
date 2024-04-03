package playgraund;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Set;

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
	JLabel foodlabel,godonglabel,billlabel,patpatlabel;

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
		myinformation_button.setBounds(568, 50, 100, 40);
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
		
		ImageIcon patimg = new ImageIcon("���ٵ��.png");
		Image patchangeimg = patimg.getImage();
		Image patscaleimg = patchangeimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		patimg.setImage(patscaleimg);
		RoundedButton but1 = new RoundedButton(60);
		but1.setIcon(patimg);
		but1.setBounds(140, 460, 60, 60);
		but1.setFont(new Font("���� ���", Font.BOLD, 10));
		but1.setOpaque(false);// �г� �����ϰ�
		add(but1);

		ImageIcon eatimg = new ImageIcon("���� ���ñ�.png");
		Image eatchangeimg = eatimg.getImage();
		Image eatscaleimg = eatchangeimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		eatimg.setImage(eatscaleimg);
		RoundedButton but2 = new RoundedButton(60);
		but2.setIcon(eatimg);
		but2.setBounds(340, 460, 60, 60);
		but2.setFont(new Font("���� ���", Font.BOLD, 10));
		but2.setOpaque(false);// �г� �����ϰ�
		add(but2);
		
		ImageIcon godongimg = new ImageIcon("�Ҷ��.png");
		Image godongchangeimg = godongimg.getImage();
		Image godongscaleimg = godongchangeimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		godongimg.setImage(godongscaleimg);
		RoundedButton but3 = new RoundedButton(60);
		but3.setIcon(godongimg);
		but3.setBounds(540, 460, 60, 60);
		but3.setFont(new Font("���� ���", Font.BOLD, 10));
		but3.setOpaque(false);// �г� �����ϰ�
		add(but3);

		// ��ư 1 �׼� ������
		but1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �������� �޽��� ����
				if(foodlabel!=null) {
					remove(foodlabel);
				}
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
				
				if(foodlabel!=null) {
					remove(foodlabel);
				}
				String[] food = { "����.png", "ġŲ.png", "�ܹ���.png", "Ÿ��.png","�丶��.png" };
				String[] messages = { "���ڸ� ��õ�Ұ�","ġŲ�� ��õ�Ұ�","�ܹ��Ÿ� ��õ�Ұ�", "Ÿ�ڸ� ��õ�Ұ�", "��⸦ ��õ�Ұ�" };
				int i = (int) (Math.random() * 5); // �������� ��ġ
				ImageIcon foodimg = new ImageIcon(food[i]);
				Image changeimg = foodimg.getImage();
				Image scaleimg = changeimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
				foodimg.setImage(scaleimg);
				foodlabel = new JLabel(foodimg);
				foodlabel.setBounds(20, 60, 450, 70);
				add(foodlabel);
				
				label.setBounds(180, 60, 450, 70);
				label.setHorizontalAlignment(JLabel.CENTER);
				label.setFont(new Font("���� ���", Font.BOLD, 30));
				label.setText(messages[i]);
				setVisible(true);

			}
		});

		// ��ư 3 �׼� ������
		but3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �������� �޽��� ����
				if(foodlabel!=null) {
					remove(foodlabel);
				}
				
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
