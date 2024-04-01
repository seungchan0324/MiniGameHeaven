package SongGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import Main_Interface.Main_Interface;
import defaultFrame.DefaultFrame;
import my_Information.MyInformationPanel;

public class Keyword extends JPanel implements KeyListener, ActionListener{
    private LinkedList<String> fruitWords;
    private LinkedList<String> animalWords;
    private LinkedList<String> workWords;
    private LinkedList<String> foodWords;
    private LinkedList<String> countryWords;
    private LinkedList<String> selectedWords;
    private int currentWordIndex;
    private String currentWord;
    private boolean gameRunning;
    private Timer timer;
    private int score;
    private int timeLeft;
    
     // time 0.1ÃÊ¸¶´Ù actionperformed½ÇÇà
    Timer time = new Timer(100, this);
    // ÃÊ±â wordY°ª
    private int wordY = 20;
    
    private JTextField inputTextField;
    private JLabel scoreLabel;
    private JButton enterButton;
    private JButton pauseButton; // ÀÏ½ÃÁ¤Áö ¹öÆ°
    private int pausedTimeLeft; // ÀÏ½ÃÁ¤ÁöµÈ ½Ã°£À» ÀúÀåÇÒ º¯¼ö
    private String pausedWord; // ÀÏ½ÃÁ¤ÁöµÈ ½ÃÁ¡ÀÇ ´Ü¾î¸¦ ÀúÀåÇÒ º¯¼ö
    private boolean wordEntered; // ´Ü¾î°¡ ÀÔ·ÂµÇ¾ú´ÂÁö ¿©ºÎ¸¦ ³ªÅ¸³»´Â º¯¼ö
    private int point;
    private JButton backButton; // µÚ·Î °¡±â ¹öÆ°
    
    //ÀÌ¹ÌÁö ¾ÆÀÌÄÜ
    ImageIcon imgAnimal = new ImageIcon("animal.png");
    ImageIcon imgCountry = new ImageIcon("country.png");
    ImageIcon imgFood = new ImageIcon("food.png");
    ImageIcon imgFruit = new ImageIcon("fruit.png");
    ImageIcon imgWork = new ImageIcon("work.png");
    
    //Å°¿öµå ¹Ú½º==================================================
    public Keyword() {
    	
        this.fruitWords = new LinkedList<>();
        this.fruitWords.add("apple");
        this.fruitWords.add("banana");
        this.fruitWords.add("orange");
        this.fruitWords.add("grape");
        this.fruitWords.add("strawberry");
        this.fruitWords.add("pineapple");
        this.fruitWords.add("watermelon");
        this.fruitWords.add("kiwi");
        this.fruitWords.add("pear");
        this.fruitWords.add("fig");
        this.fruitWords.add("mango");
        this.fruitWords.add("yuja");
        this.fruitWords.add("lime");
        this.fruitWords.add("peach");
        this.fruitWords.add("blueberry");
        this.fruitWords.add("plum");
        this.fruitWords.add("banana");
        this.fruitWords.add("avocado");
        this.fruitWords.add("cherry");
        this.fruitWords.add("grapefruit");

        this.animalWords = new LinkedList<>();
        this.animalWords.add("dog");
        this.animalWords.add("cat");
        this.animalWords.add("elephant");
        this.animalWords.add("lion");
        this.animalWords.add("tiger");
        this.animalWords.add("monkey");
        this.animalWords.add("giraffe");
        this.animalWords.add("zebra");
        this.animalWords.add("piglet");
        this.animalWords.add("fox");
        this.animalWords.add("bunny");
        this.animalWords.add("mouse");
        this.animalWords.add("whale");
        this.animalWords.add("shark");
        this.animalWords.add("otter");
        this.animalWords.add("dolpin");
        this.animalWords.add("beluga");
        this.animalWords.add("eagle");
        this.animalWords.add("duck");
        this.animalWords.add("swan");
        
        this.workWords = new LinkedList<>();
        this.workWords.add("office worker");
        this.workWords.add("programmer");
        this.workWords.add("web designer");
        this.workWords.add("software developer");
        this.workWords.add("web developer");
        this.workWords.add("baker");
        this.workWords.add("hairdresser");
        this.workWords.add("dentist");
        this.workWords.add("doctor");
        this.workWords.add("bartender");
        this.workWords.add("cook");
        this.workWords.add("chef");
        this.workWords.add("waiter");
        this.workWords.add("taxi driver");
        this.workWords.add("artist");
        this.workWords.add("editor");
        this.workWords.add("illustrator");
        this.workWords.add("painter");
        this.workWords.add("photographer");
        this.workWords.add("dancer");
        
        this.foodWords = new LinkedList<>();
        this.foodWords.add("bagels");
        this.foodWords.add("barbecue");
        this.foodWords.add("beef");
        this.foodWords.add("burgers");
        this.foodWords.add("cake");
        this.foodWords.add("curry");
        this.foodWords.add("coffee");
        this.foodWords.add("crapes");
        this.foodWords.add("eggrolls");
        this.foodWords.add("pasta");
        this.foodWords.add("pizza");
        this.foodWords.add("pork");
        this.foodWords.add("hotdog");
        this.foodWords.add("icecream");
        this.foodWords.add("yoghurt");
        this.foodWords.add("soup");
        this.foodWords.add("soba");
        this.foodWords.add("ramen");
        this.foodWords.add("pie");
        this.foodWords.add("natto");
        
        this.countryWords = new LinkedList<>();
        this.countryWords.add("argentina");
        this.countryWords.add("australia");
        this.countryWords.add("brazil");
        this.countryWords.add("cambodia");
        this.countryWords.add("canada");
        this.countryWords.add("china");
        this.countryWords.add("denmark");
        this.countryWords.add("egypt");
        this.countryWords.add("england");
        this.countryWords.add("figi");
        this.countryWords.add("finland");
        this.countryWords.add("france");
        this.countryWords.add("georgia");
        this.countryWords.add("germany");
        this.countryWords.add("ghana");
        this.countryWords.add("greece");
        this.countryWords.add("holland");
        this.countryWords.add("india");
        this.countryWords.add("ireland");
        this.countryWords.add("italian");
        

        this.selectedWords = fruitWords; // Default to fruit words

        this.currentWordIndex = -1;
        this.currentWord = "";
        this.gameRunning = false;
        this.score = 0;
        this.timer = new Timer(1000, e -> {
            if (timeLeft > 0) {
                timeLeft--;
                repaint();
            } else {
                endGame();
            }
        });
        

        setPreferredSize(new Dimension(550, 400));
        setBackground(Color.WHITE);
        setFocusable(true);
        addKeyListener(this);

        JPanel categoryPanel = new JPanel();
        categoryPanel.setBackground(Color.LIGHT_GRAY);
        JButton fruitButton = new JButton(imgFruit);
        fruitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedWords = fruitWords;
                startGame(30); // Start the game with a duration of 30 seconds
            }
        });
        JButton animalButton = new JButton(imgAnimal);
        animalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedWords = animalWords;
                startGame(30); // Start the game with a duration of 30 seconds
            }
        });
        JButton workButton = new JButton(imgWork);
        workButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedWords = workWords;
                startGame(30); // Start the game with a duration of 30 seconds
            }
        });
        
        JButton foodButton = new JButton(imgFood);
        foodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedWords = foodWords;
                startGame(30); // Start the game with a duration of 30 seconds
            }
        });
        
        JButton countryButton = new JButton(imgCountry);
        countryButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		selectedWords = countryWords;
        		startGame(30); // Start the game with a duration of 30 seconds
        	}
        });
       
        imgFruit = imageSetSize(imgFruit, 60, 60); // imageSetSize ¸Þ¼Òµå »ý¼º
        imgAnimal = imageSetSize(imgAnimal, 60, 60);
        imgWork = imageSetSize(imgWork, 60, 60);
        imgFood = imageSetSize(imgFood, 60, 60);
        imgCountry = imageSetSize(imgCountry, 60, 60);
        
        fruitButton.setIcon(imgFruit);
        fruitButton.setBackground(Color.LIGHT_GRAY);
        fruitButton.setBorderPainted(false);//¹öÆ° Å×µÎ¸® ¼³Á¤ÇØÁ¦
        
        animalButton.setIcon(imgAnimal);
        animalButton.setBackground(Color.LIGHT_GRAY);
        animalButton.setBorderPainted(false);//¹öÆ° Å×µÎ¸® ¼³Á¤ÇØÁ¦
        
        workButton.setIcon(imgWork);
        workButton.setBackground(Color.LIGHT_GRAY);
        workButton.setBorderPainted(false);//¹öÆ° Å×µÎ¸® ¼³Á¤ÇØÁ¦
        
        foodButton.setIcon(imgFood);
        foodButton.setBackground(Color.LIGHT_GRAY);
        foodButton.setBorderPainted(false);//¹öÆ° Å×µÎ¸® ¼³Á¤ÇØÁ¦
        
        countryButton.setIcon(imgCountry);
        countryButton.setBackground(Color.LIGHT_GRAY);
        countryButton.setBorderPainted(false);//¹öÆ° Å×µÎ¸® ¼³Á¤ÇØÁ¦
        
        categoryPanel.add(fruitButton);
        categoryPanel.add(animalButton);
        categoryPanel.add(workButton);
        categoryPanel.add(foodButton);
        categoryPanel.add(countryButton);

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.LIGHT_GRAY);
        //JLabel inputLabel = new JLabel("Enter the word:");
        inputTextField = new JTextField(30);
        inputTextField.addKeyListener(this);
   
        enterButton = new JButton("ÀÔ·Â");
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkInput();
            }
        });
        
        enterButton.setBackground(Color.LIGHT_GRAY);
        enterButton.setForeground(Color.DARK_GRAY);
        
//		// ÆùÆ®(±Û²Ã, ±½±â, Å©±â)
//		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 16);
        
        pauseButton = new JButton("ÀÏ½ÃÁ¤Áö");
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pauseGame();
            }
        });
        pauseButton.setBackground(Color.DARK_GRAY);
        pauseButton.setForeground(Color.white);
        
		// µÚ·Î °¡±â ¹öÆ° »ý¼º
		backButton = new JButton("°ÔÀÓ Á¾·á");
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultFrame.getInstance(new Main_Interface(), "¸ÞÀÎ È­¸é");
			}
		});
		
		backButton.setBackground(Color.DARK_GRAY);
		backButton.setForeground(Color.white);
        
        
        //inputPanel.add(inputLabel);
        inputPanel.add(backButton); // µÚ·Î °¡±â ¹öÆ°À» ÀÔ·Â ÆÐ³Î¿¡ Ãß°¡
        inputPanel.add(inputTextField);
        inputPanel.add(enterButton);
        inputPanel.add(pauseButton); // ÀÏ½ÃÁ¤Áö ¹öÆ°À» ÀÔ·Â ÆÐ³Î¿¡ Ãß°¡

        scoreLabel = new JLabel("ÇöÀç Á¡¼ö : 0");
        scoreLabel.setBorder((BorderFactory.createEmptyBorder(0 , 10 , 0 , 0)));//¿ÞÂÊ ¿©¹é
        scoreLabel.setPreferredSize(new Dimension(85,0));//»çÀÌÁî
        
        JFrame frame = new JFrame("­S­SÀÌ½½ºñ");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(this, BorderLayout.CENTER);
        frame.getContentPane().add(categoryPanel, BorderLayout.NORTH);
        frame.getContentPane().add(inputPanel, BorderLayout.SOUTH);
        frame.getContentPane().add(scoreLabel, BorderLayout.WEST);
        frame.setResizable(false);
        frame.pack();
        //frame.setFont(font);
        //frame.setLocationRelativeTo(null);

		// 1.ToolkitÀ» ÅëÇØ ¸ð´ÏÅÍÀÇ ÇØ»óµµ¸¦ ¾ò¾î¿À±â
		Toolkit tk = Toolkit.getDefaultToolkit();

		for (int i = 0; i < 3; i++) {
			try {// ¿À·ù Àâ±â
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			tk.beep();
		} // for

		// 2.DimemsionÀ» ÅëÇØ¼­ Áß¾Ó ÁÂÇ¥°ª ¼³Á¤ÇÏ±â
		Dimension di = tk.getScreenSize();
		int monitorW = di.width;
		int monitorH = di.height;

		// 3.ÇÁ·¹ÀÓ ÁÂ¿ì Å©±â »©ÁÖ±â
		int x = monitorW / 2 - frame.getWidth() / 2;
		int y = monitorH / 2 - frame.getHeight() / 2;

		frame.setLocation(x, y);
		frame.setVisible(true);
        
    }

    public void startGame(int durationInSeconds) {
        if (!gameRunning) {
            score = 0;
            timeLeft = durationInSeconds;
            gameRunning = true;
            generateWord();
            // Å¸ÀÌ¸Ó 0.1ÃÊ ¸¶´Ù ÁøÇàµÇ´Â ¸ÞÄ¿´ÏÁòÀÇ ½ÃÀÛ
            time.start();
            timer.start();
        }
    }
    
    public void startGame(int durationInSeconds, int score) {
        if (!gameRunning) {
            this.score = score;
            timeLeft = durationInSeconds;
            gameRunning = true;
            timer.start();
        }
    }

    private void generateWord() {
        Random random = new Random();
        currentWordIndex = random.nextInt(selectedWords.size());
        currentWord = selectedWords.get(currentWordIndex);
        // ´Ü¾î°¡ »ý±æ ¶§¿¡ wordY°ªÀÌ °»½ÅµÈ´Ù.
        wordY = 20;
    }

    

    private void checkInput() {
        String userInput = inputTextField.getText().trim().toLowerCase();
        if (gameRunning && !userInput.isEmpty() && userInput.equals(currentWord)) {
            score++;
            scoreLabel.setText("ÇöÀç Á¡¼ö : " + score);
            generateWord();
            inputTextField.setText("");
            repaint();

			// 2°³¾¿ ´Ü¾î¸¦ ¸ÂÈ÷¸é 100Á¡¾¿ Ãß°¡·Î Àû¸³
			if (score % 1 == 0 && score > 0) {
				int earnedPoints = 50;
				point += earnedPoints;
			}

		}
	}
    
    private void endGame() {
        gameRunning = false;
        timer.stop();
        // 5°³ÀÇ ´Ü¾î¸¦ ¸ÂÈù È½¼ö¿¡ µû¶ó ÃÑ Æ÷ÀÎÆ®¿¡ Ãß°¡Àû¸³µÇ¾î endGame¿¡ Ç¥½ÃµÊ
        int totalScore = score + point;
        JOptionPane.showMessageDialog(this, "°ÔÀÓ Á¾·á!\n¸ÂÈù °³¼ö : " + score + "\nÃÑ " + point + "Æ÷ÀÎÆ®°¡ Àû¸³µÇ¾ú½À´Ï´Ù.");

    }
    
	// °ÔÀÓ ÀÏ½ÃÁ¤Áö ±â´É
	private void pauseGame() {
		if (gameRunning) {
			gameRunning = false;
			timer.stop();
			// ¸ØÃß¸é Å¸ÀÌ¸Ó°¡ ÀÏ½ÃÀûÀ¸·Î ¸ØÃá´Ù.
			time.stop();
			pausedTimeLeft = timeLeft; // ÀÏ½ÃÁ¤ÁöµÈ ½Ã°£À» ÀúÀå
			pausedWord = currentWord; // ÀÏ½ÃÁ¤ÁöµÈ ½ÃÁ¡ÀÇ ´Ü¾î¸¦ ÀúÀå
			int option = JOptionPane.showConfirmDialog(this, "°ÔÀÓÀÌ ÀÏ½ÃÁ¤ÁöµÇ¾ú½À´Ï´Ù.\n°ÔÀÓÀ» ´Ù½Ã ½ÃÀÛÇÏ½Ã°Ú½À´Ï±î?", "ÀÏ½ÃÁ¤Áö",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				startGame(pausedTimeLeft, score); // ÀÏ½ÃÁ¤ÁöµÈ ½Ã°£ºÎÅÍ °ÔÀÓ Àç½ÃÀÛ
			}
		}
	}
	
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) { // image Size Setting
		Image ximg = icon.getImage();  //ImageIconÀ» Image·Î º¯È¯.
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg); 
		return xyimg;
	}
	

	// °ÔÀÓ Àç°³ ±â´É
	private void resumeGame() {
		if (!gameRunning) {
			gameRunning = true;
			timer.start();
			currentWord = pausedWord; // ÀÏ½ÃÁ¤ÁöµÈ ½ÃÁ¡ÀÇ ´Ü¾î·Î ´Ù½Ã ½ÃÀÛ
			repaint();
			JOptionPane.showMessageDialog(this, "°ÔÀÓÀÌ ´Ù½Ã ½ÃÀÛµÇ¾ú½À´Ï´Ù.");
		}
	}
	
	// µÚ·Î °¡±â ±â´É
	private void goBack() {
		// °æ·Î°¡ Á¤ÇØÁöÁö ¾Ê¾ÒÀ» ¶§´Â null·Î Ã³¸®
		String path = null;
		// °æ·Î°¡ nullÀÌ ¾Æ´Ñ °æ¿ì¿¡¸¸ µÚ·Î °¡±â Ã³¸®
		if (path != null) {
			// TODO: µÚ·Î °¡±â Ã³¸®
		}
	}
	
//	//Æ÷ÀÎÆ® Àû¸³
//	public void pointSave() {
//	    int earnedPoints = (score / 5) * 100;
//	    point += earnedPoints;
//	    JOptionPane.showMessageDialog(this, "Game Over!\n´ç½ÅÀÇ Á¡¼ö´Â: " + score + "\nÀû¸³µÈ Æ÷ÀÎÆ®: " + point);
//	}
	
	//°¡¿îµ¥ È­¸é¿¡ ¶ß´Â Å°¿öµå
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (gameRunning) {
            g.setColor(Color.GRAY);
            g.setFont(new Font("Arial", Font.BOLD, 24));
            FontMetrics fm = g.getFontMetrics(); // FontMetrics¸¦ »ç¿ëÇÏ¿© ³¹¸»ÀÇ ³Êºñ¸¦ ±¸ÇÔ
            int wordWidth = fm.stringWidth(currentWord); // ³¹¸»ÀÇ ³Êºñ
            int wordX = (getWidth() - wordWidth) / 2; // È­¸é °¡·Î Áß¾Ó¿¡¼­ ³¹¸»ÀÇ ¿ÞÂÊ X ÁÂÇ¥ °è»ê
             // È­¸é ¼¼·Î Áß¾Ó¿¡¼­ ³¹¸»ÀÇ Y ÁÂÇ¥ °è»ê
            g.drawString(currentWord, wordX, wordY);
            g.drawString("Time left: " + timeLeft, 20, 30);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (gameRunning && e.getKeyCode() == KeyEvent.VK_ENTER) {
            checkInput();
        }
    }

    public static void main(String[] args) {
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("asd");
		System.out.println(wordY);
		// wordY += °ªÀÌ Ä¿Áö¸é ³»·Á°¡´Â °ªÀÌ Ä¿Áø´Ù.
		wordY += 5;
		// wordY °ªÀÌ 200À¸·Î ³»·Á°¡¸é ÀÛµ¿
		if(wordY == 450) {
			// endGame();
			generateWord();
		}
	}
}
