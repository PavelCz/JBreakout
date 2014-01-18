package game;

import org.lwjgl.util.vector.Vector2f;

public class Ball extends Entity {
	private Game game;
	private int length;
	private MyVector2f velocity;
	private RectangleCollision rc;

	public Ball(Game game, float x, float y, int length, RenderObject renderObject, MyVector2f startVelocity) {
		super(game.getGameWindow());
		this.game = game;

		this.coordinates = new MyVector2f(x, y);
		this.length = length;

		this.renderObject = renderObject;

		this.velocity = startVelocity;

		this.rc = new RectangleCollision(this.coordinates, this.length, this.length);
	}

	public void update(int delta) {
		float previousX = this.getX();
		float previousY = this.getY();
		this.coordinates.setX(this.coordinates.getX() + this.velocity.getX() * delta);
		this.coordinates.setY(this.coordinates.getY() + this.velocity.getY() * delta);
		this.wallCollision(previousX, previousY);
		this.racketCollision(previousX, previousY);
		this.ballCollision(previousX, previousY);
	}

	private void racketCollision(float previousX, float previousY) {
		for (Racket racket : game.getRackets()) {
			float racketMiddle = racket.getX() + racket.getWidth() / 2;
			float distanceToRacketMiddle = racketMiddle - this.getX();
			if (this.collidesWithRacket(racket)) {
				MyVector2f newVelocity = this.velocity.clone();
				newVelocity.rotateDegrees(180);
				newVelocity.setLength(1);
				while (this.collidesWithRacket(racket)) {
					this.coordinates.setX(this.coordinates.getX() + newVelocity.getX());
					this.coordinates.setY(this.coordinates.getY() + newVelocity.getY());
				}
				if (this.coordinates.getX() + this.length < racket.getX()) { // left
					this.velocity.setX(this.velocity.getX() * -1);
				} else if (this.coordinates.getX() > racket.getX() + racket.getWidth()) { // right
					this.velocity.setX(this.velocity.getX() * -1);
				} else if (this.coordinates.getY() + this.length < racket.getY()) { // above
					this.velocity.setAngleDegrees((270 - distanceToRacketMiddle / 50 * 45));
					this.coordinates.setY(racket.getY() - this.length);
				} else { // below
					this.velocity.setAngleDegrees((distanceToRacketMiddle / 50 * 45 + 90));
					this.coordinates.setY(racket.getY() + racket.getHeight());
				}

				/*
				 * if (this.velocity.getAngleDegrees() > 0 &&
				 * this.velocity.getAngleDegrees() < 180) { // lower // racket }
				 * else { // upper racket }
				 */
			}
		}
	}

	public boolean collidesWithRacket(Racket racket) {
		return this.coordinates.getX() + this.length > racket.getX() && this.coordinates.getX() < racket.getX() + racket.getWidth()
				&& this.coordinates.getY() + this.length > racket.getY()
				&& this.coordinates.getY() < racket.getY() + racket.getHeight();
	}

	// old collision
	// private void racketCollision(float previousX, float previousY) {
	// for (Racket racket : game.getRackets()) {
	//
	// if (this.coordinates.getX() + this.length > racket.getX() &&
	// this.coordinates.getX() < racket.getX() + racket.getWidth()) {
	// if (this.coordinates.getY() + this.length > racket.getY()
	// && this.coordinates.getY() < racket.getY() + racket.getHeight()) {
	// float racketMiddle = racket.getX() + racket.getWidth() / 2;
	// float distanceToRacketMiddle = racketMiddle - this.getX();
	//
	// this.coordinates.setX(previousX);
	// if (this.velocity.getAngleDegrees() > 0 &&
	// this.velocity.getAngleDegrees() < 180) { // lower
	// // racket
	// this.velocity.setAngleDegrees((270 - distanceToRacketMiddle / 50 * 45 ));
	// this.coordinates.setY(racket.getY() - this.length);
	// } else { // upper racket
	// this.velocity.setAngleDegrees((distanceToRacketMiddle / 50 * 45 + 90));
	// this.coordinates.setY(racket.getY() + racket.getHeight());
	// }
	// }
	// }
	// }
	// }

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

	private void ballCollision(float previousX, float previousY) {
		int counter = 0;
		if (game.getBlocks() != null) {
			for (Block block : game.getBlocks()) {
				++counter;
				if (this.rc.collidesWith(block.getCollisionMask())) {
					System.out.println("collision with " + counter);
				}
			}
		}

	}

	public MyVector2f getVelocity() {
		return velocity;
	}

	public void setX(float x) {
		this.coordinates.setX(x);
	}

	public void setY(float y) {
		this.coordinates.setY(y);
	}

}
