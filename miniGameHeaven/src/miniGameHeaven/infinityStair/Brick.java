package infinityStair;

import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.JPanel;

public class Brick {
	private int brickX;
	private int brickY;
	final private int width = 80;
	final private int height = 40;
	private boolean right = true;
	static int brickcnt = 0;
	public String beforedirection = "Left";

	public Brick() {
	}

	public Brick(int x, int y) {
		this.brickX = x;
		this.brickY = y;
	}

	public int getBrickX() {
		return brickX;
	}

	public int getBrickY() {
		return brickY;
	}

	public int brickCnt() {
		return ++brickcnt;
	}

	public void draw(Graphics g, JPanel panel, Image changeImg) {
		g.drawImage(changeImg, brickX, brickY, panel);
	}

	public void moveRight() {
		brickX -= width;
		brickY += height;
	}

	public void moveLeft() {
		brickX += width;
		brickY += height;
	}

	// ���� ���� �� �Ʒ��� ���� ���� ó���ϴ� Ŭ�����̴�.
	public class BrickManager {
		public LinkedList<Brick> bricks;
		private final int maxSize = 40;
		private int firstX = (StartPanel.screenWidth / 2) + (width / 2);
		private int firstY = (StartPanel.screenHeight / 2) + (height * 2);

		public BrickManager() {
			bricks = new LinkedList<>();
		}

		// ó�� ���� ���۵ɶ��� ������ �޼���
		// ������ ó���� ������ �������� 2~5������ �����ż� �ش� ���鿡 �̾ �� 15���� ���� ������
		// �� ���� ������ 33%Ȯ���� ���� Ʋ� ������ �ȴ�.
		public LinkedList<Brick> firstStart() {
			int firstTurn = (int) (Math.random() * 4 + 2);
			do {
				firstX -= width;
				firstY -= height;
				bricks.add(new Brick(firstX, firstY));
			} while (firstTurn > bricks.size());
			firstX += width;
			firstY -= height;
			bricks.add(new Brick(firstX, firstY));
			for (int i = firstTurn + 1; i < 20; i++) {
				int turn = (int) (Math.random() * 3 + 1);
				if (turn == 3) {
					right = !right;
				}
				if (right) {
					firstX += width;
				} else {
					firstX -= width;
				}
				firstY -= height;
				bricks.add(new Brick(firstX, firstY));
			}
			brickX = firstX;
			return bricks;
		}

		// ������ �ִ� 30���� �����ϰ� �Ͽ� Ȥ�� �� Ʈ���� ���ϸ� �����Ͽ���
		// �� ������ ���� 33�� Ȯ���� ���� ������ �������ʹ� Y���� ��ǥ�� �����̰�
		// X���� ��ȭ�� �� ���������� ���� �����ǰ� �Ѵ�.
		// ���� ������ ������ ���⿡ ���� ��� ������ �����̹Ƿ� �������� ��ġ�� �� ���� ������ �޾Ƽ� �Ʒ��� ���� ��.
		public void addBrick() {
			if (bricks.size() >= maxSize) {
				bricks.removeFirst(); // ���� ������ ���� ����
			}
			int turn = (int) (Math.random() * 3 + 1);
			if (turn == 3) {
				right = !right;
			}
			if (beforedirection.equals("Right")) {
				if (right) {
					brickX -= (2 * width);
				}
			} else {
				if (!right) {
					brickX += (2 * width);
				}
			}
			brickCnt();
			bricks.addLast(new Brick(brickX, firstY));
		}

		public void moveBricksRight() {
			for (Brick brick : bricks) {
				brick.moveRight();
			}
			beforedirection = "Right";
		}

		public void moveBricksLeft() {
			for (Brick brick : bricks) {
				brick.moveLeft();
			}
			beforedirection = "Left";
		}

		public void draw(Graphics g, JPanel panel, Image changeImg) {
			for (Brick brick : bricks) {
				brick.draw(g, panel, changeImg);
			}
		}
	}

}
