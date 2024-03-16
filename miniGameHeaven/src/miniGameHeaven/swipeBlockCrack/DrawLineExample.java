package swipeBlockCrack; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawLineExample extends JFrame {
    private Point startPoint;
    private Point endPoint;

    public DrawLineExample() {
        setTitle("Draw Line Example");
        setSize(540, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Stroke oldStroke = g2d.getStroke();
                g2d.setStroke(new BasicStroke(3)); // 선의 두께를 3배로 설정
                g2d.setColor(Color.BLUE); // 하늘색으로 설정
                float[] dashPattern = {10, 5}; // 점선 스타일 정의 (10 픽셀의 실선, 5 픽셀의 공백)
                g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, dashPattern, 0)); // 점선 스타일 적용
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f)); // 투명도 설정
                if (startPoint != null && endPoint != null) {
                    g2d.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
                }
                g2d.setStroke(oldStroke); // 이전 스트로크로 복원
            }
        };

        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
                endPoint = startPoint;
                repaint();
            }
        });

        mainPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                endPoint = e.getPoint();
                repaint();
            }
        });

        setContentPane(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DrawLineExample example = new DrawLineExample();
            example.setVisible(true);
        });
    }
}
