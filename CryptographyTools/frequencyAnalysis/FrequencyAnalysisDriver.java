package frequencyAnalysis;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class FrequencyAnalysisDriver {

	public static void main(String[] args) {
		File file = new File("message.txt");
		String message = "";
		try {
			Scanner input = new Scanner(file);
			while(input.hasNextLine()){
			message += input.nextLine();
			}
			input.close();
		} catch (FileNotFoundException fnfe){
			System.out.println(fnfe);
		}
		FrequencyAnalysis helper = new FrequencyAnalysis(message);
		System.out.println(helper);

	}// end main

}//Eof
