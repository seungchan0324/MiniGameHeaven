package defaultFrame;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DefaultFrame extends JFrame {

	public static DefaultFrame instance;

	private DefaultFrame(JPanel e, String title) {

		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(768, 600);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

	}

	// �̱��� ����� ����Ϸ��� �Ѵ�
	public static void getInstance(JPanel e, String title) {
		// static���� ���������Ƿ� �ش� �޼��尡 �����ں��ٵ� ���� ȣ��ȴ�
		instance = new DefaultFrame(e, title);// �����ڸ� ���� �⺻ ������ ����
		instance.getContentPane().removeAll();
		instance.getContentPane().add(e);

		instance.revalidate(); // ���̾ƿ� �����ڿ��� ���̾ƿ������� �ٽ� ����ϵ��� ����
		instance.repaint(); // ���̾ƿ��� ���� �׸���
		e.setFocusable(true);
		e.requestFocus();
	}

}
