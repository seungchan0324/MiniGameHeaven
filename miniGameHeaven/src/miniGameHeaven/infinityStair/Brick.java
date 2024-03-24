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

	// 위는 단일 블럭 아래는 여러 블럭을 처리하는 클래스이다.
	public class BrickManager {
		public LinkedList<Brick> bricks;
		private final int maxSize = 40;
		private int firstX = (StartPanel.screenWidth / 2) + (width / 2);
		private int firstY = (StartPanel.screenHeight / 2) + (height * 2);

		public BrickManager() {
			bricks = new LinkedList<>();
		}

		// 처음 게임 시작될때에 시작할 메서드
		// 블럭들이 처음은 무조건 왼쪽으로 2~5개정도 생성돼서 해당 블럭들에 이어서 총 15개의 블럭이 생성됨
		// 그 이후 블럭들은 33%확률로 고개를 틀어서 진행이 된다.
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

		// 블럭들이 최대 30개만 존재하게 하여 혹시 모를 트레픽 부하를 생각하였고
		// 위 기존과 같이 33퍼 확률로 고개를 돌리고 이제부터는 Y값의 좌표는 고정이고
		// X값만 변화를 줘 지속적으로 블럭을 생성되게 한다.
		// 내가 이전에 진행한 방향에 따라 모든 블럭들이 움직이므로 다음으로 설치될 블럭 또한 영향을 받아서 아래와 같이 함.
		public void addBrick() {
			if (bricks.size() >= maxSize) {
				bricks.removeFirst(); // 가장 오래된 벽돌 제거
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
