
public class KWIC {
	public static void main(String[] args){
		Input input = Input.getInstance();
		
		input.run();
		
		System.out.println(input.getMovies().get(0));
	}
}
