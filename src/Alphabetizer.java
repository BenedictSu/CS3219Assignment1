import java.util.ArrayList;
import java.util.Collections;

//By Benedict Suraj Suratanakavikul (A0110493N)
/**
 * Alphabetizer
 * 
 * It sorts the list of the key words
 */
public class Alphabetizer {
    
	private static Alphabetizer alphabetizer;
    private ArrayList<String> sortedList;
    
    public Alphabetizer() {
    	sortedList = new ArrayList<String>();
    }
    
	public static Alphabetizer getInstance(){
		if(alphabetizer == null){
			alphabetizer = new Alphabetizer();
		}
		return alphabetizer;
	}
	
    public void run(ArrayList<String> unsortedList) {
        alphabetizer(unsortedList);
        Output output = Output.getInstance();
        output.set(sortedList);
        output.run();
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
