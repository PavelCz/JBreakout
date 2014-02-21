package gui;

public class Alphabet {

	private char[] letters;

	public Alphabet() {
		this.letters = new char[26];
		for (int i = (int) 'A'; i < (int) 'A' + 26; ++i) {
			this.letters[i - (int) 'A'] = (char) i;
		}
	}

	public char getLetter(int i) {
		return this.letters[i];
	}

	// old enum stuff
	/*
	 * A((int) 'A'), B((int) 'B'), C((int) 'C'), D((int) 'D'), E((int) 'E'), F((int) 'F'), G((int) 'G'), H((int) 'H'), I((int) 'I'), J(
	 * (int) 'J'), K((int) 'K'), L((int) 'A'), M((int) 'A'), N((int) 'A'), O((int) 'A'), P((int) 'A'), Q((int) 'A'), R((int) 'A'), S(
	 * (int) 'A'), T((int) 'A'), U((int) 'A'), V((int) 'A'), W((int) 'A'), X((int) 'A'), Y((int) 'A'), Z((int) 'A'); private int
	 * characterNumber;
	 * 
	 * private Alphabet(int characterNumber) { this.characterNumber = characterNumber; }
	 * 
	 * p
	 */

}
