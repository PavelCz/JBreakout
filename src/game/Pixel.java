package game;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Pixel extends RenderObject {
	// private Quad quad;
		private Vector3f colorsRGB;

		public Pixel() {
			this.colorsRGB = new Vector3f();
			this.setColor(0.1f, 0.1f, 0.5f);
		}

		

		public void render(float x, float y) {
			// set the color of the quad (R,G,B,A)
			GL11.glColor3f(this.colorsRGB.getX(), this.colorsRGB.getY(),
					this.colorsRGB.getZ());

			// draw quad
			GL11.glBegin(GL11.GL_POINTS);
			GL11.glVertex2f(x, y);
			GL11.glEnd();
		}

		public void setColor(float r, float g, float b) {
			this.colorsRGB.set(r, g, b);
		}

		

	}