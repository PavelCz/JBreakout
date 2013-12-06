package game;

public class Main {

	public static void main(String[] argv) {
		MyVector2f m = new MyVector2f(10, 10);
		m.setAngleDegrees(55);
		System.out.println(m.getLength());
		m.setLength(m.getLength() + 5);
		System.out.println(m.getLength());

		Game game = new Game();
		game.init();
		game.start();

	}

}
