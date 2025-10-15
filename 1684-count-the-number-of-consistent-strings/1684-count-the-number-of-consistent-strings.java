 class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        for (String w : words) {
            boolean ok = true;
            for (char c : w.toCharArray()) {
                if (allowed.indexOf(c) == -1) { ok = false; break; }
            }
            if (ok) count++;
        }
        return count;
    }
}
