import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Board {
	String[][] gameBoard;
	WordList list;
	
	public Board(WordList list, int size) {
		this.gameBoard = new String[size][size];
		this.list = list; 
	
		Random r = new Random();
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				String word = list.get(r.nextInt(list.size()));
				this.gameBoard[i][j] = "" + word.charAt(r.nextInt(word.length()));
			}
		}
		
		//select random row, random column for Suffix
		int row = r.nextInt(this.gameBoard.length);
		int column = r.nextInt(this.gameBoard.length);
		
		//select suffix
		int select = r.nextInt(3);
		String[] suffixArr = {"-ED","-EST","-ING"};
		this.gameBoard[row][column] = suffixArr[select];
		
		//select random row, random column
		int row2, column2;
		do {
			row2 = r.nextInt(this.gameBoard.length);
			column2 = r.nextInt(this.gameBoard.length);
		} while(row == row2 && column == column2);
				
		//select prefix
		int select2 = r.nextInt(3);
		String[] prefixArr = {"RE-","STR-","UN-"};
		this.gameBoard[row2][column2] = prefixArr[select2];

	}
	
	public ArrayList<String> find(){
		boolean[][] visited = new boolean[this.gameBoard.length][this.gameBoard[0].length];
		ArrayList<String> foundWords = new ArrayList<String>();;
		
		
		for(int i = 0; i < this.gameBoard.length; i++) {
			for(int j = 0; j < this.gameBoard[i].length; j++) {
				foundWords = merge(foundWords, startingPosition("", i, j, visited, foundWords));
			}
		}
		return foundWords;
	}
	
	public Board (WordList list, int size, int l) throws FileNotFoundException {
		this.list = list;
		String[][] names = new String[size][size];

		String[] x = {"G", "S", "G", "N"};
		String[] y = {"O", "R", "N", "L"};
		String[] z = {"T", "D", "R", "J"};
		String[] a = {"RE-", "F", "-EST", "J"};

		names[0] = x;
		names[1] = y;
		names[2] = z;
		names[3] = a;

		this.gameBoard = names;

	}
	
	public ArrayList<String> startingPosition(String word, int r, int c, boolean[][] visited, ArrayList<String> foundWords){
		visited[r][c] = true;
		//mechanics
		int maxLength = Program.MAX;
		
		if(this.gameBoard[r][c].charAt(0) == '-' /*&& (word.length() + this.gameBoard[r][c].substring(1).length()) >= Program.MAX*/) {
			word += this.gameBoard[r][c].substring(1);
			maxLength = word.length();
			
		}
		else word += this.gameBoard[r][c];
		
		if(this.list.contains(word) && !foundWords.contains(word)) {
			foundWords.add(word);
		}
		
		int right = c+1; int left = c-1; int up = r-1; int down = r+1;
		if(word.length() < maxLength) {
			if(right < this.gameBoard.length && visited[r][right] == false && this.gameBoard[r][right].charAt(this.gameBoard[r][right].length()-1) != '-' && !contains(word, this.gameBoard[r][right])) {
				foundWords = merge(foundWords, startingPosition(word, r, right, visited, foundWords));
				visited[r][right] = false;
			}
			if(left >= 0 && visited[r][left] == false && this.gameBoard[r][left].charAt(this.gameBoard[r][left].length()-1) != '-' && !contains(word, this.gameBoard[r][left])) {
				foundWords = merge(foundWords, startingPosition(word, r, left, visited, foundWords));
				visited[r][left] = false;
			}
			if(down < this.gameBoard.length && visited[down][c] == false && this.gameBoard[down][c].charAt(this.gameBoard[down][c].length()-1) != '-' && !contains(word, this.gameBoard[down][c])) {
				foundWords = merge(foundWords, startingPosition(word, down, c, visited, foundWords));
				visited[down][c] = false;
			}
			if(up >= 0 && visited[up][c] == false && this.gameBoard[up][c].charAt(this.gameBoard[up][c].length()-1) != '-' && !contains(word, this.gameBoard[up][c])) {
				foundWords = merge(foundWords, startingPosition(word, up, c, visited, foundWords));
				visited[up][c] = false;
			}
			
			
			if(right < this.gameBoard.length && up >= 0 && visited[up][right] == false && visited[up][right] == false && this.gameBoard[up][right].charAt(this.gameBoard[up][right].length()-1) != '-' && !contains(word, this.gameBoard[up][right])) {
				foundWords = merge(foundWords, startingPosition(word, up, right, visited, foundWords));
				visited[up][right] = false;
			}
			if(left >= 0 && up >= 0 && visited[up][left] == false && visited[up][left] == false && this.gameBoard[up][left].charAt(this.gameBoard[up][left].length()-1) != '-' && !contains(word, this.gameBoard[up][left])) {
				foundWords = merge(foundWords, startingPosition(word, up, left, visited, foundWords));
				visited[up][left] = false;
			}
			if(right < this.gameBoard.length && down < this.gameBoard.length && visited[down][right] == false && visited[down][right] == false && this.gameBoard[down][right].charAt(this.gameBoard[down][right].length()-1) != '-' && !contains(word, this.gameBoard[down][right])) {
				foundWords = merge(foundWords, startingPosition(word, down, right, visited, foundWords));
				visited[down][right] = false;
			}
			if(left >= 0 && down < this.gameBoard.length && visited[down][left] == false && visited[down][left] == false && this.gameBoard[down][left].charAt(this.gameBoard[down][left].length()-1) != '-' && !contains(word, this.gameBoard[down][left])) {
				foundWords = merge(foundWords, startingPosition(word, down, left, visited, foundWords));
				visited[down][left] = false;
			}
		}
		
		
		return foundWords;
	}
	
	public ArrayList<String> merge(ArrayList<String> list1, ArrayList<String> list2) {
		for(int i = 0; i < list2.size(); i++) {
			if(!list1.contains(list2.get(i))) {
				list1.add(list2.get(i));
			}
		}
		return list1;
	}
	
	public boolean contains(String s, String c) {
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == c.charAt(0)) return true;
		}
		return false;
	}
	
	public String toString() {
		String board = "";
		
		for(int i = 0; i < this.gameBoard.length; i++) {
			for(int j = 0; j < this.gameBoard[i].length; j++) {
				if(this.gameBoard[i][j].charAt(0) == '-') {
					board += this.gameBoard[i][j].substring(1) + "\t";
				}
				else if(this.gameBoard[i][j].charAt(this.gameBoard[i][j].length()-1) == '-') {
					board += this.gameBoard[i][j].substring(0, this.gameBoard[i][j].length()-1) + "\t";
				}
				else board += this.gameBoard[i][j] + "\t";
			}
			board += "\n";
		}
		return board;
	}
}