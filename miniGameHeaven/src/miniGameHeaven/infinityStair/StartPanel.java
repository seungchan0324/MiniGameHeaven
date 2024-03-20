package infinityStair;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import infinityStair.Brick.BrickManager;

public class StartPanel extends JPanel implements KeyListener {
	private LinkedList<Brick> bricks;
	private Brick.BrickManager brickmanager;
	private int backgroundImgY = -836; 
	final static int screenWidth = 600;
	final static int screenHeight = 1000;
	private Image backgroundImage; // ��� �̹����� ������ ����

// ĳ������ x�� ���� y�� ��ȭ���� ����� y���� ���� ��������.
	public StartPanel() {
		// ��� �̹��� ����
		ImageIcon img = new ImageIcon("���� ���.jpg");
		backgroundImage = img.getImage().getScaledInstance(600, 1800, Image.SCALE_SMOOTH); // �̹��� ũ�� ����

		// BrickManager�� �޼����� firstStart�� ������Ѽ� �������� ����!
		brickmanager = new Brick().new BrickManager();
		bricks = brickmanager.firstStart();
		addKeyListener(this);
		setFocusable(true);
		
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// ����̹��� ����
		g.drawImage(backgroundImage, 0, backgroundImgY, this);

		// ������ ����
		for (Brick brick : bricks) {
			brick.draw(g);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			brickmanager.moveBricksRight();
			brickmanager.addBrick();
			backgroundImgY += 30;
			System.out.println(brickmanager.bricks.getLast());
			System.out.println(brickmanager.bricks.getLast());
			repaint();
			break;
		case KeyEvent.VK_LEFT:
			brickmanager.moveBricksLeft();
			brickmanager.addBrick();
			backgroundImgY += 30;
			System.out.println(brickmanager.bricks.getLast());
			System.out.println(brickmanager.bricks.getLast());
			repaint();
			break;
		case KeyEvent.VK_ENTER:
			brickmanager.moveBricksRight();
			break;
		case KeyEvent.VK_SPACE:
			brickmanager.moveBricksLeft();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
