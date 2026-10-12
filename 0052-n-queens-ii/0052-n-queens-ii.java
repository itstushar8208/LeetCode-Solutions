class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        int[][] arr = new int[n][n];
        Solve(0, arr);
        return count;
    }
    public void Solve(int row, int[][] arr) {
        if (row == arr.length) {
            count++;
            return;
        }
        for (int col = 0; col < arr.length; col++) {
            if (canSeat(row, col, arr)) {
                arr[row][col] = 1;
                Solve(row + 1, arr);
                arr[row][col] = 0;
            }
        }
    }
    public boolean canSeat(int row, int col, int[][] arr) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (arr[i][col] == 1) {
                return false;
            }
        }
        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 1) {
                return false;
            }
        }
        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < arr.length; i--, j++) {
            if (arr[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}