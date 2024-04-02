package my_Information;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyInformationCharacter extends JPanel implements ActionListener {
	private Timer timer = new Timer(5, this); // 토양이 79 * 131, 달리 284 * 284, 구미 285 * 284
	private ImageIcon characterimg[] = { new ImageIcon("토양이.png"), new ImageIcon("내정보달리흑백.png"),
			new ImageIcon("내정보구미흑백.png") };
	private Image characterimage[] = { characterimg[0].getImage(), characterimg[1].getImage(),
			characterimg[2].getImage() };
	private RoundedButton leftselect, rightselect;
	static RoundedButton characterpurchase;
	private JButton[] selectbutton;
	private JLabel leftselecttext, rightselecttext;
	private Font characternamefont = new Font("맑은 고딕", Font.BOLD, 40);
	private Font characterdescribefont = new Font("맑은 고딕", Font.BOLD, 18);
	private Font selectfont = new Font("맑은 고딕", Font.PLAIN, 20);
	private Font purchasefont = new Font("맑은 고딕", Font.BOLD, 15);
	private ImageIcon noneselect = new ImageIcon("noneselect.png");
	private ImageIcon selected = new ImageIcon("selected.png");
	private String selectdirection = "<";
	private JLabel charactername, characterdescribe;
	private String characternames[] = { "토양이", "달리", "구미" };
	private int characterhorizontal = 0;
	private int cnt = 0;
	// 캐릭터 구매여부 0이면 미구매 1이면 구매상태
	private int dalripurchase = 0, gumipurchase = 0;
	// 마지막으로 선택된 캐릭터
	public static String characterselect = "Toyangi";

	public MyInformationCharacter() {
		setBounds(47, 175, 290, 329);
		setBackground(new Color(255, 255, 244));
		setLayout(null);

		leftselect = new RoundedButton(10);
		leftselect.setBackground(new Color(244, 244, 244));
		leftselect.setBounds(35, 290, 35, 35);

		leftselecttext = new JLabel("<");
		leftselecttext.setBounds(45, 290, 35, 35);
		leftselecttext.setFont(selectfont);
		leftselecttext.setForeground(new Color(120, 120, 120));

		rightselect = new RoundedButton(10);
		rightselect.setBackground(new Color(244, 244, 244));
		rightselect.setBounds(220, 290, 35, 35);

		rightselecttext = new JLabel(">");
		rightselecttext.setBounds(232, 290, 35, 35);
		rightselecttext.setFont(selectfont);
		rightselecttext.setForeground(new Color(120, 120, 120));

		selectbutton = new JButton[3];

		for (int i = 0; i < selectbutton.length; i++) {
			selectbutton[i] = new JButton(noneselect);
			selectbutton[i].setBounds(97 + (40 * i), 297, 20, 20);
			selectbutton[i].setContentAreaFilled(false); // 내용 영역을 투명하게 설정
			selectbutton[i].setFocusPainted(false); // 포커스 시, 버튼 테두리를 그리지 않도록 설정
			selectbutton[i].setBorderPainted(false);
			add(selectbutton[i]);
		}

		charactername = new JLabel("토양이");
		charactername.setBounds(384, 40, 200, 60);
		charactername.setFont(characternamefont);

		characterdescribe = new JLabel("귀여움 주의보, 굉장히 치명적");
		characterdescribe.setBounds(384, 100, 300, 30);
		characterdescribe.setFont(characterdescribefont);

		characterpurchase = new RoundedButton(30);
		characterpurchase.setText("Purchase");
		characterpurchase.setBackground(new Color(180, 180, 180));
		characterpurchase.setForeground(new Color(0, 0, 0));
		characterpurchase.setBounds(95, 110, 100, 50);
		characterpurchase.setFont(purchasefont);
		characterpurchase.setVisible(false);

		add(characterpurchase);
		add(leftselecttext);
		add(leftselect);
		add(rightselecttext);
		add(rightselect);

		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (characterhorizontal == -290 && dalripurchase == 0
						|| characterhorizontal == -580 && gumipurchase == 0) {
					if (e.getX() >= 60 && e.getX() <= 220 || e.getY() >= 10 && e.getY() <= 260) {
						characterpurchase.setVisible(true);
					}
				}
			}
		});

		characterpurchase.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (characterhorizontal == -290 && MyInformationPanel.money >= 10000) {
					dalripurchase = 1;
					MyInformationPanel.money -= 10000;
					characterimage[1] = new ImageIcon("내정보달리.png").getImage();
					characterpurchase.setVisible(false);
					repaint();
				} else if (characterhorizontal == -580 && MyInformationPanel.money >= 10000) {
					gumipurchase = 1;
					MyInformationPanel.money -= 10000;
					characterimage[2] = new ImageIcon("내정보구미.png").getImage();
					characterpurchase.setVisible(false);
					repaint();
				}

			}
		});

		leftselect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (characterhorizontal == -290 || characterhorizontal == -580) {
					selectdirection = "<";
					timer.start();
				} else if (characterhorizontal == 0) {
					selectdirection = ">>";
					timer.start();
				}
			}
		});

		rightselect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (characterhorizontal == 0 || characterhorizontal == -290) {
					selectdirection = ">";
					timer.start();
				} else if (characterhorizontal == -580) {
					selectdirection = "<<";
					timer.start();
				}
			}
		});
		
		selectbutton[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (characterhorizontal == -290) {
					selectdirection = "<";
					timer.start();
				} else if (characterhorizontal == -580) {
					selectdirection = "<<";
					timer.start();
				}
			}
		});

		selectbutton[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (characterhorizontal == 0) {
					selectdirection = ">";
					timer.start();
				} else if (characterhorizontal == -580) {
					selectdirection = "<";
					timer.start();
				}

			}
		});

		selectbutton[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectdirection = ">";
				if (characterhorizontal == -290) {
					timer.start();
				} else if (characterhorizontal == 0) {
					selectdirection = ">>";
					timer.start();
				}
			}
		});
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (characterhorizontal == 0) {
			charactername.setText(characternames[0]);
			characterselect = "Toyangi";
		} else if (characterhorizontal == -290) {
			charactername.setText(characternames[1]);
			if (dalripurchase == 1) {
				characterselect = "Dalri";
			}
		} else if (characterhorizontal == -580) {
			charactername.setText(characternames[2]);
			if (gumipurchase == 1) {
				characterselect = "Gumi";
			}
		}

		if (characterhorizontal <= 0 && characterhorizontal > -290) {
			g.drawImage(characterimage[0], (this.getWidth() - 79) / 2 + characterhorizontal, this.getHeight() - 216,
					this);
		} else {
			g.drawImage(characterimage[2], (this.getWidth() - 280) / 2 + characterhorizontal + 580,
					this.getHeight() - 330, this);
		}
		g.drawImage(characterimage[1], (this.getWidth() - 265) / 2 + characterhorizontal + 290, this.getHeight() - 330,
				this);

		if (characterhorizontal == 0 || selectdirection.equals("<<")
				|| selectdirection.equals("<") && characterhorizontal > -290) {
			selectbutton[0].setIcon(selected);
			selectbutton[1].setIcon(noneselect);
			selectbutton[2].setIcon(noneselect);
		} else if (characterhorizontal < 0 && characterhorizontal >= -290 && !selectdirection.equals(">>")
				|| selectdirection.equals("<")) {
			selectbutton[0].setIcon(noneselect);
			selectbutton[1].setIcon(selected);
			selectbutton[2].setIcon(noneselect);
		} else {
			selectbutton[0].setIcon(noneselect);
			selectbutton[1].setIcon(noneselect);
			selectbutton[2].setIcon(selected);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (selectdirection.equals(">") && cnt < 29) {
			characterhorizontal -= 10;
		} else if (selectdirection.equals("<") && cnt < 29) {
			characterhorizontal += 10;
		} else if (selectdirection.equals(">>") && cnt < 29) {
			characterhorizontal -= 20;
		} else if (selectdirection.equals("<<") && cnt < 29) {
			characterhorizontal += 20;
		} else {
			cnt = -1;
			timer.stop();
		}
		cnt++;
		characterpurchase.setVisible(false);
		repaint();
	}

	public JLabel getCharactername() {
		return charactername;
	}

	public JLabel getCharacterdescribe() {
		return characterdescribe;
	}

}
