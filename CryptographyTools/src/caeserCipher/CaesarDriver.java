package caeserCipher;

public class CaesarDriver {

	public static void main(String args[]) {

		Caesar password = new Caesar("abcdefghijklmnopqrstuvwxyz");

		password.encrypt();
		System.out.println(password.getMessage());
		password.decrypt();
		System.out.println(password.getMessage());

	}//end main

}//EOF
