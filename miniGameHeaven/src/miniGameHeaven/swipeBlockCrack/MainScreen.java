package swipeBlockCrack;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyMouseEvent extends JFrame implements ActionListener {
	JPanel contentPane = new JPanel();
	JLabel la = new JLabel("No Mouse Event");
	private BufferedImage image;

	MyMouseEvent() {
		this.setTitle("SWIPE_BLOCK_CRACK!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		File input = new File("C:\\Users\\nah32\\OneDrive\\바탕 화면\\MiniGameHeaven\\Ball-removebg-preview.png");
		try {
			// imput에 가져온 이미지 파일을 버퍼이미지에 저장
			image = ImageIO.read(input);
		} catch (IOException e) { // 예외처리
			e.printStackTrace();
		} // 이미지를 읽는다.

		JLabel lb = new JLabel(new ImageIcon(image));
		this.setContentPane(contentPane);
		contentPane.addMouseListener(new MyMouseListener());
		contentPane.addMouseMotionListener(new MyMouseListener());
		contentPane.add(lb);

		setBounds(900,100,500,500);
		setBackground(new Color(149,213,247));
		setVisible(true);
		contentPane.requestFocus();
	}

	class MyMouseListener implements MouseListener, MouseMotionListener {

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
			la.setText("MousePressed(" + e.getX() + "," + e.getY() + ")");
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			la.setText("MouseReleased(" + e.getX() + "," + e.getY() + ")");
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			la.setText("MouseDragged(" + e.getX() + "," + e.getY() + ")");
		}

		@Override
		public void mouseMoved(MouseEvent e) {
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}

public class MainScreen {

	public static void main(String[] args) {

		new MyMouseEvent();

	}

}
