package game;

import java.io.IOException;

import graphics.Score;
import graphics.Sprite;

public class Main {

	public static void main(String[] argv) {

//		try {
//			Sprite s = new Sprite("D:/Users/pavel/git/JBreakout/src/data/jo2.bmp");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Game game = new Game();
		game.init();
		game.start();
		
	}

}
