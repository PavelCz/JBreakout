package game;

public class Block extends Entity {
	private float width;
	private float height;
	
	private RectangleCollision rc;

	public Block(Window gameWindow, float x, float y) {
		super(gameWindow);
		this.coordinates = new MyVector2f(x, y);
		this.width = 100;
		this.height = 50;
		
		this.renderObject = new Rectangle((int)this.width, (int)this.height);
		
		this.rc = new RectangleCollision(this.coordinates, this.width, this.height);
	}

}
