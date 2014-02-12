package control;


public class Controls1D extends Controls {
	private int moveLeftKey;
	private int moveRightKey;

	public Controls1D(int moveLeftKey, int moveRightKey) {
		super();
		this.moveLeftKey = moveLeftKey;
		this.moveRightKey = moveRightKey;
	}
	
	public int getMoveLeft() {
		return moveLeftKey;
	}
	
	public int getMoveRight() {
		return moveRightKey;
	}
	
}
