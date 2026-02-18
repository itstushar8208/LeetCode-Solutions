 import java.util.*;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        int m = mat.length;
        int[][] strength = new int[m][2];

        for (int i = 0; i < m; i++) {

            int left = 0, right = mat[i].length - 1;
            int soldiers = mat[i].length;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (mat[i][mid] == 0) {
                    soldiers = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            strength[i][0] = soldiers;
            strength[i][1] = i;
        }

        Arrays.sort(strength, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });

        int[] result = new int[k];
        for (int i = 0; i < k; i++)
            result[i] = strength[i][1];

        return result;
    }
}
