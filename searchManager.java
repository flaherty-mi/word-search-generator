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
    int x;
    int y;
    int i;
    int j;
    String word;

    public searchManager(char[][] Grid, char[][] sol, ArrayList<String> line) {
        menu(Grid, sol, line);

        for (int i = 0; i < Grid.length; i++) {
            for (int j = 0; j < Grid[i].length; j++) {
        Grid[i][j] = '#';
        sol[i][j] = '#';
     }}

    }

    // directs user from their menu choice to appropriate method
    public void choice(char[][] Grid, char[][] sol, ArrayList<String> line )  {
        Scanner input = new Scanner(System.in);
        String choice = input.next();
    
        // go to whichever method is chosen
        switch (choice.toLowerCase()) {
        case "g": 
            inputOrText(Grid, sol, line);
        return;
        case "p":
            printIt(Grid, sol, line);
        return;
        case "s":
            Solution(Grid, sol, line);
        return;
        case "q":
            System.exit(0);
        return;

        }
    } // end choice

    // which method type user wants for generating a word search
    public void inputOrText(char[][] Grid, char[][] sol, ArrayList<String> line) {

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
                       createFile(Grid, sol, line);
                    return;
                case "i":
                       createInput(Grid, sol, line);
                    return;
            }
    }  // end inputOrText

    // use words from text file for word search
    public void createFile(char[][] Grid, char[][] sol, ArrayList<String> line)  {
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

        System.out.println("These are your words: ");
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
                createFile(Grid, sol, line);
            return;
            case "n":
                System.out.println("word search creation comeplete!");
                System.out.println("if you would like to print your word search or see the " + 
                "solution, choose from menu ");
                System.out.println();
        }
        menuTwo(Grid, sol, line);  
    } // end createFile

    public void createInput(char[][] Grid, char[][] sol, ArrayList<String> line) {
        // if prompted again within same program use -> clear que for input
        line.removeAll(line);

        // scanner + choose # of words to input
        Scanner in = new Scanner(System.in);
        System.out.println("How many words do you want to use?");
        System.out.println("maximum: 7");
        wordNum = in.nextInt();
        
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
                createInput(Grid, sol, line);
            return;
            case "n":
                System.out.println("word search creation comeplete");
                System.out.println("if you would like to print your word search or see the " + 
                "solution, choose from menu ");
                System.out.println();
        }
        placement(Grid, sol, line);
    } // end createInput

    // filling the array with word & char at random coordinates
    public void placement (char[][] Grid, char[][] sol, ArrayList<String> line) {
        
        for(x = 0; x < wordNum; x++) {
            int leng = line.get(x).length(); 
            for(y = 0; y < leng; y++) {
                
            Random rand = new Random();   
            int rowBound = 15;
            int columnBound = 30;

            int row = rand.nextInt(rowBound);
            int column = rand.nextInt(columnBound);
            
                Grid[row][column] = line.get(x).charAt(y);
                    
                  sol[row][column] = line.get(x).charAt(y);

                  
             } }
        
        menuTwo(Grid, sol, line);
    }

    // displays the word search 
    public void printIt(char[][] Grid, char[][] sol, ArrayList<String> line)  {
        // for loops for printing wordGrid array
        for (int i = 0; i < Grid.length; i++) {
            for (int j = 0; j < Grid[i].length; j++) {

                // fill & print array with randomized letters
                String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                Random r = new Random();
                char c = letters.charAt(r.nextInt(letters.length()));
                System.out.print(c);
               if (Grid[i][j] != '#') {
                  System.out.println(Grid[i][j]);
                  }
                // only print array size worth
                if (j == 29) {
                    System.out.println(c);
                        
                 if (Grid[i][j] != '#' && j == 29) {
                     System.out.print(Grid[i][j]);
                     }   
                } 
            }  
        }
        placement(Grid, sol, line);
    } // end printIt

    // displays the solution for the word search w/ out randomized letters
    public void Solution(char[][] Grid, char[][] sol, ArrayList<String> line) { 
         
        // for loops printing '#' in order to just show words
        for (i = 0; i < sol.length; i++) { 
            for (j = 0; j < sol[i].length; j++) {
                
                   // System.out.println(sol);

                    if (sol[i][j] != '#') {
                        System.out.print(sol[i][j]); 
                     }
                     else{
                        System.out.println('#');
                     }
                if (j == 29) { 
                  if (j == 29 && sol[i][j] != '#') {
                    System.out.print(sol[i][j]); 
                    else {
                        System.out.println('#');
                    }
                 } }// end if
                
          }  } // end for loop
        menuTwo(Grid, sol, line);
    } // end Solution

    // menu - prints menu
    public void menu(char[][] Grid, char[][] sol, ArrayList<String> line)  {
        System.out.println("welcome to the word search game!");
        System.out.println("select from options below");
        System.out.println("[g] generate a new word search");
        System.out.println("[p] print word search");
        System.out.println("[s] show the solution to the word search");
        System.out.println("[q] quit program");
    choice(Grid, sol, line);
    } // end menu

    // second menu for re-prompting
    public void menuTwo(char[][] Grid, char[][] sol, ArrayList<String> line)  {
        System.out.println();
        System.out.println("would you like to do anything else?");
        System.out.println();
        System.out.println("select from options below");
        System.out.println("[g] generate a new word search");
        System.out.println("[p] print word search");
        System.out.println("[s] show the solution to the word search");
        System.out.println("[q] quit program");
    choice(Grid, sol, line);
    } // end menuTwo

} // end of class