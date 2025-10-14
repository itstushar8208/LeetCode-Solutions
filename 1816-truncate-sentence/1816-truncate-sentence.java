 class Solution {
    public String truncateSentence(String s, int k) {
        String[] arr = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < k; i++) {
            res.append(arr[i]);
            if (i != k - 1) res.append(" ");
        }
        return res.toString();
    }
}
