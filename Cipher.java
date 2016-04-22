package caeserCipher;

public interface Cipher {
	
	public void setMessage(String message);
	
	public String getMessage();
	
	public void encrypt();
	
	public void decrypt();
	
	public boolean isPreserveCapitals();
	
	public void setPreserveCapitals(boolean preserveCapitals);

}
