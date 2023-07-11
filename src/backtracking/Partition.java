package partition;

import java.util.Arrays;

public class Partition {
    private static boolean backtrack(int i, int p1s, int p2s, int ts, int[] array, int n) {
        if (i == n) {
            return p1s == p2s && ts == p1s;
        }

        return backtrack(i + 1, p1s + array[i], p2s, ts, array, n)
                || backtrack(i + 1, p1s, p2s + array[i], ts, array, n);
    }

    public static boolean checkPartition(int[] array, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += array[i];
        }
        if (sum % 2 != 0) {
            return false;
        }

        int p1s = array[0];
        int p2s = 0;

        return backtrack(1, p1s, p2s, sum / 2, array, n);
    }
}
