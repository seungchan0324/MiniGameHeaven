package login;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Babo extends JFrame {

	int cnt = 0;

	public Babo() {
		setTitle("ĳ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(768, 600);
		setLocationRelativeTo(null);
		
		JPanel mainPanel=new JPanel();
		mainPanel.setLayout(null);
		
		JLabel label=new JLabel();
		add(label);
		
		ImageIcon ic = new ImageIcon("����.png");
		JLabel gu = new JLabel(ic);
		gu.setBounds(130, 20, 500, 500);		
		add(gu);
		
		
		ImageIcon ic2 = new ImageIcon("jan.png");
		JLabel la = new JLabel(ic2);
		la.setBounds(130, 90, 500, 500);
		add(la);
		
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
                String[] messages = { "�����̸� ��õ�Ұ�", "����� ��õ�Ұ�", "������ ��õ�Ұ�", "����", "ī���� ��õ�Ұ�","���ö��� ��õ�Ұ�" };
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
                String[] messages = { "�ȵ�", "�Ⱦ�", "���ƿ�", "������ �־�" };
                String message = messages[new Random().nextInt(messages.length)];
                label.setBounds(180, 60, 400, 50);
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setFont(new Font("���� ���", Font.BOLD, 30));
                label.setText(message);
            }
        });
        
        

		
		
	
		setLayout(null);
		setResizable(false);
		setVisible(true);
	}

}
