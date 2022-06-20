
public class SortStats implements ISortStats{
	
	private String algorithm;
	private int numItems;
	private int numComparisons;
	private int numMoves;
	private long nanoSeconds;
	
	public SortStats(String algorithm, int numItems, int numComparisons, int numMoves, long nanoSeconds) {
		this.algorithm = algorithm;
		this.numItems = numItems;
		this.numComparisons = numComparisons;
		this.numMoves = numMoves;
		this.nanoSeconds = nanoSeconds;
	}

	@Override
	public String getAlgorithm() {
		return this.algorithm;
	}

	@Override
	public int getNumItems() {
		return this.numItems;
	}

	@Override
	public int getNumComparisons() {
		return this.numComparisons;
	}

	@Override
	public int getNumMoves() {
		return this.numMoves;
	}

	@Override
	public long getNumNanoseconds() {
		return this.nanoSeconds;
	}
	
	public String toString() {	
		String algorithm = "Algorithm\t:  " + getAlgorithm() +"";
		String numItems = "NumItems\t:  " + getNumItems() +"";
		String numComparisons = "NumComparisons\t:  " + getNumComparisons() +"";
		String numMoves = "NumMoves\t:  " + getNumMoves() +"";
		String numNanoseconds = "NumNanoseconds\t:  " + getNumNanoseconds() +"";
		return algorithm + "\n" + numItems + "\n" + numComparisons + "\n" + numMoves + "\n" + numNanoseconds;
	}

}
