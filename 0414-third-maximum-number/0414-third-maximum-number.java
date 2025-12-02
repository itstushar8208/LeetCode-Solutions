 class Solution {
    public int thirdMax(int[] nums) {
        Long a = null, b = null, c = null;
        for (int n : nums) {
            long x = n;
            if (a != null && x == a || b != null && x == b || c != null && x == c)
                continue;
            if (a == null || x > a) {
                c = b;
                b = a;
                a = x;
            } else if (b == null || x > b) {
                c = b;
                b = x;
            } else if (c == null || x > c) {
                c = x;
            }
        }
        return c == null ? a.intValue() : c.intValue();
    }
}
