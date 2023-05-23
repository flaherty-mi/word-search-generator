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

public class searchManager extends generatorMain {
    ArrayList<String> line;
    int wordNum;

    public searchManager(char[][] wordGrid, ArrayList<String> line) {
        menu(wordGrid, line);
    }

    public void choice(char[][] wordGrid,ArrayList<String> line )  {
        Scanner input = new Scanner(System.in);
        String choice = input.next();
    
        // go to whichever method is chosen
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

    // which method type user wants for generating a word search
    public void inputOrText(char[][] wordGrid, ArrayList<String> line) {

        // user decide to use file or input words for word search themselves
        System.out.println("do you want to input words for a word search, or upload a text file? ");
        System.out.println("type");
        System.out.println("[i] to input your own words");
        System.out.println("[t] for a text file");
    
            Scanner in = new Scanner(System.in);
            String whichOne = in.next();

            // go to whichever method they choose
            switch (whichOne.toLowerCase()) {
                case "t":
                       createFile(wordGrid, line);
                    return;
                case "i":
                       createInput(wordGrid, line);
                    return;
            }
    }  // end inputOrText

    // use words from text file for word search
    public void createFile(char[][] wordGrid, ArrayList<String> line)  {
        Scanner input = new Scanner(System.in);
        // get file name
        System.out.print("please enter an input file: ");
        String name;
        name = input.next();
        File in = new File(name);

        // including fnf exception & scanning the input file
        try {
            input = new Scanner(in);
        } catch (FileNotFoundException e) {
            // catch block
            e.printStackTrace();
        }
           
           // get all words from file 
           while (input.hasNextLine()) {
            String word = input.nextLine();
            word = input.nextLine();
            // add lines to array list
            line.add(word);
           }

        System.out.println("These are your words: ")
        System.out.println();
        System.out.println(line);
        System.out.println();

        System.out.println("if you would like to re-enter your words please type [r]");
        System.out.println("if no changes are needed please type [n]");
        String pick = input.next();

        /*  either continue to menu & store words 
        or clear list for user to change input words or wordNum */
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
        // if prompted again within same program use -> clear que for input
        line.removeAll(line);

        // scanner + choose # of words to input
        Scanner in = new Scanner(System.in);
        System.out.println("How many words do you want to use?");
        System.out.println("maximum: 7");
        wordNum = in.nextInt();
        
        String word;
        System.out.println("please enter words as prompted");

            // prompt user for correct number of words chosen
            for (int i = 1; i < wordNum + 1; i++) {
                System.out.print(i + ": ");
                word = in.next();
                word = word.toUpperCase();
                // add words to array list
                line.add(word);
            } // end for loop

        System.out.println();
        System.out.println("These are your words:");
        // display the words input by user
        System.out.println();
        System.out.println(line);
        System.out.println();

        System.out.println("if you would like to re-enter your words please type [r]");
        System.out.println("if no changes are needed please type [n]");
        String pick = in.next();

        /*  either continue to menu & store words 
         or clear list for user to change input words or wordNum */
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

    // displays the word search 
    public void printIt(char[][] wordGrid, ArrayList<String> line)  {
        // should include randomizer for char letters outside arraylist
        
        // for loops for printing wordGrid array
        for (int i = 0; i < wordGrid.length; i++) {
            for (int j = 0; j < wordGrid[i].length; j++) {

                // fill & print array with randomized letters
                String letters = "ABCDEFGHIJKLMNOP";
                Random r = new Random();
                char c = letters.charAt(r.nextInt(letters.length()));
                System.out.print(c);

                // only print array size worth
                if (j == 29) {
                System.out.println(c);
                } 
            }  
        }
        menuTwo(wordGrid, line);
    } // end printIt

    // displays the solution for the word search w/ out randomized letters
    public void Solution(char[][] wordGrid, ArrayList<String> line) { 

        // for loop -> iterate through each word -> each char
       for(int x = 0; x < wordNum; x++) {
        int leng = line.get(x).length();

         for(int y = 0; y < leng; y++) {
           //  wordGrid[][] = line.get(x).charAt(y);
         
        // for loops printing 'x' in order to just show words
        for (int i = 0; i < wordGrid.length; i++) { 
            for (int j = 0; j < wordGrid[i].length; j++) {
                System.out.print('X');
                wordGrid[i][j] = line.get(x).charAt(y);
                if (j == 29) {
                System.out.println('X');
                }
               // System.out.println(wordGrid[i][j] = line.get(x).charAt(y));
            }  }
            
        } }
        menuTwo(wordGrid, line);
    } // end Solution

    // menu - prints menu
    public void menu(char[][] wordGrid, ArrayList<String> line)  {
        System.out.println("welcome to the word search game!");
        System.out.println("select from options below");
        System.out.println("[g] generate a new word search");
        System.out.println("[p] print word search");
        System.out.println("[s] show the solution to the word search");
        System.out.println("[q] quit program");
    choice(wordGrid, line);
    } // end menu

    // second menu for re-prompting
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
    } // end menuTwo

} // end of class