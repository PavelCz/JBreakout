package game;

import org.lwjgl.util.vector.Vector2f;

public class Rectangle extends RenderObject {
	private Quad quad;


	private int width;
	private int height;

	public Rectangle(float x, float y, int width, int height) {
		this.quad = new Quad(x, y, x + width, y, x + width, y + height, x, y + height);
		this.coordinates = new Vector2f(x,y);
		this.width = width;
		this.height = height;
	}
	public Rectangle(float x, float y, int width, int height, String color) {
		this.quad = new Quad(x, y, x + width, y, x + width, y + height, x, y + height, color);
		this.coordinates = new Vector2f(x,y);
		this.width = width;
		this.height = height;
	}

	public void render(float x,  float y) {
		this.quad.render(x, y);
	}
	
	public void setColor(float r, float g, float b) {
		this.quad.setColor(r, g, b);
	}
	public void update() {
		this.quad.setCoordinates(this.coordinates.getX(), this.coordinates.getY(),
				this.coordinates.getX() + width, this.coordinates.getY(), this.coordinates.getX()
						+ width, this.coordinates.getY() + height, this.coordinates.getX(),
				this.coordinates.getY() + height);
	}

}
