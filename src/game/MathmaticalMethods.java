package game;

public class MathmaticalMethods {
	public static boolean isPointInsideRectangle(float x, float y,
			float rectangleX, float rectangleY, float width, float height) {
		return (x >= rectangleX && x <= rectangleX + width && y >= rectangleY && y <= rectangleY
				+ height);
	}
}
