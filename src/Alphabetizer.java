import java.util.ArrayList;
import java.util.Collections;

/**
 * Alphabetizer
 * 
 * It sorts the list of the key words
 */
public class Alphabetizer {
    
    private ArrayList<String> sortedList;
    
    
    public Alphabetizer(ArrayList<String> unsortedList) {
        alphabetizer(unsortedList);
    }
    
    private void alphabetizer(ArrayList<String> unsortedList) {
        Collections.sort(unsortedList);
        sortedList = unsortedList;
    }
    
    /**
     * getSortedList
     * 
     * @return the sorted list of key words
     * 
     */
    public ArrayList<String> getSortedList () {
        return sortedList;
    }
    
}
