package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import com.sun.glass.ui.Timer;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;

public class MolePane extends GraphicsPane{
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	private MainApplication program;
	private GImage imgBG;
	private Gamemode cGame;

	
	//may need these to display properly a score variable
	//Find where it should equal zero
	private int score; //= cGame.getScore();
	private int timeLeft; //= cGame.getDifficulty().getTimer();
	
	private GLabel scoreLabel = new GLabel("Score: " + score, 50, 50);
	private GLabel timerLabel = new GLabel("Time Remaining: " + timeLeft, 450, 650);
	


	public MolePane(MainApplication app, Gamemode cGame) {
		this.program = app;
		imgBG = new GImage("LevelBG.jpg");
		this.cGame = cGame;
		scoreLabel.setFont(MainApplication.menuFont);
		timerLabel.setFont(MainApplication.menuFont);
	}
	
	//Setup the the game
	public void setup() {
		cGame.setupMoles(cGame.getDifficulty().getDifficultyLevel());
		cGame.setupHoles(WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	
	@Override
	public void showContents() {
		program.add(imgBG);
		program.add(scoreLabel);
		program.add(timerLabel);


		this.setup();
		
		 
		for(Mole tempMole:cGame.getMoleArray()) {
			GOval hole = new GOval(tempMole.getSpawn().getX(), tempMole.getSpawn().getY(), tempMole.getSpawn().getWidth(), tempMole.getSpawn().getHeight());
			hole.setFilled(true);
			hole.setColor(Color.BLACK);
			program.add(hole);
			program.add(tempMole.getMoleImage());
			tempMole.startGame();
		}	
	}
	

	@Override
	public void hideContents() {
		program.remove(imgBG);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		cGame.mousePressed(e, program.getElementAt(e.getX(), e.getY()));
		score = cGame.getScore();
	}
}
