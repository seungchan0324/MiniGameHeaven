package gameDescription;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import defaultFrame.RoundedButton;
import defaultFrame.RoundedPanel;
import infinityStair.StartFrame;
import infinityStair.StartPanel;
import my_Information.MyInformationPanel;

public class GameDescription extends JPanel {
	private JPanel mainPanel;
	private JPanel gameImagePanel;
	private JLabel gameNameLabel;
	private JTextArea gameDescriptionText;
	private JButton prevButton, nextButton;
	private int currentGameIndex = 0;
	private RoundedPanel[] roundedPanels = new RoundedPanel[6];

	// ���� ������ ���� �迭
	private String[] gameNames = { "����! ����!", "���ַ�", "�ٴٽ��丮", "�̽���", "penalty24", "Ŭ��Ŭ��" };
	private String[] gameDescriptions = { "�����̽��ٸ� �̿��� ���� ģ������ ����� ���� �� �ֵ��� ��������.\n"
			+ "�ε�ġ�� �ʰ� ������ ���ư� �ְ� ������ ������!", "���ָ� �����ϰ� ���� ���� ģ����\n"
			+ "�¿� ����Ű�� Ȱ���� ����� �ö� ���ָ� ��������!",
			"�ٴٿ� ���� ����� �� ����!\n"
					+ "��¼�� �ٴ�ӿ� ������ ������ ã�� �� ����������?!",
			"���� Ÿ�ڰ� �����ٰ� ?!\n" + "������ ! ���� �����ٰ� ! �ð��� 30�� !\n" + "ī�װ� ���� �������� �ܾ���� �ִ��� ������ ��Ȯ�ϰ� �Է��� �� !\n"
					+ "��̰� ���� Ÿ�� ������ �ϰ� ����Ʈ�� ���� !",
					"������ �º������� ����. ����, ���, ������. ��� ������ ���� ����?\n"
							+ "��ȸ�� �ټ� ��! �� �� �̻� ���� ������ �¸�, ����Ʈ�� ���� �� �ִٱ�!!",
			"���� �������� Ŭ���Ͽ� ���� ������ ������ ������!\n"
					+ "3�� Ŭ���� 1��, ������ ��浵 �ٲ�ϴ�.\n"
					+ "5������ Ŭ��Ƚ��+1����!\n"
					+ "������ �ʹ� ���� Ŭ���� ���콺�� ����� �հ��� ������ �����մϴ١�" };

	// ���� �̹��� ��γ� �������� ����� �� �ֽ��ϴ�. \
	private String[] gameImages = { "flyingflying.gif", "into space.gif", "the story of the sea.gif", "sprinkle.gif",
			"penalty24.gif", "ClickClick.gif" };

	public GameDescription() {
		setSize(768, 600);
		setLayout(null);
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
		setSize(768, 600);
		setLayout(null);
		setFocusable(true);
		requestFocusInWindow();

		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBounds(0, 0, 768, 600);
		mainPanel.setBackground(new Color(255, 255, 244));
		add(mainPanel);
		this.currentGameIndex = currentGameIndex;
		setupUI();
		updateGameInfo(currentGameIndex);

		setVisible(true);
	}

	private void setupUI() {
		// ��ܿ� ���� ȭ������ ���� ��ư
		RoundedButton mainbutton = new RoundedButton(40);
		JLabel mainLabel = new JLabel("���� ȭ��");
		mainLabel.setFont(new Font("���� ���", Font.BOLD, 15));
		mainLabel.setBounds(78, 50, 100, 40);
		mainLabel.setForeground(Color.white);
		mainbutton.setBackground(new Color(94, 94, 94));
		mainbutton.setBounds(60, 50, 100, 40);
		
		// ��ܿ� ������ ȭ�餷�� ���� ��ư
		RoundedButton infomebutton = new RoundedButton(40);
		JLabel infomeLabel = new JLabel("�� ����");
		infomeLabel.setFont(new Font("���� ���", Font.BOLD, 15));
		infomeLabel.setBounds(205, 50, 100, 40);
		infomeLabel.setForeground(Color.white);
		infomebutton.setBackground(new Color(94, 94, 94));
		infomebutton.setBounds(180, 50, 100, 40);
		
		//��ư����
		mainPanel.add(mainLabel);
		mainPanel.add(mainbutton);
		mainPanel.add(infomeLabel);
		mainPanel.add(infomebutton);

		// ����ȭ���ư �̺�Ʈ
		mainbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.getWindowAncestor(mainbutton).setVisible(false);
				DefaultFrame.getInstance(new Main_Interface(), "���� ȭ��");
			}
		});
		// ��������ư �̺�Ʈ
		infomebutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.getWindowAncestor(infomebutton).setVisible(false);
				DefaultFrame.getInstance(new MyInformationPanel(), "�� ����");
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
		gameNameLabel.setFont(new Font("���� ���", Font.BOLD, 35));
		gameNameLabel.setBounds(500, 30, 200, 200);
		gameNameLabel.setBackground(new Color(255, 255, 255));
		mainPanel.add(gameNameLabel);
		gameDescriptionText = new JTextArea();
		gameDescriptionText.setWrapStyleWord(true);
		gameDescriptionText.setLineWrap(true);
		gameDescriptionText.setBounds(0, 0, 210, 200);
		gameDescriptionText.setOpaque(false);// �г� �����ϰ�
		descriptionPanel.add(gameDescriptionText);
		descriptionPanel.setBounds(500, 170, 210, 130);
		descriptionPanel.setOpaque(false);// �г� �����ϰ�
		mainPanel.add(descriptionPanel);

		RoundedButton startGameButton = new RoundedButton(40);
		JLabel StartLabel = new JLabel("���� ����");
		StartLabel.setFont(new Font("���� ���", Font.BOLD, 20));
		StartLabel.setBounds(555, 300, 200, 50);
		StartLabel.setForeground(Color.white);
		startGameButton.setBackground(new Color(94, 94, 94));
		startGameButton.setBounds(500, 300, 200, 50);
		mainPanel.add(StartLabel);
		mainPanel.add(startGameButton);

		startGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.getWindowAncestor(startGameButton).setVisible(false);
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
		ImageIcon previmg = new ImageIcon("����.png");
		Image prevchangeimg = previmg.getImage();
		Image prevscaleimg = prevchangeimg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		previmg.setImage(prevscaleimg);
		JLabel prevlabel = new JLabel(previmg);

		ImageIcon nextimg = new ImageIcon("������.png");
		Image nextchangeimg = nextimg.getImage();
		Image nextscaleimg = nextchangeimg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		nextimg.setImage(nextscaleimg);
		JLabel nextlabel = new JLabel(nextimg);

		// �ϴܿ� ���� ���� ��ư
		prevButton = new JButton();
		nextButton = new JButton();
		prevButton.setOpaque(false);
		prevButton.setContentAreaFilled(false); // ��ư ���� ���� ��� �׸��� ����
		prevButton.setBorderPainted(false); // ��ư �׵θ� �׸��� ����

		nextButton.setOpaque(false);
		nextButton.setContentAreaFilled(false); // ��ư ���� ���� ��� �׸��� ����
		nextButton.setBorderPainted(false); // ��ư �׵θ� �׸��� ����
		prevButton.add(prevlabel);
		nextButton.add(nextlabel);
		JPanel navigationPanel = new JPanel();
		navigationPanel.setBounds(230, 430, 300, 100); // ���� ��ġ �� ũ��, �����δ� ���� �ʿ�

		roundedPanels[0] = new RoundedPanel(30, Color.GRAY); // �� ��ü �Ҵ�
		roundedPanels[1] = new RoundedPanel(30, Color.GRAY); // �� ��ü �Ҵ�
		roundedPanels[2] = new RoundedPanel(30, Color.GRAY); // �� ��ü �Ҵ�
		roundedPanels[3] = new RoundedPanel(30, Color.GRAY); // �� ��ü �Ҵ�
		roundedPanels[4] = new RoundedPanel(30, Color.GRAY); // �� ��ü �Ҵ�
		roundedPanels[5] = new RoundedPanel(30, Color.GRAY); // �� ��ü �Ҵ�

		navigationPanel.add(prevButton);
		navigationPanel.add(roundedPanels[0]);
		navigationPanel.add(roundedPanels[1]);
		navigationPanel.add(roundedPanels[2]);
		navigationPanel.add(roundedPanels[3]);
		navigationPanel.add(roundedPanels[4]);
		navigationPanel.add(roundedPanels[5]);
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
		if (currentGameIndex <= 5 && currentGameIndex >= 0) {
			for (int i = 0; i < panels.length; i++) {
				if (i == currentGameIndex) { // ��� ���� �Ķ������� ����
					panels[i].setColor(Color.BLUE); // ���� ���� �޼��� ȣ��
				} else { // ������ ������ ȸ������ ����
					panels[i].setColor(Color.GRAY); // ���� ���� �޼��� ȣ��
				}
			}
			// ����� �������� UI�� ������Ʈ

		}
	}

	private void updateGameInfo(int gameIndex) {
		gameImagePanel.removeAll();
		gameNameLabel.setText(gameNames[gameIndex]);
		gameDescriptionText.setText(gameDescriptions[gameIndex]);
		ImageIcon icon = new ImageIcon(gameImages[gameIndex]);
		RotateAndUpdateColors(roundedPanels);
		// GIF �̹����� �ε��Ͽ� ImageIcon ��ü ����
		ImageIcon img = icon;
		// JLabel�� ImageIcon�� ����
		JLabel label = new JLabel(img);
		gameImagePanel.add(label);
		mainPanel.add(gameImagePanel);

		// gameImagePanel�� �ٽ� �׸����� ��
		mainPanel.revalidate();
		mainPanel.repaint();

	}


}