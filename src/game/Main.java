package game;

public class Main {

	public static void main(String[] argv) {

		/*
		MyVector2f m = new MyVector2f(100, 0);
		System.out.println(m.getLength());
		
		m.setAngleDegrees(90);
		
		System.out.println(m.getX());
		System.out.println(m.getY());*/
		Game game = new Game();
		game.init();
		game.start();
	}

}
