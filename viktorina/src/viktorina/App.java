package viktorina;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\FoxMulder\\Desktop\\JAVA_PROJECTS\\viktorina\\facts");

		// writeToFile(file);

		String[] fileRead = readFromFile(file);
		
		HashMap<String, ArrayList<String>> facts = new HashMap<>();
		
		Random random = new Random();
		
		int iterator = 0;
		ArrayList<String> data = new ArrayList<>();
		for(String check : fileRead) {
			if(iterator < 3) {
				data.add(check);
				facts.put("Emo", data);
			} else if(iterator < 6) {
				data.add(check);
				facts.put("Momchi", data);
			} else {
				data.add(check);
				facts.put("Abokata", data);
			}
			iterator++;
		}
		
		System.out.println();
		
		int randomFact = random.nextInt(9);
		
		String answer = "";
		
		if(randomFact < 3) {
			ArrayList<String> output = facts.get("Emo");
			String fact = output.get(randomFact);
			answer = "Emo";
			System.out.println(fact);
		} else if(randomFact < 6) {
			ArrayList<String> output = facts.get("Momchi");
			String fact = output.get(randomFact);
			answer = "Momchi";
			System.out.println(fact);
		} else {
			ArrayList<String> output = facts.get("Abokata");
			String fact = output.get(randomFact);
			answer = "Abokata";
			System.out.println(fact);
		}
		
		Scanner s = new Scanner(System.in);
		
		String name = s.nextLine();
		
		if(name.equalsIgnoreCase(answer))
			System.out.println("You win!");
		else
			System.out.println("You lose!");
		s.close();
	}

	public static boolean writeToFile(File file) throws IOException {
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			fw.write("");
			return true;
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			fw.close();
		}
		return false;
	}

	public static String[] readFromFile(File file) throws IOException {
		BufferedReader fr = null;
		try {
			fr = new BufferedReader(new FileReader(file));
			String data = "";
			while (fr.ready()) {
				data = fr.readLine();
			}
			String[] wordsAndDef = data.split(" \\| ");
			return wordsAndDef;
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			fr.close();
		}
		return null;
	}

}
