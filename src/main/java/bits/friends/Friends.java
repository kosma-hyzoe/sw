package bits.friends;

import java.io.IOException;

public class Friends {
	final static byte EMPLOYEE_COUNT = 64;
	private long[] employees;

	public Friends() {
		this.employees = new long[EMPLOYEE_COUNT];
		for (int i = 0; i < EMPLOYEE_COUNT; i++)
			this.employees[i] = 0L;
	}

	public void addFriend(int a, int b) {
		this.employees[a] |= (1L << b);
		this.employees[b] |= (1L << a);
	}

	public boolean haveCommonFriend(int a, int b) {
		long aFriendsExceptB = this.employees[a] & ~(1L << b);
		long bFriendsExceptA = this.employees[b] & ~(1L << a);
		return (aFriendsExceptB & bFriendsExceptA) != 0;
	}

	public static void main(String[] args) throws IOException {
		Judge.run(new Friends());
	}
}
