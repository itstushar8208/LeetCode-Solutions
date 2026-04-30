 class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        
        int[] freq = new int[128];
        for (char c : t.toCharArray()) freq[c]++;
        
        int left = 0, right = 0, count = t.length();
        int minLen = Integer.MAX_VALUE, start = 0;
        
        while (right < s.length()) {
            if (freq[s.charAt(right)]-- > 0) count--;
            right++;
            
            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                
                if (freq[s.charAt(left)]++ == 0) count++;
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}