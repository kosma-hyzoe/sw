package bits;


public class ContainerNoBitSet {
  private byte[] bitArray;
    private int size;

    public void init(int size) {
        this.size = size;
        int byteArraySize = (size + 7) / 8;
        bitArray = new byte[byteArraySize];
    }

    public boolean add(int a) {
        if (a < 0 || a >= size) {
            return false;
        }
        int index = a / 8;
        int bitOffset = a % 8;
        if ((bitArray[index] & (1 << bitOffset)) == 0) {
            bitArray[index] |= (1 << bitOffset);
            return true;
        } else {
            return false;
        }
    }

    public boolean contains(int a) {
        if (a < 0 || a >= size) {
            return false;
        }
        int index = a / 8;
        int bitOffset = a % 8;
        return (bitArray[index] & (1 << bitOffset)) != 0;
    }

    public boolean remove(int a) {
        if (a < 0 || a >= size) {
            return false;
        }
        int index = a / 8;
        int bitOffset = a % 8;
        if ((bitArray[index] & (1 << bitOffset)) != 0) {
            bitArray[index] &= ~(1 << bitOffset);
            return true;
        } else {
            return false;
        }
    }
}
