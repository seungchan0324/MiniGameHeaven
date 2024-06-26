package SongGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import Main_Interface.Main_Interface;
import defaultFrame.DefaultFrame;
import gameDescription.GameDescription;
import my_Information.MyInformationPanel;

public class Keyword extends JPanel implements KeyListener, ActionListener {
	private LinkedList<String> fruitWords;
	private LinkedList<String> animalWords;
	private LinkedList<String> workWords;
	private LinkedList<String> foodWords;
	private LinkedList<String> countryWords;
	private LinkedList<String> selectedWords;
	private int currentWordIndex;
	private String currentWord;
	private boolean gameRunning;
	private Timer timer;
	private int score;
	private int timeLeft;
	public static int DrizzlingMaxScore;

	// time 0.1초마다 actionperformed실행
	Timer time = new Timer(100, this);
	// 초기 wordY값
	private int wordY = 20;

	private JTextField inputTextField;
	private JLabel scoreLabel;
	private JButton enterButton;
	private JButton pauseButton; // 일시정지 버튼
	private int pausedTimeLeft; // 일시정지된 시간을 저장할 변수
	private String pausedWord; // 일시정지된 시점의 단어를 저장할 변수
	private boolean wordEntered; // 단어가 입력되었는지 여부를 나타내는 변수
	private int point;
	private JButton backButton; // 뒤로 가기 버튼

	// 이미지 아이콘
	ImageIcon imgAnimal = new ImageIcon("animal.png");
	ImageIcon imgCountry = new ImageIcon("country.png");
	ImageIcon imgFood = new ImageIcon("food.png");
	ImageIcon imgFruit = new ImageIcon("fruit.png");
	ImageIcon imgWork = new ImageIcon("work.png");

	// 키워드 박스==================================================
	public Keyword() {

		this.fruitWords = new LinkedList<>();
		this.fruitWords.add("apple");
		this.fruitWords.add("banana");
		this.fruitWords.add("orange");
		this.fruitWords.add("grape");
		this.fruitWords.add("strawberry");
		this.fruitWords.add("pineapple");
		this.fruitWords.add("watermelon");
		this.fruitWords.add("kiwi");
		this.fruitWords.add("pear");
		this.fruitWords.add("fig");
		this.fruitWords.add("mango");
		this.fruitWords.add("yuja");
		this.fruitWords.add("lime");
		this.fruitWords.add("peach");
		this.fruitWords.add("blueberry");
		this.fruitWords.add("plum");
		this.fruitWords.add("avocado");
		this.fruitWords.add("cherry");
		this.fruitWords.add("grapefruit");

		this.animalWords = new LinkedList<>();
		this.animalWords.add("dog");
		this.animalWords.add("cat");
		this.animalWords.add("elephant");
		this.animalWords.add("lion");
		this.animalWords.add("tiger");
		this.animalWords.add("monkey");
		this.animalWords.add("giraffe");
		this.animalWords.add("zebra");
		this.animalWords.add("piglet");
		this.animalWords.add("fox");
		this.animalWords.add("bunny");
		this.animalWords.add("mouse");
		this.animalWords.add("whale");
		this.animalWords.add("shark");
		this.animalWords.add("otter");
		this.animalWords.add("dolphin");
		this.animalWords.add("beluga");
		this.animalWords.add("eagle");
		this.animalWords.add("duck");
		this.animalWords.add("swan");

		this.workWords = new LinkedList<>();
		this.workWords.add("office worker");
		this.workWords.add("programmer");
		this.workWords.add("web designer");
		this.workWords.add("software developer");
		this.workWords.add("web developer");
		this.workWords.add("baker");
		this.workWords.add("hairdresser");
		this.workWords.add("dentist");
		this.workWords.add("doctor");
		this.workWords.add("bartender");
		this.workWords.add("cook");
		this.workWords.add("chef");
		this.workWords.add("waiter");
		this.workWords.add("taxi driver");
		this.workWords.add("artist");
		this.workWords.add("editor");
		this.workWords.add("illustrator");
		this.workWords.add("painter");
		this.workWords.add("photographer");
		this.workWords.add("dancer");

		this.foodWords = new LinkedList<>();
		this.foodWords.add("bagels");
		this.foodWords.add("barbecue");
		this.foodWords.add("beef");
		this.foodWords.add("burgers");
		this.foodWords.add("cake");
		this.foodWords.add("curry");
		this.foodWords.add("coffee");
		this.foodWords.add("crapes");
		this.foodWords.add("eggrolls");
		this.foodWords.add("pasta");
		this.foodWords.add("pizza");
		this.foodWords.add("pork");
		this.foodWords.add("hotdog");
		this.foodWords.add("icecream");
		this.foodWords.add("yoghurt");
		this.foodWords.add("soup");
		this.foodWords.add("soba");
		this.foodWords.add("ramen");
		this.foodWords.add("pie");
		this.foodWords.add("natto");

		this.countryWords = new LinkedList<>();
		this.countryWords.add("argentina");
		this.countryWords.add("australia");
		this.countryWords.add("brazil");
		this.countryWords.add("cambodia");
		this.countryWords.add("canada");
		this.countryWords.add("china");
		this.countryWords.add("denmark");
		this.countryWords.add("egypt");
		this.countryWords.add("england");
		this.countryWords.add("figi");
		this.countryWords.add("finland");
		this.countryWords.add("france");
		this.countryWords.add("georgia");
		this.countryWords.add("germany");
		this.countryWords.add("ghana");
		this.countryWords.add("greece");
		this.countryWords.add("holland");
		this.countryWords.add("india");
		this.countryWords.add("ireland");
		this.countryWords.add("italian");

		this.selectedWords = fruitWords; // Default to fruit words

		this.currentWordIndex = -1;
		this.currentWord = "";
		this.gameRunning = false;
		this.score = 0;
		this.timer = new Timer(1000, e -> {
			if (timeLeft > 0) {
				timeLeft--;
				repaint();
			} else {
				endGame();
			}
		});

		setPreferredSize(new Dimension(550, 400));
		setBackground(Color.WHITE);
		setFocusable(true);
		addKeyListener(this);

		JPanel categoryPanel = new JPanel();
		categoryPanel.setBackground(Color.LIGHT_GRAY);
		JButton fruitButton = new JButton(imgFruit);
		fruitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedWords = fruitWords;
				startGame(30); // Start the game with a duration of 30 seconds
			}
		});
		JButton animalButton = new JButton(imgAnimal);
		animalButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedWords = animalWords;
				startGame(30); // Start the game with a duration of 30 seconds
			}
		});
		JButton workButton = new JButton(imgWork);
		workButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedWords = workWords;
				startGame(30); // Start the game with a duration of 30 seconds
			}
		});

		JButton foodButton = new JButton(imgFood);
		foodButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedWords = foodWords;
				startGame(30); // Start the game with a duration of 30 seconds
			}
		});

		JButton countryButton = new JButton(imgCountry);
		countryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedWords = countryWords;
				startGame(30); // Start the game with a duration of 30 seconds
			}
		});

		imgFruit = imageSetSize(imgFruit, 60, 60); // imageSetSize 메소드 생성
		imgAnimal = imageSetSize(imgAnimal, 60, 60);
		imgWork = imageSetSize(imgWork, 60, 60);
		imgFood = imageSetSize(imgFood, 60, 60);
		imgCountry = imageSetSize(imgCountry, 60, 60);

		fruitButton.setIcon(imgFruit);
		fruitButton.setBackground(Color.LIGHT_GRAY);
		fruitButton.setBorderPainted(false);// 버튼 테두리 설정해제

		animalButton.setIcon(imgAnimal);
		animalButton.setBackground(Color.LIGHT_GRAY);
		animalButton.setBorderPainted(false);// 버튼 테두리 설정해제

		workButton.setIcon(imgWork);
		workButton.setBackground(Color.LIGHT_GRAY);
		workButton.setBorderPainted(false);// 버튼 테두리 설정해제

		foodButton.setIcon(imgFood);
		foodButton.setBackground(Color.LIGHT_GRAY);
		foodButton.setBorderPainted(false);// 버튼 테두리 설정해제

		countryButton.setIcon(imgCountry);
		countryButton.setBackground(Color.LIGHT_GRAY);
		countryButton.setBorderPainted(false);// 버튼 테두리 설정해제

		categoryPanel.add(fruitButton);
		categoryPanel.add(animalButton);
		categoryPanel.add(workButton);
		categoryPanel.add(foodButton);
		categoryPanel.add(countryButton);

		JPanel inputPanel = new JPanel();
		inputPanel.setBackground(Color.LIGHT_GRAY);
		// JLabel inputLabel = new JLabel("Enter the word:");
		inputTextField = new JTextField(30);
		inputTextField.addKeyListener(this);

		enterButton = new JButton("입력");
		enterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkInput();
			}
		});

		enterButton.setBackground(Color.LIGHT_GRAY);
		enterButton.setForeground(Color.DARK_GRAY);

//		// 폰트(글꼴, 굵기, 크기)
//		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 16);

		pauseButton = new JButton("일시정지");
		pauseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pauseGame();
			}
		});
		pauseButton.setBackground(Color.DARK_GRAY);
		pauseButton.setForeground(Color.white);

		// 뒤로 가기 버튼 생성
		backButton = new JButton("게임 종료");
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				SwingUtilities.getWindowAncestor(backButton).setVisible(false);
				DefaultFrame.getInstance(new GameDescription(3), "게임 설명 화면");
			}
		});

		backButton.setBackground(Color.DARK_GRAY);
		backButton.setForeground(Color.white);

		// inputPanel.add(inputLabel);
		inputPanel.add(backButton); // 뒤로 가기 버튼을 입력 패널에 추가
		inputPanel.add(inputTextField);
		inputPanel.add(enterButton);
		inputPanel.add(pauseButton); // 일시정지 버튼을 입력 패널에 추가

		scoreLabel = new JLabel("현재 점수 : 0");
		scoreLabel.setBorder((BorderFactory.createEmptyBorder(0, 10, 0, 0)));// 왼쪽 여백
		scoreLabel.setPreferredSize(new Dimension(100, 0));// 사이즈

		JFrame frame = new JFrame("쵹쵹이슬비");
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(this, BorderLayout.CENTER);
		frame.getContentPane().add(categoryPanel, BorderLayout.NORTH);
		frame.getContentPane().add(inputPanel, BorderLayout.SOUTH);
		frame.getContentPane().add(scoreLabel, BorderLayout.WEST);
		frame.setResizable(false);
		frame.pack();
		// frame.setFont(font);
		// frame.setLocationRelativeTo(null);

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.dispose();
				DefaultFrame.getInstance(new GameDescription(3), "게임 설명 화면");
			}
		});

		// 1.Toolkit을 통해 모니터의 해상도를 얻어오기
		Toolkit tk = Toolkit.getDefaultToolkit();

		for (int i = 0; i < 3; i++) {
			try {// 오류 잡기
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			tk.beep();
		} // for

		// 2.Dimemsion을 통해서 중앙 좌표값 설정하기
		Dimension di = tk.getScreenSize();
		int monitorW = di.width;
		int monitorH = di.height;

		// 3.프레임 좌우 크기 빼주기
		int x = monitorW / 2 - frame.getWidth() / 2;
		int y = monitorH / 2 - frame.getHeight() / 2;

		frame.setLocation(x, y);
		frame.setVisible(true);

	}

	public void startGame(int durationInSeconds) {
		if (!gameRunning) {
			score = 0;
			timeLeft = durationInSeconds;
			gameRunning = true;
			generateWord();
			// 타이머 0.1초 마다 진행되는 메커니즘의 시작
			time.start();
			timer.start();
		}
	}

	public void startGame(int durationInSeconds, int score) {
		if (!gameRunning) {
			this.score = score;
			timeLeft = durationInSeconds;
			gameRunning = true;
			timer.start();
		}
	}

	private void generateWord() {
		Random random = new Random();
		currentWordIndex = random.nextInt(selectedWords.size());
		currentWord = selectedWords.get(currentWordIndex);
		// 단어가 생길 때에 wordY값이 갱신된다.
		wordY = 20;
	}

	private void checkInput() {
		String userInput = inputTextField.getText().trim().toLowerCase();
		if (gameRunning && !userInput.isEmpty() && userInput.equals(currentWord)) {
			score++;
			scoreLabel.setText("현재 점수 : " + score);
			generateWord();
			inputTextField.setText("");
			repaint();
			point += 50;

		}
	}

	private void endGame() {
		gameRunning = false;
		timer.stop();
		// 5개의 단어를 맞힌 횟수에 따라 총 포인트에 추가적립되어 endGame에 표시됨
		int totalScore = score + point;
		MyInformationPanel.money += (point / 5 * 3);
		DrizzlingMaxScore = DrizzlingMaxScore < score ? score : DrizzlingMaxScore;
		JOptionPane.showMessageDialog(this, "게임 종료!\n맞힌 개수 : " + score + "\n총 " + point + "포인트가 적립되었습니다.");

	}

	// 게임 일시정지 기능
	private void pauseGame() {
		if (gameRunning) {
			gameRunning = false;
			timer.stop();
			// 멈추면 타이머가 일시적으로 멈춘다.
			time.stop();
			pausedTimeLeft = timeLeft; // 일시정지된 시간을 저장
			pausedWord = currentWord; // 일시정지된 시점의 단어를 저장
			int option = JOptionPane.showConfirmDialog(this, "게임이 일시정지되었습니다.\n게임을 다시 시작하시겠습니까?", "일시정지",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				startGame(pausedTimeLeft, score); // 일시정지된 시간부터 게임 재시작
			}
		}
	}

	ImageIcon imageSetSize(ImageIcon icon, int i, int j) { // image Size Setting
		Image ximg = icon.getImage(); // ImageIcon을 Image로 변환.
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}

	// 게임 재개 기능
	private void resumeGame() {
		if (!gameRunning) {
			gameRunning = true;
			timer.start();
			currentWord = pausedWord; // 일시정지된 시점의 단어로 다시 시작
			repaint();
			JOptionPane.showMessageDialog(this, "게임이 다시 시작되었습니다.");
		}
	}

	// 뒤로 가기 기능
	private void goBack() {
		// 경로가 정해지지 않았을 때는 null로 처리
		String path = null;
		// 경로가 null이 아닌 경우에만 뒤로 가기 처리
		if (path != null) {
			// TODO: 뒤로 가기 처리
		}
	}

//	//포인트 적립
//	public void pointSave() {
//	    int earnedPoints = (score / 5) * 100;
//	    point += earnedPoints;
//	    JOptionPane.showMessageDialog(this, "Game Over!\n당신의 점수는: " + score + "\n적립된 포인트: " + point);
//	}

	// 가운데 화면에 뜨는 키워드
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (gameRunning) {
			g.setColor(Color.GRAY);
			g.setFont(new Font("Arial", Font.BOLD, 24));
			FontMetrics fm = g.getFontMetrics(); // FontMetrics를 사용하여 낱말의 너비를 구함
			int wordWidth = fm.stringWidth(currentWord); // 낱말의 너비
			int wordX = (getWidth() - wordWidth) / 2; // 화면 가로 중앙에서 낱말의 왼쪽 X 좌표 계산
			// 화면 세로 중앙에서 낱말의 Y 좌표 계산
			g.drawString(currentWord, wordX, wordY);
			g.drawString("Time left: " + timeLeft, 20, 30);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (gameRunning && e.getKeyCode() == KeyEvent.VK_ENTER) {
			checkInput();
		}
	}

	public static void main(String[] args) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// wordY += 값이 커지면 내려가는 값이 커진다.
		wordY += 5;
		// wordY 값이 200으로 내려가면 작동
		if (wordY == 450) {
			// endGame();
			generateWord();
		}
	}
}
