package infinityStair;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartFrame extends JFrame {

	public static StartFrame instance;
	
	public StartFrame() {
	}
	
	private StartFrame(JPanel e) {
		
		setTitle("���ַ�");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 800);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setVisible(true);

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
