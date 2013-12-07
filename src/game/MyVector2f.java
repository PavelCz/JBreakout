package game;

import org.lwjgl.util.vector.Vector2f;

/**
 * @author pavel.czempin
 *
 */
/**
 * @author pavel.czempin
 *
 */
public class MyVector2f {
	private Vector2f vector;
	private float angleRadians;
	private float length;

	public MyVector2f(float x, float y) {
		this.vector = new Vector2f(x, y);
		this.angleRadians = calculateAngle(x, y); // atan ist tan^-1
		this.length = (float) (Math.sqrt(x * x + y * y));

		this.angleRadians = normalizeAngle(this.angleRadians);
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

	public float getLength() {
		return this.length;
	}
	
	public void setLength(float length) {
		this.length = length;
		this.updateCoordinatesByLengthAndAngle();
	}

	public float getAngleRadians() {
		return this.angleRadians;
	}

	public float getAngleDegrees() {
		return this.calculateDegrees(this.angleRadians);
	}

	public void rotateRadians(float angle) {
		this.angleRadians += angle;

		this.angleRadians = normalizeAngle(this.angleRadians);
		this.updateCoordinatesByLengthAndAngle();

	}

	public void rotateDegrees(float angle) {
		this.angleRadians += this.calculateRadians(angle);
		this.angleRadians = normalizeAngle(this.angleRadians);
		this.updateCoordinatesByLengthAndAngle();

	}

	public void setAngleDegrees(float angle) {
		this.angleRadians = this.calculateRadians(angle);
		this.angleRadians = normalizeAngle(this.angleRadians);
		this.updateCoordinatesByLengthAndAngle();

	}

	public void setAngleRadians(float angle) {
		this.angleRadians = angle;
		this.angleRadians = normalizeAngle(this.angleRadians);
		this.updateCoordinatesByLengthAndAngle();

	}
	
	/**
	 * Updates the Coordinates using the current length and angle
	 */
	private void updateCoordinatesByLengthAndAngle() {
		this.setX((float) (this.length * Math.cos(this.angleRadians)));
		this.setY((float) (this.length * Math.sin(this.angleRadians)));
	}

	/**
	 * Takes an angle in Radians and returns the Angle in Degrees
	 * @param angleRadians
	 * @return the same Angle in degrees
	 */
	private float calculateDegrees(float angleRadians) {
		return (float) (angleRadians * 57.2957795);
	}

	private float calculateRadians(float angleDegrees) {
		return (float) (angleDegrees / 57.2957795);
	}

	public static float normalizeAngle(float angle) {
		if (angle > Math.PI * 2) {
			return normalizeAngle((float) (angle - Math.PI * 2));
		} else if (angle < 0) {
			return normalizeAngle((float) (angle + Math.PI * 2));
		} else {
			return angle;
		}
	}

	public static float calculateAngle(float x, float y) {
		float result = (float) Math.atan(y / x);
		if (x >= 0) {
			return result;
		} else {
			return (float) (result - Math.PI);
		}
	}
}
