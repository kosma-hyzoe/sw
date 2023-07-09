package tur;

public class TUR {
	private static final int N_ROUNDS = 3;
	private static int bestResult;
	private static boolean[][] triedMoves;

	public static void main(String[] args) {
		Judge.run(new TUR());
	}

	public int getBestResult(int[] board, int size) {
		bestResult = Integer.MIN_VALUE;
		triedMoves = new boolean[N_ROUNDS][size];
		backtrackMoves(0, 0, board, size);
		return bestResult;
	}

	private boolean backtrackMoves(int round, int result, int[] board, int size) {
		if (round == N_ROUNDS - 1) {
			if (result > bestResult) {
				bestResult = result;
				return true;
			} else {
				return false;
			}
		}

		int[] tmpBoard = new int[size];
		for (int i = 0; i < size; i++) {
			if (board[i] == 0 && !triedMoves[round][i]) {
				System.arraycopy(board, 0, tmpBoard, 0, size);

				triedMoves[round][i] = true;
				tmpBoard[i] = 1;
				int playerScore = sumScore(i, 1, tmpBoard, size);
				int opponentScore = performOpponentMove(tmpBoard, size);

				if (backtrackMoves(round + 1, playerScore - opponentScore, tmpBoard, size)) {
					return true;
				}
			}
		}
		return false;
	}

	private int performOpponentMove(int[] board, int size) {
		int bestResult = 0;
		int[] postBestMoveBoard = new int[size];

		for (int i = 0; i < size; i++) {
			if (board[i] == 0) {
				int[] tmpBoard = new int[size];
				System.arraycopy(board, 0, tmpBoard, 0, size);
				int scoreAfterMove = sumScore(i, 2, tmpBoard, size);
				if (scoreAfterMove > bestResult) {
					bestResult = scoreAfterMove;
					System.arraycopy(tmpBoard, 0, postBestMoveBoard, 0, size);
				}
			}
		}

		System.arraycopy(postBestMoveBoard, 0, board, 0, size);
		return bestResult;
	}

	private int sumScore(int moveField, int player, int[] board, int size) {
		int opponent = (player == 1) ? 2 : 1;
		int playerScore = 0;

		int i = moveField + 1;
		if (i != size && board[i] == opponent) {
			while (i < size - 1 && board[i] == opponent) {
				i++;
			}
			if (board[i] == player || i == size - 1) {
				while (board[i] == opponent) {
					board[i] = player;
					i--;
				}
			}
		}

		i = moveField - 1;
		if (i != -1 && board[i] == opponent) {
			while (i > 0 && board[i] == opponent) {
				i--;
			}
			if (board[i] == player || i == 0) {
				while (board[i] == opponent) {
					board[i] = player;
					i++;
				}
			}
		}

		for (int j = 0; j < size; j++) {
			if (board[j] == player) {
				playerScore++;
			}
		}

		return playerScore;
	}
}