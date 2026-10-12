class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[][] arr = new int[n][n];
        List<List<String>> result = new ArrayList<>();
        Solve(0, arr, result);
        return result;
    }
    public void Solve(int row, int[][] arr, List<List<String>> result) {
        if (row == arr.length) {
            printBoard(arr, result);
            return;
        }
        for (int col = 0; col < arr.length; col++) {
            if (canSeat(row, col, arr)) {
                arr[row][col] = 1;
                Solve(row + 1, arr, result);
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
    public void printBoard(int[][] arr, List<List<String>> result) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String row = "";
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 1) {
                    row = row + "Q";
                } else {
                    row = row + ".";
                }
            }
            board.add(row);
        }
        result.add(board);
    }
}
