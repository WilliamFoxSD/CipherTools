package frequencyAnalysis;

public class FrequencyAnalysis {
	private String message = null;
	private int[] letterCount = new int[26];
	private float[] percentages = new float[26];

	public FrequencyAnalysis() {
		this.message = "";
	}// end FrequencyAnalysis()

	public FrequencyAnalysis(String message) {
		this.message = message.toUpperCase();
		countLetters();
	}// end FrequencyAnalysis(String message)

	public String toString() {
		String temp = "";

		for (int i = 0; i < letterCount.length; i++) {
			temp += (char) (65 + i) + ":" + letterCount[i] + "  ";
			if (i % 13 == 12)
				temp += "\n";
		} // end for
		temp += "\n";
		percentages();
		for (int i = 0; i < percentages.length; i++) {
			temp += (char) (65 + i) + ":" + (percentages[i] * 100) + "%  ";
			if (i % 13 == 12)
				temp += "\n";
		}
		return temp;
	}// end toString

	public String getMessage() {
		return message;
	}// end getMessage

	public int getMessageLength() {
		return message.length();
	}// end getMessageLength

	public int length() {
		return message.length();
	}// end length

	public void setMessage(String message) {
		this.message = message.toUpperCase();
		countLetters();
	}// end setMessage

	private void countLetters() {
		for (int i = 0; i < message.length(); i++) {
			letterCount[message.charAt(i) % 65]++;
		} // end for
	}// end countLetters

	private void percentages() {
		for (int i = 0; i < percentages.length; i++) {
			percentages[i] = (float) (Math
					.floor((double) (((float) letterCount[i] / message.length())
							* 1000))
					/ 1000f);
		} // end for

	}// end percentages

}// EOF
