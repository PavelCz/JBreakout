package graphics;

public class PixelNumeral extends AdvancedRenderObject {
	private Square[][] pixels;
	private float scale;
	private Square sqre;

	public PixelNumeral(int number, float scale) {
		this.pixels = new Square[5][4];
		this.scale = scale;
		this.sqre = new Square((int) this.scale);
		if (number == 0) {
			this.pixels[0] = new Square[] { null, sqre, sqre, null };
			this.pixels[1] = new Square[] { sqre, null, null, sqre };
			this.pixels[2] = new Square[] { sqre, null, null, sqre };
			this.pixels[3] = new Square[] { sqre, null, null, sqre };
			this.pixels[4] = new Square[] { null, sqre, sqre, null };
		} else if (number == 1) {
			this.pixels[0] = new Square[] { null, null, sqre, sqre };
			this.pixels[1] = new Square[] { null, sqre, null, sqre };
			this.pixels[2] = new Square[] { null, null, null, sqre };
			this.pixels[3] = new Square[] { null, null, null, sqre };
			this.pixels[4] = new Square[] { null, null, null, sqre };
		} else if (number == 2) {
			this.pixels[0] = new Square[] { null, sqre, sqre, null };
			this.pixels[1] = new Square[] { sqre, null, null, sqre };
			this.pixels[2] = new Square[] { null, null, sqre, null };
			this.pixels[3] = new Square[] { null, sqre, null, null };
			this.pixels[4] = new Square[] { sqre, sqre, sqre, sqre };
		} else if (number == 3) {
			this.pixels[0] = new Square[] { null, sqre, sqre, null };
			this.pixels[1] = new Square[] { sqre, null, null, sqre };
			this.pixels[2] = new Square[] { null, null, sqre, sqre };
			this.pixels[3] = new Square[] { sqre, null, null, sqre };
			this.pixels[4] = new Square[] { null, sqre, sqre, null };
		} else if (number == 4) {
			this.pixels[0] = new Square[] { null, null, sqre, null };
			this.pixels[1] = new Square[] { null, sqre, null, null };
			this.pixels[2] = new Square[] { sqre, sqre, sqre, sqre };
			this.pixels[3] = new Square[] { null, null, sqre, null };
			this.pixels[4] = new Square[] { null, null, sqre, null };
		} else if (number == 5) {
			this.pixels[0] = new Square[] { sqre, sqre, sqre, sqre };
			this.pixels[1] = new Square[] { sqre, null, null, null };
			this.pixels[2] = new Square[] { sqre, sqre, sqre, null };
			this.pixels[3] = new Square[] { null, null, null, sqre };
			this.pixels[4] = new Square[] { sqre, sqre, sqre, null };
		} else if (number == 6) {
			this.pixels[0] = new Square[] { null, sqre, sqre, sqre };
			this.pixels[1] = new Square[] { sqre, null, null, null };
			this.pixels[2] = new Square[] { sqre, sqre, sqre, null };
			this.pixels[3] = new Square[] { sqre, null, null, sqre };
			this.pixels[4] = new Square[] { sqre, sqre, sqre, sqre };
		} else if (number == 7) {
			this.pixels[0] = new Square[] { sqre, sqre, sqre, sqre };
			this.pixels[1] = new Square[] { null, null, null, sqre };
			this.pixels[2] = new Square[] { sqre, sqre, sqre, sqre };
			this.pixels[3] = new Square[] { null, sqre, null, null };
			this.pixels[4] = new Square[] { sqre, null, null, null };
		} else if (number == 8) {
			this.pixels[0] = new Square[] { null, sqre, sqre, null };
			this.pixels[1] = new Square[] { sqre, null, null, sqre };
			this.pixels[2] = new Square[] { null, sqre, sqre, null };
			this.pixels[3] = new Square[] { sqre, null, null, sqre };
			this.pixels[4] = new Square[] { null, sqre, sqre, null };
		} else if (number == 9) {
			this.pixels[0] = new Square[] { sqre, sqre, sqre, sqre };
			this.pixels[1] = new Square[] { sqre, null, null, sqre };
			this.pixels[2] = new Square[] { sqre, sqre, sqre, sqre };
			this.pixels[3] = new Square[] { null, null, null, sqre };
			this.pixels[4] = new Square[] { sqre, sqre, sqre, sqre };
		} else {

			throw new IllegalArgumentException("PixelNumeral only takes numerals");
		}

	}

	@Override
	public void render(float x, float y) {
		Square currentSquare;
		for (int j = 0; j < this.pixels.length; ++j) {
			for (int i = 0; i < this.pixels[0].length; ++i) {
				currentSquare = this.pixels[j][i];
				if (currentSquare != null) {
					currentSquare.render((int) x + i * this.scale, (int) y + j * this.scale);
				}
			}
		}

	}

}
