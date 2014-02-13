package graphics;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class Sprite {
	public Sprite(String path) throws IOException {

		// try (InputStream in = Files.newInputStream(file); BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
		// String line = null;
		// while ((line = reader.readLine()) != null) {
		// System.out.println(line);
		// }
		// } catch (IOException x) {
		// System.err.println(x);
		// }
		// }

		FileInputStream file = new FileInputStream(path);
		int t;
		while (-1 != (t = file.read()))
			System.out.print((char) t);
		System.out.print("\n");
	}
}
