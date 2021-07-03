public class GameStrategy {
	private boolean placedQueens[][] = new boolean[8][8];
	private int numQueens = 0;

	private int getColumn(int cellId) {
		return cellId % 8;
	}
	
	private int getRow(int cellId) {
		return cellId / 8;
	}

	public boolean isValidPosition(int cellId) {
		int i, j;

		if(this.numQueens == 8) 
			throw new GameOverException();	// just return out of the method

		// the game is still on, so let us continue...
		
		int col = getColumn(cellId);
		int row = getRow(cellId);
		
		// Check if row contains queen
		for (int c = 0; c < 8; c++) {
			if (this.placedQueens[row][c])
				return false;
		}
		// Check if column contains queen
		for (int r = 0; r < 8; r++) {
			if (this.placedQueens[r][col])
				return false;
		}
		// Check top left diagonal
		i = row-1;
		j = col-1;
		while (i >= 0 && j >= 0) {
			if (this.placedQueens[i--][j--])
				return false;
		}
		// Check to top right diagonal
		i = row-1;
		j = col+1;
		while (i >= 0 && j < 7) {
			if (this.placedQueens[i--][j++])
				return false;
		}
		// Check to bottom left diagonal
		i = row+1;
		j = col-1;
		while (i < 7 && j >= 0) {
			if (this.placedQueens[i++][j--])
				return false;
		}
		// Check to bottom right diagonal
		i = row+1;
		j = col+1;
		while (i < 7 && j < 7) {
			if (this.placedQueens[i++][j++])
				return false;
		}

		this.placedQueens[row][col] = true;
		this.numQueens++;
		return true;
	}
}














