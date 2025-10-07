 class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(' && count++ > 0) res.append(c);
            if (c == ')' && --count > 0) res.append(c);
        }
        return res.toString();
    }
}
