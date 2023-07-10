//package backtracking;
//
//public class SUD {
//
//    private boolean foundZero = false;
//
//    private static boolean inRow(int[][] b, int n, int row) {
//        for (int c = 0; c < b.length; c++) {
//            if (n == b[row][c]) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private static boolean inColumn(int[][] b, int n, int col) {
//        for (int r = 0; r < b.length; r++) {
//            if (n == b[r][col]) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private static boolean inBox(int[][] b, int n, int row, int col) {
//        int localBoxRow = row - row % 3;
//        int localBoxColumn = col - col % 3;
//        for (int r = localBoxRow; r < localBoxRow + 3; r++) {
//            for (int c = localBoxColumn; c < localBoxColumn + 3; c++) {
//                if (n == b[r][c]) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    private static boolean isLegal(int[][] b, int n, int r, int c) {
//        return !inBox(b, n, r, c) && !inColumn(b, n, c) && !inRow(b, n, r);
//    }
//
//
//    private boolean solveBoard(int[][] b) {
//        for (int r = 0; r < b.length; r++) {
//            for (int c = 0; c < b.length; c++) {
//                if (b[r][c] == 0) {
//                    for (int n = 1; n <= 9; n++) {
//                        if (isLegal(b, n, r, c)) {
//                            b[r][c] = n;
//
//                            if ( solveBoard(b) ) {
//                                return true;
//                            } else {
//                                b[r][c] = 0;
//                            }
//                        }
//                    }
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    public void solve(int[][] b) {
//        if (!solveBoard(b)) {
//            System.exit(1);
//        }
//    }
//
//    public static void main(String[] args) {
//        Judge.run(new SUD());
//    }
//}
