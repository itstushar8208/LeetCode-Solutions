 class Solution {
    public String toGoatLatin(String s) {
        String[] w = s.split(" ");
        String v = "aeiouAEIOU";
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < w.length; i++) {
            if (v.indexOf(w[i].charAt(0)) == -1)
                w[i] = w[i].substring(1) + w[i].charAt(0);
            res.append(w[i]).append("ma");
            for (int j = 0; j <= i; j++) res.append("a");
            if (i < w.length - 1) res.append(" ");
        }
        return res.toString();
    }
}
