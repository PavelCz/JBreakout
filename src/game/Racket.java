package game;

import org.lwjgl.util.vector.Vector2f;

public class Racket extends Entity {

    
    private int width;
    private int height;

    private float speed;

    public Racket(Window gameWindow) {
	super(gameWindow);
	

	this.speed = 0.5f;
	this.width = 100;
	this.height = 25;
	this.coordinates = new Vector2f((this.gameWindow.getWidth() - this.width) / 2, this.gameWindow.getHeight() - this.height
		- 50);
	
	this.renderObject = new Rectangle(coordinates.getX(), coordinates.getY(), width, height);
	this.renderObject.setColor(0f, 0f, 1f);

    }

   

    

    public void moveHorizontally(int delta, float x) {
	this.coordinates.setX(this.coordinates.getX() + speed * x * delta);
	if (this.coordinates.getX() < 0) {
	    this.coordinates.setX(0);
	} else if (this.coordinates.getX() + this.width > this.gameWindow.getWidth()) {
	    this.coordinates.setX(this.gameWindow.getWidth() - this.width);
	}
    }
    
    public int getWidth() {
	return this.width;
    }

}
