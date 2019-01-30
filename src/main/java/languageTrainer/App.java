package languageTrainer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class App extends Application {
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

    public static void saveSingleLineToFile() {
        String newLine;
        try (FileWriter fw = new FileWriter(file, true); BufferedWriter bw = new BufferedWriter(fw)) {
            boolean flag = true;
            while (flag) {
                bw.write("\n");
                String words = scanner.nextLine();
                String[] dupa = words.split(" ");
                if (dupa.length > 1) {
                    System.out.println("slowko zapisane");
                    bw.write(words);
                    flag = false;
                } else {
                    System.out.println("wpisz conajmniej dwa slowa");
                }
            }
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

    public static void mainMenu() {
        boolean flag = true;
        while (flag) {
            System.out.println("0: exit");
            System.out.println("1: add words");
            System.out.println("2: start learning");
            String menu = scanner.nextLine();
            switch (menu) {
                case "0":
                    System.out.println("exiting program");
                    flag = false;
                    break;
                case "1":
                    saveToFile();
                    break;
                case "2":
                    readFromFile();
                    break;
            }
        }
    }


    public static void main(String[] args) {
        launch(args);
        // mainMenu();
    }

    Stage window;

    Button exitButton;
    Button addButton;
    Button learnButton;
    Button returnButton1;
    Button returnButton2;


    Scene menuScene;
    Scene addWordScene;
    Scene learnScene;



    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        primaryStage.setTitle("Language trainer");

        addButton = new Button();
        addButton.setText("Add word");
        addButton.setOnAction(e -> {
            window.setScene(addWordScene);
        });

        learnButton = new Button();
        learnButton.setText("Learn");
        learnButton.setOnAction(e -> {
            AlertBox.endOfWords("tytul", "wiadomosc");
            window.setScene(learnScene);
        });

        exitButton = new Button();
        exitButton.setText("Exit");
        exitButton.setOnAction(e -> {
            System.exit(0);
        });

        returnButton1 = new Button();
        returnButton1.setText("Return");
        returnButton1.setOnAction(e -> {
            window.setScene(menuScene);
        });

        returnButton2 = new Button();
        returnButton2.setText("Return");
        returnButton2.setOnAction(e -> {
            window.setScene(menuScene);
        });

        //layout menu
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(addButton, learnButton, exitButton);
        menuScene = new Scene(layout1, 400, 400);

        //layout dodawania
        Label label = new Label("dodawanie");
        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(label, returnButton1);
        addWordScene = new Scene(layout2, 400, 400);


        //layout uczenia
        Label labelNauka = new Label("Nauka");
        StackPane layout3 = new StackPane();
        layout3.getChildren().addAll(labelNauka, returnButton2);
        learnScene = new Scene(layout3, 400, 400);



        window.setScene(menuScene);
        primaryStage.show();
    }


}
