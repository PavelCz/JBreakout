package collision;

import maths.MathmaticalMethods;
import maths.MyVector2f;

import org.lwjgl.util.vector.Vector2f;

/**
 * @author Pavel
 * 
 */
public class RectangleCollision extends CollisionMask {
	private MyVector2f coordinates;
	private float width;
	private float height;

	public RectangleCollision(MyVector2f coordinates, float width, float height) {
		super();
		this.coordinates = coordinates;
		this.width = width;
		this.height = height;
	}

	/*
	@Override
	public boolean collidesWith(CollisionMask c) {
		if (c.getClass().equals(RectangleCollision.class)) {
			return this.collidesWith((RectangleCollision) c);
		} else {

			return false;
		}

	}*/

	/**
	 * returns if this collides with another RectangleCollisionMask. Only works
	 * if this is smaller than rc for now.
	 * 
	 * @param rc
	 * @return
	 */

	public boolean collidesWith(RectangleCollision rc) {
		MyVector2f[] coordinates = new MyVector2f[4];
		coordinates[0] = this.coordinates;
		coordinates[1] = new MyVector2f(this.coordinates.getX(),
				this.coordinates.getY() + this.height);
		coordinates[2] = new MyVector2f(this.coordinates.getX() + this.width,
				this.coordinates.getY());
		coordinates[3] = new MyVector2f(this.coordinates.getX() + this.width,
				this.coordinates.getY() + this.height);
		for (MyVector2f coordinate : coordinates) {
			if (MathmaticalMethods.isPointInsideRectangle(coordinate.getX(),
					coordinate.getY(), rc.getCoordinates().getX(), rc
							.getCoordinates().getY(), rc.getWidth(), rc
							.getHeight())) {
				return true;
			}

		}
		return false;

	}

	/*
	 * public boolean collidesWith(RectangleCollision rc) { if
	 * (this.coordinates.getX() + this.width > rc.getCoordinates().getX() &&
	 * this.coordinates.getY() +this.height > rc.coordinates.getY()) {
	 * 
	 * this.coordinates.setX(this.gameWindow.getWidth() - this.length);
	 * this.velocity.setX(this.velocity.getX() * (-1)); } else if(this.) }
	 */

	/*
	 * public boolean collidesWith(RectangleCollision rc) {
	 * 
	 * if (this.coordinates.getX() +this.width > rc.getCoordinates().getX() &&
	 * this.coordinates.getX() < ) { this.coordinates.setY(previousY);
	 * this.coordinates.setX(this.gameWindow.getWidth() - this.length);
	 * this.velocity.setX(this.velocity.getX() * (-1)); } // Collision left if
	 * (this.coordinates.getX() < 0) { this.coordinates.setY(previousY);
	 * this.coordinates.setX(0); this.velocity.setX(this.velocity.getX() *
	 * (-1)); }
	 * 
	 * // Collision bottom if (this.coordinates.getY() + this.length >=
	 * gameWindow.getHeight()) { System.out.println("FAIL");
	 * this.coordinates.setX(0); this.coordinates.setY(0); }
	 * 
	 * // Collision top if (this.coordinates.getY() < 0) {
	 * this.coordinates.setX(previousX); this.coordinates.setY(0);
	 * this.velocity.setY(this.velocity.getY() * (-1));
	 * 
	 * 
	 * }
	 */

	public MyVector2f getCoordinates() {
		return this.coordinates;
	}

	public float getWidth() {
		return this.width;
	}

	public float getHeight() {
		return this.height;
	}

}
