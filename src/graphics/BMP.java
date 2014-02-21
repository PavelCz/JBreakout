package graphics;

import java.io.FileInputStream;
import java.io.IOException;

import org.lwjgl.util.vector.Vector3f;

public class BMP {
	Vector3f[][] pixels;

	public BMP(String path) throws IOException {
		FileInputStream file = new FileInputStream(path);
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
		int width = 0;
		int height = 0;
		int bitsPerPixel = 0;
		int compressionType = 0;
		if (sizeOfDIBHeader == 40) {

			width = bytes[18];
			height = bytes[22];
			bitsPerPixel = bytes[28];
			compressionType = bytes[30];
		} else {
			throw new IllegalArgumentException("Not the right BIP header, must be 40 (BITMAPINFOHEADER");
		}

		if (compressionType == 0) {
			if (bitsPerPixel == 24) {

				int[][] pictureBytes = new int[size - 54][3];

				System.out.println(size - 54);
				int padding = width % 4;
				for (int j = 0, k = 0; j < size - 54;) {
					pictureBytes[k][0] = bytes[j + 54];
					System.out.println(j + 54);
					++j;

					pictureBytes[k][1] = bytes[j + 54];
					++j;
					pictureBytes[k][2] = bytes[j + 54];
					++j;
					if (++k % width == 0 && k > 0) {
						j += padding;
					}

				}
				pixels = new Vector3f[height][width];

				int l = 0;
				for (int j = height - 1; j >= 0; --j) {
					for (int k = 0; k < width; ++k) {

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
						pixels[j][k] = new Vector3f(red, green, blue);

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
	}
	
	public Vector3f[][] getPixels () {
		return this.pixels;
	}

}
