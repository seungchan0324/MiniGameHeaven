package my_Information;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import infinityStair.StartFrame;
import infinityStair.StartPanel;

public class MyInformationPanel extends JPanel implements ActionListener {
	private RoundedButton characterupbutton[];
	private JLabel characteruptext[];
	private JPanel moneypanel, selectpanel;
	private JLabel moneylabel, moneyimg;
	private String characterupdetail[] = { "홈", "그외버튼" };
	private RoundedButton gamescores[];
	private JLabel gamename[];
	private JLabel gamescore[];
	private String gamenames[] = { "날아! 날아!", "이슬비", "패널티 24", "바다스토리", "드래곤 알까기", "우주로" };
	private Color bannercolor[] = {new Color(211, 84, 0), new Color(39, 174, 96), new Color(52, 152, 219), new Color(241, 196, 15), new Color(155, 89, 182), new Color(64, 64, 64)};
	private Font characteruptextfont = new Font(Font.SANS_SERIF, Font.BOLD, 16);
	private Font moneyfont = new Font(Font.SANS_SERIF, Font.BOLD, 30);
	private Font gamenamefont = new Font("맑은 고딕", Font.BOLD, 20);
	private Font gamescorefont = new Font("맑은 고딕", Font.BOLD, 16);
	private ImageIcon moneyimage = new ImageIcon("money.png");
	private int cnt = 0;
	private DecimalFormat moneyformat;
	private String moneycomma;
	private MyInformationCharacter character;
	private Timer timer = new Timer(2, this);
	static long money = 100000;

	public MyInformationPanel() {

		// frame 부분
		setLayout(null);
		setBounds(0, 0, 768, 600);
		setBackground(new Color(255, 255, 244));

		// 캐릭터 위 버튼 부분(배열화 해서 처리)
		characterupbutton = new RoundedButton[2];
		for (int i = 0; i < characterupbutton.length; i++) {
			characterupbutton[i] = new RoundedButton(40);
			characterupbutton[i].setBackground(new Color(230, 230, 230));
			characterupbutton[i].setLayout(null);
			add(characterupbutton[i]);
			characterupbutton[i].setBounds((82 + 120 * i), 70, 100, 40);
		}
		characteruptext = new JLabel[2];
		for (int i = 0; i < characteruptext.length; i++) {
			characteruptext[i] = new JLabel(characterupdetail[i]);
			characteruptext[i].setForeground(new Color(120, 120, 120));
			characteruptext[i].setBounds(40 - 25 * i, 0, 100, 40);
			characteruptext[i].setFont(characteruptextfont);
			characterupbutton[i].add(characteruptext[i]);
		}

		// 캐릭터 바로위 돈(하나하나 처리)(panel 공간 220 * 59)
		moneypanel = new JPanel();
		moneypanel.setBounds(82, 131, 220, 55);
		moneypanel.setBackground(new Color(255, 255, 244));
		moneypanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		moneyformat = new DecimalFormat("###,###");
		moneycomma = moneyformat.format(money);
		moneylabel = new JLabel(moneycomma);
		moneylabel.setFont(moneyfont);

		moneyimg = new JLabel();
		moneyimg.setIcon(moneyimage);

		moneypanel.add(moneyimg);
		moneypanel.add(moneylabel);
		add(moneypanel);

		// 캐릭터(panel공간 290 * 284) and 캐릭터 선택칸
		character = new MyInformationCharacter();
		add(character);

		// 캐릭터 이름칸, 캐릭터 설명
		add(character.getCharactername());
		add(character.getCharacterdescribe());

		// 각게임당 최고점수
		gamescores = new RoundedButton[6];
		gamename = new JLabel[6];
		gamescore = new JLabel[6];

		for (int i = 0; i < gamescores.length; i++) {
			gamescores[i] = new RoundedButton(20);
			gamename[i] = new JLabel();
			gamescore[i] = new JLabel();
		}

		// db반영전 테스트 점수
		String scores[] = { "5000점", "10개", "5골", "6000점", "500점", "10000점" };

		// gamescores는 판넬, gamename은 이름 담는 라벨, gamescore은 점수담는 라벨
		// gamesnames는 게임 이름 스트링값, scores는 게임점수 스트링값, 그리고 그 뒤 색은 판넬 배경색
		for(int i = 0; i < gamescores.length; i++) {
			gamescoresgenerate(gamescores[i], gamename[i], gamescore[i], gamenames[i], scores[i], bannercolor[i]);
		}

		// 배경음(?)

		setVisible(true);

		gamescores[5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StartFrame.getInstance(new StartPanel());
			}
		});

		character.characterpurchase.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.start();
			}
		});

	}

	public void gameStart(RoundedButton[] button, JFrame frame, JPanel panel) {

	}

	public void actionPerformed(ActionEvent e) {
		moneylabel.setText(moneyformat.format(money));
		repaint();
		timer.stop();
	}

	public void gamescoresgenerate(RoundedButton button, JLabel name, JLabel score, String gamename, String gamescore,
			Color color) {

		button.setLayout(null);
		button.setBounds(384, 130 + cnt * 60, 300, 50);
		button.setBackground(color);

		name.setText(gamename);
		name.setFont(gamenamefont);
		name.setBounds(10, 0, 140, 50);
		name.setForeground(color.white);

		score.setText("최고점수 " + gamescore);
		score.setFont(gamescorefont);
		score.setBounds(150, 0, 150, 50);
		score.setForeground(color.white);

		button.add(name);
		button.add(score);
		add(button);

		cnt++;
	}

}
