package game;

import org.lwjgl.util.vector.Vector2f;

/**
 * @author Pavel
 * 
 */
public class RectangleCollision extends CollisionMask {
	private Vector2f coordinates;
	private float width;
	private float height;

	public RectangleCollision(Vector2f coordinates, float width, float height) {
		super();
		this.coordinates = coordinates;
		this.width = width;
		this.height = height;
	}

	@Override
	public boolean collidesWith(CollisionMask c) {

		return false;

	}

	/**
	 * returns if this collides with another RectangleCollisionMask. Only works
	 * if this is smaller than rc for now.
	 * 
	 * @param rc
	 * @return
	 */
	
	public boolean collidesWith(RectangleCollision rc) {
		return false;
	}
	/*public boolean collidesWith(RectangleCollision rc) {
		if (this.coordinates.getX() + this.width > rc.getCoordinates().getX() && this.coordinates.getY() +this.height > rc.coordinates.getY()) {
			
			this.coordinates.setX(this.gameWindow.getWidth() - this.length);
			this.velocity.setX(this.velocity.getX() * (-1));
		} else if(this.)
	}*/

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

	public Vector2f getCoordinates() {
		return this.coordinates;
	}

}
