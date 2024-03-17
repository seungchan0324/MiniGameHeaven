package swipeBlockCrack;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main extends JPanel {
	private Ball ball;
	private ArrayList<Block> blocks;

	public Main() {
		ball = new Ball(100, 100, 2, 2, 20, Color.RED);
		blocks = createBlocks();

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ball.moveTo(e.getX(), e.getY());
			}
		});

		startAnimation();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ball.draw(g);
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

	private ArrayList<Block> createBlocks() {
		ArrayList<Block> blocks = new ArrayList<>();
		Random random = new Random();
		int numBlocks = random.nextInt(5) + 1; // 1개에서 5개의 블록 생성
		for (int i = 0; i < numBlocks; i++) {
			int x = random.nextInt(getWidth() - 50);
			int y = random.nextInt(getHeight() - 50);
			// 블록의 숫자는 1부터 9 사이의 랜덤한 숫자로 설정
			int number = random.nextInt(9) + 1;
			blocks.add(new Block(x, y, 50, 50, Color.BLUE, number));
		}
		return blocks;
	}

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
			frame.getContentPane().add(new Main());
			frame.pack();
			frame.setVisible(true);
		});
	}
}
