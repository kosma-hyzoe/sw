
import java.util.Arrays;

public class Partition {

//    private static boolean checkComb(int[] arr, int p1s, int p2s, int ts, int i) {
//        if (i == arr.length) {
//            return p1s == p2s && ts == p1s;
//        }
//
//        for (int j = i; j < arr.length; j++) {
//            if (checkComb(arr, p1s + arr[j], p2s, j)
//                        || checkComb(arr, p1s, p2s + arr[j], j)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static boolean checkPartition(int[] arr, int n) {
//        int sum = 0;
//        for (int i = 0; i < arr.length; i++) {
//                sum += arr[i];
//        }
//        if (sum % 2 != 0) {
//            return false;
//        }
//        int target_sum = sum / 2;
//
//        int p1s = arr[0];
//        int p2s = 0;
//
//
//        return checkComb(arr, p1s, p2s, target_sum, 0);
}
