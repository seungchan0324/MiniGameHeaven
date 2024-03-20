package infinityStair;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class Brick {
	private int brickX;
	private int brickY;
	final private int width = 80;
	final private int height = 30;
	private boolean run = true;
	private Color color = new Color(190, 88, 35);
	private String beforedirection;

	@Override
	public String toString() {
		return "Brick [brickX=" + brickX + ", brickY=" + brickY + "]";
	}

	public Brick() {

	}

	public Brick(int x, int y) {
		this.brickX = x;
		this.brickY = y;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(brickX, brickY, width, height);
	}

	public void moveRight() {
		brickX -= width;
		brickY += height;
		beforedirection = "Right";
	}

	public void moveLeft() {
		brickX += width;
		brickY += height;
		beforedirection = "Left";
	}

	public class BrickManager {
		public LinkedList<Brick> bricks;
		private final int maxSize = 25;
		private int firstX = (StartPanel.screenWidth / 2) + (width / 2);
		private int firstY = (StartPanel.screenHeight / 2) + (height * 2);

		public BrickManager() {
			bricks = new LinkedList<>();
			// �����ڷ� �������� ���� 15���� ���� �̸� �����Ұǵ� ó���� ������ 2~5�������� �����ǰ� ���� ư��
			// ���� Ʋ Ȯ���� �뷫 33�������� ����.
		}

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
			for (int i = firstTurn + 1; i < 15; i++) {
				int turn = (int) (Math.random() * 3 + 1);
				if (turn == 3) {
					run = !run;
				}
				if (run) {
					firstX += width;
				} else {
					firstX -= width;
				}
				firstY -= height;
				bricks.add(new Brick(firstX, firstY));
			}
			return bricks;
		}

		public void addBrick() {
			if (bricks.size() >= maxSize) {
				bricks.removeFirst(); // ���� ������ ���� ����
			}
			int turn = (int) (Math.random() * 3 + 1);
			if (turn == 3) {
				run = !run;
			}
			if (beforedirection == "Right") {
				if (run) {
					firstX += (2 * width);
				}
			}else {
				if(!run) {
					firstX -= (2 * width);
				}
			}
			bricks.addLast(new Brick(firstX, firstY));
		}

		public void moveBricksRight() {
			for (Brick brick : bricks) {
				brick.moveRight();
			}
		}

		public void moveBricksLeft() {
			for (Brick brick : bricks) {
				brick.moveLeft();
			}
		}

		public void draw(Graphics g) {
			for (Brick brick : bricks) {
				brick.draw(g);
			}
		}
	}

}
