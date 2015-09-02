import java.util.ArrayList;
import java.util.Collections;

/**
 * AlphabetizerADT
 * 
 * It sorts the list of the key words
 */
public class AlphabetizerADT {
    
    private ArrayList<String> sortedList;
    
    
    public AlphabetizerADT(ArrayList<String> unsortedList) {
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
