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
	// �̹��� ������ ��� ���� BufferedImage ��ü ������ ����
	private BufferedImage image;
	// Ÿ�̸� ��ü�� ����
	private Timer timer;
	private int x, y;

	public MyBall() {
		System.out.println("asdasdasd");
		// setSize(), setPreferrendSize() �� �� �ִ°� �ٸ�
		setDoubleBuffered(true);// �׸��� ���� �޸� Ȱ��ȭ. ��� �Ǳ���..
		// �̹��� ���� ��ü ����
		File input = new File("C:\\temp\\Ball.png");
		try {
			// imput�� ������ �̹��� ������ �����̹����� ����
			image = ImageIO.read(input);
		} catch (IOException e) { // ����ó��
			e.printStackTrace();
		} // �̹����� �д´�.
		x = GamePanel.ballPointX;
		y = GamePanel.panelMainBottom;

		// Ÿ�̸� ������, 1�̻��̸� � ���� ���͵� ������ ����� ����Ǹ�
		// 0���Ͽ����� �ſ� ���� �ӵ��� �����δ�.
		timer = new Timer(10, this); // 10ms �������� actionPerformed ȣ��
		timer.start(); // Ÿ�̸� ��ü�� �����ϰ� ����
		
	}

	// MyPanel1 �޼ҵ�� �ʱ� �̹��� ���� ���� ��ü �� ������ ����ϰ�
	// ������ �̹����� ������ ��� �Ʒ� �޼ҵ���� �ϴ� �� ����.
	@Override
	// �׷����� ����ϴ� �޼ҵ�
	public void paintComponent(Graphics g) {
		// �׷��� ��ü�� paintComponent �޼ҵ�� �̵���Ŵ
		// �׸��׸����� �ʼ�. ù���忡 ���;���.
		super.paintComponent(g);
		// �̹����� ȭ�鿡 �׸���.
		// drawImage �޼ҵ尡 ������ �׸��� �������� �ʴ´�.
		g.drawImage(image, x, y, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// �̺�Ʈ�� �߻��ϸ� ��ǥ�� �ش� �ȼ� ��ŭ �̵���Ŵ
		x += 20 * (30 / GamePanel.ballMiddlePointX);
		y -= 20 * (30 / 259); // y�� -�ϼ��� ������
		// �̹��� ��ü�� ������ ��� �ʱ� ��ġ�� �̵���Ŵ
		// ������ �Ϸ�Ǹ� repaint �޼ҵ�� �̹����� ����
		// repaint �޼ҵ尡 ������ �׸��� �̵����� �ʴ´�.
		repaint();
	}
	
	
	
	public void updatePosition() {
        // ���⼭ ���ϴ� ��ġ�� ���� �̵���ų �� �ֵ��� �����մϴ�.
        // ���� ���, x, y ���� ���ο� ��ġ�� �����ϰ� repaint() �޼ҵ带 ȣ���Ͽ� �ٽ� �׸����� �մϴ�.
		x += 20 * (30 / GamePanel.ballMiddlePointX);
		y -= 20 * (30 / 259);
	    
	    // �г��� �ٽ� �׸����� repaint() �޼��带 ȣ���մϴ�.
	    repaint();
    }
	
}

public class BallStart {

	public BallStart() {

		GamePanel.panelMain.add(new MyBall());
		
	}

}
