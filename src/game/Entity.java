package game;

import graphics.RenderObject;
import graphics.Window;
import maths.MyVector2f;

import org.lwjgl.util.vector.Vector2f;

public abstract class Entity {
	protected RenderObject renderObject;
	protected Window gameWindow;
	protected MyVector2f coordinates;

	public Entity(Window gameWindow) {
		this.gameWindow = gameWindow;
	}

	public RenderObject getRenderObject() {
		return renderObject;
	}

	public void setRenderObject(RenderObject renderObject) {
		this.renderObject = renderObject;
	}

	public void render() {
		this.renderObject.render(this.coordinates.getX(),
				this.coordinates.getY());
	}

	//public abstract void update(int delta);

	public float getX() {
		return this.coordinates.getX();
	}

	public float getY() {
		return this.coordinates.getY();
	}

}
