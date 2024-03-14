package Menual;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Menual_MyFrame extends JFrame {

	Menual_MyFrame(){
	
	JFrame frame = new JFrame(); // creates a this
	this.setTitle("Jthis title goes here"); // sets title of this
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
	this.setResizable(false); // prevent this from being resized
	this.setSize(420, 420); // sets the x-dimension, and y-dimension of this
	this.setVisible(true);// make this visible
	
	// create an ImageIcon
	ImageIcon image = new ImageIcon("C:\\Users\\nah32\\OneDrive\\πŸ≈¡ »≠∏È\\MiniGameHeaven\\Ball-removebg-preview.png");
	this.setIconImage(image.getImage()); // chage icon of this
	this.getContentPane().setBackground(new Color(255, 255, 255)); // change color of background

	}

}
