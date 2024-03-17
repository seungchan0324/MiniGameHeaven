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

		// ���콺�� �� ���̿� ������ �׸��ϴ�.
		if (showDashedLine) {
			g.setColor(new Color(0, 0, 255, 128)); // �Ķ��� �� ���� ����
			g.drawLine(ball.getX(), ball.getY(), mouseX, mouseY); // ���� ���콺 ���̿� �� �׸���
		}

		// ���� �׸��ϴ�.
		ball.draw(g);

		// ����� �׸��ϴ�.
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

	// ���� �������̷� ���ͼ� ���� �����ϰ� ������ ���ľ���
	private ArrayList<Block> createBlocks() {
		ArrayList<Block> blocks = new ArrayList<>();
		Random random = new Random();
		int numBlocks = 5; // 1������ 5���� ��� ����
		int numEmptySpaces = 6 - numBlocks; // �� ���� ���� ���

		// ��ġ ������ �� 6���� ������ ��� ��ġ
		for (int i = 0; i < numBlocks; i++) {
			int x = 1 + i * (90 + 1); // �� ����� x ��ǥ ���
			int y = 61; // y ��ǥ�� ����

			// ����� ���ڴ� 1���� 9 ������ ������ ���ڷ� ����
			int number = random.nextInt(9) + 1;
			blocks.add(new Block(x, y, 90, 60, Color.BLUE, number));
		}

		// ���� ���� �߿� �����ϰ� �� ���� �ʷϻ� �� �߰�
		int emptySpaceIndex = random.nextInt(numEmptySpaces);
		int emptySpaceX = 1 + emptySpaceIndex * (90 + 1); // x ��ǥ ���
		int emptySpaceY = 61; // y ��ǥ�� ����
		blocks.add(new Block(emptySpaceX, emptySpaceY, 90, 60, Color.GREEN, 0));

		return blocks;
	}

	// �ε����� �۵��ϴµ� 
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
