package swipeBlockCrack;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseEventor extends JFrame implements MouseListener {
	MouseEventor() {
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.addMouseListener(this);
		add(panel);
		setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		display("Mouse clicked (# of clicks: " + e.getClickCount() + ")", e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		display("Mouse pressed (# of clicks: " + e.getClickCount() + ")", e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		display("Mouse released (# of clicks: " + e.getClickCount() + ")", e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		display("Mouse entered", e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		display("Mouse exited", e);
	}

	protected void display(String s, MouseEventor e) {
		System.out.println(s + " X=" + e.getX() + " Y=" + e.getY());
	}
}