package playGame;

import DongGame.ClickClickGame;
import HeyonGame.FlyingFlying;
import Main_Interface.Main_Interface;
import SongGame.Keyword;
import SunGame.penalty24;
import YeonGame.Umi;
import infinityStair.StartFrame;
import infinityStair.StartPanel;

public class PlayGame {

	public static void playFlyingFlying() {
		new FlyingFlying();
	}
	
	public void playToTheSpace() {
		StartFrame.getInstance(new StartPanel());
	}
	
	public void playUmi() {
		new Umi();
	}
	
	public void playKeyword() {
		new Keyword();
	}
	
	public void playPenalty24() {
		new penalty24();
	}
	
	public void playClickClickGame() {
		new ClickClickGame();
	}
	
}
