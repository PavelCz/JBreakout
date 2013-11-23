package schulzeug;

import game.Rectangle;

public class Knoten extends Listenelement {
	private Datenelement inhalt;
	private Listenelement next;
	public Knoten(Listenelement next, Datenelement inhalt) {
		this.next = next;
		this.inhalt = inhalt;
		
	}
	@Override
	public String toString() {

		return "["+this.inhalt.toString() +"]"+ this.next.toString();
	}
	
	public void render(int step) {
	    Rectangle r = new Rectangle(300, step * 100, 100, 50, this.inhalt.getColor());
	    r.render();
	    this.next.render(step + 1);
	}

}
