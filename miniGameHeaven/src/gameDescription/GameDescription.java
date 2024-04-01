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
import Main_Interface.Main_Interface;
import SongGame.Keyword;
import SunGame.penalty24;
import YeonGame.Umi;
import defaultFrame.DefaultFrame;
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
	private String[] gameDescriptions = {
			
			"스페이스바를 이용해 숲속 친구들이 배관을 피할 수 있도록 도와주자.\n"
			+ "부딪치지 않고 끝까지 날아가 최고 점수를 따내자!",
			
			"게임2 설명",
			
			"바다에 가서 잠수를 해 보자!\n"
			+ "어쩌면 바닷속에 숨겨진 보물을 찾을 수 있을지도…?!",
			
			"영어 타자가 느리다고 ?!\n"
			+ "걱정 마 ! 내가 도와줄게 ! 시간은 30초 !\n"
			+ "카테고리별로 떨어지는 단어들을 최대한 빠르고 정확하게 입력해 봐 !\n"
			+ "즐겁게 영어 타자 연습도 하고 포인트도 얻어 가자 !"
			
			, "마지막 승부차기의 순간. 왼쪽, 가운데, 오른쪽. 어느 쪽으로 공을 찰까?\n"
					+ "기회는 다섯 번! 세 번 이상 골을 넣으면 승리, 포인트도 받을 수 있다구!!",
			
			"노가다의 끝판왕! 아무 생각 없이 하기 좋은 게임!\n"
			+ "레벨이 바뀔 때마다 배경도 바뀐다. 알을 마구마구 클릭해 최고점에 도전해 보자!" };
	
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
		JLabel EndLabel = new JLabel("메인 화면");
		EndLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		EndLabel.setBounds(78, 50, 100, 40);
		EndLabel.setForeground(Color.white);
		button.setBackground(new Color(94, 94, 94));
		button.setBounds(60, 50, 100, 40);
		mainPanel.add(EndLabel);
		mainPanel.add(button);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				DefaultFrame.getInstance(new Main_Interface(), "메인 화면");
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
		gameNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 35));
		gameNameLabel.setBounds(500, 30, 200, 200);
		gameNameLabel.setBackground(new Color(255, 255, 255));
		mainPanel.add(gameNameLabel);
		gameDescriptionText = new JTextArea();
		gameDescriptionText.setWrapStyleWord(true);
		gameDescriptionText.setLineWrap(true);
		gameDescriptionText.setBounds(0, 0, 210, 200);
		gameDescriptionText.setOpaque(false);// 패널 투명하게
		descriptionPanel.add(gameDescriptionText);
		descriptionPanel.setBounds(500, 180, 210, 120);
		descriptionPanel.setOpaque(false);// 패널 투명하게
		mainPanel.add(descriptionPanel);

		RoundedButton startGameButton = new RoundedButton(40);
		JLabel StartLabel = new JLabel("게임 시작");
		StartLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		StartLabel.setBounds(555, 300, 200, 50);
		StartLabel.setForeground(Color.white);
		startGameButton.setBackground(new Color(94, 94, 94));
		startGameButton.setBounds(500, 300, 200, 50);
		mainPanel.add(StartLabel);
		mainPanel.add(startGameButton);

		startGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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