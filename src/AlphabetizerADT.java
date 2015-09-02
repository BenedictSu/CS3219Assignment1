import java.util.ArrayList;
import java.util.Collections;

/**
 * Alphabetizer
 * 
 * It sorts the list of the key words
 */
public class AlphabetizerADT {
    
	private static AlphabetizerADT alphabetizer;
    private ArrayList<String> sortedList;
    
    public AlphabetizerADT() {
    	sortedList = new ArrayList<String>();
    }
    
	public static AlphabetizerADT getInstance(){
		if(alphabetizer == null){
			alphabetizer = new AlphabetizerADT();
		}
		return alphabetizer;
	}
	
    public void run(ArrayList<String> unsortedList) {
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
