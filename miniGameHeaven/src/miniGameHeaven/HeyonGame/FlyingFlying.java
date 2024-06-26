package HeyonGame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import defaultFrame.DefaultFrame;
import gameDescription.GameDescription;
import my_Information.MyInformationCharacter;
import my_Information.MyInformationPanel;

public class FlyingFlying extends JFrame {

	private JPanel birdPanel;
	private int birdY = 250; // 시작 Y 위치
	private final int BIRD_X = 100; // X 위치는 고정
	private double acc = 1.0;
	private JPanel obstacle1;
	private JPanel obstacle2;
	private int obstacleX = 800; // 장애물의 초기 X 좌표
	private JPanel safezone;
	private int safezoneY = 250; // 장애물의 초기 Y 좌표
	private int LE_SAFE = 100; // 세로 장애물의 크기
	private JPanel BGSIZE1;
	private JPanel BGSIZE2;
	private int LE_BGSIZE = 500;
	private int WI_BGSIZE = 800;
	private int BGX1 = 0;
	private int BGX2 = 800;
	private int BGY = -10;
	private final int WI_SIZE = 100; // 가로 장애물의 크기
	private Timer timer;
	private int cnt = 0;
	private int score = 0;
	public static int FlyingFlyingMaxScore;
	private int second = 3;
	private JLabel titleLabel = new JLabel("시작하실려면 아무키나 누르시오", SwingConstants.CENTER);
	JPanel mainPanel;
	Timer countdownTimer;
	// 키 리스너 객체를 변수에 할당
	KeyListener myKeyListener = new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			startGame();
		}
	};
	ImageIcon img;
	Image image;

	public void characterSelect() {
		if (MyInformationCharacter.characterselect.equals("Gumi")) {
			img = new ImageIcon("날아날아구미.png");

		} else if (MyInformationCharacter.characterselect.equals("Dalri")) {
			img = new ImageIcon("날아날아 달이.png");

		} else {
			img = new ImageIcon("토양이오른쪽.png");

		}
		image = img.getImage();
	}

	public FlyingFlying() {
		characterSelect();
		setTitle("Flappy Bird");
		setSize(800, 500);
		setLocationRelativeTo(null); // 화면 중앙에 위치시킴

		startpenal();

		// 키 리스너 추가
		addKeyListener(myKeyListener);

		// JFrame이 키 이벤트를 받을 수 있게 설정
		setFocusable(true);
		requestFocusInWindow();

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				DefaultFrame.getInstance(new GameDescription(0), "게임 설명 화면");
			}
		});

	}

	private void startpenal() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		// 캐릭터
		birdPanel = new JPanel();
		birdPanel.setOpaque(false);// 패널 투명하게
		birdPanel.setBounds(BIRD_X, birdY, 50, 50); // 새의 크기 및 초기 위치
		// 배경
		BGSIZE1 = new JPanel();
		birdPanel.setOpaque(false);// 패널 투명하게
		BGSIZE1.setBounds(BGX1, BGY, WI_BGSIZE, LE_BGSIZE);
		BGSIZE2 = new JPanel();
		birdPanel.setOpaque(false);// 패널 투명하게
		BGSIZE2.setBounds(BGX2, BGY, WI_BGSIZE, LE_BGSIZE);
		Image scaleimg2 = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		img.setImage(scaleimg2);
		JLabel ch = new JLabel(img);
		ImageIcon img1 = new ImageIcon("BG.jpg");
		Image changeimg1 = img1.getImage();
		Image scaleimg1 = changeimg1.getScaledInstance(WI_BGSIZE, LE_BGSIZE, Image.SCALE_SMOOTH);
		img1.setImage(scaleimg1);
		JLabel BGimg1 = new JLabel(img1);
		JLabel BGimg2 = new JLabel(img1);

		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		titleLabel.setBounds(100, 150, 600, 50);// 점수
		mainPanel.add(titleLabel, BorderLayout.CENTER);

		birdPanel.add(ch);
		BGSIZE1.add(BGimg1);
		BGSIZE2.add(BGimg2);
		mainPanel.add(birdPanel);
		mainPanel.add(BGSIZE1);
		mainPanel.add(BGSIZE2);
		add(mainPanel);

		setVisible(true);

	}

	private void startGame() {
		// 카운트다운을 위한 레이블 설정
		if (countdownTimer == null || !countdownTimer.isRunning()) {
			countdownTimer = new Timer(500, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (second > 0) {
						titleLabel.setText("" + second);
					} else if (second == 0) {
						titleLabel.setText("GAME START");
					} else {
						// 카운트다운 타이머 정지
						((Timer) e.getSource()).stop();
						// 게임 시작을 위한 메인 타이머 시작
						goToNextScreen();
					}
					second--;
				}
			});
			countdownTimer.setInitialDelay(0); // 타이머 시작 지연 없이 즉시 시작
			countdownTimer.start();
		}
	}

	private void goToNextScreen() {
		// 나중에 키 리스너 제거
		getContentPane().removeAll();
		removeKeyListener(myKeyListener);
		setTitle("Flappy Bird");
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setFocusable(true);
		requestFocusInWindow();
		birdPanel = new JPanel();
		birdPanel.setOpaque(false);// 패널 투명하게
		birdPanel.setBounds(BIRD_X, birdY, 50, 50); // 새의 크기 및 초기 위치
		// 장애물1
		obstacle1 = new JPanel();
		obstacle1.setBounds(obstacleX, 350, WI_SIZE, 300); // 장애물 그리기
		obstacle1.setOpaque(false);// 패널 투명하게
		// 장애물2
		obstacle2 = new JPanel();
		obstacle2.setBounds(obstacleX, 0, WI_SIZE, 300);// 장애물 그리기
		obstacle2.setOpaque(false);// 패널 투명하게
		// 생존존
		safezone = new JPanel();
		safezone.setBounds(obstacleX, safezoneY, WI_SIZE, LE_SAFE);
		safezone.setOpaque(false);// 패널 투명하게
		// 배경
		BGSIZE1 = new JPanel();
		birdPanel.setOpaque(false);// 패널 투명하게
		BGSIZE1.setBounds(BGX1, BGY, WI_BGSIZE, LE_BGSIZE);
		BGSIZE2 = new JPanel();
		birdPanel.setOpaque(false);// 패널 투명하게
		BGSIZE2.setBounds(BGX2, BGY, WI_BGSIZE, LE_BGSIZE);

		// 점수 표기
		JLabel ScoreaLabel = new JLabel("점수: " + cnt, SwingConstants.RIGHT);
		ScoreaLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		ScoreaLabel.setBounds(650, 10, 100, 30);// 점수

		setLocationRelativeTo(null); // 창을 화면 중앙에 위치

		// 배경
		ImageIcon img1 = new ImageIcon("BG.jpg");
		Image changeimg1 = img1.getImage();
		Image scaleimg1 = changeimg1.getScaledInstance(800, 500, Image.SCALE_SMOOTH);
		img1.setImage(scaleimg1);
		JLabel BGimg1 = new JLabel(img1);
		JLabel BGimg2 = new JLabel(img1);
		// 캐릭터
		Image scaleimg2 = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		img.setImage(scaleimg2);
		JLabel ch = new JLabel(img);
		// 장애물
		ImageIcon img3 = new ImageIcon("sin1.png");
		Image changeimg3 = img3.getImage();
		Image scaleimg3 = changeimg3.getScaledInstance(WI_SIZE, 300, Image.SCALE_SMOOTH);
		img3.setImage(scaleimg3);
		JLabel ob1 = new JLabel(img3);

		ImageIcon img4 = new ImageIcon("rsin2.png");
		Image changeimg4 = img4.getImage();
		Image scaleimg4 = changeimg4.getScaledInstance(WI_SIZE, 725, Image.SCALE_SMOOTH);
		img4.setImage(scaleimg4);
		JLabel ob2 = new JLabel(img4);

		// 생성
		add(ScoreaLabel);
		BGSIZE1.add(BGimg1);
		BGSIZE2.add(BGimg2);
		birdPanel.add(ch);
		obstacle1.add(ob1);
		obstacle2.add(ob2);

		add(birdPanel);
		add(safezone);
		add(obstacle1);
		add(obstacle2);
		add(BGSIZE1);
		add(BGSIZE2);

		setVisible(true);

		if (timer == null || !timer.isRunning()) {// 타이머가 실행 중이지 않을 때만 시작
			addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					int key = e.getKeyCode();
					if (key == KeyEvent.VK_SPACE) {
						birdY -= 45;
						acc = 1; // 점프 후 중력 가속도 재설정
					}
				}
			});

			timer = new Timer(10, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScoreaLabel.setText("점수: " + cnt);
					birdY += acc; // 중력 효과
					acc += 0.18;
					birdPanel.setBounds(BIRD_X, birdY, 50, 50);
					obstacleX -= 10;
					BGX1 -= 10;
					BGX2 -= 10;
					if (((obstacleX) <= BIRD_X) && ((obstacleX + 100) >= BIRD_X)) {
						if (!(((safezoneY) <= birdY) && ((safezoneY + 75) >= birdY))) {
							showGameOverPanel(); // 게임 오버 화면 표시 메서드 호출
							((Timer) e.getSource()).stop(); // 게임 오버 시 타이머 정지
						} else if (BIRD_X == (obstacleX + 60)) {
							cnt += 100;
							System.out.println("통과");
						}
					}

					if (birdY > 450 || birdY < 0) {
						showGameOverPanel(); // 게임 오버 화면 표시 메서드 호출
						((Timer) e.getSource()).stop(); // 게임 오버 시 타이머 정지
					}
					if (obstacleX <= -100) {
						obstacleX = 800;
						safezoneY = (int) (Math.random() * (300 - 30 + 1)) + 30; // 세이프존 위치

					}
					if (BGX1 == -800) {
						BGX1 = 800;
					} else if (BGX2 == -800) {
						BGX2 = 800;
					}
					ScoreaLabel.setBounds(650, 10, 100, 30);// 점수

					BGSIZE1.setBounds(BGX1, BGY, WI_BGSIZE, LE_BGSIZE); // 배경1
					BGSIZE2.setBounds(BGX2, BGY, WI_BGSIZE, LE_BGSIZE); // 배경2

					safezone.setBounds(obstacleX, safezoneY, WI_SIZE, LE_SAFE); // 세이프존
					obstacle1.setBounds(obstacleX, (safezoneY + LE_SAFE), WI_SIZE, 600); // 장애물아래
					obstacle2.setBounds(obstacleX, safezoneY - 725, WI_SIZE, 725); // 장애물위

				}

			});

			timer.start(); // 타이머 시작
		}

	}

	private void showGameOverPanel() {
		Object[] options = { "재시작", "종료" };
		int choice = JOptionPane.showOptionDialog(null, "게임 오버! 다시 하시겠습니까?", "게임 오버", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]); // 초기 선택값

		score = +cnt / 10;
		System.out.println("포인트 : " + score);
		FlyingFlyingMaxScore = FlyingFlyingMaxScore < cnt ? cnt : FlyingFlyingMaxScore;
		MyInformationPanel.money += score;
		if (choice == JOptionPane.YES_OPTION) {
			timer = null;
			dispose();
			new FlyingFlying();
		} else {
			timer = null;
			dispose();
			DefaultFrame.getInstance(new GameDescription(0), "게임 설명 화면");
		}
	}

}
