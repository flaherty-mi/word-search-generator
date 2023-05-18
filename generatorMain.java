// Meghan Flaherty
// CS145
// Main
/* word search generator: creates a word search
   user can try to find all of the words in the word search, get the solutions, or print the word search 
*/
 // package searchGenerator;
import java.util.ArrayList;

public class generatorMain {
    public static void main(String[] args)  {
        
        char[][] wordGrid = new char [15][30];
        ArrayList<String> line = new ArrayList<>();
        new Generator(wordGrid);
        new searchManager(wordGrid, line);

    }
}
