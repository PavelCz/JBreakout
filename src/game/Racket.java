package game;

import graphics.Rectangle;
import graphics.Window;
import maths.MyVector2f;

import org.lwjgl.util.vector.Vector2f;

import control.Controllable;

public class Racket extends Entity implements Controllable {

	private int width;
	private int height;

	private float speed;

	public Racket(Window gameWindow, float startingX, float startingY,
			int width, int height) {
		super(gameWindow);

		this.speed = 0.75f;
		this.width = width;
		this.height = height;
		this.coordinates = new MyVector2f(startingX, startingY);

		this.renderObject = new Rectangle(width, height);
		this.renderObject.setColor(0f, 0f, 1f);

	}

	public void moveHorizontally(int delta, float x) {
		this.coordinates.setX(this.coordinates.getX() + speed * x * delta);
		if (this.coordinates.getX() < 0) {
			this.coordinates.setX(0);
		} else if (this.coordinates.getX() + this.width > this.gameWindow
				.getWidth()) {
			this.coordinates.setX(this.gameWindow.getWidth() - this.width);
		}
	}

	public int getWidth() {
		return this.width;
	}

	public float getHeight() {
		return this.height;
	}

}
