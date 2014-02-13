package graphics;

import maths.MyVector2f;

public class Score extends GUIElement {
	private int number;
	private float scale;
	private boolean leftAligned;

	public Score(int x, int y, int number, float scale) {
		this.leftAligned = true;
		this.number = number;
		this.scale = scale;
		this.coordinates = new MyVector2f(x, y);
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public void render() {
		if (this.leftAligned) {
			if (this.number > 999) {

			}
		}

	}

	public int getNumberNumerals() {
		if (this.number == 0) {
			return 1;
		} else {
			int numberBuffer = this.number;
			int i;
			for (i = 0; numberBuffer >= 1; ++i) {
				numberBuffer /= 10;
			}

			return i;
		}
	}

}
