 class Solution {

    public int findNumbers(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (digits(nums[i])) {
                count++;
            }
        }
        return count;
    }

    public boolean digits(int no) {
        int count = 0;

        while (no > 0) {
            count++;
            no = no / 10;
        }
        return count % 2 == 0;
    }
}
