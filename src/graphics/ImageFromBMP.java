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
		
		int bitmapFileHeader = 14;
		size = bytes[2];
		int whereStartsImage = bytes[10];

		int sizeOfDIBHeader = whereStartsImage - bitmapFileHeader;
		if (sizeOfDIBHeader != bytes[14]) {
			throw new IllegalArgumentException("BIPHeader not stored correctly");
		}
		int bitsPerPixel = 0;
		int compressionType = 0;
		if (sizeOfDIBHeader == 40) {

			this.width = bytes[18];
			this.height = bytes[22];
			bitsPerPixel = bytes[28];
			compressionType = bytes[30];
		} else {
			throw new IllegalArgumentException("Not the right BIP header, must be 40 (BITMAPINFOHEADER");
		}

		if (compressionType == 0) {
			if (bitsPerPixel == 24) {

				int[][] pictureBytes = new int[size - 54][3];

				System.out.println(size - 54);
				int padding = this.width % 4;
				for (int j = 0, k = 0; j < size - 54;) {
					pictureBytes[k][0] = bytes[j + 54];
					System.out.println(j + 54);
					++j;

					pictureBytes[k][1] = bytes[j + 54];
					++j;
					pictureBytes[k][2] = bytes[j + 54];
					++j;
					if (++k % this.width == 0 && k > 0) {
						j += padding;
					}

				}
				pixels = new Square[this.height][this.width];

				int l = 0;
				for (int j = this.height - 1; j >= 0; --j) {
					for (int k = 0; k < this.width; ++k) {

						float r;
						float g;
						float b;
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

						++l;
					}
				}

			} else {
				throw new IllegalArgumentException("BMP must have 24 bits/pixel for now. Other Values are currently not supported.");
			}

		} else {
			throw new IllegalArgumentException(
					"BMP can't be compressed for now. Another Compressiontype than 'no compression' (0) is currently not supported.");
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
