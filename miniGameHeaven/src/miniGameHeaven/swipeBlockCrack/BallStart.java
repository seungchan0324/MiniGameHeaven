package swipeBlockCrack;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

class MyBall extends JPanel implements ActionListener {
	// 이미지 파일을 담기 위한 BufferedImage 객체 변수를 생성
	private BufferedImage image;
	// 타이머 객체도 생성
	private Timer timer;
	private int x, y;

	public MyBall() {
		System.out.println("asdasdasd");
		// setSize(), setPreferrendSize() 쓸 수 있는게 다름
		setDoubleBuffered(true);// 그림을 넣을 메모리 활성화. 없어도 되긴함..
		// 이미지 파일 객체 생성
		File input = new File("C:\\temp\\Ball.png");
		try {
			// imput에 가져온 이미지 파일을 버퍼이미지에 저장
			image = ImageIO.read(input);
		} catch (IOException e) { // 예외처리
			e.printStackTrace();
		} // 이미지를 읽는다.
		x = GamePanel.ballPointX;
		y = GamePanel.panelMainBottom;

		// 타이머 생성자, 1이상이면 어떤 값이 들어와도 동일한 결과가 수행되며
		// 0이하에서는 매우 빠른 속도로 움직인다.
		timer = new Timer(10, this); // 10ms 간격으로 actionPerformed 호출
		timer.start(); // 타이머 객체를 생성하고 시작
		
	}

	// MyPanel1 메소드는 초기 이미지 조건 파일 객체 등 생성만 담당하고
	// 나머지 이미지의 동작은 모두 아래 메소드들이 하는 것 같다.
	@Override
	// 그래픽을 출력하는 메소드
	public void paintComponent(Graphics g) {
		// 그래픽 객체를 paintComponent 메소드로 이동시킴
		// 그림그리려면 필수. 첫문장에 나와야함.
		super.paintComponent(g);
		// 이미지를 화면에 그린다.
		// drawImage 메소드가 없으면 그림이 생성되지 않는다.
		g.drawImage(image, x, y, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 이벤트가 발생하면 좌표를 해당 픽셀 만큼 이동시킴
		x += 20 * (30 / GamePanel.ballMiddlePointX);
		y -= 20 * (30 / 259); // y는 -일수록 높아짐
		// 이미지 객체가 범위를 벗어난 초기 위치로 이동시킴
		// 동작이 완료되면 repaint 메소드로 이미지를 갱신
		// repaint 메소드가 없으면 그림이 이동하지 않는다.
		repaint();
	}
	
	
	
	public void updatePosition() {
        // 여기서 원하는 위치로 공을 이동시킬 수 있도록 구현합니다.
        // 예를 들어, x, y 값을 새로운 위치로 설정하고 repaint() 메소드를 호출하여 다시 그리도록 합니다.
		x += 20 * (30 / GamePanel.ballMiddlePointX);
		y -= 20 * (30 / 259);
	    
	    // 패널을 다시 그리도록 repaint() 메서드를 호출합니다.
	    repaint();
    }
	
}

public class BallStart {

	public BallStart() {

		GamePanel.panelMain.add(new MyBall());
		
	}

}
