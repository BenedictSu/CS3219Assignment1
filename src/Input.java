import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class Input {
	
    private static final String MESSAGE_END = "end", 
            MESSAGE_MOVIE = "Please insert the movies names one by one and type "
                    + "end after the last entry. For example:\nThe Day after Tomorrow\n"
                    + "Man of Steel\nFast and Furious\nend",
            MESSAGE_IGNORE = "Please insert the lsit of words to be ignored one "
                    + "by one and type end after the last entry. For example:\nthe\nof\n"
                    + "and\nas\na\nafter\nend";
	
	private static Input input;
	private static Scanner sc;
	private static ArrayList<String> movies;
	private static HashSet<String> ignores;
		
	private Input(){
		movies = new ArrayList<String>();
		ignores = new HashSet<String>();
	}
	
	public static Input getInstance(){
		if(input == null){
			input = new Input();
		}
		return input;
	}
	
	public void run(){
		sc = new Scanner(System.in);
		
		System.out.println(MESSAGE_MOVIE);
		readMovies();
		
		System.out.println(MESSAGE_IGNORE);
		readIgnores();
		
		sc.close();
		
		CircularShift circularShift = CircularShift.getInstance();
		circularShift.run(this.getMovies(), this.getIgnores());
	}
	
	private void readMovies(){
		String text = "";
		
		while(true){
			text = sc.nextLine();
			if(text.equals(MESSAGE_END)){
				break;
			}
			else{
				movies.add(text.toLowerCase());
			}
		}
	}
	
	private void readIgnores(){
		String text = "";
		
		while(true){
			text = sc.nextLine();
			if(text.equals(MESSAGE_END)){
				break;
			}
			else{
				ignores.add(text.toLowerCase());
			}
		}
	}
	
	public ArrayList<String> getMovies(){
		return movies;
	}
	
	public HashSet<String> getIgnores(){
		return ignores;
	}
}
