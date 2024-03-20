package infinityStair;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartFrame extends JFrame {

	private static StartFrame instance;
	
	private StartFrame(JPanel e) {
		setTitle("무한의 계단");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(e);
		setSize(600, 1000);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	// 싱글톤 기법을 사용하려고 한다
		public static void getInstance(JPanel e) {
			// static으로 선언했으므로 해당 메서드가 생성자보다도 먼저 호출된다
			instance = new StartFrame(e);// 생성자를 통해 기본 프레임 정의

			instance.getContentPane().removeAll();
			instance.getContentPane().add(e);

			instance.revalidate(); // 레이아웃 관리자에게 레이아웃정보를 다시 계산하도록 지시
			instance.repaint(); // 레이아웃을 새로 그린다
		}
	
}
