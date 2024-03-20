package infinityStair;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartFrame extends JFrame {

	private static StartFrame instance;
	
	private StartFrame(JPanel e) {
		setTitle("������ ���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(e);
		setSize(600, 1000);
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
		}
	
}
