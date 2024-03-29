package gameDescription;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import DongGame.ClickClickGame;
import HeyonGame.FlyingFlying;
import SongGame.Keyword;
import SunGame.penalty24;
import YeonGame.Umi;
import infinityStair.StartFrame;
import infinityStair.StartPanel;

public class GameDescription extends JFrame {
	private JPanel mainPanel;
	private JPanel gameImagePanel;
	private JLabel gameNameLabel;
	private JTextArea gameDescriptionText;
	private JButton prevButton, nextButton;
	private int currentGameIndex = 0;
	private RoundedPanel[] roundedPanels = new RoundedPanel[6];

	// 게임 정보를 담을 배열
	private String[] gameNames = { "날아! 날아!", "우주로", "바다이야기", "이슬비", "penalty24", "클릭클릭" };
	private String[] gameDescriptions = { "날아라 토양이는 토양이를 스페이스바로 사용해 배관에 부딛치지 않고 최고점수를 따내는 게임이다.", "게임2 설명", "게임3 설명",
			"게임4 설명", "게임5 설명", "게임6 설명" };
	// 게임 이미지 경로나 아이콘을 사용할 수 있습니다. \
	private String[] gameImages = { "flyingflying.gif", "into space.gif", "the story of the sea.gif", "sprinkle.gif",
			"penalty24.gif", "ClickClick.gif" };

	public GameDescription() {
		setTitle("게임 설명 페이지");
		setSize(768, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setFocusable(true);
		requestFocusInWindow();

		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBounds(0, 0, 768, 600);
		mainPanel.setBackground(new Color(255, 255, 244));
		add(mainPanel);

		setupUI();
		updateGameInfo(currentGameIndex);

		setVisible(true);
	}

	public GameDescription(int currentGameIndex) {
		setTitle("게임 설명 페이지");
		setSize(768, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setFocusable(true);
		requestFocusInWindow();

		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBounds(0, 0, 768, 600);
		mainPanel.setBackground(new Color(255, 255, 244));
		add(mainPanel);
		this.currentGameIndex=currentGameIndex;
		setupUI();
		updateGameInfo(currentGameIndex);

		setVisible(true);
	}

	private void setupUI() {
		// 상단에 메인 화면으로 가는 버튼
		RoundedButton button = new RoundedButton(40);
		JLabel EndLabel = new JLabel("게임 종료");
		EndLabel.setFont(new Font("던파 비트비트체 v2", Font.BOLD, 15));
		EndLabel.setBounds(78, 50, 100, 40);
		EndLabel.setForeground(Color.white);
		button.setBackground(new Color(94, 94, 94));
		button.setBounds(60, 50, 100, 40);
		mainPanel.add(EndLabel);
		mainPanel.add(button);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentGameIndex > 0) {
					currentGameIndex--;
					updateGameInfo(currentGameIndex);
				}
			}
		});

		// 게임 이미지 표시 패널
		gameImagePanel = new JPanel();
		gameImagePanel.setBounds(60, 100, 400, 300);
		gameImagePanel.setOpaque(false);// 패널 투명하게
		mainPanel.add(gameImagePanel);

		// 게임 이름, 설명, 시작 버튼을 담을 패널
		JPanel descriptionPanel = new JPanel();
		descriptionPanel.setLayout(null);
		descriptionPanel.setBackground(new Color(255, 255, 255));
		gameNameLabel = new JLabel();
		gameNameLabel.setFont(new Font("던파 비트비트체 v2", Font.BOLD, 35));
		gameNameLabel.setBounds(500, 30, 200, 200);
		gameNameLabel.setBackground(new Color(255, 255, 255));
		mainPanel.add(gameNameLabel);
		gameDescriptionText = new JTextArea();
		gameDescriptionText.setWrapStyleWord(true);
		gameDescriptionText.setLineWrap(true);
		gameDescriptionText.setBounds(0, 0, 210, 200);
		gameDescriptionText.setOpaque(false);// 패널 투명하게
		descriptionPanel.add(gameDescriptionText);
		descriptionPanel.setBounds(500, 180, 210, 100);
		descriptionPanel.setOpaque(false);// 패널 투명하게
		mainPanel.add(descriptionPanel);

		RoundedButton startGameButton = new RoundedButton(40);
		JLabel StartLabel = new JLabel("게임 시작");
		StartLabel.setFont(new Font("던파 비트비트체 v2", Font.BOLD, 20));
		StartLabel.setBounds(555, 300, 200, 50);
		StartLabel.setForeground(Color.white);
		startGameButton.setBackground(new Color(94, 94, 94));
		startGameButton.setBounds(500, 300, 200, 50);
		mainPanel.add(StartLabel);
		mainPanel.add(startGameButton);

		startGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				switch (currentGameIndex) {
				case 0:
					new FlyingFlying();
					break;
				case 1:
					StartFrame.getInstance(new StartPanel());
					break;
				case 2:
					new Umi();
					break;
				case 3:
					new Keyword();
					break;
				case 4:
					new penalty24();
					break;
				case 5:
					new ClickClickGame();
					break;
				}

			}
		});
		ImageIcon previmg = new ImageIcon("왼쪽.png");
		Image prevchangeimg = previmg.getImage();
		Image prevscaleimg = prevchangeimg.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		previmg.setImage(prevscaleimg);
		JLabel prevlabel = new JLabel(previmg);

		ImageIcon nextimg = new ImageIcon("오른쪽.png");
		Image nextchangeimg = nextimg.getImage();
		Image nextscaleimg = nextchangeimg.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		nextimg.setImage(nextscaleimg);
		JLabel nextlabel = new JLabel(nextimg);

		// 하단에 게임 변경 버튼
		prevButton = new JButton();
		nextButton = new JButton();
		prevButton.setOpaque(false);
		prevButton.setContentAreaFilled(false); // 버튼 내용 영역 배경 그리지 않음
		prevButton.setBorderPainted(false); // 버튼 테두리 그리지 않음

		nextButton.setOpaque(false);
		nextButton.setContentAreaFilled(false); // 버튼 내용 영역 배경 그리지 않음
		nextButton.setBorderPainted(false); // 버튼 테두리 그리지 않음
		prevButton.add(prevlabel);
		nextButton.add(nextlabel);
		JPanel navigationPanel = new JPanel();
		navigationPanel.setBounds(230, 430, 300, 100); // 예시 위치 및 크기, 실제로는 조정 필요

		roundedPanels[0] = new RoundedPanel(30, Color.GRAY); // 새 객체 할당
		roundedPanels[1] = new RoundedPanel(30, Color.GRAY); // 새 객체 할당
		roundedPanels[2] = new RoundedPanel(30, Color.GRAY); // 새 객체 할당
		roundedPanels[3] = new RoundedPanel(30, Color.GRAY); // 새 객체 할당
		roundedPanels[4] = new RoundedPanel(30, Color.GRAY); // 새 객체 할당
		roundedPanels[5] = new RoundedPanel(30, Color.GRAY); // 새 객체 할당

		navigationPanel.add(prevButton);
		navigationPanel.add(roundedPanels[0]);
		navigationPanel.add(roundedPanels[1]);
		navigationPanel.add(roundedPanels[2]);
		navigationPanel.add(roundedPanels[3]);
		navigationPanel.add(roundedPanels[4]);
		navigationPanel.add(roundedPanels[5]);
		navigationPanel.add(nextButton);
		navigationPanel.setOpaque(false);// 패널 투명하게
		mainPanel.add(navigationPanel);

		prevButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentGameIndex > 0) {
					currentGameIndex--;
					RotateAndUpdateColors(roundedPanels);
					navigationPanel.revalidate();
					navigationPanel.repaint();
					updateGameInfo(currentGameIndex);
				}
			}
		});

		nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentGameIndex < gameNames.length - 1) {
					currentGameIndex++;
					RotateAndUpdateColors(roundedPanels);
					navigationPanel.revalidate();
					navigationPanel.repaint();
					updateGameInfo(currentGameIndex);
				}
			}
		});

	}

	private void RotateAndUpdateColors(RoundedPanel[] panels) {
		// 색상 변경
		if (currentGameIndex <= 5 && currentGameIndex >= 0) {
			for (int i = 0; i < panels.length; i++) {
				if (i == currentGameIndex) { // 가운데 원을 파란색으로 변경
					panels[i].setColor(Color.BLUE); // 색상 변경 메서드 호출
				} else { // 나머지 원들은 회색으로 변경
					panels[i].setColor(Color.GRAY); // 색상 변경 메서드 호출
				}
			}
			// 변경된 색상으로 UI를 업데이트

		} 
	}

	private void updateGameInfo(int gameIndex) {
		gameImagePanel.removeAll();
		gameNameLabel.setText(gameNames[gameIndex]);
		gameDescriptionText.setText(gameDescriptions[gameIndex]);
		ImageIcon icon = new ImageIcon(gameImages[gameIndex]);
		RotateAndUpdateColors(roundedPanels);
		// GIF 이미지를 로드하여 ImageIcon 객체 생성
		ImageIcon img = icon;
		// JLabel에 ImageIcon을 설정
		JLabel label = new JLabel(img);
		gameImagePanel.add(label);
		mainPanel.add(gameImagePanel);

		// gameImagePanel을 다시 그리도록 함
		mainPanel.revalidate();
		mainPanel.repaint();

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GameDescription();
			}
		});
	}

}