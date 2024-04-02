package infinityStair;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import defaultFrame.DefaultFrame;
import gameDescription.GameDescription;

public class StartFrame extends JFrame {

	public static StartFrame instance;

	private StartFrame(JPanel e) {

		setTitle("���ַ�");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 800);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				instance.dispose();
				DefaultFrame.getInstance(new GameDescription(1), "���� ���� ȭ��");
			}
		});

	}

	// �̱��� ����� ����Ϸ��� �Ѵ�
	public static void getInstance(JPanel e) {
		// static���� ���������Ƿ� �ش� �޼��尡 �����ں��ٵ� ���� ȣ��ȴ�
		instance = new StartFrame(e);// �����ڸ� ���� �⺻ ������ ����
		instance.getContentPane().removeAll();
		instance.getContentPane().add(e);

		instance.revalidate(); // ���̾ƿ� �����ڿ��� ���̾ƿ������� �ٽ� ����ϵ��� ����
		instance.repaint(); // ���̾ƿ��� ���� �׸���
		e.setFocusable(true);
		e.requestFocus();
	}

}
