package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyInformationPanel extends JPanel {
	private RoundedButton characterupbutton[];
	private JLabel characteruptext[];
	private JPanel moneypanel, selectpanel;
	private JLabel moneylabel, moneyimg;
	private String characterupdetail[] = { "Ȩ", "�׿ܹ�ư" };
	private RoundedPanel gamescores[];
	private JLabel gamename[];
	private JLabel gamescore[];
	private String gamenames[] = { "����! ����!", "�̽���", "�г�Ƽ 24", "�ٴٽ��丮", "�巡�� �˱��", "���ַ�" };
	private Font characteruptextfont = new Font(Font.SANS_SERIF, Font.BOLD, 16);
	private Font moneyfont = new Font(Font.SANS_SERIF, Font.BOLD, 30);
	private Font gamenamefont = new Font("���� ����", Font.BOLD, 20);
	private Font gamescorefont = new Font("���� ����", Font.BOLD, 16);
	private ImageIcon moneyimage = new ImageIcon("money.png");
	private int cnt = 0;

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

		moneylabel = new JLabel("1,000,000");
		moneylabel.setFont(moneyfont);

		moneyimg = new JLabel();
		moneyimg.setIcon(moneyimage);

		moneypanel.add(moneyimg);
		moneypanel.add(moneylabel);
		add(moneypanel);

		// ĳ����(panel���� 290 * 284) and ĳ���� ����ĭ
		MyInformationCharacter character = new MyInformationCharacter();
		add(character);

		// ĳ���� �̸�ĭ, ĳ���� ����
		add(character.getCharactername());
		add(character.getCharacterdescribe());

		// �����Ӵ� �ְ�����
		gamescores = new RoundedPanel[6];
		gamename = new JLabel[6];
		gamescore = new JLabel[6];

		for (int i = 0; i < gamescores.length; i++) {
			gamescores[i] = new RoundedPanel(20);
			gamename[i] = new JLabel();
			gamescore[i] = new JLabel();
		}

		// db�ݿ��� �׽�Ʈ ����
		String scores[] = { "5000��", "10��", "5��", "6000��", "500��", "10000��" };

		gamescoresgenerate(gamescores[0], gamename[0], gamescore[0], gamenames[0], scores[0], new Color(211, 84, 0));
		gamescoresgenerate(gamescores[1], gamename[1], gamescore[1], gamenames[1], scores[1], new Color(39, 174, 96));
		gamescoresgenerate(gamescores[2], gamename[2], gamescore[2], gamenames[2], scores[2], new Color(52, 152, 219));
		gamescoresgenerate(gamescores[3], gamename[3], gamescore[3], gamenames[3], scores[3], new Color(241, 196, 15));
		gamescoresgenerate(gamescores[4], gamename[4], gamescore[4], gamenames[4], scores[4], new Color(155, 89, 182));
		gamescoresgenerate(gamescores[5], gamename[5], gamescore[5], gamenames[5], scores[5], new Color(64, 64, 64));

		// �����(?)

		setVisible(true);

	}

	public void gamescoresgenerate(RoundedPanel panel, JLabel name, JLabel score, String gamename, String gamescore,
			Color color) {

		panel.setLayout(null);
		panel.setBounds(384, 130 + cnt * 60, 300, 50);
		panel.setBackground(color);

		name.setText(gamename);
		name.setFont(gamenamefont);
		name.setBounds(10, 0, 140, 50);
		name.setForeground(color.white);

		score.setText("�ְ����� " + gamescore);
		score.setFont(gamescorefont);
		score.setBounds(150, 0, 150, 50);
		score.setForeground(color.white);

		panel.add(name);
		panel.add(score);
		add(panel);

		cnt++;
	}

}