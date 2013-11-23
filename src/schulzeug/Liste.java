package schulzeug;


public class Liste {
	private Listenelement erster;
	public Liste() {
		this.erster = new Abschluss();
	}
	public void einfuegen(Datenelement element) {
		this.erster = new Knoten(erster, element);
	}
	public String toString() {
		return "{"+this.erster.toString();
	}
	
	public void render() {
	    this.erster.render(0);
	}
}
