import java.io.IOException;
import java.util.Scanner;

public class Judge {
	private static long seed;

	private static int pseudoRand() {
		seed = seed * 134775813 + 1;
		return (int) ((seed >> 33) & 0x7FFFFFFF);
	}

	private static final String vowels = "aeiouy"; // 6
	private static final String consonants = "bcdfghjklmnprstvwxz"; // 19

	private static char[] randomCity() {
		int maxLen = 10;
		int len = 3 + pseudoRand() % (maxLen - 3);
		char[] s = new char[len];
		s[0] = (char) (consonants.charAt(pseudoRand() % 19) + 'A' - 'a');
		for (int i = 1; i < len; i++) {
			if ((i & 1) == 1) s[i] = vowels.charAt(pseudoRand() % 6);
			else s[i] = consonants.charAt(pseudoRand() % 19);
		}
		return s;
	}

	static final int MAX_N = 1000;
	static final int MAX_M = 10000;
	static final char[][] cities = new char[MAX_N][];
	static final char[][] a = new char[MAX_M][];
	static final char[][] b = new char[MAX_M][];

	public static void run(BFS solution) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N = sc.nextInt();
		int M = sc.nextInt();
		seed = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			for (int i = 0; i < N; i++) {
				cities[i] = randomCity();
			}

			char[] start = cities[0];
			char[] end = cities[N - 1];

			int path = pseudoRand() % (N - 1);
			for (int i = 0; i < path; i++) {
				a[i] = cities[i];
				b[i] = cities[i + 1];
			}

			for (int i = path; i < M; i++) {
				int x = pseudoRand() % N;
				int y = pseudoRand() % (N - 1);
				if (y == x)
					y = N - 1;
				a[i] = cities[x];
				b[i] = cities[y];
			}

			int answer = solution.solve(N, M, start, end, a, b);
			System.out.printf("%d: %d\n", tc, answer);
		}
	}
}
