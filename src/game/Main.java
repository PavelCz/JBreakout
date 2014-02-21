package game;

import gui.Alphabet;


public class Main {

	public static void main(String[] argv) {

//		try {
//			Sprite s = new Sprite("D:/Users/pavel/git/JBreakout/src/data/jo2.bmp");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println((int)'A');
		Game game = new Game();
		game.init();
		game.start();
		
	}

}
