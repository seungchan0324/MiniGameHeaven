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

	// 싱글톤 기법을 사용하려고 한다
	public static void getInstance(JPanel e, String title) {
		// static으로 선언했으므로 해당 메서드가 생성자보다도 먼저 호출된다
		instance = new DefaultFrame(e, title);// 생성자를 통해 기본 프레임 정의
		instance.getContentPane().removeAll();
		instance.getContentPane().add(e);

		instance.revalidate(); // 레이아웃 관리자에게 레이아웃정보를 다시 계산하도록 지시
		instance.repaint(); // 레이아웃을 새로 그린다
		e.setFocusable(true);
		e.requestFocus();
	}

}
