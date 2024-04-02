package SunGame;

import javax.swing.*;

import defaultFrame.DefaultFrame;
import gameDescription.GameDescription;
import my_Information.MyInformationPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Game extends JFrame {

	private ImageIcon initialIcon;
	private JLabel lb1;
	private JLabel scoreLabel;
	private int attempts = 0;
	private int goals = 0;
	private int points = 0;
	private JLabel messageLabel;
	public static int Penalty24MaxScore;

	public Game() {
		initialIcon = new ImageIcon("golkeep.jpg");

		lb1 = new JLabel(initialIcon, JLabel.CENTER);
		lb1.setBounds(0, 60, 700, 500);
		add(lb1);
		setResizable(false);
		setTitle("페널티 킥");
		setLocation(600, 170);
		setSize(700, 700);
		setLayout(null);

		scoreLabel = new JLabel("시도: 0, 골: 0     현재 포인트: " + points, JLabel.CENTER);
		scoreLabel.setBounds(0, 0, 700, 30);
		add(scoreLabel);

		messageLabel = new JLabel("", JLabel.CENTER);
		messageLabel.setBounds(0, 10, 700, 50);
		add(messageLabel);

		JButton button = new JButton("왼쪽으로 차기");
		button.setBounds(100, 550, 130, 80);
		JButton button2 = new JButton("가운데로 차기");
		button2.setBounds(280, 550, 130, 80);
		JButton button3 = new JButton("오른쪽으로 차기");
		button3.setBounds(460, 550, 130, 80);
		JButton restartButton = new JButton("다시하기");
		restartButton.setBounds(560, 20, 100, 30);
		JButton overButton = new JButton("게임종료");
		overButton.setBounds(30, 20, 100, 30);

		add(button);
		add(button2);
		add(button3);
		add(restartButton);
		add(overButton);

		button.addActionListener(e -> shoot(1));
		button2.addActionListener(e -> shoot(2));
		button3.addActionListener(e -> shoot(3));

		restartButton.addActionListener(e -> resetGame());
		overButton.addActionListener(e -> exitGame());

		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				DefaultFrame.getInstance(new GameDescription(2), "게임 설명 화면");
			}
		});

	}

	private void shoot(int direction) {
		if (attempts >= 5) {
			return;
		}
		ImageIcon shotIcon;
		String imagePath;
		switch (direction) {
		case 1:
			imagePath = "bale.jpg";
			break;
		case 2:
			imagePath = "golkeep2.jpg";
			break;
		case 3:
			imagePath = "bari.jpg";
			break;
		default:
			imagePath = "";

		}
		shotIcon = new ImageIcon(imagePath);
		lb1.setIcon(shotIcon);

		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				executeShotResult(direction);
			}
		}, 150);
	}

	private void executeShotResult(int playerDirection) {
		Random random = new Random();
		int keeper = random.nextInt(3) + 1;

		String keeperImagePath = switch (keeper) {
		case 1 -> "dele.jpg";
		case 2 -> "ke.jpg";
		case 3 -> "deri.jpg";
		default -> initialIcon.toString();
		};

		ImageIcon newIcon = new ImageIcon(keeperImagePath);
		lb1.setIcon(newIcon);

		attempts++;

		if (playerDirection == keeper) {
			messageLabel.setText("골키퍼가 막았습니다.");
		} else {
			messageLabel.setText("골!!!");
			goals++;
			if (goals == 3) {
				points += 10;
			}
		}

		scoreLabel.setText(String.format("시도: %d, 골: %d", attempts, goals));

		if (attempts == 5) {
			MyInformationPanel.money += points;
			Penalty24MaxScore = Penalty24MaxScore < goals ? goals : Penalty24MaxScore;
			JOptionPane.showMessageDialog(this, goals >= 3 ? "승리했습니다! 포인트10점 획득" : "패배했습니다.");
		}

		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				lb1.setIcon(initialIcon);
				messageLabel.setText("");
			}
		}, 1000);
	}

	private void resetGame() {
		attempts = 0;
		goals = 0;
		scoreLabel.setText("시도: 0, 골: 0     현재 포인트: " + points);
		messageLabel.setText("");
		lb1.setIcon(initialIcon);
	}

	private void exitGame() {
		dispose();
		DefaultFrame.getInstance(new GameDescription(4), "게임 설명 화면");
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(Game::new);
	}
}
