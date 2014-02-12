package graphics;
// Quad unsupported for now

/*package game;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

*//**
 * @author Pavel
 * 
 *         Generates a Quad. After the constructor the addCoordinate function must be called 4 times, or else the remaining Vertices
 *         will have default Coordinates.
 *//*
public class Quad extends RenderObject {
	private Vector3f colorsRGB;
	//private float alpha = 1;
	private Vector2f[] coordinates;
	private int coordinatesGiven;

	public Quad() {
		//this.coordinates = new Vector2f[4];
		this.coordinatesGiven = 0;
	}

	public Quad(float x0, float y0, float x1, float y1, float x2, float y2, float x3, float y3) {
		this.coordinatesGiven = 4;
		//this.coordinates = new Vector2f[4];
		for(int i = 0; i < 4; ++i) {
			this.coordinates[i]= new Vector2f();
		}
		this.coordinates[0].setX(x0);
		this.coordinates[0].setY(y0);
		this.coordinates[1].setX(x1);
		this.coordinates[1].setY(y1);
		this.coordinates[2].setX(x2);
		this.coordinates[2].setY(y2);
		this.coordinates[3].setX(x3);
		this.coordinates[3].setY(y3);
		this.colorsRGB = new Vector3f();
		this.setColor(0.1f,0.1f,0.5f);
	}
	public Quad(float x0, float y0, float x1, float y1, float x2, float y2, float x3, float y3, String color) {
		this.coordinatesGiven = 4;
		this.coordinates = new Vector2f[4];
		for(int i = 0; i < 4; ++i) {
			this.coordinates[i]= new Vector2f();
		}
		this.coordinates[0].setX(x0);
		this.coordinates[0].setY(y0);
		this.coordinates[1].setX(x1);
		this.coordinates[1].setY(y1);
		this.coordinates[2].setX(x2);
		this.coordinates[2].setY(y2);
		this.coordinates[3].setX(x3);
		this.coordinates[3].setY(y3);
		this.colorsRGB = new Vector3f();
		switch (color) {
		    case "blau":this.setColor(0.1f,0.1f,0.5f);
				break;
		    case "rot":this.setColor(0.5f,0.1f,0.1f);
			break;
		    case "gelb":this.setColor(0.1f,0.5f,0.1f);
			break;
				
				
		}
		//this.setColor(0.1f,0.1f,0.5f);
	}
	public void setColor(float r, float g, float b) {
		this.colorsRGB.set(r, g, b);
	}
	
	public void setCoordinates(float x0, float y0, float x1, float y1, float x2, float y2, float x3, float y3)  {
		this.coordinates[0].setX(x0);
		this.coordinates[0].setY(y0);
		this.coordinates[1].setX(x1);
		this.coordinates[1].setY(y1);
		this.coordinates[2].setX(x2);
		this.coordinates[2].setY(y2);
		this.coordinates[3].setX(x3);
		this.coordinates[3].setY(y3);
	}

	public Quad(Vector2f[] coordinates) {
		if (coordinates.length == 4) {
			this.coordinates = coordinates;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public void update() {
		
	}

	public void addCoordinate(float x, float y) {
		if (coordinatesGiven < 4) {
			this.coordinates[this.coordinatesGiven] = new Vector2f(x, y);
			++coordinatesGiven;
		}
	}

	public void render(float x, float y) {

		// set the color of the quad (R,G,B,A)
		GL11.glColor3f(this.colorsRGB.getX(), this.colorsRGB.getY(), this.colorsRGB.getZ());

		// draw quad
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(this.coordinates[0].x + x, this.coordinates[0].y + y);
		GL11.glVertex2f(this.coordinates[1].x + x, this.coordinates[1].y + y);
		GL11.glVertex2f(this.coordinates[2].x + x, this.coordinates[2].y + y);
		GL11.glVertex2f(this.coordinates[3].x + x, this.coordinates[3].y + y);
		GL11.glEnd();
	}
}
*/