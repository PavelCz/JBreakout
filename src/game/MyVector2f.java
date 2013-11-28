package game;

import org.lwjgl.util.vector.Vector2f;

public class MyVector2f {
    private Vector2f vector;
    
    public MyVector2f(float x, float y) {
	this.vector = new Vector2f(x, y);
    }
    
    
    public float getX() {
	return vector.getX();
    }
    public float getY() {
	return vector.getY();
    }
    public void setX(float x) {
	vector.setX(x);
    }
    public void setY(float y) {
	vector.setY(y);
    }
    
}
