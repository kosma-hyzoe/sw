import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class BFS {
	private static int minNoOfTransfers = Integer.MAX_VALUE;
	private static ArrayList<char[]> visited = new ArrayList<>();

	// Not part of task - may be useful when debugging.
	void printTestCase(int n, int m, char[] start, char[] end, char[][] a, char[][] b) {
		for (int i = 0; i < m; i++) {
			System.out.println(String.valueOf(a[i]) + " -> " + String.valueOf(b[i]));
		}
		System.out.println("QUESTION: " + String.valueOf(start) + " -> " + String.valueOf(end));
	}

	public void backtrackTransfers(char[] curr, int nt, int n, int m, char[] end, char[][] a, char[][] b) {

		if (Arrays.equals(curr, end)) {
			if (nt < minNoOfTransfers)
				minNoOfTransfers = nt;
			return;
		}

		for (int i = 0; i < m; i++) {
			if (Arrays.equals(a[i], curr) && !visited.contains(b[i])) {
				visited.add(b[i]);
				backtrackTransfers(b[i], nt + 1, n, m, end, a, b);
			}
		}
	}

	public int solve(int n, int m, char[] start, char[] end, char[][] a, char[][] b) {
		//printTestCase(n, m, start, end, a, b);
		backtrackTransfers(start, 0, n, m, end, a, b);

		if (minNoOfTransfers == Integer.MAX_VALUE)
			return -1;
		else
			return minNoOfTransfers;
	}

	public static void main(String[] args) throws IOException {
		Judge.run(new BFS());
	}
}