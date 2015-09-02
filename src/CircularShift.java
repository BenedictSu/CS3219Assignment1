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

    public CircularShift(ArrayList<String> userInput,
            HashSet<String> userIgnoredWords) {
        input = userInput;
        ignoredWords = userIgnoredWords;
        computeList();
    }

    private void computeList() {
        unsortedList = new ArrayList<String>();
        for (int i = 0; i < input.size(); i++) {
            userInputArray = splitUserInput(input.get(i));
            checkIgnore(userInputArray.length, 0, "");
        }
    }

    private String[] splitUserInput(String sentence) {
        return sentence.trim().split("\\s+");
    }

    private String checkIgnore(int lastPosition, int position, String frontWords) {
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

    /**
     * getUnsortedList
     * 
     * @return the unsorted list of key words
     * 
     */
    public ArrayList<String> getUnsortedList() {
        return unsortedList;
    }
}
