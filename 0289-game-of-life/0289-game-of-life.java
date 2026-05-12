 class Solution {
    public void gameOfLife(int[][] board) {

        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int live = 0;

                for (int r = i - 1; r <= i + 1; r++) {
                    for (int c = j - 1; c <= j + 1; c++) {

                        if (r >= 0 && c >= 0 && r < m && c < n &&
                            !(r == i && c == j) &&
                            Math.abs(board[r][c]) == 1) {
                            live++;
                        }
                    }
                }

                if (board[i][j] == 1 && (live < 2 || live > 3))
                    board[i][j] = -1;

                if (board[i][j] == 0 && live == 3)
                    board[i][j] = 2;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] > 0 ? 1 : 0;
            }
        }
    }
}