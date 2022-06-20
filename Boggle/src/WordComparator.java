import java.util.ArrayList;
import java.util.Collections;

public class WordComparator {
	
	public ArrayList<ArrayList<String>> sort(ArrayList<String> list) {
		ArrayList<ArrayList<String>> wordOrder = new ArrayList<ArrayList<String>>();
		for(int i = 0; i <= Program.MAX; i++) {
			wordOrder.add(new ArrayList<String>());
		}
		
		for(int i = Program.MIN; i < list.size(); i++) {
			if(!wordOrder.get(list.get(i).length()).contains(list.get(i))) {
				wordOrder.get(list.get(i).length()).add(list.get(i));
				Collections.sort(wordOrder.get(list.get(i).length()));
			}
		}
		return wordOrder;
	}
}
