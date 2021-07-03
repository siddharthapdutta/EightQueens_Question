public class ChessBoardRenderer {
	public boolean isBlackSquare(int square) {
		boolean evenRow = (int)square/8 % 2 == 0;
		// Even rows have black squares in odd places
		if (evenRow && square % 2 != 0)
			return true;
		// Odd rows have black squares in even places
		if (!evenRow && square % 2 == 0)
			return true;
		return false;
	}
}
