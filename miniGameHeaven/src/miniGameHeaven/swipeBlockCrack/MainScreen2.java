package swipeBlockCrack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class GamePanel extends JFrame {
	JFrame frame = new JFrame("Swipe Block Crack!!");
	JPanel panelNorth, panelMain, panelSouth;
	JLabel la = new JLabel("No Mouse Event");
	JLabel imageLabel;

	GamePanel() {

		setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		ImageIcon icon = new ImageIcon("C:\\Users\\nah32\\OneDrive\\바탕 화면\\MiniGameHeaven\\Ball.png");
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(22, 22, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);

		setIconImage(icon.getImage());

		panelNorth = new JPanel();
		panelMain = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon icon = new ImageIcon("C:\\Users\\nah32\\OneDrive\\바탕 화면\\MiniGameHeaven\\Ball.png");
				Image img = icon.getImage();
				g.drawImage(img, 50, 518, this); // 이미지 그리기
			}
		};
		panelSouth = new JPanel();
		panelNorth.setBackground(Color.black);
		panelMain.setBackground(Color.red);
		panelSouth.setBackground(Color.blue);

		setLayout(new BorderLayout());
		add(panelNorth, BorderLayout.NORTH);
		add(panelMain, BorderLayout.CENTER);
		add(panelSouth, BorderLayout.SOUTH);

		panelMain.addMouseListener(new MyMouseListener());
		panelMain.addMouseMotionListener(new MyMouseListener());
		panelNorth.setLayout(new BorderLayout());
		panelNorth.add(la, BorderLayout.NORTH);

		panelNorth.setPreferredSize(new Dimension(540, 120));
		panelMain.setPreferredSize(new Dimension(540, 544));
		panelSouth.setPreferredSize(new Dimension(540, 120));

		pack(); // 컴포넌트에 맞게 JFrame 크기 조정
		setLocationRelativeTo(null); // JFrame을 화면 중앙에 배치
		setVisible(true);
	}

	class MyMouseListener implements MouseListener, MouseMotionListener {

		@Override
		public void mousePressed(MouseEvent e) {
			la.setText("MousePressed(" + e.getX() + "," + e.getY() + ")");
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			la.setText("MouseReleased(" + e.getX() + "," + e.getY() + ")");
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			la.setText("MouseDragged(" + e.getX() + "," + e.getY() + ")");
		}

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mouseMoved(MouseEvent e) {
		}

	}

}

public class MainScreen2 {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> new GamePanel());

	}

}
