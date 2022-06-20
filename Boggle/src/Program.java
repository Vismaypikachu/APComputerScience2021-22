import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Program {
	
	public static final int SIZE = 4;
	public static final int MIN = 3;
	public static final int MAX = 8;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Welcome to Boggle, by Vismay Patel");
		System.out.println("Check out http://vismaypatel.com");
		
		WordList list = new WordList("WordList.txt", MIN, MAX);
		Board board = new Board(list, SIZE);
		System.out.println(board);
		ArrayList<ArrayList<String>> wordsSorted = new WordComparator().sort(board.find());
		results(wordsSorted);
		
	}
		
	public static void results(ArrayList<ArrayList<String>> wordsSorted) {
		int count = 0;
		for(int i = MAX; i >= MIN; i--) {
			for(int j = 0; j < wordsSorted.get(i).size(); j++) {
				count++;
			}
		}
		System.out.println(count + " words found!");
		for(int i = MAX; i >= MIN; i--) {
			if(wordsSorted.get(i).size() > 0) {
				System.out.println(i + " letter words");
				for(int j = 0; j < wordsSorted.get(i).size(); j++) {
					System.out.println(wordsSorted.get(i).get(j));
				}
				System.out.println("\n");
			}
		}
	}
}
