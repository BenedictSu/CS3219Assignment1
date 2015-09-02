import java.util.ArrayList;
import java.util.HashSet;

/**
 * CircularShift
 * 
 * It computes the list of Key words where the circular titles do not start
 * with an ignored word
 */
public class CircularShift {

    private static ArrayList<String> input;
    private static ArrayList<String> unsortedList;
    private static HashSet<String> ignoredWords;
    private static String[] userInputArray;
    
    private static CircularShift circularShift;
        
    private CircularShift(){
    }
    
    public static CircularShift getInstance(){
        if(circularShift == null){
            circularShift = new CircularShift();
        }
        return circularShift;
    }
    
    /**
     * run
     * 
     * compute the list of key words
     * 
     * @return the unsorted list of key words
     * 
     */
    public ArrayList<String> run(ArrayList<String> userInput,
            HashSet<String> userIgnoredWords) {
        input = userInput;
        ignoredWords = userIgnoredWords;
        computeList();
        Alphabetizer alphabetizer = Alphabetizer.getInstance();
        alphabetizer.run(unsortedList);
        return unsortedList;
    }

    private static void computeList() {
        unsortedList = new ArrayList<String>();
        for (int i = 0; i < input.size(); i++) {
            userInputArray = splitUserInput(input.get(i));
            checkIgnore(userInputArray.length, 0, "");
        }
    }

    private static String[] splitUserInput(String sentence) {
        return sentence.trim().split("\\s+");
    }

    private static String checkIgnore(int lastPosition, int position, String frontWords) {
        String secondPart = "";

        if (!ignoredWords.contains(userInputArray[position])) {
            if (position != lastPosition - 1) {
                if (position == 0) {
                    secondPart =
                            checkIgnore(lastPosition, position + 1,
                                    userInputArray[position]);
                    unsortedList.add(userInputArray[position] + secondPart);
                } else {
                    secondPart =
                            checkIgnore(lastPosition, position + 1, frontWords + " "
                                    + userInputArray[position]);
                    unsortedList.add(userInputArray[position] + secondPart + " "
                            + frontWords);
                }
            } else {
                if (position == 0) {
                    unsortedList.add(userInputArray[position]);
                } else {
                    unsortedList.add(userInputArray[position] + " " + frontWords);
                }
            }
            return " " + userInputArray[position] + secondPart;
        } else {
            if (position != lastPosition - 1) {
                if (position == 0) {
                    secondPart =
                            checkIgnore(lastPosition, position + 1,
                                    userInputArray[position]);
                } else {
                    secondPart =
                            checkIgnore(lastPosition, position + 1, frontWords + " "
                                    + userInputArray[position]);
                }
            }
            return " " + userInputArray[position] + secondPart;
        }
    }
}
