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
	JPanel panelNorth, panelMain, panelSouth;
	JLabel imageLabel;
	private Point endPoint;
	private final static int panelMainBottom = 532;
	private final static int ballMiddlePointY = 543;
	private final static int gameStartPointX = 270;
	private static int ballMiddlePointX = 281;
	private static int ballPointX = gameStartPointX;
	private static int endPointX, endPointY;
	JLabel la = new JLabel("No Mouse Event");

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
		panelMain.add(la);

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

				int X = e.getX();
				int Y = e.getY();

				// ���������������� �Ÿ� ���
				int deltaX = X - 281;
				int deltaY = Y - 543;

				// �������������� �г� �𼭸������� ����
				int panelCornerX = 540 - 281;
				int panelCornerY = 0 - 543;

				// �г� �𼭸������� �Ÿ� ���
				double length = Math.sqrt(panelCornerX * panelCornerX + panelCornerY * panelCornerY);

				// �г� �𼭸������� ������ ������ ���� ����

				int duplicateY;
				if (X < 281) {
					duplicateY = (int) ((30.0 / 281) * X + 513);
				} else {
					duplicateY = (int) ((-30.0 / 259) * X + 575);
				}

				la.setText("MousePressed(" + e.getX() + "," + e.getY() + ")" + duplicateY);

				if (Y > duplicateY) {
					if (X < 281) {
						endPointX = 0;
					} else {
						endPointX = 540;
					}
				} else {
					// �г� �𼭸������� ������ ������ ���� ����
					endPointX = (int) (281 + deltaX * (length / Math.sqrt(deltaX * deltaX + deltaY * deltaY)));
				}

				endPointY = Y > duplicateY ? 513
						: (int) (543 + deltaY * (length / Math.sqrt(deltaX * deltaX + deltaY * deltaY)));
				;
				repaint();
			}
		});

	}

}

public class MainScreen2 {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> new GamePanel());

	}

}
