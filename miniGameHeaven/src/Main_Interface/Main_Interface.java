package Main_Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import SunGame.penalty24;
import gameDescription.GameDescription;
import infinityStair.Main;
import infinityStair.StartFrame;
import infinityStair.StartPanel;
import my_Information.MyInformationCharacter;
import my_Information.MyInformationPanel;

public class Main_Interface extends JFrame {
	int i;
	RoundedButton[] button;
	
	ImageIcon profileImg = new ImageIcon("profile.png");
	public Main_Interface() {

		setSize(768, 600);
		setBackground(new Color(255, 255, 244));
		setLocationRelativeTo(null);
		setLayout(null);
		
		// 폰트(글꼴, 굵기, 크기)
		Font fontB = new Font("맑은 고딕", Font.BOLD, 18);
		Font font = new Font("맑은 고딕", Font.PLAIN, 14);

		 // Profile Panel 생성
        JPanel profilePanel = new JPanel();
        //profilePanel.setBackground(Color.gray); // 크기 알고 싶을 때 배경색 설정
        profilePanel.setBounds(0, 15, getWidth()/2, 40); // 위치 및 크기 설정
        //profilePanel.setLayout(new BorderLayout()); // 레이아웃 매니저 설정
        profilePanel.setFont(fontB);

        
        Image img = profileImg.getImage();
        Image changeimg = img.getScaledInstance(30,  30,  Image.SCALE_SMOOTH);
        profileImg = new ImageIcon(changeimg);
        JButton imgButton = new JButton(profileImg);
        imgButton.setPreferredSize(new Dimension(30, 30));
        imgButton.setContentAreaFilled(false);//백 투명
        imgButton.setBorderPainted(false);//버튼 테두리 설정해제
        
       
        
        imgButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StartFrame.getInstance(new MyInformationPanel());
				
			}
		});
        
		// nameLabel 생성
		JLabel nameLabel = new JLabel("수달은수달");
		nameLabel.setFont(fontB);
		Font labelFont = nameLabel.getFont();
		FontMetrics labelFontMetrics = nameLabel.getFontMetrics(labelFont);
		int nameLabelWidth = labelFontMetrics.stringWidth(nameLabel.getText());

		// profileLabel 생성
		JLabel profileLabel = new JLabel("님 환영합니다");
		profileLabel.setFont(font);
		profileLabel.setBounds(nameLabelWidth + 10, 0, getWidth() - (nameLabelWidth + 10), 50);
	
        nameLabel.setBounds(0, 0, nameLabelWidth, 30);

        profileLabel.setForeground(Color.DARK_GRAY); // 텍스트 색상 설정
        
        profilePanel.add(imgButton); 
        profilePanel.add(nameLabel); 
        profilePanel.add(profileLabel); 

        add(profilePanel); // 프레임에 Profile Panel 추가
        
        // button Panel 생성
        JPanel buttonPanel = new JPanel();
        //buttonPanel.setBackground(Color.black); // 크기 알고 싶을 때 배경색 설정
        buttonPanel.setBounds(380, 15, getWidth()/2, 40); // 위치 및 크기 설정
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        
        JButton aButton = new JButton("그 외");
        aButton.setPreferredSize(new Dimension(30, 30));
        aButton.setIcon(null);
        
        JButton bButton = new JButton("그 외");
        bButton.setPreferredSize(new Dimension(30, 30));
        bButton.setIcon(null);
        
        buttonPanel.add(aButton);
        buttonPanel.add(bButton);
        //buttonPanel.add(bButton,BorderLayout.EAST);
        
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 90));//buttonPanel 안쪽 여백
        add(buttonPanel);
        
        
		
		//가운데 화면
		button = new RoundedButton[6];
//		Color[] colors = { new Color(26, 188, 156), new Color(52, 152, 219), new Color(243, 156, 18),
//				new Color(241, 196, 15), new Color(155, 89, 182), new Color(64, 64, 64) };
		ImageIcon[] imgMain = {new ImageIcon("날아날아.png"), new ImageIcon("우주로.png"), new ImageIcon("바다스토리.png"), new ImageIcon("이슬비.png"), new ImageIcon("패널티24.png"),new ImageIcon("클릭!클릭!.png")};

		for (int i = 0; i < button.length; i++) {
			button[i] = new RoundedButton(20);
			button[i].setIcon(imgMain[i]);
			add(button[i]);
			if (i < 3) {
				button[i].setBounds(65 + (i * 210), 60, 200, 230);
			} else {
				button[i].setBounds(65 + ((i - 3) * 210), 310, 200, 230);
			}
			button[i].setBorderPainted(false);
		}//for

		// ------------------Button이벤트--------------------
		for(i=0;i<button.length;i++) {
			buttonAction(i);
		}//for
		
		
		
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
			setContentAreaFilled(false); // ϰ
			setFocusPainted(false); // Ŀ , ư ׵θ ׸ ʵ
		}

		public void setBackground(ImageIcon imageIcon) {
			// TODO Auto-generated method stub
			
		}

		ImageIcon imageSetSize(ImageIcon icon, int i, int j) { // image Size Setting
			Image ximg = icon.getImage();  //ImageIcon을 Image로 변환.
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
	
	public void buttonAction(int x) {
		button[x].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new GameDescription(x);
			}
		});
	}
	

	public static void main(String[] args) {

		new Main_Interface();
		
	}

}
