package HeyonGame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class FlyingFlying extends JFrame {

	private JPanel birdPanel;
	private int birdY = 250; // ���� Y ��ġ
	private final int BIRD_X = 100; // X ��ġ�� ����
	private double acc = 1.0;
	private JPanel obstacle1;
	private JPanel obstacle2;
	private int obstacleX = 450; // ��ֹ��� �ʱ� X ��ǥ
	private JPanel safezone;
	private int safezoneY = 250; // ��ֹ��� �ʱ� Y ��ǥ
	private int LE_SAFE = 100; // ���� ��ֹ��� ũ��
	private JPanel BGSIZE1;
	private JPanel BGSIZE2;
	private int LE_BGSIZE = 500;
	private int WI_BGSIZE = 800;
	private int BGX1 = 0;
	private int BGX2 = 800;
	private int BGY = -10;
	private final int WI_SIZE = 100; // ���� ��ֹ��� ũ��
	private Timer timer;
	private int cnt=0;
	private int score=0;
	// Ű ������ ��ü�� ������ �Ҵ�
	KeyListener myKeyListener = new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {
	        goToNextScreen();
	    }
	};
	
	public FlyingFlying() {
		setTitle("���� ���� ȭ��");
		setSize(768, 600);
		setLocationRelativeTo(null); // ȭ�� �߾ӿ� ��ġ��Ŵ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		JLabel titleLabel = new JLabel("�����ϽǷ��� �ƹ�Ű�� �����ÿ�", SwingConstants.CENTER);
		titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
		mainPanel.add(titleLabel, BorderLayout.CENTER);
		add(mainPanel);

		setVisible(true);



		// Ű ������ �߰�
		addKeyListener(myKeyListener);



	

		// JFrame�� Ű �̺�Ʈ�� ���� �� �ְ� ����
		setFocusable(true);
		requestFocusInWindow();
	}
	
	private void goToNextScreen() {
		// ���߿� Ű ������ ����
		removeKeyListener(myKeyListener);

		getContentPane().removeAll();
		setTitle("Flappy Bird");
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setFocusable(true);
		requestFocusInWindow();
		birdPanel = new JPanel();
		birdPanel.setOpaque(false);// �г� �����ϰ�
		birdPanel.setBounds(BIRD_X, birdY, 20, 20); // ���� ũ�� �� �ʱ� ��ġ
		// ��ֹ�1
		obstacle1 = new JPanel();
		obstacle1.setBounds(obstacleX, 350, WI_SIZE, 300); // ��ֹ� �׸���
		obstacle1.setOpaque(false);// �г� �����ϰ�
		// ��ֹ�2
		obstacle2 = new JPanel();
		obstacle2.setBounds(obstacleX, 0, WI_SIZE, 300);// ��ֹ� �׸���
		obstacle2.setOpaque(false);// �г� �����ϰ�
		// ������
		safezone = new JPanel();
		safezone.setBounds(obstacleX, safezoneY, WI_SIZE, LE_SAFE);
		safezone.setOpaque(false);// �г� �����ϰ�
		// ���
		BGSIZE1 = new JPanel();
		birdPanel.setOpaque(false);// �г� �����ϰ�
		BGSIZE1.setBounds(BGX1, BGY, WI_BGSIZE, LE_BGSIZE);
		BGSIZE2 = new JPanel();
		birdPanel.setOpaque(false);// �г� �����ϰ�
		BGSIZE2.setBounds(BGX2, BGY, WI_BGSIZE, LE_BGSIZE);
		
		//���� ǥ��
		JLabel ScoreaLabel = new JLabel("����: "+cnt, SwingConstants.RIGHT);
		ScoreaLabel.setFont(new Font("Serif", Font.BOLD, 20));
		ScoreaLabel.setBounds(650, 10, 100, 30);//����
		setLocationRelativeTo(null); // â�� ȭ�� �߾ӿ� ��ġ

		

		

		// ���
		ImageIcon img1 = new ImageIcon("BG.jpg");
		Image changeimg1 = img1.getImage();
		Image scaleimg1 = changeimg1.getScaledInstance(800, 500, Image.SCALE_SMOOTH);
		img1.setImage(scaleimg1);
		JLabel BGimg1 = new JLabel(img1);
		JLabel BGimg2 = new JLabel(img1);
		// ĳ����
		ImageIcon img2 = new ImageIcon("ch.png");
		Image changeimg2 = img2.getImage();
		Image scaleimg2 = changeimg2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		img2.setImage(scaleimg2);
		JLabel ch = new JLabel(img2);
		// ��ֹ�
		ImageIcon img3 = new ImageIcon("sin1.png");
		Image changeimg3 = img3.getImage();
		Image scaleimg3 = changeimg3.getScaledInstance(WI_SIZE, 300, Image.SCALE_SMOOTH);
		img3.setImage(scaleimg3);
		JLabel ob1 = new JLabel(img3);
		ImageIcon img4 = new ImageIcon("rsin2.png");
		Image changeimg4 = img4.getImage();
		Image scaleimg4 = changeimg4.getScaledInstance(WI_SIZE, 725, Image.SCALE_SMOOTH);
		img4.setImage(scaleimg4);
		JLabel ob2 = new JLabel(img4);

		
		// ����
		add(ScoreaLabel);
		BGSIZE1.add(BGimg1);
		BGSIZE2.add(BGimg2);
		birdPanel.add(ch);
		obstacle1.add(ob1);	
		obstacle2.add(ob2);
		

		add(birdPanel);
		add(safezone);
		add(obstacle1);
		add(obstacle2);
		add(BGSIZE1);
		add(BGSIZE2);

		setVisible(true);

		if (timer == null || !timer.isRunning()) {// Ÿ�̸Ӱ� ���� ������ ���� ���� ����
			addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					int key = e.getKeyCode();
					if (key == KeyEvent.VK_SPACE) {
						birdY -= 45;
						acc = 1; // ���� �� �߷� ���ӵ� �缳��
					}
				}
			});
			timer = new Timer(10, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					birdY += acc; // �߷� ȿ��
					acc += 0.18;
					birdPanel.setBounds(BIRD_X, birdY, 40, 40);
					obstacleX -= 10;
					BGX1 -= 10;
					BGX2 -= 10;

					if (((obstacleX) <= BIRD_X) && ((obstacleX + 100) >= BIRD_X)) {
						if (!(((safezoneY) <= birdY) && ((safezoneY + 75) >= birdY))) {
							showGameOverPanel(); // ���� ���� ȭ�� ǥ�� �޼��� ȣ��
							((Timer) e.getSource()).stop(); // ���� ���� �� Ÿ�̸� ����
						}else if(BIRD_X==(obstacleX + 60))
						{
							cnt+=100;
						}
					}

					if (birdY > 450 || birdY < 0) {
						showGameOverPanel(); // ���� ���� ȭ�� ǥ�� �޼��� ȣ��
						((Timer) e.getSource()).stop(); // ���� ���� �� Ÿ�̸� ����
					}
					if (obstacleX <= -100) {
						obstacleX = 800;
						safezoneY = (int) (Math.random() * (300 - 50 + 1)) + 50; // �������� ��ġ

					}
					if (BGX1 == -800) {
						BGX1 = 800;
					} else if (BGX2 == -800) {
						BGX2 = 800;
					}
					ScoreaLabel.setBounds(650, 10, 100, 30);//����

					BGSIZE1.setBounds(BGX1, BGY, WI_BGSIZE, LE_BGSIZE); // ���1
					BGSIZE2.setBounds(BGX2, BGY, WI_BGSIZE, LE_BGSIZE); // ���2
					
					
					safezone.setBounds(obstacleX, safezoneY, WI_SIZE, LE_SAFE); // ��������
					obstacle1.setBounds(obstacleX, (safezoneY + LE_SAFE), WI_SIZE, 600); // ��ֹ��Ʒ�
					obstacle2.setBounds(obstacleX, safezoneY-725, WI_SIZE, 725); // ��ֹ���

				}

			});


			timer.start(); // Ÿ�̸� ����
		}

	}

	private void showGameOverPanel() {
		Object[] options = { "�����", "����" };
		int choice = JOptionPane.showOptionDialog(null, "���� ����! �ٽ� �Ͻðڽ��ϱ�?", "���� ����", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]); // �ʱ� ���ð�

		score=+(cnt/100)*30;
		System.out.println("����Ʈ : "+  score);
		if (choice == JOptionPane.YES_OPTION) {
			timer = null;
			dispose();
			new FlyingFlying();
		} else {
			System.exit(0);
		}
	}


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new FlyingFlying();
			}
		});
	}

}
