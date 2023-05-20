package bits;

import java.util.BitSet;

public class Container {
    private BitSet bitSet;
    private int size;

    public void init(int size) {
        this.size = size;
        bitSet = new BitSet(size);
    }

    public boolean add(int a) {
        if (a < 0 || a >= this.size) {
            return false;
        }
        if (!bitSet.get(a)) {
            bitSet.set(a);
            return true;
        } else {
            return false;
        }
    }

    public boolean contains(int a) {
        if (a < 0 || a >= size) {
            return false;
        }
        return bitSet.get(a);
    }

    public boolean remove(int a) {
        if (a < 0 || a >= size) {
            return false;
        }
        if (bitSet.get(a)) {
            bitSet.clear(a);
            return true;
        } else {
            return false;
        }
    }
}
