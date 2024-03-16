package swipeBlockCrack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawLineExample extends JFrame {
	private Point endPoint;
	private final static int panelMainBottom = 532;
	private final static int ballMiddlePointY = 543;
	private final static int gameStartPointX = 270;
	private static int ballMiddlePointX = 281;
	private static int ballPointX = gameStartPointX;
	private static int endPointX, endPointY;
	JLabel la = new JLabel("No Mouse Event");

	public DrawLineExample() {
		setTitle("Draw Line Example");
		setSize(540, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon icon = new ImageIcon("C:\\Users\\nah32\\OneDrive\\바탕 화면\\MiniGameHeaven\\Ball.png");
				Image img = icon.getImage();
				g.drawImage(img, gameStartPointX, panelMainBottom, this); // 이미지 그리기
				Graphics2D g2d = (Graphics2D) g;
				Stroke oldStroke = g2d.getStroke();
				g2d.setStroke(new BasicStroke(3)); // 선의 두께를 3배로 설정
				g2d.setColor(Color.BLUE); // 하늘색으로 설정
				float[] dashPattern = { 10, 5 }; // 점선 스타일 정의 (10 픽셀의 실선, 5 픽셀의 공백)
				g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, dashPattern, 0));
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f)); // 투명도 설정
				if (endPoint != null) {
					g2d.drawLine(ballMiddlePointX, ballMiddlePointY, endPointX, endPointY);
				}
				g2d.setStroke(oldStroke); // 이전 스트로크로 복원
			}
		};

		mainPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				repaint();
			}
		});

		mainPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				la.setText("MousePressed(" + e.getX() + "," + e.getY() + ")");
				endPoint = e.getPoint();
				
				if (e.getX() > 540) {
					endPointX = 540;
				} else if (e.getX() < 0) {
					endPointX = 0;
				} else {
					endPointX = (e.getX() - 281) * 100 + 281;
				}

				if (e.getY() > 513) {
					endPointY = (513 - 543) * 100 + 543;
				}else
					endPointY = (e.getY() - 543) * 100 + 543;
				
				
				repaint();
			}
		});
		mainPanel.add(la);
		setContentPane(mainPanel);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			DrawLineExample example = new DrawLineExample();
			example.setLocationRelativeTo(null); // JFrame을 화면 중앙에 배치
			example.setVisible(true);
		});
	}
}
