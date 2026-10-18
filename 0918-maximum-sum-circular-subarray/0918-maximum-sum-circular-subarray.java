class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;

        int sum1 = 0;
        int maxSum = Integer.MIN_VALUE;

        int sum2 = 0;
        int minSum = Integer.MAX_VALUE;

        for (int temp : nums) {
            // Kadane Max
            sum1 = Math.max(sum1 + temp, temp);
            maxSum = Math.max(maxSum, sum1);

            // Kadane Min
            sum2 = Math.min(sum2 + temp, temp);
            minSum = Math.min(minSum, sum2);

            // Total Sum
            totalSum += temp;
        }

        // Handle the all-negative case
        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }
}