package backtracking;


public class TUR {
    private static final int N_ROUNDS = 3;
    private static final int BACKTRACKING_PLAYER = 1;
    private static final int NON_BACKTRACKING_PLAYER = 2;

    private static int bestResult;

    public int getBestResult(int[] board, int size) {
        bestResult = Integer.MIN_VALUE;
        backtrackMoves(0, bestResult, board, size);
        return bestResult;
    }

    private void backtrackMoves(int round, int result, int[] board, int size) {
        if (round == N_ROUNDS) {
            if (result > bestResult) {
                bestResult = result;
            }
            return;
        }

        int[] tmpBoard = new int[size];
        for (int i = 0; i < size; i++) {
            if (board[i] == 0) {

                System.arraycopy(board, 0, tmpBoard, 0, size);

                performMove(BACKTRACKING_PLAYER, i, tmpBoard, size);
                int nonBacktrackingPlayerScore =
                        performImmediatelyBestMove(NON_BACKTRACKING_PLAYER, tmpBoard, size);
                int backtrackingPlayerScore = countStones(BACKTRACKING_PLAYER, tmpBoard, size);

                result = backtrackingPlayerScore - nonBacktrackingPlayerScore;
                backtrackMoves(round + 1, result, tmpBoard, size);
            }
        }
    }

    private void performMove(int player, int move, int[] board, int size) {
        board[move] = player;
        shiftStones(move, player, board, size);
    }

    private int performImmediatelyBestMove(int player, int[] board, int size) {
        int immediatelyBestResult = 0;
        int[] postBestMoveBoard = new int[size];
        int[] tmpBoard = new int[size];
        boolean hasLegalMoves = false;

        for (int i = 0; i < size; i++) {
            if (board[i] == 0) {
                System.arraycopy(board, 0, tmpBoard, 0, size);
                tmpBoard[i] = player;
                shiftStones(i, 2, tmpBoard, size);
                int scoreAfterMove = countStones(player, tmpBoard, size);
                if (scoreAfterMove > immediatelyBestResult) {
                    if (!hasLegalMoves)
                        hasLegalMoves = true;
                    immediatelyBestResult = scoreAfterMove;
                    System.arraycopy(tmpBoard, 0, postBestMoveBoard, 0, size);
                }
            }
        }
        if (!hasLegalMoves)
            return countStones(player, board, size);

        System.arraycopy(postBestMoveBoard, 0, board, 0, size);
        return immediatelyBestResult;
    }
    private void shiftStones(int moveField, int player, int[] board, int size) {
        int opponent = (player == BACKTRACKING_PLAYER) ? NON_BACKTRACKING_PLAYER : BACKTRACKING_PLAYER;

        shiftStonesLeft(moveField, player, opponent, board);
        shiftStonesRight(moveField, player, opponent, board, size);
    }

    private void shiftStonesRight(int moveField, int player, int opponent, int[] board, int size) {
        if (moveField != size - 1 && board[moveField + 1] == opponent) {
            int i = moveField + 1;
            if (board[i] == player)
                return;
            while (i < size - 1 && board[i] == opponent)
                i++;
            if (board[i] == player)
                closeGroup(moveField + 1, i - 1, player, board);
            else if (i == size - 1 && board[i] == opponent)
                closeGroup(moveField + 1, i, player, board);
        }
    }

    private void shiftStonesLeft(int moveField, int player, int opponent, int[] board) {
        if (moveField != 0 && board[moveField - 1] == opponent) {
            int i = moveField - 1;
            if (board[i] == player)
                return;
            while (i > 0 && board[i] == opponent)
                i--;
            if (board[i] == player)
                closeGroup(i + 1, moveField - 1, player, board);
            else if (i == 0 && board[i] == opponent)
                closeGroup(i, moveField - 1, player, board);
        }
    }

    private void closeGroup(int startIndex, int endIndex, int player, int[] board) {
        for (int i = startIndex; i <= endIndex; i++) {
            board[i] = player;
        }
    }
    private int countStones(int player, int[] board, int size) {
        int playerScore = 0;
        for (int j = 0; j < size; j++) {
            if (board[j] == player) {
                playerScore++;
            }
        }
        return playerScore;
    }
}
