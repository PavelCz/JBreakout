package game;

public class Block extends Entity {
	private float width;
	private float height;
	
	private RectangleCollision rc;

	public Block(Window gameWindow, float x, float y) {
		super(gameWindow);
		this.coordinates.setX(x);
		this.coordinates.setY(y);
		this.width = 100;
		this.height = 50;
		
		this.rc = new RectangleCollision(this.coordinates, this.width, this.height);
	}

}
