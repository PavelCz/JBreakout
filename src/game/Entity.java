package game;

import org.lwjgl.util.vector.Vector2f;

public abstract class Entity {
	protected RenderObject renderObject;
	protected Window gameWindow;
	protected Vector2f coordinates;

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
		this.renderObject.render();
	}

	public void update(int delta) {
		this.renderObject.setCoordinates(this.coordinates.getX(),
				this.coordinates.getY());
		this.renderObject.update();
	}

	public float getX() {
		return this.coordinates.getX();
	}

	public float getY() {
		return this.coordinates.getY();
	}

}
