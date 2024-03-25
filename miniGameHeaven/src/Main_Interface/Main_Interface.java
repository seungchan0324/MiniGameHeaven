package Main_Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingContainer;

public class Main_Interface extends JFrame {
	
	ImageIcon profileImg = new ImageIcon("profile.png");
	
	public Main_Interface() {

		setSize(768, 600);
		setLocationRelativeTo(null);
		setLayout(null);
		
		// �룿�듃(湲�瑗�, 援듦린, �겕湲�)
		Font fontB = new Font("Pretendard", Font.BOLD, 18);
		Font font = new Font("Pretendard", Font.PLAIN, 14);

		 // Profile Panel �깮�꽦
        JPanel profilePanel = new JPanel();
        profilePanel.setBackground(Color.gray); // �겕湲� �븣怨� �떢�쓣 �븣 諛곌꼍�깋 �꽕�젙
        profilePanel.setBounds(0, 15, getWidth()/2, 40); // �쐞移� 諛� �겕湲� �꽕�젙
        //profilePanel.setLayout(new BorderLayout()); // �젅�씠�븘�썐 留ㅻ땲�� �꽕�젙
        profilePanel.setFont(fontB);

        
        JButton imgButton = new JButton(profileImg);
        imgButton.setPreferredSize(new Dimension(30, 30));
        
        profileImg = imageSetSize(profileImg, 30, 30); // imageSetSize 硫붿냼�뱶 �깮�꽦
        imgButton.setIcon(profileImg);
        imgButton.setBorderPainted(false);//踰꾪듉 �뀒�몢由� �꽕�젙�빐�젣
        
        
		// nameLabel �깮�꽦
		JLabel nameLabel = new JLabel("�닔�떖���닔�떖");
		nameLabel.setFont(fontB);
		Font labelFont = nameLabel.getFont();
		FontMetrics labelFontMetrics = nameLabel.getFontMetrics(labelFont);
		int nameLabelWidth = labelFontMetrics.stringWidth(nameLabel.getText());

		// profileLabel �깮�꽦
		JLabel profileLabel = new JLabel("�떂 �솚�쁺�빀�땲�떎");
		profileLabel.setFont(font);
		profileLabel.setBounds(nameLabelWidth + 10, 0, getWidth() - (nameLabelWidth + 10), 50);
	
        nameLabel.setBounds(0, 0, nameLabelWidth, 30);

        profileLabel.setForeground(Color.DARK_GRAY); // �뀓�뒪�듃 �깋�긽 �꽕�젙
        
        profilePanel.add(imgButton); 
        profilePanel.add(nameLabel); 
        profilePanel.add(profileLabel); 

        add(profilePanel); // �봽�젅�엫�뿉 Profile Panel 異붽�
        
        // button Panel �깮�꽦
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.black); // �겕湲� �븣怨� �떢�쓣 �븣 諛곌꼍�깋 �꽕�젙
        buttonPanel.setBounds(380, 15, getWidth()/2, 40); // �쐞移� 諛� �겕湲� �꽕�젙
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        
        JButton aButton = new JButton("洹� �쇅");
        aButton.setPreferredSize(new Dimension(30, 30));
        aButton.setIcon(null);
        
        JButton bButton = new JButton("洹� �쇅");
        bButton.setPreferredSize(new Dimension(30, 30));
        bButton.setIcon(null);
        
        buttonPanel.add(aButton);
        buttonPanel.add(bButton);
        //buttonPanel.add(bButton,BorderLayout.EAST);
        
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 90));//buttonPanel �븞履� �뿬諛�
        add(buttonPanel);
        
        
		
		//媛��슫�뜲 �솕硫�
		RoundedButton[] button = new RoundedButton[6];
		Color[] colors = { new Color(26, 188, 156), new Color(52, 152, 219), new Color(243, 156, 18),
				new Color(241, 196, 15), new Color(155, 89, 182), new Color(64, 64, 64) };

		for (int i = 0; i < button.length; i++) {
			button[i] = new RoundedButton(30);
			button[i].setBackground(colors[i]);
			add(button[i]);
			if (i < 3) {
				button[i].setBounds(65 + (i * 210), 60, 200, 230);
			} else {
				button[i].setBounds(65 + ((i - 3) * 210), 310, 200, 230);
			}
			button[i].setBorderPainted(false);
		}

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
	}

	private ImageIcon imageSetSize(ImageIcon profileImg2, int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	class RoundedButton extends JButton {
		private int radius;

		public RoundedButton(int radius) {
			this.radius = radius;
			setContentAreaFilled(false); // 構
			setFocusPainted(false); // 커 , 튼 流罐 琉 茄
		}

		ImageIcon imageSetSize(ImageIcon icon, int i, int j) { // image Size Setting
			Image ximg = icon.getImage();  //ImageIcon�쓣 Image濡� 蹂��솚.
			Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
			ImageIcon xyimg = new ImageIcon(yimg); 
			return xyimg;
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			if (getModel().isArmed()) {
				g.setColor(Color.lightGray);
			} else {
				g.setColor(getBackground());
			}
			g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
			super.paintComponent(g);
		}

		@Override
		protected void paintBorder(Graphics g) {
			g.setColor(getForeground());
			g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
		}
	}

	public static void main(String[] args) {

		new Main_Interface();

	}

}
