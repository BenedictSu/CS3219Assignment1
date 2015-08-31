import java.util.ArrayList;
import java.util.HashSet;

/**
* CircularShift
* 
* It computes the list of Key words where the circular titles do not start
* with an ignored word
*/
public class CircularShift {
    
    private ArrayList<String> input;
    private ArrayList<String> unsortedList;
    private HashSet<String> ignoredWords;
    String[] userInputArray;
    
    public CircularShift (ArrayList<String> userInput, HashSet<String> userIgnoredWords) {
        input = userInput;
        ignoredWords = userIgnoredWords;      
        computeList();
    }
    
    private void computeList () {
        unsortedList = new ArrayList<String>();
        for (int i = 0; i < input.size(); i++) {
            userInputArray = splitUserInput(input.get(i));
            checkIgnore(0);
            
        }
    }
    
    private String[] splitUserInput(String sentence) {
        return sentence.trim().split("\\s+");
    }
    
    private void checkIgnore (int position) {
        
        
    }
    
}
