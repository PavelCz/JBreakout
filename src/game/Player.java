package game;

import org.lwjgl.input.Keyboard;

public class Player {
	private Controllable controlling;
	private int score;
	private int lives;
	
	public Player(Controllable controlling, int score, int lives) {
		super();
		this.controlling = controlling;
		this.score = score;
		this.lives = lives;
	}
	
	public void control(int delta) {
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			this.controlling.moveHorizontally(delta, -1);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			this.controlling.moveHorizontally(delta, 1);
		}
	}
}