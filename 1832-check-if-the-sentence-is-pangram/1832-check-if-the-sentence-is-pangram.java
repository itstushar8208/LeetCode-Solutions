 class Solution {
    public boolean checkIfPangram(String s) {
        boolean[] seen = new boolean[26];
        for (char c : s.toCharArray())
            seen[c - 'a'] = true;
        for (boolean b : seen)
            if (!b) return false;
        return true;
    }
}
