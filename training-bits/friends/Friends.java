import java.io.IOException;

public class Friends {
	final static byte EMPLOYEE_COUNT = 64;
	private long[] employees;

	public Friends() {
		this.employees = new long[EMPLOYEE_COUNT];
		for (int i = 0; i < EMPLOYEE_COUNT; i++)
			this.employees[i] = (1 << i);
	}

	void addFriend(int a, int b) {
		this.employees[a] |= (1 << b);
		this.employees[b] |= (1 << a);
	}

	boolean haveCommonFriend(int a, int b) {
		long aFriendsExceptB = this.employees[a] & ~(1 << a) & ~(1 << b);
		long bFriendsExceptA = this.employees[b] & ~(1 << a) & ~(1 << b);
		return ((aFriendsExceptB & bFriendsExceptA) > 0) ? true : false;
	}

	public static void main(String[] args) throws IOException {
		Judge.run(new Friends());
	}
}
