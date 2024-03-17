package swipeBlockCrack;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

class GamePanel extends JFrame {
	JFrame frame = new JFrame("Swipe Block Crack!!");
	static JPanel panelNorth, panelMain, panelSouth;
	JLabel imageLabel;
	private Point endPoint;
    private MyBall ball;
	final static int panelMainBottom = 532;
	private final static int ballMiddlePointY = 543;
	private final static int gameStartPointX = 259;
	static int ballMiddlePointX = 270;
	static int ballPointX = gameStartPointX;
	static int endPointX, endPointY;
	static int deltaX, deltaY, panelCornerX, panelCornerY, duplicateY;
	static double length;

	GamePanel() {

		setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		ImageIcon icon = new ImageIcon("C:\\Users\\nah32\\OneDrive\\���� ȭ��\\MiniGameHeaven\\Ball.png");
		setIconImage(icon.getImage());

		panelNorth = new JPanel();
		panelMain = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon icon = new ImageIcon("C:\\Users\\nah32\\OneDrive\\���� ȭ��\\MiniGameHeaven\\Ball.png");
				Image img = icon.getImage();
				g.drawImage(img, gameStartPointX, panelMainBottom, this); // �̹��� �׸���
				Graphics2D g2d = (Graphics2D) g;
				Stroke oldStroke = g2d.getStroke();
				g2d.setStroke(new BasicStroke(3)); // ���� �β��� 3��� ����
				g2d.setColor(Color.BLUE); // �ϴû����� ����
				float[] dashPattern = { 10, 5 }; // ���� ��Ÿ�� ���� (10 �ȼ��� �Ǽ�, 5 �ȼ��� ����)
				g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, dashPattern, 0));
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f)); // ���� ����
				if (endPoint != null) {
					g2d.drawLine(ballMiddlePointX, ballMiddlePointY, endPointX, endPointY);
				}
				g2d.setStroke(oldStroke); // ���� ��Ʈ��ũ�� ����
			}
		};
		panelSouth = new JPanel();
		
        
		setLayout(new BorderLayout());
		add(panelNorth, BorderLayout.NORTH);
		add(panelMain, BorderLayout.CENTER);
		add(panelSouth, BorderLayout.SOUTH);

		panelNorth.setLayout(new BorderLayout());
		panelNorth.setPreferredSize(new Dimension(540, 120));
		panelMain.setPreferredSize(new Dimension(540, 560));
		panelSouth.setPreferredSize(new Dimension(540, 120));

		Border border = BorderFactory.createMatteBorder(6, 0, 6, 0, Color.BLACK); // ���ʰ� �Ʒ��ʿ��� ������ �׵θ��� �߰��մϴ�.
		panelMain.setBorder(border);

		pack(); // ������Ʈ�� �°� JFrame ũ�� ����
		setLocationRelativeTo(null); // JFrame�� ȭ�� �߾ӿ� ��ġ
		setVisible(true);

		panelMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				repaint();
			}
		});

		panelMain.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				endPoint = e.getPoint();

				// ���������������� �Ÿ� ���
				deltaX = e.getX() - ballMiddlePointX;
				deltaY = e.getY() - 543;

				// �������������� �г� �𼭸������� ����
				panelCornerX = 540 - ballMiddlePointX;
				panelCornerY = 0 - 543;

				// �г� �𼭸������� �Ÿ� ���
				length = Math.sqrt(panelCornerX * panelCornerX + panelCornerY * panelCornerY);

				// �г� �𼭸������� ������ ������ ���� ����

				if (e.getX() < ballMiddlePointX) {
					duplicateY = (int) ((30.0 / ballMiddlePointX) * e.getX() + 513);
				} else {
					duplicateY = (int) ((-30.0 / 259) * e.getX() + 575);
				}

				if (e.getY() > duplicateY) {
					if (e.getX() < ballMiddlePointX) {
						endPointX = 0;
					} else {
						endPointX = 540;
					}
				} else {
					// �г� �𼭸������� ������ ������ ���� ����
					endPointX = (int) (ballMiddlePointX + deltaX * (length / Math.sqrt(deltaX * deltaX + deltaY * deltaY)));
				}

				endPointY = e.getY() > duplicateY ? 513 : (int) (543 + deltaY * (length / Math.sqrt(deltaX * deltaX + deltaY * deltaY)));;
				repaint();
			}
		});

		panelMain.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
		            ball = new MyBall();
		            panelMain.add(ball);
		            panelMain.revalidate(); // ������Ʈ ���� ������ Swing�� �˷��ݴϴ�.
		            panelMain.repaint(); // JPanel�� �ٽ� �׸����� ��û�մϴ�.
			}

		});
	}

}

public class MainScreen2 {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> new GamePanel());

	}

}
