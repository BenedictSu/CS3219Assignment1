import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class MasterControl {
    
    
    private static MasterControl masterControl;
    private static InputADT inputADT;
    private static CircularShiftADT circularShiftADT;
    private static AlphabetizerADT alphabetizerADT;
    private static OutputADT outputADT;
        
    private MasterControl(){
        inputADT = InputADT.getInstance();
        outputADT = OutputADT.getInstance();
    }
    
    public static MasterControl getInstance(){
        if(masterControl == null){
            masterControl = new MasterControl();
        }
        return masterControl;
    }
}
