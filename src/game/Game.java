package game;

import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class Game {
	private long lastFrame;
	private Window gameWindow;
	private Racket racket;
	private Ball b;
	private Block[] blocks;

	public Game() {
		this.gameWindow = new Window(800, 600);
		gameWindow.start();

		this.racket = new Racket(gameWindow);
		this.b = new Ball(this, 3f,3f, 10, new Square(10), new MyVector2f(0.1f, 0.5f));
		//this.blocks = new Block[3];
		//this.blocks[0] = new Block(gameWindow, 100, 100);
		//this.blocks[1] = new Block(gameWindow, 400, 500);
		//this.blocks[2] = new Block(gameWindow, 300, 100);

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

		racket.render();
		b.render();
		for (Block block : this.blocks) {
			block.render();
			
		}

		Display.update();

	}

	public void update(int delta) {
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			racket.moveHorizontally(delta, -1);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			racket.moveHorizontally(delta, 1);
		}
		b.update(delta);
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

	public Window getGameWindow() {
		return this.gameWindow;
	}

	public Racket getRacket() {
		return this.racket;
	}

	public Block[] getBlocks() {
		return blocks;
	}
	

}
