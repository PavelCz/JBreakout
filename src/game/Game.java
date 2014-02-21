package game;

import java.io.IOException;

import graphics.BMP;
import graphics.Image;
import graphics.Square;
import graphics.Window;
import gui.Healthbar;
import gui.Score;
import gui.Text;
import maths.MyVector2f;

import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import control.Controls1D;

public class Game {
	private int fps;
	private long lastFPS;
	private boolean debug;
	private long lastFrame;
	private Window gameWindow;
	private Racket[] rackets;
	private Player[] players;
	private Controls1D controls1, controls2;
	private Ball ball;
	private boolean running;
	private boolean physicsPaused;
	private int counter1;
	private Healthbar[] healthbars;
	private Score[] scores;
	private Text scoreText1;
	private Text scoreText2;

	// Tests:
	//
	public Game() {
		// Test:
		
		//
		this.scoreText1 = new Text("./data/font", "L",200, 0,5);
		this.scoreText2 = new Text("./data/font", "WUSS",200, 400,5);
		this.running = true;
		this.physicsPaused = false;
		this.counter1 = 0;
		this.debug = false;
		this.gameWindow = new Window(800, 600);
		this.gameWindow.start();
		this.controls1 = new Controls1D(Keyboard.KEY_LEFT, Keyboard.KEY_RIGHT);
		this.controls2 = new Controls1D(Keyboard.KEY_A, Keyboard.KEY_D);

		this.rackets = new Racket[2];
		this.players = new Player[2];
		int racketHeight = 25;
		int racketWidth = 100;
		// upper racket
		this.rackets[0] = new Racket(gameWindow, this.gameWindow.getWidth() / 2 - racketWidth / 2, 50, racketWidth, racketHeight);
		// lower racket
		this.rackets[1] = new Racket(gameWindow, this.gameWindow.getWidth() / 2 - racketWidth / 2, this.gameWindow.getHeight()
				- racketHeight - 50, racketWidth, racketHeight);

		this.players[0] = new Player(rackets[0], controls1, 0, 5);
		this.players[1] = new Player(rackets[1], controls2, 0, 5);

		this.healthbars = new Healthbar[2];
		this.healthbars[0] = new Healthbar(0, 0, this.players[0].getLives(), 100, 20);
		this.healthbars[1] = new Healthbar(0, this.gameWindow.getHeight() - 20, this.players[0].getLives(), 100, 20);

		int scoreScale = 3;
		this.scores = new Score[2];
		this.scores[0] = new Score(800, 0, this.players[0].getScore(), false, scoreScale);
		this.scores[1] = new Score(800, this.gameWindow.getHeight() - scoreScale * 5, this.players[1].getScore(), false, scoreScale);

		int ballDiameter = 10;
		this.ball = new Ball(this, 3f, 3f, ballDiameter, new Square(ballDiameter), new MyVector2f(0.1f, 0.5f));
		this.ball.resetBall(1);

	}

	public void init() {

		// init OpenGL here

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, gameWindow.getWidth(), gameWindow.getHeight(), 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		this.getDelta();

	}

	public void start() {
		this.lastFPS = getTime();
		while (!Display.isCloseRequested() && this.running) {
			int delta = this.getDelta();

			this.update(delta);

			this.render();

		}

		Display.destroy();
	}

	public void render() {

		// render OpenGL here

		// Clear the screen and depth buffer
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

		for (Racket racket : this.rackets) {
			racket.render();
		}
		ball.render();
		
		this.renderGUI();

		// render tests
		//
		Display.update();

	}

	private void renderGUI() {
		for (Healthbar healthbar : this.healthbars) {
			healthbar.render();
		}

		for (Score score : this.scores) {
			score.render();

		}
		
		this.scoreText1.render();
		this.scoreText2.render();
	}

	public void update(int delta) {
		while (Keyboard.next()) {
			if (Keyboard.getEventKey() == Keyboard.KEY_L) {
				if (Keyboard.getEventKeyState()) {
					this.debug = !this.debug;
					System.out.println(this.debug);
				}
			}
			if (Keyboard.getEventKey() == Keyboard.KEY_P) {
				if (Keyboard.getEventKeyState()) {
					this.tooglePause();
					if (this.physicsPaused) {
						System.out.println("Paused");
					} else {
						System.out.println("Unpaused");
					}
				}
			}
			// Test Key Event
			if (Keyboard.getEventKey() == Keyboard.KEY_O) {
				if (Keyboard.getEventKeyState()) {
					// Tests

				}
			}
		}
		if (!this.physicsPaused) {
			players[0].control(delta);
			players[1].control(delta);

			ball.update(delta);

			if (this.debug) {
				ball.setX(Mouse.getX());
				ball.setY(this.gameWindow.getHeight() - Mouse.getY());
			}

			if (this.players[0].getLives() <= 0) {
				System.out.println("Player 2 won!!!");
				this.running = false;
			} else if (this.players[1].getLives() <= 0) {
				System.out.println("Player 1 won!!!");
				this.running = false;
			}
		}
		this.updateHealth();
		this.updateFPS();
	}

	private void updateHealth() {
		this.healthbars[0].setHealth(this.players[0].getLives());
		this.healthbars[1].setHealth(this.players[1].getLives());
		this.scores[0].setScore(this.players[0].getScore());
		this.scores[1].setScore(this.players[1].getScore());
	}

	public int getDelta() {
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;

		return delta;
	}

	/**
	 * Get the time in milliseconds
	 * 
	 * @return The system time in milliseconds
	 */
	public long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}

	/**
	 * Calculate the FPS and set it in the title bar
	 */
	public void updateFPS() {
		if (getTime() - lastFPS > 1000) {
			Display.setTitle("FPS: " + fps);
			fps = 0;
			lastFPS += 1000;
		}
		fps++;
	}

	public void tooglePause() {
		this.physicsPaused = !this.physicsPaused;
	}

	public Window getGameWindow() {
		return this.gameWindow;
	}

	public Racket getRacket(int number) {
		return this.rackets[number];
	}

	public Racket[] getRackets() {
		return this.rackets;
	}

	public Player[] getPlayers() {
		return this.players;
	}

	public Player getPlayer0() {
		return this.players[0];
	}

	public Player getPlayer1() {
		return this.players[1];
	}

	// public Block[] getBlocks() {
	// return blocks;
	// }

}
