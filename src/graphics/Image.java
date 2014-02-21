package graphics;

import java.io.FileInputStream;
import java.io.IOException;

import org.lwjgl.util.vector.Vector3f;

public class Image extends AdvancedRenderObject {
	private int width, height;
	private float scale;
	Square[][] pixels;

	public Image(Vector3f[][] pixels, float scale){
		
		this.scale = scale;
		this.height = pixels.length;
		this.width = pixels[0].length;
		this.pixels = new Square[height][width];
		for(int i = 0; i < height; ++i) {
			for(int j = 0; j < width; ++j) {
				this.pixels[i][j] = new Square(scale, pixels[i][j].x,pixels[i][j].y,pixels[i][j].z );
				
			}
		}
	}

	public void render(float x, float y) {
		for (int j = 0; j < this.height; ++j) {
			for (int i = 0; i < this.width; ++i) {
				this.pixels[j][i].render(x + i * scale, y + j * scale);

			}
		}
	}
}
