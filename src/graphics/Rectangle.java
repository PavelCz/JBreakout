package graphics;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class Rectangle extends BasicRenderObject {
	// private Quad quad;
	private Vector3f colorsRGB;

	private float width;
	private float height;

	public Rectangle(float width, float height) {
		this.width = width;
		this.height = height;
		this.colorsRGB = new Vector3f();
		this.setColor(0.1f, 0.5f, 0.1f);
	}

	public Rectangle(float width, float height, float r, float g, float b) {
		this.width = width;
		this.height = height;
		this.colorsRGB = new Vector3f();
		this.setColor(r, g, b);

	}

	public void render(float x, float y) {
		// set the color of the quad (R,G,B,A)
		GL11.glColor3f(this.colorsRGB.getX(), this.colorsRGB.getY(), this.colorsRGB.getZ());

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

	public void setWidth(float width) {
		this.width = (int) width;
	}

}
