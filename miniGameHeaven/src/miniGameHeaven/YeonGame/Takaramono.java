package YeonGame;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

import defaultFrame.DefaultFrame;
import gameDescription.GameDescription;
import my_Information.MyInformationPanel;

public class Takaramono extends JFrame implements ActionListener {

	private int clickCount = 0; // 클릭 횟수를 추적하는 변수
	private int saigo = 0;
	private int point = 0;
	private int takarabako;
	public static int TakaramonoMaxScore;

	private boolean spinning = false;

	Timer timer;

	JLabel l1, l2, l3;
	ImageIcon image[] = { new ImageIcon("001.jpg"), new ImageIcon("002.jpg"), new ImageIcon("003.jpg") };

	public Takaramono(int takarabako) {
		this.takarabako = takarabako;

		setLayout(null);

		// 사이즈 지정
		setSize(800, 600);
		setTitle("~ 바 다 스 토 리 ~");
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, this.getWidth(), this.getHeight());
		panel.setLayout(null);

		ImageIcon img4 = new ImageIcon("slot.jpg");

		Image changeImg = img4.getImage();
		Image img = changeImg.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
		img4 = new ImageIcon(img);

		JLabel ura = new JLabel(img4);

		l1 = new JLabel(image[0]);
		l2 = new JLabel(image[1]);
		l3 = new JLabel(image[2]);

		Font font = new Font("맑은고딕", Font.PLAIN, 12);
		
		///// 로직 출력되는 곳
		JTextArea textArea = new JTextArea(5, 20);
		textArea.setFont(font);
		textArea.setEditable(false);
		textArea.append("총 " + takarabako + "개의 보물 상자를 열어 보겠습니다.\n");
		textArea.append("슬롯의 그림 세 개가 전부 일치할 시 자물쇠가 풀리는 듯합니다.\n\n");
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(150, 270, 500, 230);
		panel.add(scrollPane);
		//////////////

		// 좌표값
		ura.setBounds(0, 0, 800, 600);
		l1.setBounds(200, 80, 100, 100);
		l2.setBounds(350, 80, 100, 100);
		l3.setBounds(500, 80, 100, 100);

		add(panel);
		panel.add(l1);
		panel.add(l2);
		panel.add(l3);
		panel.add(ura);

		// 중앙에 나오는거
		setVisible(true);

		JButton startButton = new JButton("슬롯을 돌려 자물쇠 풀기!");
		startButton.setBounds(300, 200, 200, 50); // 버튼 위치 및 사이즈 설정
		startButton.setFont(font);
		ura.add(startButton);

		JButton restart = new JButton("다시 시작");
		restart.setBounds(550, 510, 100, 30); // 버튼 위치 및 사이즈 설정
		restart.setFont(font);
		ura.add(restart);
		restart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Umi();
			}
		});

		JButton shimai = new JButton("게임 종료");
		shimai.setBounds(665, 510, 100, 30);
		shimai.setFont(font);
		ura.add(shimai);
		shimai.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				DefaultFrame.getInstance(new GameDescription(2), "게임 설명 화면");
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				DefaultFrame.getInstance(new GameDescription(2), "게임 설명 화면");
			}
		});

		// 버튼액션 시작
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!spinning && clickCount < takarabako) {
					spinning = true;
					timer = new Timer(100, new ActionListener() {
						int count = 0;

						@Override
						public void actionPerformed(ActionEvent e) {
							if (count < 15) { // 이미지를 랜덤으로 변경
								int random1 = (int) (Math.random() * image.length);
								int random2 = (int) (Math.random() * image.length);
								int random3 = (int) (Math.random() * image.length);

								l1.setIcon(image[random1]);
								l2.setIcon(image[random2]);
								l3.setIcon(image[random3]);
								count++;
							} else { // 결과 출력
								timer.stop();
								int random1 = (int) (Math.random() * image.length);
								int random2 = (int) (Math.random() * image.length);
								int random3 = (int) (Math.random() * image.length);

								l1.setIcon(image[random1]);
								l2.setIcon(image[random2]);
								l3.setIcon(image[random3]);

								textArea.append((clickCount + 1) + "번째 보물 상자를 열어 보겠습니다.\n");

								if (image[random1].equals(image[random2]) && image[random2].equals(image[random3])) {
									textArea.append("신난다! 보물을 찾았습니다!\n");
									saigo++;
								} else {
									textArea.append("보물 상자 안에는 아무것도 없었습니다….\n");
								}

								clickCount++; // 클릭 횟수 증가
								spinning = false;

								// takarabako 횟수에 도달했을 때 로직 종료
								if (clickCount >= takarabako) {
									textArea.append("\n보물 상자를 전부 열었습니다.\n");
									textArea.append("총 " + saigo + "개의 보물을 찾았습니다.\n\n");
									point = saigo * 100;
									textArea.append("\n" + point + "포인트 획득");
									TakaramonoMaxScore += saigo;
									MyInformationPanel.money += point;
								}
							}
						}
					});
					timer.start();
				}
			}

		});
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}