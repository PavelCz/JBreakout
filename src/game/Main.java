package game;

public class Main {

	public static void main(String[] argv) {

		
		/*MyVector2f m = new MyVector2f(100, 0);
		MyVector2f m2 = m.clone();
		
		m2.setAngleDegrees(180);
		
		System.out.println(m.getX());
		System.out.println(m2.getX());*/
		
		Game game = new Game();
		game.init();
		game.start();
		
	}

}
