package languageTrainer;

import java.io.*;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static String file = "dictionary.txt";

    public static void readFromFile() {

        String line;
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
            while ((line = br.readLine()) != null) {

                String[] words = line.split(" ");
                String question = words[0];
                String solution = words[1];

                System.out.println(question);


                String answer = scanner.next().toLowerCase();

                while (!answer.equals(solution)) {
                    scanner.close();

                    System.out.println("bad answer, try again");
                    answer = scanner.next();
                }
                scanner.close();

                System.out.println("good answer");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveSingleLineToFile() {
        String newLine;
        try (FileWriter fw = new FileWriter(file, true); BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("\n");
            bw.write(scanner.nextLine());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveToFile() {
        boolean flag = true;


        while (flag) {
            System.out.println("Choose form options:\n" +
                    "0 -> quit\n" +
                    "1 -> add new ");

            String menu = scanner.nextLine();
            switch (menu) {
                case "0":
                    System.out.println("exit");
                    flag = false;
                    break;
                case "1":
                    System.out.println("Add word with schema: \n word translation");
                    saveSingleLineToFile();
                    break;
                default:
                    System.out.println("bad input");
                    break;
            }

        }
    }

    /*boolean flag = true;
            c
    int menu = scanner.nextInt();*/

    public static void main(String[] args) {
        //readFromFile();
        saveToFile();

    }
}
