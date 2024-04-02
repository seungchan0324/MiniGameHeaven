package YeonGame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import defaultFrame.DefaultFrame;
import gameDescription.GameDescription;

public class Umi extends JFrame {

	static BufferedImage img[] = new BufferedImage[3];
	private static int[] numbers = new int[3];
	private int takarabako = 0;
	private Random random = new Random();

	public Umi() {

		// 창 설정
		JFrame f = new JFrame("~ 바 다 스 토 리 ~");
		f.setLayout(null);

		f.setSize(800, 600); // 윈도우 사이즈
		f.setLocationRelativeTo(null);

		ImageIcon img = new ImageIcon("main_tobira.jpg");
		JLabel jl = new JLabel(img);
		jl.setBounds(0, 0, 800, 600); // 원본사이즈에 맞춰야 함
		Font font = new Font("맑은고딕", Font.PLAIN, 12);

		// 게임 시작
		JButton startButton = new JButton("잠수 시작");
		startButton.setBounds(170, 450, 150, 50); // 버튼 위치 및 사이즈 설정
		startButton.setFont(font);
		f.add(startButton);

		// 얻은 보물상자로 슬롯 돌리는 버튼
		JButton endButton = new JButton("보물 상자 열기");
		endButton.setBounds(420, 450, 150, 50);
		endButton.setFont(font);
		f.add(endButton);
		endButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				Takaramono tk = new Takaramono(takarabako);
				tk.setVisible(true);

			}
		});

		///// 로직 출력되는 곳
		JTextArea textArea = new JTextArea(5, 20);
		textArea.setFont(font);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(130, 200, 500, 230);
		//////////////
		textArea.append("환영합니다!\n");
		textArea.append("<잠수 시작> 버튼을 클릭해 해저를 탐험해 봅시다.\n");

		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				DefaultFrame.getInstance(new GameDescription(2), "게임 설명 화면");
			}
		});

		// 버튼액션
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int iriguchi = 0;
				boolean isValidInput = false;
				do {
					String input = JOptionPane.showInputDialog("몇 번 잠수하시겠습니까? (1~10 사이의 숫자를 입력해 주세요.)");
					if (input != null && !input.isEmpty()) {
						try {
							iriguchi = Integer.parseInt(input);
							// 사용자가 1부터 10 사이의 숫자를 입력했는지 확인
							if (iriguchi >= 1 && iriguchi <= 10) {
								isValidInput = true;
							} else {
								// 유효하지 않은 범위의 숫자를 입력한 경우
								JOptionPane.showMessageDialog(null, "그렇게 오래 잠수했다간 죽습니다.", "횟수 초과",
										JOptionPane.ERROR_MESSAGE);
							}
						} catch (NumberFormatException ex) {
							// 숫자가 아닌 값을 입력한 경우
							JOptionPane.showMessageDialog(null, "다른 짓 말고 잠수에 집중합시다.", "횟수 미입력",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						// 사용자가 취소 버튼을 누르거나 입력 없이 확인 버튼을 누른 경우
						return; // 메서드 종료
					}
				} while (!isValidInput);

				textArea.setText(iriguchi + "번의 잠수를 시작합니다.\n");
				for (int i = 0; i < iriguchi; i++) {
					int ran = random.nextInt(2);
					if (ran == 0) {
						textArea.append("☆○o。" + (i + 1) + "번의 잠수 끝에 보물 상자 발견!。o○☆\n\n");
						takarabako++;

					} else {
						textArea.append("보물 상자를 발견하지 못했습니다.\n");
					}
				}
				textArea.append("\n해저 탐험을 마쳤습니다.\n\n");
				textArea.append("\n총 " + takarabako + "개의 보물 상자 획득.\n\n");
				textArea.append("잠수를 끝내고 뭍으로 복귀합니다.\n\n");
				textArea.append("보물 상자를 조금 더 모으고 싶으면 <잠수 시작> 버튼을 눌러 다시 잠수해 주세요.\n");
				textArea.append("충분히 모았다면 <보물 상자 열기> 버튼을 눌러 보물 상자의 자물쇠를 따 봅시다.\n");
				return;
			}

		});

		f.add(scrollPane);
		f.add(startButton);
		f.add(endButton);
		f.add(jl);
		f.setLayout(null);
		f.setVisible(true);

	}

	public static void main(String[] args) {
		new Umi();
	}
}