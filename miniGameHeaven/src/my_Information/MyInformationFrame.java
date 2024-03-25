package my_Information;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyInformationFrame extends JFrame {

	public static MyInformationFrame instance;

	private MyInformationFrame(JPanel e) {

		setTitle("�� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(768, 600);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setVisible(true);

	}

	// �̱��� ����� ����Ϸ��� �Ѵ�
	public static void getInstance(JPanel e) {
		// static���� ���������Ƿ� �ش� �޼��尡 �����ں��ٵ� ���� ȣ��ȴ�
		instance = new MyInformationFrame(e);// �����ڸ� ���� �⺻ ������ ����
		instance.getContentPane().removeAll();
		instance.getContentPane().add(e);

		instance.revalidate(); // ���̾ƿ� �����ڿ��� ���̾ƿ������� �ٽ� ����ϵ��� ����
		instance.repaint(); // ���̾ƿ��� ���� �׸���
		e.setFocusable(true);
		e.requestFocus();
	}

}
