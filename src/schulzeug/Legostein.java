package schulzeug;


public class Legostein extends Datenelement {
	private String color;
	public Legostein(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return this.color;
	}
	
	public String getColor() {
	    return this.color;
	}

}
