package gui;

import graphics.Window;
import maths.MyVector2f;

public abstract class GUIElement {
	protected Window gameWindow;
	protected MyVector2f coordinates;
	
//	public GUIElement() {
//		this.coordinates = new MyVector2f();
//	}
	
	public abstract void render();
}
