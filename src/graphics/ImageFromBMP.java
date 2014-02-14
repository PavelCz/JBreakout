package graphics;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageFromBMP extends AdvancedRenderObject {
	private int width, height;
	private float scale;
	Square[][] pixels;

	public ImageFromBMP(String path, float scale) throws IOException {

		// "inspired" by lecture info1
		FileInputStream file = new FileInputStream(path);
		this.scale = scale;
		int size = file.available();
		int[] bytes = new int[size];
		System.out.println("size:" + size);
		int t;
		int i = 0;
		// file.read(bytes);
		while (-1 != (t = file.read())) {
			bytes[i] = t;
			++i;
		}
		file.close();
		int numberColorsUsed = bytes[46];
		size = bytes[2];
		int bitsPerPixel = bytes[28];
		int compressionType = bytes[30];
		int whereStartsImage = bytes[10];
		int sizeOfDIBHeader = bytes[14];
		System.out.println(sizeOfDIBHeader);
		System.out.println(bytes[33]);
		System.out.println((char) bytes[0] + "" + (char) bytes[1]);
		System.out.println(bytes[1]);
		System.out.println(bytes[0] + bytes[1]);

		if (compressionType == 0) {
			if (bitsPerPixel == 24) {
				if (sizeOfDIBHeader == 40) {
					this.width = bytes[18];
					this.height = bytes[18];
					// System.out.println(bitsPerPixel);
					// System.out.println(whereStartsImage);
					// System.out.println(sizeOfTheFile);
					// System.out.println("Colors: " + numberColorsUsed);

					int[][] pictureBytes = new int[size - 54][3];

					System.out.println(size - 54);
					for (int j = 54, k = 0; j < size; j += 2, ++k) {
						System.out.println("K:" + k);
						pictureBytes[k][0] = bytes[j];
						System.out.println(j);
						pictureBytes[k][1] = bytes[++j];
						System.out.println(j);
						pictureBytes[k][2] = bytes[++j];
						System.out.println(j);
					}
					System.out.println("+++" + pictureBytes[19][0]);
					System.out.println("+++" + pictureBytes[19][1]);
					System.out.println("+++" + pictureBytes[19][2]);
					pixels = new Square[this.height][this.width];
					int[][] pixels2 = new int[this.height][this.width];

					int l = 0;
					for (int j = this.height - 1; j >= 0; --j) {
						for (int k = 0; k < this.width; ++k) {

							int r;
							int g;
							int b;
							float red;
							float green;
							float blue;
							b = pictureBytes[l][0];
							g = pictureBytes[l][1];
							r = pictureBytes[l][2];
							red = r / 255;
							green = g / 255;
							blue = b / 255;
							pixels[j][k] = new Square(scale, red, green, blue);
							pixels2[j][k] = g;

							++l;
						}
					}

					for (int[] js : pixels2) {
						for (int j : js) {
							// System.out.println(j);
						}
					}
				} else {
					throw new IllegalArgumentException("Not the right BIP header, must be 40 (BITMAPINFOHEADER");
				}
			} else {
				throw new IllegalArgumentException("BMP must have 24 bits/pixel for now. Other Values are currently not supported.");
			}

		} else {
			throw new IllegalArgumentException(
					"BMP can't be compressed for now. Another Compressiontype than 'no compression' is currently not supported.");
		}

		// System.out.println(bytes[22]);
		/*
		 * for (int j = 0; j < bytes.length; ++j) { System.out.println(bytes[j]); } System.out.print("\n");
		 */
	}

	public void render(float x, float y) {
		for (int j = 0; j < this.height; ++j) {
			for (int i = 0; i < this.height; ++i) {
				this.pixels[j][i].render(x + i * scale, y + j * scale);

			}
		}
	}
}
