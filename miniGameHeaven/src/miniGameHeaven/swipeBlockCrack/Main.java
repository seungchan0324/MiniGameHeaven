package swipeBlockCrack;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main extends JPanel {
	private Ball ball;
	private ArrayList<Block> blocks;
	private int mouseX, mouseY;
	static boolean showDashedLine = true;
	JLabel la = new JLabel("No Mouse Event");

	public Main() {
		ball = new Ball(259, 540, 0, 0, 11, Color.BLUE);
		blocks = createBlocks();
		add(la);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (showDashedLine) {
					ball.moveTo(e.getX(), e.getY(), 5);
					showDashedLine = false;
				}
			}
		});

		addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				la.setText("mouseMoved(" + e.getX() + "," + e.getY() + ")" + Ball.dx + "," + Ball.dy);

				mouseX = e.getX();
				mouseY = e.getY();
				repaint();
			}
		});

		startAnimation();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// 마우스와 공 사이에 점선을 그립니다.
		if (showDashedLine) {
			g.setColor(new Color(0, 0, 255, 128)); // 파란색 및 투명도 설정
			g.drawLine(ball.getX(), ball.getY(), mouseX, mouseY); // 공과 마우스 사이에 선 그리기
		}

		// 공을 그립니다.
		ball.draw(g);

		// 블록을 그립니다.
		for (Block block : blocks) {
			block.draw(g);
		}
	}

	private void startAnimation() {
		Thread animationThread = new Thread(() -> {
			while (true) {
				ball.move(getHeight());
				handleCollisions();
				repaint();

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		animationThread.start();
	}

	// 블럭이 마구잡이로 나와서 완전 랜덤하게 나오게 고쳐야함
	private ArrayList<Block> createBlocks() {
		ArrayList<Block> blocks = new ArrayList<>();
		Random random = new Random();
		int numBlocks = 5; // 1개에서 5개의 블록 생성
		int numEmptySpaces = 6 - numBlocks; // 빈 공간 개수 계산

		// 설치 가능한 총 6개의 공간에 블록 배치
		for (int i = 0; i < numBlocks; i++) {
			int x = 1 + i * (90 + 1); // 각 블록의 x 좌표 계산
			int y = 61; // y 좌표는 고정

			// 블록의 숫자는 1부터 9 사이의 랜덤한 숫자로 설정
			int number = random.nextInt(9) + 1;
			blocks.add(new Block(x, y, 90, 60, Color.BLUE, number));
		}

		// 남은 공간 중에 랜덤하게 한 곳에 초록색 공 추가
		int emptySpaceIndex = random.nextInt(numEmptySpaces);
		int emptySpaceX = 1 + emptySpaceIndex * (90 + 1); // x 좌표 계산
		int emptySpaceY = 61; // y 좌표는 고정
		blocks.add(new Block(emptySpaceX, emptySpaceY, 90, 60, Color.GREEN, 0));

		return blocks;
	}

	// 부딪힐때 작동하는데 
	private void handleCollisions() {
		Rectangle ballBounds = ball.getBounds();
		for (Block block : blocks) {
			Rectangle blockBounds = block.getBounds();
			if (ballBounds.intersects(blockBounds)) {
				ball.reverseDirection();
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Ball Animation");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Main mainPanel = new Main();
			frame.getContentPane().add(mainPanel);
			frame.setSize(564, 900);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		});
	}
}
