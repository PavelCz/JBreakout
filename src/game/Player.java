package game;

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
}