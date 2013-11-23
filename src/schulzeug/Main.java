package schulzeug;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Liste liste = new Liste();
		liste.einfuegen(new Legostein("blau"));
		liste.einfuegen(new Legostein("blau"));
		Legoturm l = new Legoturm() ;
		l.init();
		l.start();
	}

}
