package bits;
import java.util.*;

public class CNT {
    public int popCount(int value) {
        int count = 0;
        while (value != 0) {
            count += value & 1;
            value >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Judge.run(new CNT());
    }
}