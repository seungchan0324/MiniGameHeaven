package swipeBlockCrack; 

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.IOException;
import java.awt.image.BufferedImage;

class MyPanel1 extends JPanel implements ActionListener {
	// final ��ȣ�� ����� ����� Ȱ��, �̹����� ũ�� �� �ʱ���ġ
	private final int WIDTH = 500;
	private final int HEIGHT = 300;
	private final int START_X = 0;
	private final int START_Y = 250;
	// �̹��� ������ ��� ���� BufferedImage ��ü ������ ����
	private BufferedImage image;
	// Ÿ�̸� ��ü�� ����
	private Timer timer;
	private int x, y;

	public MyPanel1() {
			//�г� ���� ����, �г� ũ��� JFrame ũ�Ⱑ ����
			setBackground(Color.WHITE);
			setPreferredSize(new Dimension(WIDTH, HEIGHT));
			//��õ �⺻ ũ�⸦ �˾Ƽ� ����
			//��ġ�����ڿ� ����, �Ǵ� �г�, ��ư �����̳ʿ� ���� 
			//setSize(), setPreferrendSize() �� �� �ִ°� �ٸ�
			setDoubleBuffered(true);//�׸��� ���� �޸� Ȱ��ȭ. ��� �Ǳ���..
			//�̹��� ���� ��ü ����
			File input = new File("C:\\Users\\nah32\\OneDrive\\���� ȭ��\\MiniGameHeaven\\Ball-removebg-preview.png");
			try {
				//imput�� ������ �̹��� ������ �����̹����� ����
				image = ImageIO.read(input);
			}catch(IOException e) { //����ó��
				e.printStackTrace();
			} //�̹����� �д´�.
			x = START_X;
			y = START_Y;
			
			//Ÿ�̸� ������, 1�̻��̸� � ���� ���͵� ������ ����� ����Ǹ�
			//0���Ͽ����� �ſ� ���� �ӵ��� �����δ�.
			timer = new Timer(1, this);
			timer.start(); //Ÿ�̸� ��ü�� �����ϰ� ����
		}

	// MyPanel1 �޼ҵ�� �ʱ� �̹��� ���� ���� ��ü �� ������ ����ϰ�
	// ������ �̹����� ������ ��� �Ʒ� �޼ҵ���� �ϴ� �� ����.
	@Override
	// �׷����� ����ϴ� �޼ҵ�
	public void paintComponent(Graphics g) {
		// �׷��� ��ü�� paintComponent �޼ҵ�� �̵���Ŵ
		// �׸��׸����� �ʼ�. ù���忡 ���;���.
		super.paintComponent(g);
		// �̹����� ȭ�鿡 �׸���.
		// drawImage �޼ҵ尡 ������ �׸��� �������� �ʴ´�.
		g.drawImage(image, x, y, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// �̺�Ʈ�� �߻��ϸ� ��ǥ�� �ش� �ȼ� ��ŭ �̵���Ŵ
		x += 2;
		y -= 2; // y�� -�ϼ��� ������
		// �̹��� ��ü�� ������ ��� �ʱ� ��ġ�� �̵���Ŵ
		if (x > WIDTH) {
			x = START_X;
			y = START_Y;
		}
		// ������ �Ϸ�Ǹ� repaint �޼ҵ�� �̹����� ����
		// repaint �޼ҵ尡 ������ �׸��� �̵����� �ʴ´�.
		repaint();
	}
}

// ���� Ŭ������ JFrame ��ü�� �ȴ�.
public class E17Animation extends JFrame {
	public E17Animation() {
		// JPanel Ŭ������ MyPanel1�� �����ڸ� �߰��Ѵ�
		add(new MyPanel1()); // �гΰ�ü �߰�
		setTitle("�ִϸ��̼� �׽�Ʈ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new E17Animation();
	}
}