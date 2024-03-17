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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

class GamePanel extends JPanel {
	JFrame frame = new JFrame("Swipe Block Crack!!");
	static JPanel panelNorth, panelMain, panelSouth;
	JLabel imageLabel;
	private Point endPoint;
	final static int panelMainBottom = 538;
	final static int ballMiddlePointY = 549;
	final static int gameStartPointX = 259;
	static int ballMiddlePointX = 270;
	static int ballPointX = gameStartPointX;
	static int endPointX, endPointY;
	static int deltaX, deltaY, panelCornerX, panelCornerY, duplicateY;
	static double length;
	private float transparency = 0.5f;

	GamePanel() {

		panelNorth = new JPanel();
		panelMain = new JPanel();
		panelSouth = new JPanel();

		panelMain.addMouseMotionListener(new MouseListeners());		
		setLayout(new BorderLayout());
		add(panelNorth, BorderLayout.NORTH);
		add(panelMain, BorderLayout.CENTER);
		add(panelSouth, BorderLayout.SOUTH);

		panelNorth.setLayout(new BorderLayout());
		panelNorth.setPreferredSize(new Dimension(540, 120));
		panelMain.setPreferredSize(new Dimension(540, 560));
		panelSouth.setPreferredSize(new Dimension(540, 120));

		Border borderTop = BorderFactory.createMatteBorder(0, 0, 6, 0, Color.BLACK); // 위쪽과 아래쪽에만 검정색 테두리를 추가합니다.
		Border borderBottom = BorderFactory.createMatteBorder(6, 0, 0, 0, Color.BLACK); // 위쪽과 아래쪽에만 검정색 테두리를 추가합니다.
		panelNorth.setBorder(borderTop);
		panelSouth.setBorder(borderBottom);

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon icon = new ImageIcon("C:\\temp\\Ball.png");
		Image img = icon.getImage();
		g.drawImage(img, gameStartPointX, panelMainBottom, this); // 이미지 그리기
		Graphics2D g2d = (Graphics2D) g;
		Stroke oldStroke = g2d.getStroke();
		g2d.setStroke(new BasicStroke(3)); // 선의 두께를 3배로 설정
		g2d.setColor(Color.BLUE); // 하늘색으로 설정
		float[] dashPattern = { 10, 5 }; // 점선 스타일 정의 (10 픽셀의 실선, 5 픽셀의 공백)
		g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, dashPattern, 0));
		transparency = 0.5f;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency)); // 투명도 설정
		if (endPoint != null) {
			g2d.drawLine(ballMiddlePointX, ballMiddlePointY, endPointX, endPointY);
		}
		g2d.setStroke(oldStroke); // 이전 스트로크로 복원

	}
}

public class MainScreen2 {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Swipe Block Crack!!");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            GamePanel gamePanel = new GamePanel(); // GamePanel을 생성하여 프레임에 추가합니다.
            ImageIcon icon = new ImageIcon("C:\\temp\\Ball.png");
    		frame.setIconImage(icon.getImage());
            frame.getContentPane().add(gamePanel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

	}

}
