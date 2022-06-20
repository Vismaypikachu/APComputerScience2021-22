import java.util.Arrays;
import java.util.Random;

public class Program {

	public static void main(String[] args) {
		Check check = new Check();
		//first set of tests
		for(int i = 1; i <= 4096; i*=2) {
			int[] testArr = new int[i];
			for(int j = 0; j < i; j++) testArr[j] = new Random().nextInt(Integer.MAX_VALUE);
			int[] testArr1 = testArr.clone();
			System.out.println(new BubbleSort().sort(testArr1).toString() + " Check: " + check.isInOrder(testArr1) +"\n");
			testArr1 = testArr.clone();
			System.out.println(new SelectionSort().sort(testArr1).toString() + " Check: " + check.isInOrder(testArr1) +"\n");
			check.isInOrder(testArr1);
			testArr1 = testArr.clone();
			System.out.println(new InsertionSort().sort(testArr1).toString() + " Check: " + check.isInOrder(testArr1) +"\n");
			check.isInOrder(testArr1);
			testArr1 = testArr.clone();
			System.out.println(new MergeSort().sort(testArr1).toString() + " Check: " + check.isInOrder(testArr1) +"\n");
			check.isInOrder(testArr1);
		}
		
		
		//second set of tests
		int[] testArr = new int[4096];
		testArr[0] = Integer.MAX_VALUE;
		for(int j = 1; j < 4096; j++) {
			testArr[j] = testArr[j-1] - new Random().nextInt(4096);
		}
		int[] testArr2 = testArr.clone();
		System.out.println(new BubbleSort().sort(testArr2).toString() + " Check: " + check.isInOrder(testArr2) +"\n");
		check.isInOrder(testArr2);
		testArr2 = testArr.clone();
		System.out.println(new SelectionSort().sort(testArr2).toString() + " Check: " + check.isInOrder(testArr2) +"\n");
		check.isInOrder(testArr2);
		testArr2 = testArr.clone();
		System.out.println(new InsertionSort().sort(testArr2).toString() + " Check: " + check.isInOrder(testArr2) +"\n");
		check.isInOrder(testArr2);
		testArr2 = testArr.clone();
		System.out.println(new MergeSort().sort(testArr2).toString() + " Check: " + check.isInOrder(testArr2) +"\n");		
		check.isInOrder(testArr2);
		
		//sorts array
		Arrays.sort(testArr);
		
		testArr2 = testArr.clone();
		System.out.println(new BubbleSort().sort(testArr2).toString() + " Check: " + check.isInOrder(testArr2) +"\n");
		check.isInOrder(testArr2);
		testArr2 = testArr.clone();
		System.out.println(new SelectionSort().sort(testArr2).toString() + " Check: " + check.isInOrder(testArr2) +"\n");
		check.isInOrder(testArr2);
		testArr2 = testArr.clone();
		System.out.println(new InsertionSort().sort(testArr2).toString() + " Check: " + check.isInOrder(testArr2) +"\n");
		check.isInOrder(testArr2);
		testArr2 = testArr.clone();
		System.out.println(new MergeSort().sort(testArr2).toString() + " Check: " + check.isInOrder(testArr2) +"\n");
		check.isInOrder(testArr2);	
	}

}
