package infinityStair;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import my_Information.MyInformationPanel;

public class StartPanel extends JPanel implements ActionListener, KeyListener {
	private LinkedList<Brick> bricks;
	private Brick.BrickManager brickmanager;
	private Brick brick = new Brick();
	private int backgroundImgY = -435;
	final static int screenWidth = 600;
	final static int screenHeight = 1000;
	private Timer timer1 = new Timer(300, this);
	private Font font = new Font("Impact", Font.BOLD, 40);
	private Character character;
	private Image brickimg[] = new Image[3];
	private Image backgroundImage[] = new Image[2];
	// 블럭갯수 새기 위한 용도
	private int cnt = 1;
	// cloudY 구름이 적용될 위치를 측정하기 위한 장치
	private int cloudY = 50;
	// 방향이 true면 왼쪽 아니면 오른쪽
	private boolean direction = true;
	private JLabel score;
	private TimeLimit timelimit;
	// 1은 동작중인 상태
	private int statement;
	private int backgroundImgYminus = 40;
	public static int ToTheSpaceMaxScore;

	// 캐릭터의 x를 고정 y를 변화시켜 배경의 y또한 점점 내려간다.
	public StartPanel() {
		// 재시작때에 초기화
		timelimit = new TimeLimit();
		Brick.brickcnt = 0;
		timelimit.gauge = 145;
		timelimit.timer.stop();
		statement = 1;

		character = new Character();

		// 상단 점수 표기
		setLayout(null);
		score = new JLabel((Brick.brickcnt + ""));
		score.setHorizontalAlignment(SwingConstants.CENTER);
		score.setVerticalAlignment(SwingConstants.CENTER);
		score.setBounds(0, 20, screenWidth, 100);
		score.setFont(font);
		score.setForeground(new Color(0, 0, 0));
		add(score);

		ImageIcon[] imgicon = { new ImageIcon("Brick.png"), new ImageIcon("Cloud.png"), new ImageIcon("운석.png") };
		for (int i = 0; i < imgicon.length; i++) {
			Image image = imgicon[i].getImage();
			brickimg[i] = image.getScaledInstance(82, 42, Image.SCALE_SMOOTH);
		}

		setBounds(0, 0, 600, 1000);
		setBackground(new Color(55, 205, 255));

		// 배경 이미지 셋팅
		ImageIcon[] img = { new ImageIcon("BackGround.jpg"), new ImageIcon("night.jpg") };
		for (int i = 0; i < img.length; i++) {
			backgroundImage[i] = img[i].getImage().getScaledInstance(600, 1200, Image.SCALE_SMOOTH); // 이미지 크기 조정
		}

		// BrickManager의 메서드인 firstStart를 진행시켜서 벽돌들을 생성!
		brickmanager = new Brick().new BrickManager();
		bricks = brickmanager.firstStart();
		addKeyListener(this);

		JLabel label = new JLabel();
		label.setBounds(0, 0, 600, 50);
		label.setBackground(new Color(0, 0, 0));
		add(label);

		timelimit = new TimeLimit();
		add(timelimit.gaugepanel);
		add(timelimit.backgroundpanel);
		add(timelimit.framepanel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		character.setX(character.middlepointX);
		character.image = character.frontimg.getImage();
		repaint();
		timer1.stop();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// 배경이미지 삽입
		if (Brick.brickcnt >= 1000 && Brick.brickcnt < 1130) {
			g.drawImage(backgroundImage[1], 0, backgroundImgY, this);
		} else if (Brick.brickcnt < 20) {
			g.drawImage(backgroundImage[0], 0, backgroundImgY, this);
		}
		// 벽돌들 삽입
		for (Brick brick : bricks) {
			if (Brick.brickcnt >= 1000) {
				brick.draw(g, this, brickimg[2]);
			} else if (Brick.brickcnt >= 88 && brick.getBrickY() < cloudY) {
				brick.draw(g, this, brickimg[1]);
			} else {
				brick.draw(g, this, brickimg[0]);
			}
		}

		character.draw(g, this);

		if (timelimit.gauge <= 0 && statement == 1) {
			GameOver();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (Brick.brickcnt == 0)
				timelimit.timer.start();
			int x = brickmanager.bricks.get(cnt).getBrickX();
			backgroundImgY += backgroundImgYminus;
			switch (e.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				brickmanager.moveBricksRight();
				character.setX(character.rightmiddlepointX);
				character.image = character.rightimg.getImage();
				direction = false;
				break;
			case KeyEvent.VK_LEFT:
				brickmanager.moveBricksLeft();
				character.setX(character.leftmiddlepointX);
				character.image = character.leftimg.getImage();
				direction = true;
				break;
			}
			if (x == 340) {
				if (direction) {
					GameOver();
				}
			} else {
				if (!direction) {
					GameOver();
				}
			}
			brickmanager.addBrick();
			if (cnt < 21) {
				cnt++;
			}
			if (Brick.brickcnt > 88 && Brick.brickcnt <= 110) {
				cloudY += 40;
			}
			if (Brick.brickcnt == 1000) {
				backgroundImgY = -435;
				backgroundImgYminus = 10;
				setBackground(new Color(0, 2, 16));
				score.setForeground(new Color(255, 255, 255));
			}
			timelimit.gauge += 10;
			if (timelimit.gauge > 290) {
				timelimit.gauge = 290;
			}
			score.setText(brick.brickcnt + "");
			timer1.start();
			repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public void GameOver() {
		statement = 0;
		MyInformationPanel.money += Brick.brickcnt;
		ToTheSpaceMaxScore = ToTheSpaceMaxScore < Brick.brickcnt ? Brick.brickcnt : ToTheSpaceMaxScore;
		GameOver gameover = new GameOver();
		this.add(gameover);
		this.add(gameover.retrybutton);
		this.add(gameover.endbutton);
		repaint();
		timelimit.timer.stop();
		gameover.retrybutton.requestFocus();
		// brickmanager.bricks.removeAll(bricks);
	}

}
