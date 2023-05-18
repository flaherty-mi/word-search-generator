// Meghan Flaherty
// CS145
// Manager

//  package searchGenerator;

import java.util.ArrayList;
import java.util.Scanner;

public class searchManager extends generatorMain{
    

    public searchManager(char[][] wordGrid, ArrayList<String> line) {
        menu(wordGrid, line);
    }


    

   


    public void choice(char[][] wordGrid,ArrayList<String> line ) {
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

    public void createFile(char[][] wordGrid, ArrayList<String> line) {



        menuTwo(wordGrid, line);
    } // end createFile

    public void createInput(char[][] wordGrid, ArrayList<String> line) {

        Scanner in = new Scanner(System.in);
        System.out.println("How many words do you want to use?");
        System.out.println("maximum: 7");
        int wordNum = in.nextInt();
        
        String word;
        System.out.println("please enter words as prompted");
            for (int i = 1; i < wordNum + 1; i++) {
                System.out.print(i + ": ");
                word = in.next();
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

     // print array here 
     // prompt if they want to keep the words or use diff ones
     // if new -> reprompt method
     // if not -> present options

        menuTwo(wordGrid, line);
    } // end createInput


    public void printIt(char[][] wordGrid, ArrayList<String> line) {
        // should include randomizer for char letters outside arraylist

        for (int i = 0; i < wordGrid.length; i++) {
            for (int j = 0; j < wordGrid[i].length; j++) {
            
                System.out.print('X');

                if (j == 29) {
                System.out.println('X');
                }
            }  
        }
        menuTwo(wordGrid, line);
    } // end printIt

    public void Solution(char[][] wordGrid, ArrayList<String> line) {

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

    public void menu(char[][] wordGrid, ArrayList<String> line) {
        System.out.println("welcome to the word search game!");
        System.out.println("select from options below");
        System.out.println("[g] generate a new word search");
        System.out.println("[p] print word search");
        System.out.println("[s] show the solution to the word search");
        System.out.println("[q] quit program");
    choice(wordGrid, line);
    } // end menu

    public void menuTwo(char[][] wordGrid, ArrayList<String> line) {
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