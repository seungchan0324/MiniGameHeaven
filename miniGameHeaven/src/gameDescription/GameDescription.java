package gameDescription;

import javax.swing.*;

import DongGame.ClickClickGame;
import HeyonGame.FlyingFlying;
import SongGame.Keyword;
import SunGmae.penalty24;
import YeonGame.Umi;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameDescription extends JFrame {
    private JPanel mainPanel;
    private JPanel gameImagePanel;
    private JLabel gameNameLabel;
    private JTextArea gameDescriptionText;
    private JButton prevButton, nextButton;
    private int currentGameIndex = 0;
    private RoundedPanel[] roundedPanels = new RoundedPanel[3];

    // 게임 정보를 담을 배열 
    private String[] gameNames = {"날아라 토양이", "이슬비", "ClickClick", "penalty24", "바다이야기", "게임6"};
    private String[] gameDescriptions = {
        "날아라 토양이는 토양이를 스페이스바로 사용해 배관에 부딛치지 않고 최고점수를 따내는 게임이다.", "게임2 설명", "게임3 설명", "게임4 설명", "게임5 설명", "게임6 설명"
    };
    // 게임 이미지 경로나 아이콘을 사용할 수 있습니다. \
    private String[] gameImages = {
        "Game1.png", "sul1_1.jpg", "sul1_2.jpg",
        "/path/to/game4/image", "/path/to/game5/image", "/path/to/game6/image"
    };

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

    private void setupUI() {
        // 상단에 메인 화면으로 가는 버튼
    	RoundedButton button = new RoundedButton(40, "메인화면");
        button.setBackground(new Color(255, 255, 255));
        button.setBounds(20, 20, 100, 40);
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
        gameNameLabel.setFont(new Font("Serif", Font.BOLD, 30));
        gameNameLabel.setBounds(500, 30, 200, 200);
        mainPanel.add(gameNameLabel);
        gameDescriptionText = new JTextArea();
        gameDescriptionText.setWrapStyleWord(true);
        gameDescriptionText.setLineWrap(true);
        gameDescriptionText.setBounds(0, 0, 210, 200);
        gameDescriptionText.setOpaque(false);// 패널 투명하게
        descriptionPanel.add(gameDescriptionText);
        descriptionPanel.setBounds(500, 180, 210, 200);
        descriptionPanel.setOpaque(false);// 패널 투명하게
        mainPanel.add(descriptionPanel);
        

        RoundedButton startGameButton = new RoundedButton(40, "게임 시작");
        startGameButton.setBackground(new Color(255, 255, 255));
        startGameButton.setBounds(500, 340, 200, 50);
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
					new Keyword();
					break;
				case 2:
					new ClickClickGame();
					break;
				case 3:
					new penalty24();
					break;
				case 4:
					new Umi();
					break;
				case 5:
					new Keyword();
					break;
				}

			}
		});

        
        
        // 하단에 게임 변경 버튼
        prevButton = new JButton("<");
        nextButton = new JButton(">");
        JPanel navigationPanel = new JPanel();
        navigationPanel.setBounds(300, 500, 168, 50); // 예시 위치 및 크기, 실제로는 조정 필요

        roundedPanels[0] = new RoundedPanel(30, Color.BLUE); // 새 객체 할당
        roundedPanels[1] = new RoundedPanel(30, Color.GRAY); // 새 객체 할당
        roundedPanels[2] = new RoundedPanel(30, Color.GRAY); // 새 객체 할당

        navigationPanel.add(prevButton);
        navigationPanel.add(roundedPanels[0]);
        navigationPanel.add(roundedPanels[1]);
        navigationPanel.add(roundedPanels[2]);
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
	    if(currentGameIndex<=2 && currentGameIndex>=0) {
	        for (int i = 0; i < panels.length; i++) {
	            if (i == currentGameIndex) { // 가운데 원을 파란색으로 변경
	            	panels[i].setColor(Color.BLUE); // 색상 변경 메서드 호출
	            } else { // 나머지 원들은 회색으로 변경
	            	panels[i].setColor(Color.GRAY); // 색상 변경 메서드 호출
	            }
	        }
	        // 변경된 색상으로 UI를 업데이트

	    }else if(currentGameIndex<=5 && currentGameIndex>=3) {
	    	for (int i = 0; i < panels.length; i++) {
	            if (i == (currentGameIndex-3)) { // 가운데 원을 파란색으로 변경
	            	panels[i].setColor(Color.BLUE); // 색상 변경 메서드 호출
	            } else { // 나머지 원들은 회색으로 변경
	            	panels[i].setColor(Color.GRAY); // 색상 변경 메서드 호출
	            }
	        }
	    }
	}

    private void updateGameInfo(int gameIndex) {
    	gameImagePanel.removeAll();
        gameNameLabel.setText(gameNames[gameIndex]);
        gameDescriptionText.setText(gameDescriptions[gameIndex]);
        ImageIcon icon = new ImageIcon(gameImages[gameIndex]);

		Image changeimg = icon.getImage();
		Image scaleimg = changeimg.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
		icon.setImage(scaleimg);
		JLabel label = new JLabel(icon);
		gameImagePanel.add(label);
        mainPanel.add(gameImagePanel);

        // gameImagePanel을 다시 그리도록 함
        mainPanel.revalidate();
        mainPanel.repaint();

    }

    public static void rightRotate(RoundedPanel[] array) {
        // 배열의 마지막 요소를 임시 변수에 저장
        RoundedPanel lastElement = array[array.length - 1];
        
        // 배열의 나머지 요소를 오른쪽으로 이동
        for (int i = 0; i > array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        
        // 배열의 첫 번째 요소로 임시 변수의 값을 설정
        array[0] = lastElement;
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