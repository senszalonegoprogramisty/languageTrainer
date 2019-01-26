package languageTrainer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        String file = "dictionary.txt";
        String line;
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
            while ((line = br.readLine()) != null) {

                String[] words = line.split(" ");
                String question = words[0];
                String solution = words[1];

                System.out.println(question);

                Scanner scanner = new Scanner(System.in);

                String answer = scanner.next().toLowerCase();

                while (!answer.equals(solution)) {
                    System.out.println("bad answer, try again");
                    answer = scanner.next();
                }

                System.out.println("good answer");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
