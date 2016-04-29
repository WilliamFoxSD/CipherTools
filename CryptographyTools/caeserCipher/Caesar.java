

package caeserCipher;


/**
 * A class that allows the user 
 * to encode or decode a message
 * with a Caesar Cipher
 * 
 * @author ruberVulpes
 */
public class Caesar implements Cipher {
	/** The message to be encoded/decoded */
	private String message = "Default Message";
	/** The length of the message to be encoded/decoded */
	private int length;
	/** The amount to shift the characters of the message */
	private int shift = 3;
	/** Flag used to signal whether or not to preserve capitalization */
	private boolean preserveCapitals = true;

	/**
	 * Does nothing
	 */
	public Caesar() {
		// Do Nothing
	}

	/**
	 * Constructor that sets message
	 * 
	 * @param message Message to encode/decode
	 */
	public Caesar(String message) {
		if (!preserveCapitals)
			this.message = message.toUpperCase();
		else
			this.message = message;
		this.length = message.length();
	} // end Caesar constructor

	/**
	 * Constructor that sets message and shift
	 * 
	 * @param message  Message to encode/decode
	 * @param shift	 Number to shift by
	 */
	public Caesar(String message, int shift) {
		setMessage(message);
		setShift(shift);
	} // end Caesar

	/**
	 * Constructor that sets message, shift, and isPreserveCapitals
	 * 
	 * @param message Message to encode/decode
	 * @param shift	Number to shift by
	 * @param isPreserveCapitals Flag to preserve capitalization
	 */
	public Caesar(String message, int shift, boolean isPreserveCapitals) {
		setMessage(message);
		setShift(shift);
		setPreserveCapitals(isPreserveCapitals);
	} // end Caesar

	@Override
	public void encrypt() {
		String cipherText = "";
		for (int i = 0; i < length; i++) {
			char c = (char) (message.charAt(i));
			if (c > '@' && c < '[' - shift)
				c = (char) (message.charAt(i) + shift);
			else if (c > '`' && c < '{' - shift)
				c = (char) (message.charAt(i) + shift);
			else if (c == ' ')
				c = ' ';
			else if (c >= '[' - shift && c < '[') // Needs to wrap around
													// alphabet
				c = (char) (65 + ((message.charAt(i) - 65) + shift) % 26);
			else if (c >= '{' - shift && c < '{')
				c = (char) (97 + ((message.charAt(i) - 97) + shift) % 26);
			cipherText += c;
		} // end for
		message = cipherText;
	} // end encrypt

	@Override
	public void decrypt() {
		String plainText = "";
		for (int i = 0; i < length; i++) {
			char c = message.charAt(i);
			if (c > '@' + shift && c < '[')
				c = (char) (message.charAt(i) - shift);
			else if (c > '`' + shift && c < '{')
				c = (char) (message.charAt(i) - shift);
			else if (c > '@' && c <= '@' + shift) // Needs to wrap around
													// alphabet
				c = (char) (65 + (26 + (message.charAt(i) - 65) - shift));
			else if (c > '`' && c <= '`' + shift)
				c = (char) (65 + (26 + (message.charAt(i) - 65) - shift));

			plainText += c;
		} // end for
		message = plainText;
	}// end decrypt

	@Override
	public void setMessage(String message) {
		if (!preserveCapitals)
			this.message = message.toUpperCase();
		else
			this.message = message;
		this.length = this.message.length();
	}// end setMessage

	@Override
	public String getMessage() {
		return this.message;
	}// end getPlainText

	public boolean isPreserveCapitals() {
		return preserveCapitals;
	}// end isPreserveCapitals

	public void setPreserveCapitals(boolean preserveCapitals) {
		this.preserveCapitals = preserveCapitals;
	}// end setPreserveCapitals

	public void togglePreserveCapitals() {
		this.preserveCapitals = !this.preserveCapitals;
	}// end togglePreserveCapitals

	
	/**
	 * Sets the shift field
	 * 
	 * @param shift Number to shift by
	 */
	public void setShift(int shift) {
		this.shift = shift % 26;
	}// end setShift

	/**
	 * Returns the shift to be used
	 * 
	 * @return shift 
	 */
	public int getShift() {
		return this.shift;
	}// end getShift
}// EOF
