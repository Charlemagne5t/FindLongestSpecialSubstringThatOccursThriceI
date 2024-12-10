import java.util.HashMap;
import java.util.Map;

class Solution {
    int res = -1;

    public int maximumLength(String s) {
        Map<String, Integer> map = new gHashMap<>();
        int count = 1;
        int res = -1;
        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                int c = map.getOrDefault("" +s.charAt(i - 1) + count, 0);
                c++;
                if (c > 2) {
                    res = Math.max(count, res);
                }
                map.put("" + s.charAt(i - 1) + count, c);
                if (count > 1) {
                    c = map.getOrDefault("" +s.charAt(i - 1) + (count - 1), 0);
                    c += 2;
                    if (c > 2) {
                        res = Math.max(count - 1, res);
                    }
                    map.put("" +s.charAt(i - 1) + (count - 1), c);
                }
                if (count > 2) {
                    c = map.getOrDefault("" +s.charAt(i - 1) + (count - 2), 0);
                    c += 3;
                    if (c > 2) {
                        res = Math.max(count - 2, res);
                    }
                    map.put("" +s.charAt(i - 1) + (count - 2), c);
                }
                count = 1;
            }

        }

        return res;

    }
}