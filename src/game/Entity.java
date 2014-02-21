package game;

import graphics.BasicRenderObject;
import graphics.Window;
import maths.MyVector2f;

public abstract class Entity {
	protected BasicRenderObject renderObject;
	protected Window gameWindow;
	protected MyVector2f coordinates;

	public Entity(Window gameWindow) {
		this.gameWindow = gameWindow;
	}

	public BasicRenderObject getRenderObject() {
		return renderObject;
	}

	public void setRenderObject(BasicRenderObject renderObject) {
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
