package gameDescription;

import java.awt.Color;
import java.awt.Font;
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

public class GameDescription extends JFrame {
	private JPanel mainPanel;
	private JPanel gameImagePanel;
	private JLabel gameNameLabel;
	private JTextArea gameDescriptionText;
	private JButton prevButton, nextButton;
	private int currentGameIndex = 0;
	private RoundedPanel[] roundedPanels = new RoundedPanel[3];

	// ���� ������ ���� �迭
	private String[] gameNames = { "���ƶ� �����", "�̽���", "ClickClick", "penalty24", "�ٴ��̾߱�", "����6" };
	private String[] gameDescriptions = { "���ƶ� ����̴� ����̸� �����̽��ٷ� ����� ����� �ε�ġ�� �ʰ� �ְ������� ������ �����̴�.", "����2 ����", "����3 ����",
			"����4 ����", "����5 ����", "����6 ����" };
	// ���� �̹��� ��γ� �������� ����� �� �ֽ��ϴ�. \
	private String[] gameImages = { "flyingflying.gif", "sul1_1.jpg", "sul1_2.jpg", "/path/to/game4/image",
			"/path/to/game5/image", "/path/to/game6/image" };

	public GameDescription() {
		setTitle("���� ���� ������");
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
		setTitle("���� ���� ������");
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
		// ��ܿ� ���� ȭ������ ���� ��ư
		RoundedButton button = new RoundedButton(40, "����ȭ��");
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

		// ���� �̹��� ǥ�� �г�
		gameImagePanel = new JPanel();
		gameImagePanel.setBounds(60, 100, 400, 300);
		gameImagePanel.setOpaque(false);// �г� �����ϰ�
		mainPanel.add(gameImagePanel);

		// ���� �̸�, ����, ���� ��ư�� ���� �г�
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
		gameDescriptionText.setOpaque(false);// �г� �����ϰ�
		descriptionPanel.add(gameDescriptionText);
		descriptionPanel.setBounds(500, 180, 210, 100);
		descriptionPanel.setOpaque(false);// �г� �����ϰ�
		mainPanel.add(descriptionPanel);

		RoundedButton startGameButton = new RoundedButton(40, "���� ����");
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

		// �ϴܿ� ���� ���� ��ư
		prevButton = new JButton("<");
		nextButton = new JButton(">");
		JPanel navigationPanel = new JPanel();
		navigationPanel.setBounds(300, 500, 168, 50); // ���� ��ġ �� ũ��, �����δ� ���� �ʿ�

		roundedPanels[0] = new RoundedPanel(30, Color.BLUE); // �� ��ü �Ҵ�
		roundedPanels[1] = new RoundedPanel(30, Color.GRAY); // �� ��ü �Ҵ�
		roundedPanels[2] = new RoundedPanel(30, Color.GRAY); // �� ��ü �Ҵ�

		navigationPanel.add(prevButton);
		navigationPanel.add(roundedPanels[0]);
		navigationPanel.add(roundedPanels[1]);
		navigationPanel.add(roundedPanels[2]);
		navigationPanel.add(nextButton);
		navigationPanel.setOpaque(false);// �г� �����ϰ�
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
		// ���� ����
		if (currentGameIndex <= 2 && currentGameIndex >= 0) {
			for (int i = 0; i < panels.length; i++) {
				if (i == currentGameIndex) { // ��� ���� �Ķ������� ����
					panels[i].setColor(Color.BLUE); // ���� ���� �޼��� ȣ��
				} else { // ������ ������ ȸ������ ����
					panels[i].setColor(Color.GRAY); // ���� ���� �޼��� ȣ��
				}
			}
			// ����� �������� UI�� ������Ʈ

		} else if (currentGameIndex <= 5 && currentGameIndex >= 3) {
			for (int i = 0; i < panels.length; i++) {
				if (i == (currentGameIndex - 3)) { // ��� ���� �Ķ������� ����
					panels[i].setColor(Color.BLUE); // ���� ���� �޼��� ȣ��
				} else { // ������ ������ ȸ������ ����
					panels[i].setColor(Color.GRAY); // ���� ���� �޼��� ȣ��
				}
			}
		}
	}

	private void updateGameInfo(int gameIndex) {
		gameImagePanel.removeAll();
		gameNameLabel.setText(gameNames[gameIndex]);
		gameDescriptionText.setText(gameDescriptions[gameIndex]);
		ImageIcon icon = new ImageIcon(gameImages[gameIndex]);

		// GIF �̹����� �ε��Ͽ� ImageIcon ��ü ����
		JLabel label = new JLabel(icon);
		gameImagePanel.add(label);
		mainPanel.add(gameImagePanel);

		// gameImagePanel�� �ٽ� �׸����� ��
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