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
    
     // time 0.1�ʸ��� actionperformed����
    Timer time = new Timer(100, this);
    // �ʱ� wordY��
    private int wordY = 20;
    
    private JTextField inputTextField;
    private JLabel scoreLabel;
    private JButton enterButton;
    private JButton pauseButton; // �Ͻ����� ��ư
    private int pausedTimeLeft; // �Ͻ������� �ð��� ������ ����
    private String pausedWord; // �Ͻ������� ������ �ܾ ������ ����
    private boolean wordEntered; // �ܾ �ԷµǾ����� ���θ� ��Ÿ���� ����
    private int point;
    private JButton backButton; // �ڷ� ���� ��ư
    
    //�̹��� ������
    ImageIcon imgAnimal = new ImageIcon("animal.png");
    ImageIcon imgCountry = new ImageIcon("country.png");
    ImageIcon imgFood = new ImageIcon("food.png");
    ImageIcon imgFruit = new ImageIcon("fruit.png");
    ImageIcon imgWork = new ImageIcon("work.png");
    
    //Ű���� �ڽ�==================================================
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
       
        imgFruit = imageSetSize(imgFruit, 60, 60); // imageSetSize �޼ҵ� ����
        imgAnimal = imageSetSize(imgAnimal, 60, 60);
        imgWork = imageSetSize(imgWork, 60, 60);
        imgFood = imageSetSize(imgFood, 60, 60);
        imgCountry = imageSetSize(imgCountry, 60, 60);
        
        fruitButton.setIcon(imgFruit);
        fruitButton.setBackground(Color.LIGHT_GRAY);
        fruitButton.setBorderPainted(false);//��ư �׵θ� ��������
        
        animalButton.setIcon(imgAnimal);
        animalButton.setBackground(Color.LIGHT_GRAY);
        animalButton.setBorderPainted(false);//��ư �׵θ� ��������
        
        workButton.setIcon(imgWork);
        workButton.setBackground(Color.LIGHT_GRAY);
        workButton.setBorderPainted(false);//��ư �׵θ� ��������
        
        foodButton.setIcon(imgFood);
        foodButton.setBackground(Color.LIGHT_GRAY);
        foodButton.setBorderPainted(false);//��ư �׵θ� ��������
        
        countryButton.setIcon(imgCountry);
        countryButton.setBackground(Color.LIGHT_GRAY);
        countryButton.setBorderPainted(false);//��ư �׵θ� ��������
        
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
   
        enterButton = new JButton("�Է�");
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkInput();
            }
        });
        
        enterButton.setBackground(Color.LIGHT_GRAY);
        enterButton.setForeground(Color.DARK_GRAY);
        
//		// ��Ʈ(�۲�, ����, ũ��)
//		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 16);
        
        pauseButton = new JButton("�Ͻ�����");
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pauseGame();
            }
        });
        pauseButton.setBackground(Color.DARK_GRAY);
        pauseButton.setForeground(Color.white);
        
		// �ڷ� ���� ��ư ����
		backButton = new JButton("���� ����");
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultFrame.getInstance(new Main_Interface(), "���� ȭ��");
			}
		});
		
		backButton.setBackground(Color.DARK_GRAY);
		backButton.setForeground(Color.white);
        
        
        //inputPanel.add(inputLabel);
        inputPanel.add(backButton); // �ڷ� ���� ��ư�� �Է� �гο� �߰�
        inputPanel.add(inputTextField);
        inputPanel.add(enterButton);
        inputPanel.add(pauseButton); // �Ͻ����� ��ư�� �Է� �гο� �߰�

        scoreLabel = new JLabel("���� ���� : 0");
        scoreLabel.setBorder((BorderFactory.createEmptyBorder(0 , 10 , 0 , 0)));//���� ����
        scoreLabel.setPreferredSize(new Dimension(85,0));//������
        
        JFrame frame = new JFrame("�S�S�̽���");
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

		// 1.Toolkit�� ���� ������� �ػ󵵸� ������
		Toolkit tk = Toolkit.getDefaultToolkit();

		for (int i = 0; i < 3; i++) {
			try {// ���� ���
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			tk.beep();
		} // for

		// 2.Dimemsion�� ���ؼ� �߾� ��ǥ�� �����ϱ�
		Dimension di = tk.getScreenSize();
		int monitorW = di.width;
		int monitorH = di.height;

		// 3.������ �¿� ũ�� ���ֱ�
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
            // Ÿ�̸� 0.1�� ���� ����Ǵ� ��Ŀ������ ����
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
        // �ܾ ���� ���� wordY���� ���ŵȴ�.
        wordY = 20;
    }

    

    private void checkInput() {
        String userInput = inputTextField.getText().trim().toLowerCase();
        if (gameRunning && !userInput.isEmpty() && userInput.equals(currentWord)) {
            score++;
            scoreLabel.setText("���� ���� : " + score);
            generateWord();
            inputTextField.setText("");
            repaint();

			// 2���� �ܾ ������ 100���� �߰��� ����
			if (score % 1 == 0 && score > 0) {
				int earnedPoints = 50;
				point += earnedPoints;
			}

		}
	}
    
    private void endGame() {
        gameRunning = false;
        timer.stop();
        // 5���� �ܾ ���� Ƚ���� ���� �� ����Ʈ�� �߰������Ǿ� endGame�� ǥ�õ�
        int totalScore = score + point;
        JOptionPane.showMessageDialog(this, "���� ����!\n���� ���� : " + score + "\n�� " + point + "����Ʈ�� �����Ǿ����ϴ�.");

    }
    
	// ���� �Ͻ����� ���
	private void pauseGame() {
		if (gameRunning) {
			gameRunning = false;
			timer.stop();
			// ���߸� Ÿ�̸Ӱ� �Ͻ������� �����.
			time.stop();
			pausedTimeLeft = timeLeft; // �Ͻ������� �ð��� ����
			pausedWord = currentWord; // �Ͻ������� ������ �ܾ ����
			int option = JOptionPane.showConfirmDialog(this, "������ �Ͻ������Ǿ����ϴ�.\n������ �ٽ� �����Ͻðڽ��ϱ�?", "�Ͻ�����",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				startGame(pausedTimeLeft, score); // �Ͻ������� �ð����� ���� �����
			}
		}
	}
	
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) { // image Size Setting
		Image ximg = icon.getImage();  //ImageIcon�� Image�� ��ȯ.
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg); 
		return xyimg;
	}
	

	// ���� �簳 ���
	private void resumeGame() {
		if (!gameRunning) {
			gameRunning = true;
			timer.start();
			currentWord = pausedWord; // �Ͻ������� ������ �ܾ�� �ٽ� ����
			repaint();
			JOptionPane.showMessageDialog(this, "������ �ٽ� ���۵Ǿ����ϴ�.");
		}
	}
	
	// �ڷ� ���� ���
	private void goBack() {
		// ��ΰ� �������� �ʾ��� ���� null�� ó��
		String path = null;
		// ��ΰ� null�� �ƴ� ��쿡�� �ڷ� ���� ó��
		if (path != null) {
			// TODO: �ڷ� ���� ó��
		}
	}
	
//	//����Ʈ ����
//	public void pointSave() {
//	    int earnedPoints = (score / 5) * 100;
//	    point += earnedPoints;
//	    JOptionPane.showMessageDialog(this, "Game Over!\n����� ������: " + score + "\n������ ����Ʈ: " + point);
//	}
	
	//��� ȭ�鿡 �ߴ� Ű����
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (gameRunning) {
            g.setColor(Color.GRAY);
            g.setFont(new Font("Arial", Font.BOLD, 24));
            FontMetrics fm = g.getFontMetrics(); // FontMetrics�� ����Ͽ� ������ �ʺ� ����
            int wordWidth = fm.stringWidth(currentWord); // ������ �ʺ�
            int wordX = (getWidth() - wordWidth) / 2; // ȭ�� ���� �߾ӿ��� ������ ���� X ��ǥ ���
             // ȭ�� ���� �߾ӿ��� ������ Y ��ǥ ���
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
		// wordY += ���� Ŀ���� �������� ���� Ŀ����.
		wordY += 5;
		// wordY ���� 200���� �������� �۵�
		if(wordY == 450) {
			// endGame();
			generateWord();
		}
	}
}
