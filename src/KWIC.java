
public class KWIC {
	public static void main(String[] args){
		Input input = Input.getInstance();
		Output output = Output.getInstance();
		
		input.run();
		
		output.set(input.getMovies());
		output.run();
	}
}
