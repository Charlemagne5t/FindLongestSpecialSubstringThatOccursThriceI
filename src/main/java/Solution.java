class Solution {
    int res = -1;
    public int maximumLength(String s) {
        Map<String, Integer> map = new HashMap<>();
        boolean[] starts = new boolean[s.length()];
        starts[0] = true; 
        dfs(s, 1, s.charAt(0) + "", map, starts);
       
        return res;
    }

    void dfs(String s, int i, String cur,  Map<String, Integer> map, boolean[] starts ) {
        
        int c = map.getOrDefault(cur, 0);
        c++;
        if(c == 3 && cur.length() != 0) {
            res = Math.max(res, cur.length()); 
        }
        map.put(cur, c);
        if(i == s.length()) {
            return;
        }
        if(i < s.length()&& cur.charAt(cur.length() - 1) == s.charAt(i)) {
            dfs(s, i + 1, cur + s.charAt(i), map, starts);;
        }
        
        if(!starts[i]){
            starts[i] = true;
            dfs(s, i + 1, "" + s.charAt(i), map, starts);
            
        }
        
    }
}