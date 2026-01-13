 class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for (int n : nums) {
            if (n == 1) count++;
            else count = 0;
            max = Math.max(max, count);
        }
        return max;
    }
}
