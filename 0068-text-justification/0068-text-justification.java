 import java.util.*;

class Solution {
    public List<String> fullJustify(String[] w, int m) {
        List<String> r = new ArrayList<>();
        for (int i = 0; i < w.length;) {
            int j = i, len = 0;
            while (j < w.length && len + w[j].length() + (j - i) <= m)
                len += w[j++].length();

            StringBuilder sb = new StringBuilder();
            int gaps = j - i - 1, space = gaps > 0 ? (m - len) / gaps : 0, extra = gaps > 0 ? (m - len) % gaps : 0;

            for (int k = i; k < j; k++) {
                sb.append(w[k]);
                if (k < j - 1) {
                    int s = (j == w.length) ? 1 : space + (k - i < extra ? 1 : 0);
                    while (s-- > 0) sb.append(" ");
                }
            }

            while (sb.length() < m) sb.append(" ");
            r.add(sb.toString());
            i = j;
        }
        return r;
    }
}