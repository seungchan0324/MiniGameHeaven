package swipeBlockCrack;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseListeners implements MouseMotionListener, MouseListener {

	private Point endPoint;
	static int ballMiddlePointX = 270;
	static int ballPointX = GamePanel.gameStartPointX;
	static int endPointX, endPointY;
	static int deltaX, deltaY, panelCornerX, panelCornerY, duplicateY;
	static double length;

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {

		endPoint = e.getPoint();

		// 기준점에서부터의 거리 계산
		deltaX = e.getX() - ballMiddlePointX;
		deltaY = e.getY() - 543;

		// 기준점에서부터 패널 모서리까지의 벡터
		panelCornerX = 540 - ballMiddlePointX;
		panelCornerY = 0 - 543;

		// 패널 모서리까지의 거리 계산
		length = Math.sqrt(panelCornerX * panelCornerX + panelCornerY * panelCornerY);

		// 패널 모서리까지의 비율로 직선의 끝점 설정

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
			// 패널 모서리까지의 비율로 직선의 끝점 설정
			endPointX = (int) (ballMiddlePointX + deltaX * (length / Math.sqrt(deltaX * deltaX + deltaY * deltaY)));
		}

		endPointY = e.getY() > duplicateY ? 513
				: (int) (543 + deltaY * (length / Math.sqrt(deltaX * deltaX + deltaY * deltaY)));
		;

		GamePanel.panelMain.repaint();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
}
