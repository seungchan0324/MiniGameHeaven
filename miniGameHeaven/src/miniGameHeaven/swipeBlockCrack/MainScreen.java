package swipeBlockCrack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MainPanel extends JFrame {
	JFrame frame = new JFrame("Swipe Block Crack!!");

	MainPanel() throws IOException {

		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		ImageIcon icon = new ImageIcon("C:\\Users\\nah32\\OneDrive\\바탕 화면\\MiniGameHeaven\\Ball-removebg-preview.png");
		frame.setIconImage(icon.getImage());
        frame.setBounds(0, 0, 540, 780);
        frame.setBackground(new Color(149, 213, 247));
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);
		
     // MyMouseEvent 인스턴스 생성 및 추가
        MyMouseEvent mouseEvent = new MyMouseEvent();
        mainPanel.add(mouseEvent);
        
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

	}

	class MyMouseEvent extends JPanel implements ActionListener {
		JPanel contentPane = new JPanel(new FlowLayout());
		JLabel la = new JLabel("No Mouse Event");
		private BufferedImage image;

		MyMouseEvent() throws IOException {

			image = ImageIO.read(new File("C:\\Users\\nah32\\OneDrive\\바탕 화면\\MiniGameHeaven\\Ball-removebg-preview.png"));
			// chage icon of this
			contentPane.addMouseListener(new MyMouseListener());
			contentPane.addMouseMotionListener(new MyMouseListener());
			contentPane.setBounds(270, 780, 22, 22);

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

		public void paintComponent(Graphics g) {
			// 그래픽 객체를 paintComponent 메소드로 이동시킴
			// 그림그리려면 필수. 첫문장에 나와야함.
			super.paintComponent(g);
			// 이미지를 화면에 그린다.
			// drawImage 메소드가 없으면 그림이 생성되지 않는다.
			g.drawImage(image, 270, 780, this);
		}

	}
}

public class MainScreen {

	public static void main(String[] args) throws IOException {

		new MainPanel();

	}

}
