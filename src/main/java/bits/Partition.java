package bits;

import java.util.Arrays;

public class Partition {
    private static int sumMask(int mask, int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if ((1 << i & mask) != 0) {
                sum += arr[i];
            }
        }
        return sum;
    }

    private static int[] createBitmasks(int n) {
        int[] bitmasks = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
                bitmasks[i] = i;
        }
        return bitmasks;
    }

    public static boolean checkPartition(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int[] bitmasks = createBitmasks(n);

        for (int mask : bitmasks) {
            if (sumMask(mask, arr, n) == sum / 2 && sumMask(~mask, arr, n) == sum / 2) {
                return true;
            }
        }
        return false;
    }
}
