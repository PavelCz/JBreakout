package gui;

import graphics.Window;
import maths.MyVector2f;

public abstract class GUIElement {
	protected Window gameWindow;
	protected MyVector2f coordinates;
	
	public GUIElement(float x, float y) {
		this.coordinates = new MyVector2f(x, y);
	}
	
	public abstract void render();
}
