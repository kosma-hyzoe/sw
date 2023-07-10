//public class NADOLD {
//
//	private static final long INF = (long) 1e18;
//    private long minCost;
//    private boolean[] visited;
//    private long[][] cost;
//    private int n;
//    private int k;
//
//    public long getMinimumCost(int n, int k, long[][] cost) {
//        this.n = n;
//        this.k = k;
//        this.cost = cost;
//        this.minCost = INF;
//        this.visited = new boolean[n];
//        backtrack(0, 0L);
//        return minCost;
//    }
//
//    private void backtrack(int task, long currCost) {
//        if (task == k) {
//            minCost = Math.min(minCost, currCost);
//            return;
//        }
//        if (currCost >= minCost) return;
//
//        for (int i = 0; i < n; i++) {
//            if (!visited[i]) {
//                visited[i] = true;
//                backtrack(task + 1, currCost + cost[i][task]);
//                visited[i] = false;
//            }
//        }
//    }
//
//	public static void main(String[] args) {
//		Judge.run(new NAD());
//	}
//}