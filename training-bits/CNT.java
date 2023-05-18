import java.util.*;

public class CNT {
	public int popCount(int value) {
        int count = 0;

        do {
            count += (value % 2);
        } while ((value /= 2) >= 1);

        return count;
	}

	public static void main(String[] args) {
		Judge.run(new CNT());
	}
}
