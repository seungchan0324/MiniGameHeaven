package login;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Babo extends JFrame {

	int cnt = 0;

	public Babo() {
		setTitle("캐릭터");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(768, 600);
		setLocationRelativeTo(null);
		
		JPanel mainPanel=new JPanel();
		mainPanel.setLayout(null);
		
		JLabel label=new JLabel();
		add(label);
		
		ImageIcon ic = new ImageIcon("구미.png");
		JLabel gu = new JLabel(ic);
		gu.setBounds(130, 20, 500, 500);		
		add(gu);
		
		
		ImageIcon ic2 = new ImageIcon("jan.png");
		JLabel la = new JLabel(ic2);
		la.setBounds(130, 90, 500, 500);
		add(la);
		
		JButton but1 = new JButton("인사");
        but1.setBounds(120, 480, 120, 40);
        but1.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        but1.setVisible(true);
        add(but1);
        
        JButton but2 = new JButton("저메추");
        but2.setBounds(320, 480, 120, 40);
        but2.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        but2.setVisible(true);
        add(but2);
        
        JButton but3 = new JButton("마멉의 소라고동");
        but3.setBounds(520, 480, 120, 40);
        but3.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        but3.setVisible(true);
        add(but3);
                   
        // 버튼 1 액션 리스너
        but1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 랜덤으로 메시지 선택
                String[] messages = { "안녕 반가워", "내 이름은 구미야", "오늘 날씨가 좋네~" };
                String message = messages[new Random().nextInt(messages.length)];
                label.setBounds(180, 60, 400, 50);
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setFont(new Font("맑은 고딕", Font.BOLD, 30));
                label.setText(message);
            }
        });

        // 버튼 2 액션 리스너
        but2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 랜덤으로 메시지 선택
                String[] messages = { "떡볶이를 추천할게", "돈까스를 추천할게", "덮밥을 추천할게", "굶어", "카레를 추천할게","도시락을 추천할게" };
                String message = messages[new Random().nextInt(messages.length)];
                label.setBounds(180, 60, 400, 50);
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setFont(new Font("맑은 고딕", Font.BOLD, 30));
                label.setText(message);
                
            }
        });

        // 버튼 3 액션 리스너
        but3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 랜덤으로 메시지 선택
                String[] messages = { "안돼", "싫어", "좋아요", "가만히 있어" };
                String message = messages[new Random().nextInt(messages.length)];
                label.setBounds(180, 60, 400, 50);
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setFont(new Font("맑은 고딕", Font.BOLD, 30));
                label.setText(message);
            }
        });
        
        

		
		
	
		setLayout(null);
		setResizable(false);
		setVisible(true);
	}

}
