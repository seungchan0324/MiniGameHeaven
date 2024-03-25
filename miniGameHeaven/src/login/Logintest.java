package login;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Logintest extends JFrame {

    private JTextField userIdField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton gaib;

    public Logintest() {
        setTitle("로그인");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(768, 600);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        
        JLabel userIdLabel = new JLabel("아이디");
        userIdLabel.setBounds(191, 250, 90, 30);
        userIdLabel.setOpaque(true);
        userIdLabel.setBackground(Color.gray);
        userIdLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(userIdLabel);
        
        userIdField = new JTextField(13);
        userIdField.setBounds(280, 250, 250, 30);
        add(userIdField);

        JLabel userIdLabel2 = new JLabel("비밀번호");
        userIdLabel2.setBounds(191, 300, 90, 30); 
        userIdLabel2.setOpaque(true);
        userIdLabel2.setBackground(Color.gray);
        userIdLabel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(userIdLabel2);

        passwordField = new JPasswordField(13);
        passwordField.setBounds(280, 300, 250, 30);
        add(passwordField);

        loginButton = new JButton("로그인");
        loginButton.setBounds(240, 360, 240, 35);
        loginButton.setBackground(Color.orange);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(loginButton);
        
        gaib = new JButton("회원가입");
        gaib.setBounds(240, 410, 240, 35);
        gaib.setBackground(Color.GREEN);
        gaib.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(gaib);
        
        ImageIcon icon = new ImageIcon("lo.png");
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        add(label);
        
       
        
        
        
    }

}
