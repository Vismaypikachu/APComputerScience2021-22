import java.util.Arrays;

public class MergeSort implements ISorter{
	
	private int moves = 0;
	private int comparisons = 0;

	public MergeSort() {
		
	}
	
	@Override
	public ISortStats sort(int[] a) {
		long startingTime = System.nanoTime();
		
		a = mergeSort(a);
		
		return new SortStats("Merge Sort", a.length, comparisons, moves, System.nanoTime()-startingTime);
	}
	
	private int[] mergeSort(int arr[]) {
		int middle = arr.length/2;
		int arrayLower[] = Arrays.copyOfRange(arr, 0, middle);
		int arrayHigher[] = Arrays.copyOfRange(arr, middle, arr.length);
		moves+=2;
		if (arr.length > 1) {
			arrayLower = mergeSort(arrayLower);
			arrayHigher = mergeSort(arrayHigher);
			moves+=2;
		}
		if(arrayLower.length > 0 && arrayHigher.length > 0) {
			merge(arr, arrayLower, arrayHigher);
			moves++;
		}
		return arr;
	}

	private void merge(int[] arr, int[] lower, int[] higher) {
		int index = 0;
		int i = 0, j = 0;
		
		while(i < lower.length && j < higher.length) {
			if (lower[i] < higher[j]) {
				arr[index] = lower[i];
				i++;
				moves++;
			}
			else {
				arr[index] = higher[j];
				j++;
				moves++;
			}
			index++;
			comparisons++;
		}

		while (i < lower.length) {
            arr[index] = lower[i];
            i++;
            index++;
            moves++;
        }
  
        while (j < higher.length) {
            arr[index] = higher[j];
            j++;
            index++;
            moves++;
        }

	}
}
