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
	private String characterupdetail[] = { "Ȩ", "�׿ܹ�ư" };
	private RoundedButton gamescores[];
	private JLabel gamename[];
	private JLabel gamescore[];
	private String gamenames[] = { "����! ����!", "�̽���", "�г�Ƽ 24", "�ٴٽ��丮", "�巡�� �˱��", "���ַ�" };
	private Color bannercolor[] = {new Color(211, 84, 0), new Color(39, 174, 96), new Color(52, 152, 219), new Color(241, 196, 15), new Color(155, 89, 182), new Color(64, 64, 64)};
	private Font characteruptextfont = new Font(Font.SANS_SERIF, Font.BOLD, 16);
	private Font moneyfont = new Font(Font.SANS_SERIF, Font.BOLD, 30);
	private Font gamenamefont = new Font("���� ���", Font.BOLD, 20);
	private Font gamescorefont = new Font("���� ���", Font.BOLD, 16);
	private ImageIcon moneyimage = new ImageIcon("money.png");
	private int cnt = 0;
	private DecimalFormat moneyformat;
	private String moneycomma;
	private MyInformationCharacter character;
	private Timer timer = new Timer(2, this);
	static long money = 100000;

	public MyInformationPanel() {

		// frame �κ�
		setLayout(null);
		setBounds(0, 0, 768, 600);
		setBackground(new Color(255, 255, 244));

		// ĳ���� �� ��ư �κ�(�迭ȭ �ؼ� ó��)
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

		// ĳ���� �ٷ��� ��(�ϳ��ϳ� ó��)(panel ���� 220 * 59)
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

		// ĳ����(panel���� 290 * 284) and ĳ���� ����ĭ
		character = new MyInformationCharacter();
		add(character);

		// ĳ���� �̸�ĭ, ĳ���� ����
		add(character.getCharactername());
		add(character.getCharacterdescribe());

		// �����Ӵ� �ְ�����
		gamescores = new RoundedButton[6];
		gamename = new JLabel[6];
		gamescore = new JLabel[6];

		for (int i = 0; i < gamescores.length; i++) {
			gamescores[i] = new RoundedButton(20);
			gamename[i] = new JLabel();
			gamescore[i] = new JLabel();
		}

		// db�ݿ��� �׽�Ʈ ����
		String scores[] = { "5000��", "10��", "5��", "6000��", "500��", "10000��" };

		// gamescores�� �ǳ�, gamename�� �̸� ��� ��, gamescore�� ������� ��
		// gamesnames�� ���� �̸� ��Ʈ����, scores�� �������� ��Ʈ����, �׸��� �� �� ���� �ǳ� ����
		for(int i = 0; i < gamescores.length; i++) {
			gamescoresgenerate(gamescores[i], gamename[i], gamescore[i], gamenames[i], scores[i], bannercolor[i]);
		}

		// �����(?)

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

		score.setText("�ְ����� " + gamescore);
		score.setFont(gamescorefont);
		score.setBounds(150, 0, 150, 50);
		score.setForeground(color.white);

		button.add(name);
		button.add(score);
		add(button);

		cnt++;
	}

}
