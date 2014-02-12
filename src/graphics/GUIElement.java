package graphics;

import maths.MyVector2f;

public abstract class GUIElement {
	protected Window gameWindow;
	protected MyVector2f coordinates;
	
	public abstract void render(float x, float y);
}
