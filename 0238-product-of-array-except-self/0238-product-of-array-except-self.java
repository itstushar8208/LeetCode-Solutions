
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int prefix = 1;

        for (int j = 0; j < n; j++) {
            result[j] = prefix;
            prefix *= nums[j];
        }

        int suffix = 1;

        for (int j = n - 1; j >= 0; j--) {
            result[j] *= suffix;
            suffix *= nums[j];
        }

        return result;
    }
}
