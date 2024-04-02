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

		// â ����
		JFrame f = new JFrame("~ �� �� �� �� �� ~");
		f.setLayout(null);

		f.setSize(800, 600); // ������ ������
		f.setLocationRelativeTo(null);

		ImageIcon img = new ImageIcon("main_tobira.jpg");
		JLabel jl = new JLabel(img);
		jl.setBounds(0, 0, 800, 600); // ��������� ����� ��
		Font font = new Font("�������", Font.PLAIN, 12);

		// ���� ����
		JButton startButton = new JButton("��� ����");
		startButton.setBounds(170, 450, 150, 50); // ��ư ��ġ �� ������ ����
		startButton.setFont(font);
		f.add(startButton);

		// ���� �������ڷ� ���� ������ ��ư
		JButton endButton = new JButton("���� ���� ����");
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

		///// ���� ��µǴ� ��
		JTextArea textArea = new JTextArea(5, 20);
		textArea.setFont(font);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(130, 200, 500, 230);
		//////////////
		textArea.append("ȯ���մϴ�!\n");
		textArea.append("<��� ����> ��ư�� Ŭ���� ������ Ž���� ���ô�.\n");

		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				DefaultFrame.getInstance(new GameDescription(2), "���� ���� ȭ��");
			}
		});

		// ��ư�׼�
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int iriguchi = 0;
				boolean isValidInput = false;
				do {
					String input = JOptionPane.showInputDialog("�� �� ����Ͻðڽ��ϱ�? (1~10 ������ ���ڸ� �Է��� �ּ���.)");
					if (input != null && !input.isEmpty()) {
						try {
							iriguchi = Integer.parseInt(input);
							// ����ڰ� 1���� 10 ������ ���ڸ� �Է��ߴ��� Ȯ��
							if (iriguchi >= 1 && iriguchi <= 10) {
								isValidInput = true;
							} else {
								// ��ȿ���� ���� ������ ���ڸ� �Է��� ���
								JOptionPane.showMessageDialog(null, "�׷��� ���� ����ߴٰ� �׽��ϴ�.", "Ƚ�� �ʰ�",
										JOptionPane.ERROR_MESSAGE);
							}
						} catch (NumberFormatException ex) {
							// ���ڰ� �ƴ� ���� �Է��� ���
							JOptionPane.showMessageDialog(null, "�ٸ� �� ���� ����� �����սô�.", "Ƚ�� ���Է�",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						// ����ڰ� ��� ��ư�� �����ų� �Է� ���� Ȯ�� ��ư�� ���� ���
						return; // �޼��� ����
					}
				} while (!isValidInput);

				textArea.setText(iriguchi + "���� ����� �����մϴ�.\n");
				for (int i = 0; i < iriguchi; i++) {
					int ran = random.nextInt(2);
					if (ran == 0) {
						textArea.append("�١�o��" + (i + 1) + "���� ��� ���� ���� ���� �߰�!��o�ۡ�\n\n");
						takarabako++;

					} else {
						textArea.append("���� ���ڸ� �߰����� ���߽��ϴ�.\n");
					}
				}
				textArea.append("\n���� Ž���� ���ƽ��ϴ�.\n\n");
				textArea.append("\n�� " + takarabako + "���� ���� ���� ȹ��.\n\n");
				textArea.append("����� ������ ������ �����մϴ�.\n\n");
				textArea.append("���� ���ڸ� ���� �� ������ ������ <��� ����> ��ư�� ���� �ٽ� ����� �ּ���.\n");
				textArea.append("����� ��Ҵٸ� <���� ���� ����> ��ư�� ���� ���� ������ �ڹ��踦 �� ���ô�.\n");
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