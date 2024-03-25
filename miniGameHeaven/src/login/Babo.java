package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer; 
import javax.swing.border.Border;

public class Babo extends JFrame {
    
    public Babo() {
        setTitle("캐릭터");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(768, 600);
            
        ImageIcon ic2 = new ImageIcon("jan.png");
        JLabel la=new JLabel(ic2);
        la.setBounds(130,160,500,500);
        
        ImageIcon ic = new ImageIcon("babo.png");
        JButton button = new JButton(ic);
        button.setBounds(120, 40, 500, 500);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        
        JLabel textLabel = new JLabel("");
        textLabel.setBounds(325, 40, 100, 30);
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setVerticalAlignment(JLabel.NORTH);
        
        add(textLabel);
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textLabel.setText("운동 가자");
                textLabel.setFont(new Font("Serif", Font.BOLD, 15));
                Border border = BorderFactory.createLineBorder(Color.black);
                textLabel.setBorder(border);
                textLabel.setOpaque(true);
                textLabel.setBackground(Color.white);
                
                Timer timer = new Timer(2500, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textLabel.setText(""); 
                        textLabel.setBorder(null); 
                        textLabel.setOpaque(false); 
                    }
                });
                timer.setRepeats(false);
                timer.start(); 
            }
        });
        
        add(button);
        add(la);
        
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
   
}
