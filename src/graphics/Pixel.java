package graphics;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class Pixel extends BasicRenderObject {
	// private Quad quad;
	private Vector3f colorsRGB;

	public Pixel() {
		this.colorsRGB = new Vector3f();
		this.setColor(0.5f, 0.1f, 0.1f);
	}

	/**
	 * Note: It seems, a Pixel at Position (0; 0) cant be seen. The
	 * y-coordinate has to be at least 1 that it can be seen. This means a Pixel
	 * in the upper left corner actually has the coordinates (0; 1).
	 * 
	 */
	@Override
	public void render(float x, float y) {
		// set the color of the quad (R,G,B,A)
		GL11.glColor3f(this.colorsRGB.getX(), this.colorsRGB.getY(), this.colorsRGB.getZ());

		// draw quad
		GL11.glBegin(GL11.GL_POINTS);
		GL11.glVertex2f(x, y);
		GL11.glEnd();
	}

	public void setColor(float r, float g, float b) {
		this.colorsRGB.set(r, g, b);
	}

}