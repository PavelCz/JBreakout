package game;

public class Main {

	public static void main(String[] argv) {
		MyVector2f m = new MyVector2f(10, 10);
		m.setAngleDegrees(55);
		System.out.println(m.getLength());
		System.out.println(m.getAngleDegrees());
		System.out.println(m.getAngleRadians());

		Game game = new Game();
		game.init();
		game.start();

	}
}
