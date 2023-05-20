package bits;

import java.util.*;

public class CNT {
    public byte popCount(int value) {
        return (byte) Integer.bitCount(value);
    }

    public byte popCountTooSlow(int value) {
        byte count = 0;
        while (value != 0) {
            count += value & 1;
            value >>>= 1;
        }
        return count;
    }
}
