package gui;

import graphics.PixelNumeral;

public class Score extends GUIElement {
	private int number;
	private float scale;
	private boolean leftAligned;

	public Score(int x, int y, int number, boolean leftAligned, float scale) {
		super(x,y);
		this.leftAligned = leftAligned;
		this.number = number;
		this.scale = scale;
	}

	public void setScore(int number) {
		this.number = number;
	}

	@Override
	public void render() {
		PixelNumeral pixelNumber;
		int numberBuffer = this.number;
		int numberNumerals = this.getNumberNumerals();

		float x = this.coordinates.getX();
		float y = this.coordinates.getY();
		if (this.leftAligned) {
			int logNumber = 1;
			for (int i = 1; i < numberNumerals; ++i) {
				logNumber *= 10;
			}
			for (int i = 0; i < numberNumerals; ++i) {
				pixelNumber = new PixelNumeral(numberBuffer / (logNumber), this.scale);
				// every PixelNumber is 4 pixels wide and is scaled. With i * 5 * scale there is a gap of 1 Pixel between each numeral
				// of a number
				pixelNumber.render(x + i * 5 * this.scale, y);
				
				numberBuffer %= logNumber;
				logNumber /= 10;
			}
		} else {
			for (int i = 0; i < numberNumerals; ++i) {
				pixelNumber = new PixelNumeral(numberBuffer%10, this.scale);
				if(i == 0) {
				pixelNumber.render(x - this.scale * 4 * (i+1), y);
				} else {
					pixelNumber.render(x - this.scale * 5 * (i+1), y);
				}
				numberBuffer /=10;
			
			}
		}

	}

	private int getNumberNumerals() {
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

	public void setLeftALigned(boolean leftAligned) {
		this.leftAligned = leftAligned;
	}

}
