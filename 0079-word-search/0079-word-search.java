 class Solution {
    private int rows;
    private int cols;
    private String word;

    private final int[] dr = {-1, 1, 0, 0};
    private final int[] dc = {0, 0, -1, 1};

    public boolean exist(char[][] board, String word) {
        this.rows = board.length;
        this.cols = board[0].length;
        this.word = word;

        int[] boardFreq = new int[128];
        int[] wordFreq = new int[128];

        for (char[] row : board) {
            for (char ch : row) {
                boardFreq[ch]++;
            }
        }

        for (char ch : word.toCharArray()) {
            wordFreq[ch]++;

            if (wordFreq[ch] > boardFreq[ch]) {
                return false;
            }
        }

        /*
         * Start from the rarer character.
         * This can significantly reduce the number of starting points.
         */
        if (boardFreq[word.charAt(0)] > boardFreq[word.charAt(word.length() - 1)]) {
            this.word = new StringBuilder(word).reverse().toString();
        }

        // Try every cell as a starting point
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == this.word.charAt(0)
                        && dfs(board, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int r, int c, int index) {
        // All characters have been matched
        if (index == word.length()) {
            return true;
        }

        // Boundary check
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return false;
        }

        // Character mismatch or already visited
        if (board[r][c] != word.charAt(index)) {
            return false;
        }

        // Mark current cell as visited
        char original = board[r][c];
        board[r][c] = '#';

        // Explore four directions
        for (int d = 0; d < 4; d++) {
            if (dfs(board, r + dr[d], c + dc[d], index + 1)) {
                board[r][c] = original;
                return true;
            }
        }

        // Backtrack: restore the cell
        board[r][c] = original;

        return false;
    }
}