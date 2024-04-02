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

	private int clickCount = 0; // Ŭ�� Ƚ���� �����ϴ� ����
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

		// ������ ����
		setSize(800, 600);
		setTitle("~ �� �� �� �� �� ~");
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

		Font font = new Font("�������", Font.PLAIN, 12);
		
		///// ���� ��µǴ� ��
		JTextArea textArea = new JTextArea(5, 20);
		textArea.setFont(font);
		textArea.setEditable(false);
		textArea.append("�� " + takarabako + "���� ���� ���ڸ� ���� ���ڽ��ϴ�.\n");
		textArea.append("������ �׸� �� ���� ���� ��ġ�� �� �ڹ��谡 Ǯ���� ���մϴ�.\n\n");
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(150, 270, 500, 230);
		panel.add(scrollPane);
		//////////////

		// ��ǥ��
		ura.setBounds(0, 0, 800, 600);
		l1.setBounds(200, 80, 100, 100);
		l2.setBounds(350, 80, 100, 100);
		l3.setBounds(500, 80, 100, 100);

		add(panel);
		panel.add(l1);
		panel.add(l2);
		panel.add(l3);
		panel.add(ura);

		// �߾ӿ� �����°�
		setVisible(true);

		JButton startButton = new JButton("������ ���� �ڹ��� Ǯ��!");
		startButton.setBounds(300, 200, 200, 50); // ��ư ��ġ �� ������ ����
		startButton.setFont(font);
		ura.add(startButton);

		JButton restart = new JButton("�ٽ� ����");
		restart.setBounds(550, 510, 100, 30); // ��ư ��ġ �� ������ ����
		restart.setFont(font);
		ura.add(restart);
		restart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Umi();
			}
		});

		JButton shimai = new JButton("���� ����");
		shimai.setBounds(665, 510, 100, 30);
		shimai.setFont(font);
		ura.add(shimai);
		shimai.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				DefaultFrame.getInstance(new GameDescription(2), "���� ���� ȭ��");
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				DefaultFrame.getInstance(new GameDescription(2), "���� ���� ȭ��");
			}
		});

		// ��ư�׼� ����
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!spinning && clickCount < takarabako) {
					spinning = true;
					timer = new Timer(100, new ActionListener() {
						int count = 0;

						@Override
						public void actionPerformed(ActionEvent e) {
							if (count < 15) { // �̹����� �������� ����
								int random1 = (int) (Math.random() * image.length);
								int random2 = (int) (Math.random() * image.length);
								int random3 = (int) (Math.random() * image.length);

								l1.setIcon(image[random1]);
								l2.setIcon(image[random2]);
								l3.setIcon(image[random3]);
								count++;
							} else { // ��� ���
								timer.stop();
								int random1 = (int) (Math.random() * image.length);
								int random2 = (int) (Math.random() * image.length);
								int random3 = (int) (Math.random() * image.length);

								l1.setIcon(image[random1]);
								l2.setIcon(image[random2]);
								l3.setIcon(image[random3]);

								textArea.append((clickCount + 1) + "��° ���� ���ڸ� ���� ���ڽ��ϴ�.\n");

								if (image[random1].equals(image[random2]) && image[random2].equals(image[random3])) {
									textArea.append("�ų���! ������ ã�ҽ��ϴ�!\n");
									saigo++;
								} else {
									textArea.append("���� ���� �ȿ��� �ƹ��͵� �������ϴ١�.\n");
								}

								clickCount++; // Ŭ�� Ƚ�� ����
								spinning = false;

								// takarabako Ƚ���� �������� �� ���� ����
								if (clickCount >= takarabako) {
									textArea.append("\n���� ���ڸ� ���� �������ϴ�.\n");
									textArea.append("�� " + saigo + "���� ������ ã�ҽ��ϴ�.\n\n");
									point = saigo * 100;
									textArea.append("\n" + point + "����Ʈ ȹ��");
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