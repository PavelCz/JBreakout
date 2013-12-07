package game;

import org.lwjgl.util.vector.Vector2f;

public class Square extends RenderObject {
	private Rectangle rectangle;

	private int length;

	public Square(float x, float y, int length) {
		this.rectangle = new Rectangle(x, y, length, length);
		this.coordinates = new Vector2f(x, y);
		this.length = length;

	}

	public void render(float x, float y) {
		this.rectangle.render(x, y);
	}
	public void setColor(float r, float g, float b) {
		this.rectangle.setColor(r, g, b);
	}

	/*public void moveHorizontally(float x) {
		this.coordinates.setX(this.coordinates.getX() + x);
		this.update();
	}
	
	public void moveVertically(float y) {
		this.coordinates.setY(this.coordinates.getY() + y);
		this.update();
	}*/

	public void update() {
		this.rectangle.setCoordinates(coordinates.getX(), this.coordinates.getY());
		this.rectangle.update();
	}
}
