package graphics;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Rectangle extends RenderObject {
	// private Quad quad;
	private Vector3f colorsRGB;

	private int width;
	private int height;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
		this.colorsRGB = new Vector3f();
		this.setColor(0.1f, 0.1f, 0.5f);
	}

	public Rectangle(int width, int height, String color) {
		this.width = width;
		this.height = height;
		this.colorsRGB = new Vector3f();
		switch (color) {
		case "blau":
			this.setColor(0.1f, 0.1f, 0.5f);
			break;
		case "rot":
			this.setColor(0.5f, 0.1f, 0.1f);
			break;
		case "gelb":
			this.setColor(0.1f, 0.5f, 0.1f);
			break;

		}
	}

	public void render(float x, float y) {
		// set the color of the quad (R,G,B,A)
		GL11.glColor3f(this.colorsRGB.getX(), this.colorsRGB.getY(),
				this.colorsRGB.getZ());

		// draw quad
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(0 + x, 0 + y);
		GL11.glVertex2f(this.width + x, 0 + y);
		GL11.glVertex2f(this.width + x, this.height + y);
		GL11.glVertex2f(0 + x, this.height + y);
		GL11.glEnd();
	}

	public void setColor(float r, float g, float b) {
		this.colorsRGB.set(r, g, b);
	}

	

}
