package game;

import java.util.Random;

import org.lwjgl.util.vector.Vector2f;

public class Ball extends Entity {
    private Game game;
    private int length;
    private MyVector2f velocity;

    public Ball(Game game) {
	super(game.getGameWindow());
	this.game = game;

	this.coordinates = new Vector2f(3, 3);
	this.length = 10;

	this.renderObject = new Square(this.coordinates.getX(), this.coordinates.getY(), this.length);

	// this.renderObject.setColor(0f, 0f, 1f);

	this.velocity = new MyVector2f(0.1f, 0.5f);
	// this.velocity = new Vector2f(0.01f, 0.01f);
    }

    public void update(int delta) {
	float previousX = this.getX();
	float previousY = this.getY();
	this.coordinates.setX(this.coordinates.getX() + this.velocity.getX() * delta);
	this.coordinates.setY(this.coordinates.getY() + this.velocity.getY() * delta);
	this.wallCollision(previousX, previousY);
	this.racketCollision(previousX);

	super.update(delta);
    }

    private void racketCollision(float previousX) {
	Racket racket = this.game.getRacket();
	if (this.coordinates.getX() + this.length >= racket.getX() && this.coordinates.getX() <= racket.getX() + racket.getWidth()) {
	    if (this.coordinates.getY() + this.length >= racket.getY()) {
		// System.out.println("JO");
		this.coordinates.setX(previousX);
		this.coordinates.setY(racket.getY() - this.length);
		//this.velocity.
		this.velocity.setY(this.velocity.getY() * (-1));
	    }
	}
    }

    private void wallCollision(float previousX, float previousY) {
	// Collision right
	if (this.coordinates.getX() + this.length >= gameWindow.getWidth()) {
		this.coordinates.setY(previousY);
	    this.coordinates.setX(this.gameWindow.getWidth() - this.length);
	    this.velocity.setX(this.velocity.getX() * (-1));
	}
	// Collision left
	if (this.coordinates.getX() < 0) {
		this.coordinates.setY(previousY);
	    this.coordinates.setX(0);
	    this.velocity.setX(this.velocity.getX() * (-1));
	}

	// Collision bottom
	if (this.coordinates.getY() + this.length >= gameWindow.getHeight()) { 
	    System.out.println("FAIL");
	    this.coordinates.setX(0);
	    this.coordinates.setY(0);
	}

	// Collision top
	if (this.coordinates.getY() < 0) {
		this.coordinates.setX(previousX);
	    this.coordinates.setY(0);
	    this.velocity.setY(this.velocity.getY() * (-1));
	}
    }

}
