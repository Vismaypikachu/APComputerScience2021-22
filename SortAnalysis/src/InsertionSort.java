
public class InsertionSort implements ISorter{

	public InsertionSort() {
		
	}
	
	@Override
	public ISortStats sort(int[] a) {
		long startingTime = System.nanoTime();
		int comparisons = 0, moves = 0;
		
        for (int i = 1; i < a.length; ++i) {
            int value = a[i];
            int j = i - 1;
 
            while (j >= 0 && a[j] > value) {
                a[j + 1] = a[j];
                j = j - 1;
                moves++;
                comparisons++;
            }
            a[j + 1] = value;
            moves++;
        }
        
        return new SortStats("Insertion Sort", a.length, comparisons, moves, System.nanoTime()-startingTime);
	}

}
