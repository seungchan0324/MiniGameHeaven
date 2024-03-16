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
                g2d.setStroke(new BasicStroke(3)); // ���� �β��� 3��� ����
                g2d.setColor(Color.BLUE); // �ϴû����� ����
                float[] dashPattern = {10, 5}; // ���� ��Ÿ�� ���� (10 �ȼ��� �Ǽ�, 5 �ȼ��� ����)
                g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, dashPattern, 0)); // ���� ��Ÿ�� ����
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f)); // ���� ����
                if (startPoint != null && endPoint != null) {
                    g2d.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
                }
                g2d.setStroke(oldStroke); // ���� ��Ʈ��ũ�� ����
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
