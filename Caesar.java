package caeserCipher;

public class Caesar implements Cipher {
	private String message = "";
	private int length;
	private int shift = 3;
	private int shiftTracker = 0;
	private boolean preserveCapitals = false;

	public Caesar() {
		// Do Nothing
	}

	public Caesar(String message) {
		if(!preserveCapitals)
			this.message = message.toUpperCase();
		else
			this.message = message;
		this.length = message.length();
	} // end Caesar constructor

	@Override
	public void encrypt() {
		String cipherText = "";
		for (int i = 0; i < length; i++) {
			char c = (char) (message.charAt(i));
			if (c > '@' && c < 'X')
				c = (char) (message.charAt(i) + shift);
			else if (c > '`' && c < 'x')
				c = (char) (message.charAt(i) + shift);
			else if (c == ' ')
				c = ' ';
			else if (c > 'W' && c < '[') // Needs to wrap around alphabet
				c = (char) (65 + ((message.charAt(i) - 65) + shift) % 26);
			else if (c > 'w' && c < '{')
				c = (char) (97 + ((message.charAt(i) - 97) + shift) % 26);
			cipherText += c;
		} // end for
		shiftTracker += shift;
		message = cipherText;
	} // end encrypt

	@Override
	public void decrypt() {
		//TODO: fix W 
		String plainText = "";
		for (int i = 0; i < length; i++) {
			char c = message.charAt(i);
			if (c > 'C' && c < '[')
				c = (char) (message.charAt(i) - shift);
			else if (c > 'c' && c < '{')
				c = (char) (message.charAt(i) - shift);
			else if (c > '@' && c < 'D') // Needs to wrap around alphabet
				c = (char) (65 + (26 + (message.charAt(i) - 65) - shift));
			else if (c > '`' && c < 'd')
				c = (char) (65 + (26 + (message.charAt(i) - 65) - shift));

			plainText += c;
		} // end for
		shiftTracker += shift;
		message = plainText;
	}// end decrypt

	@Override
	public void setMessage(String message) {
		if(!preserveCapitals)
			this.message = message.toUpperCase();
		else
			this.message = message;
		this.length = this.message.length();
	}// end setMessage

	@Override
	public String getMessage() {
		return this.message;
	}// end getPlainText

	public int getShiftTracker() {
		return this.shiftTracker;
	}// end getShiftTracker

	public boolean isPreserveCapitals() {
		return preserveCapitals;
	}// end isPreserveCapitals

	public void setPreserveCapitals(boolean preserveCapitals) {
		this.preserveCapitals = preserveCapitals;
	}// end setPreserveCapitals
	public void togglePreserveCapitals(){
		this.preserveCapitals = !this.preserveCapitals;
	}
}
