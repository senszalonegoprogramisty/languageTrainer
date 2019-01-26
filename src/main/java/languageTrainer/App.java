package languageTrainer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        String file = "dictionary.txt";
        String line = null;
        String line2 = null;
        try {
            FileReader fr = new FileReader(file);
            FileReader fr2 = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            BufferedReader br2 = new BufferedReader(fr2);

            int count = 0;
            while ((line = br.readLine()) != null) {

                count++;
                System.out.println(line);
            }

            Random random = new Random();
            int bound = random.nextInt(count);
            System.out.println(bound);


            for (int i = 0; i <= bound; i++) {
                if ((line2 = br2.readLine()) != null && i == bound) {

                    System.out.println(line2);
                    String[] words = line2.split(" ");
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
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


//
//        String word = "door drzwi";
//
//        String[] words = word.split(" ");
//        String question = words[0];
//        String solution = words[1];
//        System.out.println(question);
//
//        Scanner scanner = new Scanner(System.in);
//
//        String answer = scanner.next().toLowerCase();
//
//        while (!answer.equals(solution)){
//            System.out.println("bad answer, try again");
//            answer = scanner.next();
//        }
//
//        System.out.println("good answer");


    }
}
