import java.util.ArrayList;

// By Tan Chun How (A0111867A)
public class OutputADT {
    private static final String MESSAGE_KWIC = "output:";
    
    private static OutputADT output;
    private ArrayList<String> kwic;
    
    private OutputADT(){
        kwic = new ArrayList<String>();
    }
    
    public static OutputADT getInstance(){
        if(output == null){
            output = new OutputADT();
        }
        return output;
    }
    
    public void set(ArrayList<String> kwic){
        this.kwic = kwic;
    }
    
    public void run(){
        System.out.println(MESSAGE_KWIC);
        for(int i = 0; i < kwic.size(); i++){
            System.out.println(upperFirst(kwic.get(i)));
        }
    }
	
	private String upperFirst(String word){
		String[] words = word.split(" ", 2);
		if(words.length > 1){
			return words[0].toUpperCase() + " " + words[1];
		}
		else{
			return word.toUpperCase();
		}
	}
}
