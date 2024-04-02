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

		setTitle("우주로");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 800);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				instance.dispose();
				DefaultFrame.getInstance(new GameDescription(1), "게임 설명 화면");
			}
		});

	}

	// 싱글톤 기법을 사용하려고 한다
	public static void getInstance(JPanel e) {
		// static으로 선언했으므로 해당 메서드가 생성자보다도 먼저 호출된다
		instance = new StartFrame(e);// 생성자를 통해 기본 프레임 정의
		instance.getContentPane().removeAll();
		instance.getContentPane().add(e);

		instance.revalidate(); // 레이아웃 관리자에게 레이아웃정보를 다시 계산하도록 지시
		instance.repaint(); // 레이아웃을 새로 그린다
		e.setFocusable(true);
		e.requestFocus();
	}

}
