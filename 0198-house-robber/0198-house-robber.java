 class Solution {
    public int rob(int[] nums) {
        int prev = 0, curr = 0;
        for (int n : nums) {
            int temp = Math.max(curr, prev + n);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}
