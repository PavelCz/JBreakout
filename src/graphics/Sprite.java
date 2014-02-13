package graphics;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class Sprite {
	private int width, height;
	
	public Sprite(String path) throws IOException {
		// from Javadoc
		// try (InputStream in = Files.newInputStream(file); BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
		// String line = null;
		// while ((line = reader.readLine()) != null) {
		// System.out.println(line);
		// }
		// } catch (IOException x) {
		// System.err.println(x);
		// }
		// }
		// "inspired" by lecture info1
		FileInputStream file = new FileInputStream(path);
		int size = file.available();
		int[] bytes = new int[size];
		System.out.println("size:" + size);
		int t;
		int i = 0;
		while (-1 != (t = file.read())) {
			bytes[i] = t;
			++i;
		}
		this.width = bytes[18];
		this.height = bytes[18];
		
		int[][]pictureBytes = new int[size-54][3];
		
		for(int j = 54, k = 0; j < size-2; ++j, ++k) {
			pictureBytes[k][0] = bytes[j];
			pictureBytes[k][1] = bytes[++j];
			pictureBytes[k][2] = bytes[++j];
		}
		
		System.out.println(bytes[22]);
		/*for (int j = 0; j < bytes.length; ++j) {
			System.out.println(bytes[j]);
		}
		System.out.print("\n");*/
	}
}
