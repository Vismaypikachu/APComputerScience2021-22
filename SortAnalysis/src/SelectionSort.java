
public class SelectionSort implements ISorter{

	public SelectionSort() {
		
	}
	
	@Override
	public ISortStats sort(int[] a) {
		long startingTime = System.nanoTime();
		int comparisons = 0;
		int moves = 0;

		for (int i = 0; i < a.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < a.length; j++) {
            	comparisons++;
            	if (a[j] < a[index]) {
                	index = j;
                }
            }
            if(index != i) {
            	int smallerNumber = a[index];  
                a[index] = a[i];
                a[i] = smallerNumber;
                
                moves+=3;
            }
        }
		
		return new SortStats("Selection Sort", a.length, comparisons, moves, System.nanoTime()-startingTime);
	}

}
