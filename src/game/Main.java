package game;


public class Main {

	public static void main(String[] argv) {
		//Game game = new Game();
		//game.init();
		//game.start();
		
		MyVector2f m = new MyVector2f(10, -10);
		m.rotateDegrees(-10);
		System.out.println(m.getLength());
		System.out.println(m.getAngleDegrees());
		System.out.println(m.getAngleRadians());
	} 
}
