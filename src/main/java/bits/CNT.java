package bits;

import java.util.*;
// make an int array containing number of set bits in each
// then `res += data[(value)] & 0xFF]; res += data[(value >> 8)] & 0xFF]

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
