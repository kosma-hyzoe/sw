package nad;

public class NAD1 {
	// WIP, a new version with less help from chatGPT :')
    private long recurseCost(long compCost, int k, boolean[] isBusy, int kk, int nn, long[][] cc) {
        int cost = 0;
        for (int j = k; j < kk;  j++) {
            for (int i = 0; i < nn; i++) {
                if (!isBusy[i]) {
                    isBusy[i] = true;
                    cost += cc[i][j];
                    long tempCost = recurseCost(compCost, j + 1, isBusy, kk, nn, cc);
                    if (tempCost > compCost) {
                        isBusy[i] = false;
                        cost -= cc[i][j];
                    } else {
                        compCost = tempCost;
                    }
                }
            }
        }
        if (cost == 0) {
            return compCost;
        } else {
            return cost;
        }
    }
    public long getMinimumCost(int nn, int kk, long[][] cc) {
        boolean[] isBusy = new boolean[nn];

        return recurseCost(Long.MAX_VALUE, 0,  isBusy, nn, kk, cc);
    }

    public static void main(String[] args) {
        Judge.run(new NAD());
    }
}

