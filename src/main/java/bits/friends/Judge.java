package bits.friends;

import java.io.IOException;
import java.util.Scanner;

public class Judge {
	public static void run(Friends solution) throws IOException {
		Scanner sc = new Scanner(System.in);
		int add = sc.nextInt();

		for(int i = 0; i < add; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			solution.addFriend(a, b);
		}

		int check = sc.nextInt();
		for(int i = 0; i < check; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(solution.haveCommonFriend(a, b) ? 1 : 0);
		}
		
		sc.close();
	}
}
