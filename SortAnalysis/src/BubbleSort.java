
public class BubbleSort implements ISorter{

	public BubbleSort() {

	}

	@Override
	public ISortStats sort(int[] a) {
		long startingTime = System.nanoTime();
		int moves = 0;
		int comparisons = 0;

		if(a.length>1) {
			for(int i = 0; i < a.length; i++) {
				for(int j = 0; j < a.length - i - 1; j++) {
					comparisons++;
					if(a[j] > a[j+1]) {
						int temp = a[j];
						a[j] = a[j+1];
						a[j+1] = temp;
						moves+=3;
					}
				}
			}
		}
		return new SortStats("BubbleSort", a.length, comparisons, moves, System.nanoTime()-startingTime);
	}

}
