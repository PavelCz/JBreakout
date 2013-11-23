package game;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

public class Pixel /*extends RenderObject*/ {
	private Vector2f coordinates;

	public Pixel(int x, int y) {
		this.coordinates = new Vector2f(x, y);
	}

	public void init(Window window) {
		// init OpenGL
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, window.getWidth(), 0, window.getHeight(), 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}

	public void render() {

		// set the color of the quad (R,G,B,A)
		GL11.glColor3f(0.5f, 0.5f, 1.0f);

		// draw quad
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(this.coordinates.x, this.coordinates.y);
		GL11.glEnd();
	}
}
