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
	private Image backgroundImage; // 배경 이미지를 저장할 변수

// 캐릭터의 x를 고정 y를 변화시켜 배경의 y또한 점점 내려간다.
	public StartPanel() {
		// 배경 이미지 셋팅
		ImageIcon img = new ImageIcon("도시 배경.jpg");
		backgroundImage = img.getImage().getScaledInstance(600, 1800, Image.SCALE_SMOOTH); // 이미지 크기 조정

		// BrickManager의 메서드인 firstStart를 진행시켜서 벽돌들을 생성!
		brickmanager = new Brick().new BrickManager();
		bricks = brickmanager.firstStart();
		addKeyListener(this);
		setFocusable(true);
		
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// 배경이미지 삽입
		g.drawImage(backgroundImage, 0, backgroundImgY, this);

		// 벽돌들 삽입
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
