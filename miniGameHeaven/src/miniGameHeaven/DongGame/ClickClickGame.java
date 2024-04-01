package DongGame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import defaultFrame.DefaultFrame;
import gameDescription.GameDescription;
import my_Information.MyInformationPanel;

public class ClickClickGame extends JFrame {

	private int click = 0;
	private int clickNeeded = 30;
	private int level = 1;
	private int score = 0;

	private JLabel clickLabel;
	private JLabel remainingClicksLabel;
	private JLabel levelLabel;
	private JLabel gameLabel;
	private JLabel backgroundLabel;
	private JLabel scoreLabel;
	private JLabel breakLabel;

	public ClickClickGame() {
		setTitle("ClickClick");
		setSize(500, 500);
		setLocationRelativeTo(null);
		
		// Creating main panel with pink background
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);

		// Creating click label
		clickLabel = new JLabel(getEggIcon());
		clickLabel.setBounds(230, 120, 200, 247);
		mainPanel.add(clickLabel);

		// Creating break Label
		breakLabel = new JLabel("알이 깨졌습니다");
		breakLabel.setFont(new Font("고딕체", Font.BOLD, 21));
		breakLabel.setBounds(230, 60, 800, 80);
		breakLabel.setVisible(false);
		mainPanel.add(breakLabel);

		// Creating game Label
		gameLabel = new JLabel("게임을 시작하려면 알을 클릭하세요!");
		gameLabel.setFont(new Font("궁서체", Font.BOLD, 23));
		gameLabel.setBounds(40, 20, 500, 80);
		gameLabel.setVisible(true);
		mainPanel.add(gameLabel);

		// Creating score Label
		scoreLabel = new JLabel("Score: " + score);
		scoreLabel.setFont(new Font("디딤체", Font.BOLD, 15));
		scoreLabel.setBounds(320, 350, 300, 80);
		scoreLabel.setVisible(false);
		mainPanel.add(scoreLabel);

		// Creating remaining clicks label
		remainingClicksLabel = new JLabel("남은 클릭 횟수: " + clickNeeded);
		remainingClicksLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		remainingClicksLabel.setBounds(40, 150, 450, 80);
		mainPanel.add(remainingClicksLabel, BorderLayout.WEST);

		// Creating level Label
		levelLabel = new JLabel("Lv: " + level);
		levelLabel.setFont(new Font("디딤체", Font.BOLD, 15));
		levelLabel.setBounds(260, 350, 300, 80);
		levelLabel.setVisible(false);
		mainPanel.add(levelLabel, BorderLayout.NORTH);
		// Adding main panel to frame
		add(mainPanel);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				MyInformationPanel.money += score;
				dispose();
				DefaultFrame.getInstance(new GameDescription(5), "게임 설명 화면");
			}
		});

		// Mouse listener for clicking
		mainPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				levelLabel.setVisible(true);
				gameLabel.setVisible(false);
				scoreLabel.setVisible(true);
				if (click % 3 == 0) {
					score++;
					scoreLabel.setText("Score: " + score);
				}
				if (click < clickNeeded) {
					if (level > 5) {
						click = click + 2;
					} else if (level > 10) {
						click = click + 3;
					} else {
						click++;
					}
					clickLabel.setIcon(getEggIcon());
					remainingClicksLabel.setText("남은 클릭 횟수: " + (clickNeeded - click));
					if (click >= clickNeeded) {
						level++;
						clickNeeded = level * 15;
						backgroundLabel.setIcon(backIcon());
						breakLabel.setVisible(true);
						breakLabel.setText("알이 깨졌습니다!!");
						remainingClicksLabel.setText("남은 클릭 횟수: " + clickNeeded);
						click = 0;
						levelLabel.setText("Lv: " + level);
					} else {
						breakLabel.setVisible(false);
					}
				}
			}
		});
		// background
		ImageIcon backgroundIamge = new ImageIcon("skys.jpg"); // 배경사진
		backgroundLabel = new JLabel(backgroundIamge);
		backgroundLabel.setBounds(0, 0, 500, 500);
		mainPanel.add(backgroundLabel);
		setVisible(true);
	}

	private ImageIcon backIcon() {
		ImageIcon[] backgroundIcons = { new ImageIcon("bk1.jpg"), new ImageIcon("bk2.jpg"), new ImageIcon("bk3.jpg"), };
		return backgroundIcons[(level) % backgroundIcons.length];

	}

	private ImageIcon getEggIcon() {
		ImageIcon[] eggIcons = { new ImageIcon("realegg.png"), new ImageIcon("realegg2.png"),
				new ImageIcon("realegg3.png") };
		return eggIcons[click % eggIcons.length];
	}

}