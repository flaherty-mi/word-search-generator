// Meghan Flaherty
// CS145
// Manager

//  package searchGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.PrintStream;
import java.sql.Array;
import java.io.FileReader;

public class searchManager extends generatorMain{
    

    public searchManager(char[][] wordGrid, ArrayList<String> line) {
        menu(wordGrid, line);
    }

    public void choice(char[][] wordGrid,ArrayList<String> line )  {
        Scanner input = new Scanner(System.in);
        String choice = input.next();
    
        switch (choice.toLowerCase()) {

        case "g": 
            inputOrText(wordGrid, line);
        return;
    
        case "p":
            printIt(wordGrid, line);
        return;
        case "s":
            Solution(wordGrid, line);
        return;
        case "q":
            System.exit(0);
        return;

        }
    } // end choice

    public void inputOrText(char[][] wordGrid, ArrayList<String> line) {

        System.out.println("do you want to input words for a word search, or upload a text file? ");
        System.out.println("type");
        System.out.println("[i] to input your own words");
        System.out.println("[t] for a text file");
    
            Scanner in = new Scanner(System.in);
            String whichOne = in.next();

            switch (whichOne.toLowerCase()) {
                case "t":
                       createFile(wordGrid, line);
                    return;
                case "i":
                       createInput(wordGrid, line);
                    return;
            }
    }  // end inputOrText

    public void createFile(char[][] wordGrid, ArrayList<String> line)  {
        Scanner input = new Scanner(System.in);
        System.out.print("please enter an input file: ");
        String name;
        name = input.next();
        File in = new File(name);
        System.out.print("please enter an output file: ");
        String outname = input.next();
        File complete = new File(outname);
        try {
            PrintStream output = new PrintStream(complete);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
           Scanner one = new Scanner(System.in);
        try {
            one = new Scanner(in);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           
           while (one.hasNextLine()) {
            String word = one.nextLine();
            word = one.nextLine();
            line.add(word);
           }

        System.out.println();
        System.out.println(line);
        System.out.println();

        System.out.println("if you would like to re-enter your words please type [r]");
        System.out.println("if no changes are needed please type [n]");
        String pick = one.next();
        switch(pick.toLowerCase()) {
            case "r":
                line.removeAll(line);
                createFile(wordGrid, line);
            return;
            case "n":
                System.out.println("word search creation comeplete!");
                System.out.println("if you would like to print your word search or see the " + 
                "solution, choose from menu ");
                System.out.println();
        }
        menuTwo(wordGrid, line);
        
    } // end createFile

    public void createInput(char[][] wordGrid, ArrayList<String> line) {
        // if prompted again -> clear que for input
        line.removeAll(line);

        // scanner + choose # of words to input
        Scanner in = new Scanner(System.in);
        System.out.println("How many words do you want to use?");
        System.out.println("maximum: 7");
        int wordNum = in.nextInt();
        
        String word;
        System.out.println("please enter words as prompted");
            for (int i = 1; i < wordNum + 1; i++) {
                System.out.print(i + ": ");
                word = in.next();
                word = word.toUpperCase();
                line.add(word);
            }
        System.out.println();
        System.out.println("These are your words:");

        System.out.println();
        System.out.println(line);
        System.out.println();

        System.out.println("if you would like to re-enter your words please type [r]");
        System.out.println("if no changes are needed please type [n]");
        String pick = in.next();
        switch(pick.toLowerCase()) {
            case "r":
                line.removeAll(line);
                createInput(wordGrid, line);
            return;
            case "n":
                System.out.println("word search creation comeplete");
                System.out.println("if you would like to print your word search or see the " + 
                "solution, choose from menu ");
                System.out.println();
        }
        menuTwo(wordGrid, line);
    } // end createInput


    public void printIt(char[][] wordGrid, ArrayList<String> line)  {
        // should include randomizer for char letters outside arraylist
        
        for (int i = 0; i < wordGrid.length; i++) {
            for (int j = 0; j < wordGrid[i].length; j++) {
                String letters = "ABCDEFGHIJKLMNOP";
                Random r = new Random();
                char c = letters.charAt(r.nextInt(letters.length()));
                System.out.print(c);

                if (j == 29) {
                System.out.println(c);
                } 
            }  
        }
        menuTwo(wordGrid, line);
    } // end printIt

    public void Solution(char[][] wordGrid, ArrayList<String> line) { 
       for(int x = 0; x < line.size(); x++) {
         //for(int y = 0; y < line; )
       }

        for (int i = 0; i < wordGrid.length; i++) { 
            for (int j = 0; j < wordGrid[i].length; j++) {
                System.out.print('X');

                if (j == 29) {
                System.out.println('X');
                }
            }  
        }
        menuTwo(wordGrid, line);
    } // end Solution

    public void menu(char[][] wordGrid, ArrayList<String> line)  {
        System.out.println("welcome to the word search game!");
        System.out.println("select from options below");
        System.out.println("[g] generate a new word search");
        System.out.println("[p] print word search");
        System.out.println("[s] show the solution to the word search");
        System.out.println("[q] quit program");
    choice(wordGrid, line);
    } // end menu

    public void menuTwo(char[][] wordGrid, ArrayList<String> line)  {
        System.out.println();
        System.out.println("would you like to do anything else?");
        System.out.println();
        System.out.println("select from options below");
        System.out.println("[g] generate a new word search");
        System.out.println("[p] print word search");
        System.out.println("[s] show the solution to the word search");
        System.out.println("[q] quit program");
    choice(wordGrid, line);
    }

}