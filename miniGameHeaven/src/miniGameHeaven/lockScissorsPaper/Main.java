package lockScissorsPaper;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Main extends JFrame implements ActionListener {
	private ImageIcon[] images;
	private ImageIcon[] rock_scissors_paper;
	private static JLabel label;
	private Timer timer;
	private boolean isStopped;
	private JButton bt_rock, bt_paper, bt_scissors;
	private static int wincount = 0;
	private static int drawcount = 0;
	private static int losecount = 0;

	public Main() {
		setTitle("Random Image Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(415, 670);
		setLocationRelativeTo(null);
		setLayout(null);

		rock_scissors_paper = new ImageIcon[3];
		rock_scissors_paper[0] = new ImageIcon("Little_ROCK.png");
		rock_scissors_paper[1] = new ImageIcon("Little_SCISSORS.png");
		rock_scissors_paper[2] = new ImageIcon("Little_PAPER.png");

		images = new ImageIcon[3];
		images[0] = new ImageIcon("ROCK.jpg");
		images[1] = new ImageIcon("SCISSORS.jpg");
		images[2] = new ImageIcon("PAPER.png");

		for (int i = 0; i < rock_scissors_paper.length; i++) {
			Image img = rock_scissors_paper[i].getImage();
			Image changeImg = img.getScaledInstance(133, 133, Image.SCALE_SMOOTH);
			rock_scissors_paper[i].setImage(changeImg);
		}

		for (int i = 0; i < images.length; i++) {
			Image img = images[i].getImage();
			Image changeImg = img.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
			images[i].setImage(changeImg);
		}
		label = new JLabel();
		label.setBounds(0, 0, 400, 400);
		add(label);

		Font font = new Font("함초롱바탕", Font.BOLD, 30);
		JLabel result = new JLabel("넌 졌다!");
		result.setHorizontalAlignment(SwingConstants.CENTER); // 가로 중앙 정렬
		result.setVerticalAlignment(SwingConstants.CENTER); // 세로 중앙 정렬
		result.setFont(font);

		bt_rock = new JButton(rock_scissors_paper[0]);
		bt_scissors = new JButton(rock_scissors_paper[1]);
		bt_paper = new JButton(rock_scissors_paper[2]);
		bt_rock.setBorderPainted(false);
		bt_scissors.setBorderPainted(false);
		bt_paper.setBorderPainted(false);
		result.setBounds(0, 400, 400, 100);
		bt_rock.setBounds(0, 500, 133, 133);
		bt_scissors.setBounds(133, 500, 133, 133);
		bt_paper.setBounds(266, 500, 133, 133);
		bt_rock.setBackground(new Color(255, 255, 255));
		bt_scissors.setBackground(new Color(255, 255, 255));
		bt_paper.setBackground(new Color(255, 255, 255));
		add(result);
		add(bt_rock);
		add(bt_scissors);
		add(bt_paper);

		// 게임 속도
		timer = new Timer(50, this);
		timer.start();

		isStopped = false;

		bt_rock.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 이미지 클릭 시 타이머 시 작 또는 멈춤
				timer.stop();
				result.setText(arena(images[0]));
				timer.start();
				repaint();
				isStopped = !isStopped;
				try {
				    Thread.sleep(1000); // 3초 동안 기다립니다.
				} catch (InterruptedException er) {
				    er.printStackTrace();
				}
				isStopped = !isStopped;
			}
		});

		bt_scissors.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 이미지 클릭 시 타이머 시 작 또는 멈춤
				timer.stop();
				result.setText(arena(images[1]));
				timer.start();
				repaint();
				isStopped = !isStopped;
				try {
				    Thread.sleep(1000); // 3초 동안 기다립니다.
				} catch (InterruptedException er) {
				    er.printStackTrace();
				}
				isStopped = !isStopped;
			}
		});

		bt_paper.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 이미지 클릭 시 타이머 시 작 또는 멈춤
				timer.stop();
				result.setText(arena(images[2]));
				timer.start();
				repaint();
				isStopped = !isStopped;
				try {
				    Thread.sleep(1000); // 3초 동안 기다립니다.
				} catch (InterruptedException er) {
				    er.printStackTrace();
				}
				isStopped = !isStopped;
			}
		});

		// 라벨에 마우스 클릭 이벤트 리스너 추가
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 이미지 클릭 시 타이머 시 작 또는 멈춤
				if (isStopped) {
					timer.start();
				} else {
					timer.stop();
				}
				isStopped = !isStopped;
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!isStopped) {
			Random random = new Random();
			int index = random.nextInt(3);
			label.setIcon(images[index]);
		}
	}


	public static String arena(Icon icon) {
		String enemy = Main.label.getIcon().toString();
		String my = icon.toString(); // 나

		if (enemy.equals("ROCK.jpg")) {
			if (my.equals("ROCK.jpg")) {
				Main.drawcount++;
				return Main.drawcount + "회 비겼습니다!";
			} else if (my.equals("SCISSORS.jpg")) {
				Main.losecount++;
				return Main.losecount + "회 졌습니다.";
			} else {
				Main.wincount++;
				return Main.wincount + "회 이겼습니다.";
			}
		} else if (enemy.equals("SCISSORS.jpg")) {
			if (my.equals("ROCK.jpg")) {
				Main.wincount++;
				return Main.wincount + "회 이겼습니다.";
			} else if (my.equals("SCISSORS.jpg")) {
				Main.drawcount++;
				return Main.drawcount + "회 비겼습니다!";
			} else {
				Main.losecount++;
				return Main.losecount + "회 졌습니다.";
			}
		} else {
			if (my.equals("ROCK.jpg")) {
				Main.losecount++;
				return Main.losecount + "회 졌습니다.";
			} else if (my.equals("SCISSORS.jpg")) {
				Main.wincount++;
				return Main.wincount + "회 이겼습니다.";
			} else {
				Main.drawcount++;
				return Main.drawcount + "회 비겼습니다!";
			}
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Main frame = new Main();
			frame.setVisible(true);
		});
	}
	
}
