package bits;

import java.util.Arrays;

public class Partition {

    private static int sumArray(int[] arr) {
        int sum = 0;
            }

    private static boolean wasTried(int[] arr) {
        for (int triedArr : tried) {
            if (Arrays.equals(triedArr, arr) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkComb(int arr, int p1s, int p2s, int i) {
        if (i == arr.length) {
            return p1s == p2s;
        }

        for (int j = i; j < arr.length; j++) {
            if (checkComb(p1s + arr[j], p2s, j
                        || checkComb(p1s, p2s + arr[j], j)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPartition(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target sum = sum / 2;

        int p1s = arr[0];
        int p2s = 0;


        return checkComb(arr, p1s, p2s);
}
