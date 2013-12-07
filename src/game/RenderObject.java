package game;

import org.lwjgl.util.vector.Vector2f;

public abstract class RenderObject {
	//protected Vector2f coordinates;
	
	public abstract void update();

	public abstract void render(float x, float y);
	
	public abstract void setColor(float r, float g, float b);

	/*public void setCoordinates(float x, float y) {
		this.coordinates.setX(x);
		this.coordinates.setY(y);
	}

	public void setX(float x) {
		this.coordinates.setX(x);
	}

	public void setY(float y) {
		this.coordinates.setY(y);
	}*/
	
	
}
