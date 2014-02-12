package graphics;

import org.lwjgl.util.vector.Vector2f;

public class Square extends BasicRenderObject {
	private Rectangle rectangle;

	private int length;

	/**
	 * Default Square length is 1, just like a pixel
	 */
	public Square() {
		this(1);

	}
	public Square(int length) {
		this.rectangle = new Rectangle(length, length);
		this.length = length;

	}
	
	

	public void render(float x, float y) {
		this.rectangle.render(x, y);
	}
	public void setColor(float r, float g, float b) {
		this.rectangle.setColor(r, g, b);
	}

	
}
