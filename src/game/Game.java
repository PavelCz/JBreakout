package game;

import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class Game {
	private int fps;
	private long lastFPS;
	private boolean debug;
	private long lastFrame;
	private Window gameWindow;
	private Racket[] rackets;
	private Player player1, player2;
	private Controls1D controls1, controls2;
	private Ball b;

	// private Block[] blocks;

	public Game() {
		this.debug = false;
		this.gameWindow = new Window(800, 600);
		gameWindow.start();
		this.controls1 = new Controls1D(Keyboard.KEY_LEFT, Keyboard.KEY_RIGHT);
		this.controls2 = new Controls1D(Keyboard.KEY_A, Keyboard.KEY_D);

		this.rackets = new Racket[2];
		int racketHeight = 25;
		int racketWidth = 100;

		this.rackets[0] = new Racket(gameWindow, this.gameWindow.getWidth() / 2
				- racketWidth / 2, 50, racketWidth, racketHeight);
		this.rackets[1] = new Racket(gameWindow, this.gameWindow.getWidth() / 2
				- racketWidth / 2, this.gameWindow.getHeight() - racketHeight
				- 50, racketWidth, racketHeight);

		this.player1 = new Player(rackets[0], controls1, 0, -1);
		this.player2 = new Player(rackets[1], controls2, 0, -1);

		int ballDiameter = 10;
		this.b = new Ball(this, 3f, 3f, ballDiameter, new Square(ballDiameter),
				new MyVector2f(0.1f, 0.5f));
		// this.blocks = new Block[3];
		// this.blocks[0] = new Block(gameWindow, 100, 100);
		// this.blocks[1] = new Block(gameWindow, 400, 500);
		// this.blocks[2] = new Block(gameWindow, 300, 100);

	}

	public void init() {

		// init OpenGL here

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, gameWindow.getWidth(), gameWindow.getHeight(), 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		getDelta();

	}

	public void start() {
		this.lastFPS = getTime();
		while (!Display.isCloseRequested()) {
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
		b.render();

		/*
		 * for (Block block : this.blocks) { block.render();
		 * 
		 * }
		 */

		Display.update();

	}

	public void update(int delta) {
		while (Keyboard.next()) {
			if (Keyboard.getEventKey() == Keyboard.KEY_P) {
				if (Keyboard.getEventKeyState()) {
					this.debug = !this.debug;
					System.out.println(this.debug);
				}
			}
		}
		player1.control(delta);
		player2.control(delta);

		b.update(delta);

		if (this.debug) {
			b.setX(Mouse.getX());
			b.setY(this.gameWindow.getHeight() - Mouse.getY());
		}

		this.updateFPS();
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

	public Window getGameWindow() {
		return this.gameWindow;
	}

	public Racket getRacket(int number) {
		return this.rackets[number];
	}

	public Racket[] getRackets() {
		return this.rackets;
	}

	// public Block[] getBlocks() {
	// return blocks;
	// }

}
