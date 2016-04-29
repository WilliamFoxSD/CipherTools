/**
 * 
 * A basic interface for ciphers
 * @author William Fox
 */

package caeserCipher;

public interface Cipher {

	/**
	 * Sets the message to be encoded or decoded
	 * 
	 * @param message Message to be encoded/decoded
	 */
	public void setMessage(String message);

	/**
	 * Returns the message that was encoded or decoded
	 * 
	 * @return message
	 */
	public String getMessage();

	/**
	 * Encrypts the message
	 */
	public void encrypt();

	/**
	 * Decrypts the message
	 */
	public void decrypt();

	/**
	 * Returns the state of whether or not to preserve the capitalizations
	 * 
	 * @return isPreserveCapitals
	 */
	public boolean isPreserveCapitals();

	/**
	 * Sets the isPreserveCapitals flag
	 * 
	 * @param preserveCapitals Flag to preserve capitalization
	 */
	public void setPreserveCapitals(boolean preserveCapitals);
	
	/**
	 * Toggles the isPreserveCapitals flag
	 */
	public void togglePreserveCapitals();
}// Eof
