public class SUD {
	private static final int GRID_SIZE = 9;

    private static boolean inRow(int[][] b, int n, int row) {
        for (int c = 0; c < GRID_SIZE; c++) {
            if (n == b[row][c]) {
                return true;
            }
        }
        return false;
    }

    private static boolean inColumn(int[][] b, int n, int col) {
        for (int r = 0; r < GRID_SIZE; r++) {
            if (n == b[r][col]) {
                return true;
            }
        }
        return false;
    }

    private static boolean inBox(int[][] b, int n, int row, int col) {
        int localBoxRow = row - row % 3;
        int localBoxColumn = col - col % 3;
        for (int r = localBoxRow; r < localBoxRow + 3; r++) {
            for (int c = localBoxColumn; c < localBoxColumn + 3; c++) {
                if (n == b[r][c]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isLegal(int[][] b, int n, int r, int c) {
        return !inBox(b, n, r, c) && !inColumn(b, n, c) && !inRow(b, n, r);
    }

    private boolean solveCell(int[][] b, int r, int c) {
        for (int n = 1; n <= 9; n++) {
            if (n > b[r][c] && isLegal(b, n, r, c)) {
                b[r][c] = n;
                return true;
            }
        }
        b[r][c] = -1;
        return false;
    }

    public void solve(int[][] b) {

        int c = 0, r = 0;
        while (true) {
            if (b[r][c] != 0 && !solveCell(b, r, c)) {
                if (c == 0) {
                    r--;
                    c = GRID_SIZE - 1;
                } else {
                    c--;
                }
                continue;
            }

            if (c == GRID_SIZE - 1 && r == GRID_SIZE -1) {
                break;
            } else if (c == GRID_SIZE - 1) {
                r++;
                c = 0;
            } else {
                c++;
            }
        }
    }

	public static void main(String[] args) {
		Judge.run(new SUD());
	}
}