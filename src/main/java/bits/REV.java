package bits;

import java.util.*;

public class REV {
    public static int bitReverse(int value) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            res <<= 1;
            if ((value & 1) == 1) {
                res |= 1;
            }
            value >>= 1;
        }

        return res;
    }
}
