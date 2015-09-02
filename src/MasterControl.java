import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

//By Tan Chun How (A0111867A)and Benedict Suraj Suratanakavikul (A0110493N)
public class MasterControl {
    
    private static MasterControl masterControl;
    private static InputADT inputADT;
    private static CircularShiftADT circularShiftADT;
    private static AlphabetizerADT alphabetizerADT;
    private static OutputADT outputADT;
        
    private MasterControl(){
        inputADT = InputADT.getInstance();
        circularShiftADT = CircularShiftADT.getInstance();
        alphabetizerADT = AlphabetizerADT.getInstance();
        outputADT = OutputADT.getInstance();
    }
    
    public static MasterControl getInstance(){
        if(masterControl == null){
            masterControl = new MasterControl();
        }
        return masterControl;
    }
    
    public static void run() {
        inputADT.run();
        ArrayList<String> unsortedList = circularShiftADT.run(inputADT.getMovies(), inputADT.getIgnores());
        alphabetizerADT.run(unsortedList);
        ArrayList<String> sortedList = alphabetizerADT.getSortedList();
        outputADT.set(sortedList);
        outputADT.run();
    }
}
